package structure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

public class Statistics {
    @JacksonXmlProperty(localName = "pointsPerGame")
    @Expose(serialize = true)
    private String pointsPerGame;
    @JacksonXmlProperty(localName = "assistsPerGame")
    @Expose(serialize = true)
    private String assistsPerGame;
    @JacksonXmlProperty(localName = "reboundsPerGame")
    @Expose(serialize = true)
    private String reboundsPerGame;
}
