package structure;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonPropertyOrder({ "name", "position", "teamName", "jerseyNumber", "statistics" })
@JacksonXmlRootElement(localName = "player")
public class Player {
    private String name;
    private String position;
    @JacksonXmlProperty(localName = "teamName")
    private String teamName;
    private int jerseyNumber;
    private Statistics statistic;

}
