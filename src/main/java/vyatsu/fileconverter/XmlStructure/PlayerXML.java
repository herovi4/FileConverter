package vyatsu.fileconverter.XmlStructure;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;


@Builder
@JsonPropertyOrder({"name", "position", "jerseyNumber", "teamName", "statistics"})
@JacksonXmlRootElement(localName = "player")
public record PlayerXML(
    @JacksonXmlProperty(localName = "name")
    String name,
    @JacksonXmlProperty(localName = "position")
    String position,
    @JacksonXmlProperty(localName = "teamName")
    String teamName,
    @JacksonXmlProperty(localName = "jerseyNumber")
    int jerseyNumber,
    @JacksonXmlProperty(localName = "statistics")
    Statistics statistic) {
}
