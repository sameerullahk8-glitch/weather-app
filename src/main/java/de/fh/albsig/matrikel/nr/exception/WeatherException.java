package de.fh.albsig.matrikel.nr.exception;

/** Exception thrown when weather data cannot be retrieved. */
public class WeatherException extends Exception {

  private static final long serialVersionUID = 1L;

  public WeatherException(String message) {
    super(message);
  }

  public WeatherException(String message, Throwable cause) {
    super(message, cause);
  }
}
