package vyatsu.fileconverter.JsonStructure;

import lombok.*;
import vyatsu.fileconverter.XmlStructure.Statistics;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerJson {
    String name;
    String position;
    int jerseyNumber;
    Statistics statistic;
}
