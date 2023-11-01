package structure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;


public class Statistics {
    @JacksonXmlProperty(localName = "Points_Per_Game")
    private String pointsPerGame;
    @JacksonXmlProperty(localName = "Assists_Per_Game")
    private String assistsPerGame;
    @JacksonXmlProperty(localName = "Rebounds_Per_Game")
    private String reboundsPerGame;
}
