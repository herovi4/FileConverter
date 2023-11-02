package structure;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NBAPlayersJson {
    @SerializedName("teams")
    private List<Teams> teams;

}
