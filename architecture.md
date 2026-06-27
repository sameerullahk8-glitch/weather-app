stdin city name -> App -> WeatherService -> MockWeatherService -> WeatherReport
App -> XmlFormatter -> XML stdout
MockWeatherService -> WeatherException -> Log4j error log
pom.xml -> build/test/quality
Jenkinsfile -> build/test/quality
AppMockitoTest -> WeatherService / WeatherReport
MockWeatherServiceTest -> MockWeatherService
XmlFormatterTest -> XmlFormatter
