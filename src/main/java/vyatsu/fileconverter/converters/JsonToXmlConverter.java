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
                        .flatMap(team -> team.getTeam().getPlayers().stream()
                                .map(playerJson -> PlayerXML.builder()
                                        .name(playerJson.getName())
                                        .position(playerJson.getPosition())
                                        .jerseyNumber(playerJson.getJerseyNumber())
                                        .teamName(team.getTeam().getTeamName())
                                        .statistic(new Statistics(
                                                playerJson.getStatistic().pointsPerGame(),
                                                playerJson.getStatistic().assistsPerGame(),
                                                playerJson.getStatistic().reboundsPerGame()))
                                        .build()))
                        .toList())
                .build();
    }
}

