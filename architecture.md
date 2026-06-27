flowchart TD
    A[stdin city name] --> B[App]
    B --> C[WeatherService]
    C --> D[MockWeatherService]
    D --> E[WeatherReport]
    B --> F[XmlFormatter]
    F --> E
    F --> G[XML stdout]
    D --> H[WeatherException]
    B --> H
    H --> I[Log4j error log]
    J[pom.xml] --> K[build test quality]
    L[Jenkinsfile] --> K
    M[AppMockitoTest] --> C
    M --> E
    N[MockWeatherServiceTest] --> D
    O[XmlFormatterTest] --> F
