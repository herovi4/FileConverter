package vyatsu.fileconverter.JsonStructure;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @JsonProperty("name")
    @SerializedName("name")
    String teamName;
    @JsonProperty("players")
    @SerializedName("players")
    List<PlayerJson> players;
}
