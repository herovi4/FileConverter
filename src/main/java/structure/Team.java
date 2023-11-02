package structure;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Team {
    private String clubName;
    private List<Player> players;
}
