package de.fh.albsig.matrikel.nr.service;

import de.fh.albsig.matrikel.nr.exception.WeatherException;
import de.fh.albsig.matrikel.nr.model.WeatherReport;

/** Service interface for retrieving weather data. */
public interface WeatherService {

  /**
   * Returns the weather report for the given city.
   *
   * @param city the name of the city to query; must not be blank
   * @return the weather report for that city
   * @throws WeatherException if the city name is blank or data cannot be retrieved
   */
  WeatherReport getWeatherForCity(String city) throws WeatherException;
}
