package vyatsu.fileconverter.JsonStructure;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teams {
    @SerializedName("team")
    Team team;
}
