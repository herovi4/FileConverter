package vyatsu.structure;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teams {
    @SerializedName("team")
    private Team team;
}
