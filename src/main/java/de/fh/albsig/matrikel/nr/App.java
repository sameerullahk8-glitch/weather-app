package de.fh.albsig.matrikel.nr;

import de.fh.albsig.matrikel.nr.exception.WeatherException;
import de.fh.albsig.matrikel.nr.model.WeatherReport;
import de.fh.albsig.matrikel.nr.service.MockWeatherService;
import de.fh.albsig.matrikel.nr.service.WeatherService;
import de.fh.albsig.matrikel.nr.xml.XmlFormatter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** Console weather application entry point. */
public final class App {

  private static final Logger LOGGER = LogManager.getLogger(App.class);

  private App() {
  }

  /** Application entry point. */
  public static void main(String[] args) {
    WeatherService weatherService = new MockWeatherService();
    XmlFormatter xmlFormatter = new XmlFormatter();
    runApplication(weatherService, xmlFormatter);
  }

  static void runApplication(WeatherService weatherService, XmlFormatter xmlFormatter) {
    try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
      LOGGER.info("Weather application started.");
      System.out.print("Enter city name: ");
      String city = scanner.nextLine();

      WeatherReport report = weatherService.getWeatherForCity(city);
      String xml = xmlFormatter.toXml(report);

      System.out.println(xml);
      LOGGER.info("Weather report created successfully for city {}.", report.getCity());
    } catch (WeatherException exception) {
      LOGGER.error("Could not create weather report.", exception);
    }
  }
}
