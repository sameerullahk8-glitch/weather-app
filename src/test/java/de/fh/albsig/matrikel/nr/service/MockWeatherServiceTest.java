package de.fh.albsig.matrikel.nr.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.fh.albsig.matrikel.nr.exception.WeatherException;
import de.fh.albsig.matrikel.nr.model.WeatherReport;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MockWeatherServiceTest {

    private MockWeatherService service;

    @BeforeAll
    static void beforeAll() {
    }

    @BeforeEach
    void setUp() {
        service = new MockWeatherService();
    }

    @Test
    void shouldReturnWeatherForValidCity() throws WeatherException {
        WeatherReport report = service.getWeatherForCity("berlin");
        assertEquals("Berlin", report.getCity());
    }

    @Test
    void shouldThrowExceptionForBlankCity() {
        assertThrows(WeatherException.class, () -> service.getWeatherForCity(" "));
    }

    @Test
    void shouldReturnSunnyCondition() throws WeatherException {
        WeatherReport report = service.getWeatherForCity("münchen");
        assertEquals("Sunny", report.getCondition());
    }

    @Test
    void shouldReturnDescription() throws WeatherException {
        WeatherReport report = service.getWeatherForCity("berlin");
        assertEquals("Overcast", report.getDescription());
    }

    @Test
    void shouldReturnWindSpeed() throws WeatherException {
        WeatherReport report = service.getWeatherForCity("berlin");
        assertEquals(25, report.getWindSpeedKmh());
    }

    @Test
    void shouldReturnHamburgRainy() throws WeatherException {
        WeatherReport report = service.getWeatherForCity("hamburg");
        assertEquals("Rainy", report.getCondition());
    }

    @Test
    void shouldReturnFallbackForUnknownCity() throws WeatherException {
        WeatherReport report = service.getWeatherForCity("Paris");
        assertEquals("Paris", report.getCity());
        assertEquals(21.5, report.getTemperature());
    }

    @Test
    void shouldReturnMunichAlias() throws WeatherException {
        WeatherReport report = service.getWeatherForCity("munich");
        assertEquals("Sunny", report.getCondition());
    }

    @Test
    void shouldCreateExceptionWithCause() {
        Throwable cause = new RuntimeException("network error");
        WeatherException exception = new WeatherException("Failed", cause);
        assertEquals("Failed", exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void afterAll() {
    }
}
