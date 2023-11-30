package vyatsu.fileconverter.JsonStructure;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NBAPlayersJson {
    @SerializedName("teams")
    List<Teams> teams;
    public NBAPlayersJson(List<Teams> teams) {
        this.teams = teams;
    }
}
