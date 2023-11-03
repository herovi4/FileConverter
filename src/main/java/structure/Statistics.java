package structure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Statistics {
    @JacksonXmlProperty(localName = "pointsPerGame")
    private String pointsPerGame;
    @JacksonXmlProperty(localName = "assistsPerGame")
    private String assistsPerGame;
    @JacksonXmlProperty(localName = "reboundsPerGame")
    private String reboundsPerGame;
}
