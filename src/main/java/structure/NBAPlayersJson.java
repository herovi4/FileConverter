package structure;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NBAPlayersJson {
    @SerializedName("team")
    private List<Team> teams;

}
