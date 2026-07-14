package de.fh.albsig.matrikel.nr.model;

/** Holds weather data for a specific city. */
public class WeatherReport {

  private final String city;
  private final double temperature;
  private final String description;
  private final int humidity;
  private final int windSpeedKmh;

  /**
   * Creates a new WeatherReport.
   *
   * @param city         the city name
   * @param temperature  the temperature in Celsius
   * @param description  the weather description
   * @param humidity     the humidity percentage
   * @param windSpeedKmh the wind speed in kilometres per hour
   */
  public WeatherReport(
      final String city,
      final double temperature,
      final String description,
      final int humidity,
      final int windSpeedKmh) {
    this.city = city;
    this.temperature = temperature;
    this.description = description;
    this.humidity = humidity;
    this.windSpeedKmh = windSpeedKmh;
  }

  /**
   * Returns the city name.
   *
   * @return the city name
   */
  public String getCity() {
    return city;
  }

  /**
   * Returns the temperature in Celsius.
   *
   * @return the temperature in Celsius
   */
  public double getTemperature() {
    return temperature;
  }

  /**
   * Returns the weather description.
   *
   * @return the weather description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Returns the weather condition (alias for description).
   *
   * @return the weather condition
   */
  public String getCondition() {
    return description;
  }

  /**
   * Returns the humidity percentage.
   *
   * @return the humidity percentage
   */
  public int getHumidity() {
    return humidity;
  }

  /**
   * Returns the wind speed in kilometres per hour.
   *
   * @return the wind speed in kilometres per hour
   */
  public int getWindSpeedKmh() {
    return windSpeedKmh;
  }
}
