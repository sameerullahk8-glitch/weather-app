package de.fh.albsig.matrikel.nr.model;

/** Holds weather data for a specific city. */
public class WeatherReport {

  private final String city;
  private final double temperature;
  private final String description;
  private final int humidity;

  /**
   * Creates a new WeatherReport.
   *
   * @param city        the city name
   * @param temperature the temperature in Celsius
   * @param description the weather description
   * @param humidity    the humidity percentage
   */
  public WeatherReport(
      final String city,
      final double temperature,
      final String description,
      final int humidity) {
    this.city = city;
    this.temperature = temperature;
    this.description = description;
    this.humidity = humidity;
  }

  public String getCity() {
    return city;
  }

  public double getTemperature() {
    return temperature;
  }

  public String getDescription() {
    return description;
  }

  public String getCondition() {
    return description;
  }

  public int getHumidity() {
    return humidity;
  }
}