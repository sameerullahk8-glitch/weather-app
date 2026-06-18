package de.fh.albsig.matrikel.nr.service;

import de.fh.albsig.matrikel.nr.exception.WeatherException;
import de.fh.albsig.matrikel.nr.model.WeatherReport;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/** Mock implementation of WeatherService that returns fixed weather data. */
public class MockWeatherService implements WeatherService {

  @Override
  public WeatherReport getWeatherForCity(String city) throws WeatherException {
    if (StringUtils.isBlank(city)) {
      throw new WeatherException("City must not be empty.");
    }

    String trimmedCity = city.trim().toLowerCase(Locale.ROOT);
    String normalizedCity = StringUtils.capitalize(trimmedCity);
    return new WeatherReport(normalizedCity, 21.5, "Sunny", 55);
  }
}
