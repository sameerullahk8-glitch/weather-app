package de.fh.albsig.matrikel.nr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import de.fh.albsig.matrikel.nr.exception.WeatherException;
import de.fh.albsig.matrikel.nr.model.WeatherReport;
import de.fh.albsig.matrikel.nr.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AppMockitoTest {

    @Test
    void shouldUseMockitoToMockService() throws WeatherException {
        WeatherService weatherService = Mockito.mock(WeatherService.class);
        WeatherReport report = new WeatherReport("Munich", 18.5, "Rainy", 70);

        when(weatherService.getWeatherForCity("Munich")).thenReturn(report);

        WeatherReport result = weatherService.getWeatherForCity("Munich");
        assertEquals("Munich", result.getCity());
    }
}
