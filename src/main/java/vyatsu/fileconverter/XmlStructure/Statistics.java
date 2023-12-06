package vyatsu.fileconverter.XmlStructure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public record Statistics(@JacksonXmlProperty(localName = "pointsPerGame")
                         String pointsPerGame,
                         @JacksonXmlProperty(localName = "assistsPerGame")
                         String assistsPerGame,
                         @JacksonXmlProperty(localName = "reboundsPerGame")
                         String reboundsPerGame) {
}
