package structure;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonPropertyOrder({ "name", "position", "teamName", "jerseyNumber", "statistics" })
@JacksonXmlRootElement(localName = "player")
public class Player {
    @JacksonXmlProperty(localName = "name")
    @Expose(serialize = true)
    private String name;
    @JacksonXmlProperty(localName = "position")
    @Expose(serialize = true)
    private String position;
    @JacksonXmlProperty(localName = "teamName")
    private String teamName;
    @JacksonXmlProperty(localName = "jerseyNumber")
    @Expose(serialize = true)
    private int jerseyNumber;
    @JacksonXmlProperty(localName = "statistics")
    @Expose(serialize = true)
    private Statistics statistic;

}
