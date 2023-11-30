package vyatsu.fileconverter.XmlStructure;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonPropertyOrder({"name", "position","jerseyNumber", "teamName", "statistics"})
@JacksonXmlRootElement(localName = "player")
public class Player {
    @JacksonXmlProperty(localName = "name")
    @Expose(serialize = true)
    String name;
    @JacksonXmlProperty(localName = "position")
    @Expose(serialize = true)
    String position;
    @JacksonXmlProperty(localName = "teamName")
    String teamName;
    @JacksonXmlProperty(localName = "jerseyNumber")
    @Expose(serialize = true)
    int jerseyNumber;
    @JacksonXmlProperty(localName = "statistics")
    @Expose(serialize = true)
    Statistics statistic;

}
