package vyatsu.fileconverter.JsonStructure;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import java.util.List;

@Builder
public record Team (
    @JsonProperty("name")
    @SerializedName("name")
    String teamName,
    @JsonProperty("players")
    @SerializedName("players")
    List<PlayerJson> players){
}
