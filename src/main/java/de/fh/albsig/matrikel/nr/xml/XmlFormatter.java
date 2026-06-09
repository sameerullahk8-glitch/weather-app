package de.fh.albsig.matrikel.nr.xml;

import de.fh.albsig.matrikel.nr.model.WeatherReport;
import java.util.Objects;

public class XmlFormatter {

  public XmlFormatter() {
  }

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