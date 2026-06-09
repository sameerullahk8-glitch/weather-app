package de.fh.albsig.matrikel.nr.xml;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.fh.albsig.matrikel.nr.model.WeatherReport;
import org.junit.jupiter.api.Test;

class XmlFormatterTest {

    private final XmlFormatter formatter = new XmlFormatter();

    @Test
    void shouldContainCityTag() {
        WeatherReport report = new WeatherReport("Berlin", 20.0, "Cloudy", 60);
        String xml = formatter.toXml(report);
        assertTrue(xml.contains("<city>Berlin</city>"));
    }

    @Test
    void shouldContainTemperatureTag() {
        WeatherReport report = new WeatherReport("Berlin", 20.0, "Cloudy", 60);
        String xml = formatter.toXml(report);
        assertTrue(xml.contains("<temperatureCelsius>20.0</temperatureCelsius>"));
    }

    @Test
    void shouldThrowExceptionForNullReport() {
        assertThrows(NullPointerException.class, () -> formatter.toXml(null));
    }
}
