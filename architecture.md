# Weather App — Architecture Diagram

## Component & Data-Flow Diagram

```mermaid
flowchart TD
    %% ── INPUT ──────────────────────────────────────────────
    CON(["📥 stdin\ncity name"])

    %% ── RUNTIME ─────────────────────────────────────────────
    subgraph RUNTIME["Runtime — src/main/java"]
        direction TB

        APP["**App**
        ───────────────
        main()
        runApplication()"]

        WS["**«interface»**
        **WeatherService**
        ───────────────
        getWeatherForCity(city)"]

        MWS["**MockWeatherService**
        ───────────────
        validates blank input
        normalises capitalisation
        returns fixed data"]

        WR["**WeatherReport**
        ───────────────
        city : String
        temperature : double  ➜  21.5 °C
        description : String  ➜  Sunny
        humidity : int        ➜  55 %
        windSpeedKmh : int    ➜  15 km/h"]

        XF["**XmlFormatter**
        ───────────────
        toXml(report)"]

        WE["**WeatherException**
        ───────────────
        extends Exception
        message / message + cause"]
    end

    %% ── OUTPUT ──────────────────────────────────────────────
    subgraph OUTPUT["Output"]
        XML(["📤 stdout\nXML string"])
        ERR(["🪵 Log4j\nerror log"])
    end

    %% ── TESTS ───────────────────────────────────────────────
    subgraph TESTS["Tests — src/test/java"]
        direction TB
        AMT["**AppMockitoTest**
        ─────────────
        1 test
        mocks WeatherService
        via Mockito"]

        MWST["**MockWeatherServiceTest**
        ─────────────
        6 tests
        valid city · blank city
        condition · description
        wind speed · exception cause"]

        XFT["**XmlFormatterTest**
        ─────────────
        4 tests
        city tag · temp tag
        windSpeed tag · null guard"]
    end

    %% ── BUILD & CI ──────────────────────────────────────────
    subgraph BUILD["Build & CI"]
        direction TB
        POM["**pom.xml**
        ──────────────────
        Java 17 · Maven 3.9
        Checkstyle  google_checks.xml
        PMD         static analysis
        SpotBugs    effort=Max
        JaCoCo      coverage ≥ 70%
        Surefire    test runner"]

        JF["**Jenkinsfile**
        ──────────────────
        Stage 1 → Build
        Stage 2 → Test
        Stage 3 → Quality"]
    end

    %% ── RUNTIME FLOW ────────────────────────────────────────
    CON                     --> APP
    APP  -->|"getWeatherForCity(city)"| WS
    WS   -. "implemented by" .-> MWS
    MWS  -->|"new WeatherReport(...)"|  WR
    MWS  -. "throws on blank input" .-> WE
    APP  -->|"toXml(report)"| XF
    XF   -->|"reads all 5 fields"| WR
    XF                      --> XML
    APP  -. "catches · LOGGER.error()" .-> WE
    WE                      -.-> ERR

    %% ── TEST RELATIONSHIPS ──────────────────────────────────
    AMT  -. "mocks" .->  WS
    AMT  -. "creates" .-> WR
    MWST -. "tests" .->  MWS
    XFT  -. "tests" .->  XF
    XFT  -. "creates" .-> WR

    %% ── BUILD RELATIONSHIPS ─────────────────────────────────
    JF   -->|"mvn clean compile"| POM
    JF   -->|"mvn test"|          POM
    JF   -->|"mvn checkstyle:check\npmd:check spotbugs:check"| POM
    POM  -. "analyses" .-> RUNTIME
    POM  -. "runs" .->     TESTS
```

---

## Data-Flow Walkthrough

| Step | What happens |
|------|-------------|
| 1 | User types a city name; `App.main()` wires `MockWeatherService` + `XmlFormatter` and calls `runApplication()` |
| 2 | `runApplication()` reads one line from `System.in` via `Scanner` |
| 3 | Calls `weatherService.getWeatherForCity(city)` through the `WeatherService` interface |
| 4 | `MockWeatherService` rejects blank input → throws `WeatherException("City must not be empty.")` |
| 5 | For valid input: normalises capitalisation, returns `WeatherReport("Berlin", 21.5, "Sunny", 55, 15)` |
| 6 | `App` passes the report to `XmlFormatter.toXml(report)` |
| 7 | `XmlFormatter` reads all five fields and builds a single XML string |
| 8 | `App` prints XML to `System.out` and logs success |
| 9 | On error: `App` catches `WeatherException` and calls `LOGGER.error()` — no XML printed |

**Sample output (valid city):**
```
Enter city name: Berlin
<?xml version="1.0" encoding="UTF-8"?><weather><city>Berlin</city><temperatureCelsius>21.5</temperatureCelsius><condition>Sunny</condition><humidity>55</humidity><windSpeedKmh>15</windSpeedKmh></weather>
```

**Sample output (blank input):**
```
Enter city name:
ERROR App - Could not create weather report.
de.fh.albsig.matrikel.nr.exception.WeatherException: City must not be empty.
```

---

## Layer Summary

```
┌─────────────────────────────────────────────────┐
│  CI / PIPELINE LAYER                            │
│  Jenkinsfile  →  Build · Test · Quality stages  │
├─────────────────────────────────────────────────┤
│  BUILD / QUALITY LAYER                          │
│  pom.xml  →  Checkstyle · PMD · SpotBugs        │
│           →  JaCoCo (72.7% coverage) · Surefire │
├─────────────────────────────────────────────────┤
│  TEST LAYER                (11 tests, 0 failures)│
│  AppMockitoTest  MockWeatherServiceTest          │
│  XmlFormatterTest                               │
├─────────────────────────────────────────────────┤
│  RUNTIME LAYER                                  │
│  App  →  WeatherService  →  MockWeatherService  │
│       →  XmlFormatter    →  WeatherReport       │
│                          →  WeatherException    │
├─────────────────────────────────────────────────┤
│  I/O                                            │
│  stdin (city name)   stdout (XML)   Log4j       │
└─────────────────────────────────────────────────┘
```
