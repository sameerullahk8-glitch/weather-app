package de.fh.albsig.matrikel.nr.exception;

/** Exception thrown when weather data cannot be retrieved. */
public class WeatherException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Creates a WeatherException with a detail message.
   *
   * @param message the detail message
   */
  public WeatherException(String message) {
    super(message);
  }

  /**
   * Creates a WeatherException with a detail message and a cause.
   *
   * @param message the detail message
   * @param cause   the cause of this exception
   */
  public WeatherException(String message, Throwable cause) {
    super(message, cause);
  }
}
