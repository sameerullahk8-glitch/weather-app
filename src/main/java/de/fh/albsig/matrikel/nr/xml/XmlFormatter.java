package de.fh.albsig.matrikel.nr.xml;

import de.fh.albsig.matrikel.nr.model.WeatherReport;
import java.util.Objects;

/** Formats a WeatherReport as an XML string. */
public class XmlFormatter {

  public XmlFormatter() {
  }

  /**
   * Converts a WeatherReport to an XML string.
   *
   * @param report the weather report to format
   * @return the XML representation of the report
   */
  public String toXml(final WeatherReport report) {
    Objects.requireNonNull(report, "report must not be null");

    StringBuilder xml = new StringBuilder();
    xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    xml.append("<weather>");
    xml.append("<city>").append(report.getCity()).append("</city>");
    xml.append("<temperatureCelsius>")
        .append(report.getTemperature())
        .append("</temperatureCelsius>");
    xml.append("<condition>").append(report.getCondition()).append("</condition>");
    xml.append("<humidity>").append(report.getHumidity()).append("</humidity>");
    xml.append("</weather>");
    return xml.toString();
  }
}