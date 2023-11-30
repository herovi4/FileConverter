package vyatsu.fileconverter.XmlStructure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Statistics {
    @JacksonXmlProperty(localName = "pointsPerGame")
    @Expose(serialize = true)
    String pointsPerGame;
    @JacksonXmlProperty(localName = "assistsPerGame")
    @Expose(serialize = true)
    String assistsPerGame;
    @JacksonXmlProperty(localName = "reboundsPerGame")
    @Expose(serialize = true)
    String reboundsPerGame;
}
