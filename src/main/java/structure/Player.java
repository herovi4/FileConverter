package structure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Player {
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "position")
    private String position;
    @JacksonXmlProperty(localName = "teamName")
    private String teamName;
    @JacksonXmlProperty(localName = "jerseyNumber")
    private int jerseyNumber;
    @JacksonXmlProperty(localName = "statistics")
    private Statistics statistic;

}
