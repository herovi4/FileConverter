package vyatsu.structure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JacksonXmlRootElement(localName = "NBA_Players")
public class NBAPlayers {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "player")
    private List<Player> players;

}
