package vyatsu.fileconverter.JsonStructure;

import lombok.Builder;
import vyatsu.fileconverter.XmlStructure.Statistics;

@Builder
public record PlayerJson(
    String name,
    String position,
    int jerseyNumber,
    Statistics statistic) {
}
