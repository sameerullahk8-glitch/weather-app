# Weather App

Console-based Java weather application built for the Professional Java Development module at FH Albsig.

## What it does

The app asks for a city name, validates it, and prints a weather report as a single XML string.

```
Enter city name: Berlin
<?xml version="1.0" encoding="UTF-8"?><weather><city>Berlin</city><temperatureCelsius>10.0</temperatureCelsius><condition>Overcast</condition><humidity>75</humidity><windSpeedKmh>25</windSpeedKmh></weather>
```

Blank input is rejected with a logged error and no XML is printed:

```
Enter city name:
[ERROR] Could not create weather report.
de.fh.albsig.matrikel.nr.exception.WeatherException: City must not be empty.
```

The current weather data is mocked (no live API). Known cities (Berlin, Hamburg, München/Munich, Stuttgart) each return a distinct profile. Any other city name falls back to a default profile (21.5 °C, Sunny, 55 % humidity, 15 km/h).

## Project structure

```
src/
  main/java/.../
    App.java                  — entry point; wires service and formatter
    model/WeatherReport.java  — immutable value object (city, temp, description, humidity, windSpeedKmh)
    service/WeatherService.java       — interface
    service/MockWeatherService.java   — hardcoded implementation; validates and normalises city name
    xml/XmlFormatter.java             — builds XML string from a WeatherReport
    exception/WeatherException.java   — checked exception for service errors
  main/resources/
    log4j2.xml                — Log4j 2 console logger configuration
  test/java/.../
    AppMockitoTest.java           — Mockito integration test
    service/MockWeatherServiceTest.java — unit tests for service validation and normalisation
    xml/XmlFormatterTest.java     — unit tests for XML output
```

## Requirements

- Java 17 or newer
- Maven 3.9 or newer

## Build

```bash
mvn clean compile
```

## Run tests

```bash
mvn test
```

## Build the JAR

```bash
mvn clean package
```

## Run the application

Copy dependencies then run with the full classpath:

```bash
mvn dependency:copy-dependencies
java -cp "target/weather-app-1.0-SNAPSHOT.jar;target/dependency/*" de.fh.albsig.matrikel.nr.App
```

On Linux/macOS replace `;` with `:` in the classpath.

Alternatively, run `App.main()` directly from an IDE (IntelliJ IDEA or Eclipse).

## Quality checks

```bash
# Run each tool individually
mvn checkstyle:check
mvn pmd:check
mvn spotbugs:check

# Or run all three at once
mvn checkstyle:check pmd:check spotbugs:check
```

Style rules follow the Google Java Style Guide (`google_checks.xml`).

## Test coverage

```bash
mvn clean test jacoco:report
```

The HTML report is written to `target/site/jacoco/index.html`. The project target is ≥ 70% instruction coverage.

## Full install (build + test + package)

```bash
mvn clean install
```

## Jenkins pipeline

`Jenkinsfile` defines a minimal three-stage declarative pipeline:

| Stage   | Command |
|---------|---------|
| Build   | `mvn clean compile` |
| Test    | `mvn test` |
| Quality | `mvn checkstyle:check pmd:check spotbugs:check` |

## Git workflow

Commits are kept small and logically grouped. Review the history with:

```bash
git log --oneline
```

## AI usage

Claude Code may be used as a coding assistant for small, reviewable changes, test support, and pipeline help. All committed changes must remain understandable and reviewable by the student. Design decisions, manual quality fixes, and explanations of the final code are the student's responsibility.

## Notes

- No secrets should be committed to the repository.
- `.gitignore` excludes generated build output (`target/`).
- Quality fixes should prefer minimal changes without altering application behaviour.
