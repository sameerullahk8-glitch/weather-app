flowchart TD
    CON["stdin: city name"]

    subgraph RUNTIME["Runtime / src/main/java"]
        APP["App\nmain() / runApplication()"]
        WS["WeatherService\ninterface"]
        MWS["MockWeatherService\nvalidates blank input\nnormalises city\nreturns fixed weather data"]
        WR["WeatherReport\ncity, temperature, description, humidity, wind speed"]
        XF["XmlFormatter\ntoXml(report)"]
        WE["WeatherException\nmessage / message + cause"]
    end

    subgraph OUTPUT["Output"]
        XML["stdout XML"]
        ERR["Log4j error log"]
    end

    subgraph TESTS["Tests / src/test/java"]
        AMT["AppMockitoTest\nMockito mock of WeatherService"]
        MWST["MockWeatherServiceTest\ncity, blank input, exception"]
        XFT["XmlFormatterTest\nXML tags and null guard"]
    end

    subgraph BUILD["Build / CI"]
        POM["pom.xml\nJUnit, Mockito, Log4j\nCheckstyle, PMD, SpotBugs, JaCoCo"]
        JF["Jenkinsfile\nBuild / Test / Quality"]
    end

    CON --> APP
    APP -->|getWeatherForCity| WS
    WS -.-> MWS
    MWS -->|creates| WR
    MWS -.->|throws on blank input| WE
    APP -->|toXml| XF
    XF -->|reads all fields| WR
    XF --> XML
    APP -.->|catches and logs| WE
    WE -.-> ERR

    AMT -.-> WS
    AMT -.-> WR
    MWST -.-> MWS
    XFT -.-> XF
    XFT -.-> WR

    JF --> POM
    POM -.-> RUNTIME
    POM -.-> TESTS
