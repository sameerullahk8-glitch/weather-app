package de.fh.albsig.matrikel.nr.service;

import de.fh.albsig.matrikel.nr.exception.WeatherException;
import de.fh.albsig.matrikel.nr.model.WeatherReport;

/** Service interface for retrieving weather data. */
public interface WeatherService {

  WeatherReport getWeatherForCity(String city) throws WeatherException;
}
