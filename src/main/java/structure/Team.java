package structure;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class Team {
    @SerializedName("name")
    private String teamName;
    @SerializedName("players")
    private List<Player> players;
}
