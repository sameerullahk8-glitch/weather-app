package de.fh.albsig.matrikel.nr.service;

import de.fh.albsig.matrikel.nr.exception.WeatherException;
import de.fh.albsig.matrikel.nr.model.WeatherReport;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/** Mock implementation of WeatherService with per-city weather profiles. */
public class MockWeatherService implements WeatherService {

  private static final Map<String, WeatherReport> PROFILES = Map.of(
      "Berlin", new WeatherReport("Berlin", 10.0, "Overcast", 75, 25),
      "Hamburg", new WeatherReport("Hamburg", 14.0, "Rainy", 80, 30),
      "München", new WeatherReport("München", 18.0, "Sunny", 50, 10),
      "Munich", new WeatherReport("Munich", 18.0, "Sunny", 50, 10),
      "Stuttgart", new WeatherReport("Stuttgart", 16.0, "Partly Cloudy", 60, 12)
  );

  @Override
  public WeatherReport getWeatherForCity(String city) throws WeatherException {
    if (StringUtils.isBlank(city)) {
      throw new WeatherException("City must not be empty.");
    }

    String normalizedCity = StringUtils.capitalize(city.trim().toLowerCase(Locale.ROOT));
    return PROFILES.getOrDefault(normalizedCity,
        new WeatherReport(normalizedCity, 21.5, "Sunny", 55, 15));
  }
}
