package vyatsu.fileconverter.JsonStructure;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import vyatsu.fileconverter.XmlStructure.Player;

import java.util.List;

@Getter
@Setter
public class Team {
    @SerializedName("name")
    String teamName;
    @SerializedName("players")
    List<Player> players;
}
