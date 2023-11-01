package structure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Player {
    @JacksonXmlProperty(localName = "Name")
    private String name;
    @JacksonXmlProperty(localName = "Position")
    private String position;
    @JacksonXmlProperty(localName = "Team_Name")
    private String teamName;
    @JacksonXmlProperty(localName = "Jersey_Number")
    private int jerseyNumber;
    @JacksonXmlProperty(localName = "Statistics")
    private Statistics statistic;

}
