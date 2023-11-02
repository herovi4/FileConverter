package structure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
