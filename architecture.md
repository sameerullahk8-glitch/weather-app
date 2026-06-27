flowchart TD
    CON["stdin city name"]

    subgraph RUNTIME["Runtime"]
        APP["App"]
        WS["WeatherService"]
        MWS["MockWeatherService"]
        WR["WeatherReport"]
        XF["XmlFormatter"]
        WE["WeatherException"]
    end

    subgraph OUTPUT["Output"]
        XML["XML stdout"]
        ERR["Log4j error log"]
    end

    subgraph TESTS["Tests"]
        AMT["AppMockitoTest"]
        MWST["MockWeatherServiceTest"]
        XFT["XmlFormatterTest"]
    end

    subgraph BUILD["Build CI"]
        POM["pom.xml"]
        JF["Jenkinsfile"]
    end

    CON --> APP
    APP --> WS
    WS --> MWS
    MWS --> WR
    MWS --> WE
    APP --> XF
    XF --> WR
    XF --> XML
    APP --> WE
    WE --> ERR

    AMT --> WS
    AMT --> WR
    MWST --> MWS
    XFT --> XF
    XFT --> WR

    JF --> POM
    POM --> RUNTIME
    POM --> TESTS
