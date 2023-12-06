package vyatsu.fileconverter.converters;

import lombok.experimental.UtilityClass;
import vyatsu.fileconverter.JsonStructure.NBAPlayersJson;
import vyatsu.fileconverter.JsonStructure.PlayerJson;
import vyatsu.fileconverter.JsonStructure.Team;
import vyatsu.fileconverter.JsonStructure.Teams;
import vyatsu.fileconverter.XmlStructure.NBAPlayers;
import vyatsu.fileconverter.XmlStructure.PlayerXML;
import vyatsu.fileconverter.XmlStructure.Statistics;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;


@UtilityClass
public class XMLToJsonConverter {
    public NBAPlayersJson convertToJson(NBAPlayers players) {
        return NBAPlayersJson.builder()
                .teams(players.getPlayers().stream()
                        .collect(Collectors.groupingBy(PlayerXML::getTeamName, LinkedHashMap::new, Collectors.toList()))
                        .entrySet().stream()
                        .map(entry -> Teams.builder()
                                .team(Team.builder()
                                        .teamName(entry.getKey())
                                        .players(entry.getValue().stream()
                                                .map(playerXML -> PlayerJson.builder()
                                                        .name(playerXML.getName())
                                                        .position(playerXML.getPosition())
                                                        .jerseyNumber(playerXML.getJerseyNumber())
                                                        .statistic(new Statistics(
                                                                playerXML.getStatistic().pointsPerGame(),
                                                                playerXML.getStatistic().assistsPerGame(),
                                                                playerXML.getStatistic().reboundsPerGame()))
                                                        .build())
                                                .toList())
                                        .build())
                                .build())
                        .toList())
                .build();
    }
}
