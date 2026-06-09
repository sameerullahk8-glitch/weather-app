package de.fh.albsig.matrikel.nr.model;

public class WeatherReport {

  private final String city;
  private final double temperature;
  private final String description;
  private final int humidity;

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