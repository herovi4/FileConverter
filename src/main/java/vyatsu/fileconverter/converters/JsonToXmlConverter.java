package vyatsu.fileconverter.converters;

import lombok.experimental.UtilityClass;
import vyatsu.fileconverter.JsonStructure.NBAPlayersJson;
import vyatsu.fileconverter.XmlStructure.NBAPlayers;
import vyatsu.fileconverter.XmlStructure.PlayerXML;
import vyatsu.fileconverter.XmlStructure.Statistics;

@UtilityClass
public class JsonToXmlConverter {
    public NBAPlayers convertToXml(final NBAPlayersJson nbaPlayersJson) {
        return NBAPlayers.builder()
            .players(nbaPlayersJson.getTeams().stream()
                .flatMap(team -> team.getTeam().players().stream()
                    .map(playerJson -> PlayerXML.builder()
                        .name(playerJson.name())
                        .position(playerJson.position())
                        .jerseyNumber(playerJson.jerseyNumber())
                        .teamName(team.getTeam().teamName())
                        .statistic(new Statistics(
                            playerJson.statistic().pointsPerGame(),
                            playerJson.statistic().assistsPerGame(),
                            playerJson.statistic().reboundsPerGame()))
                        .build()))
                    .toList())
            .build();
    }
}

