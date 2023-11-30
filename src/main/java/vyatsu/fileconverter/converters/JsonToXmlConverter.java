package vyatsu.fileconverter.converters;

import lombok.experimental.UtilityClass;
import vyatsu.fileconverter.JsonStructure.NBAPlayersJson;
import vyatsu.fileconverter.JsonStructure.Team;
import vyatsu.fileconverter.XmlStructure.NBAPlayers;
import vyatsu.fileconverter.XmlStructure.Player;

import java.util.List;

@UtilityClass
public class JsonToXmlConverter {
    private List<Player> extractPlayers(final NBAPlayersJson nbaPlayersJson) {
        return nbaPlayersJson.getTeams().stream()
                .flatMap(teams -> {
                    Team team = teams.getTeam();
                    String teamName = team.getTeamName();
                    return team.getPlayers().stream().map(player -> {
                        player.setTeamName(teamName);
                        return player;
                    });
                })
                .toList();
    }

    public NBAPlayers convertToXml(final NBAPlayersJson nbaPlayersJson) {
        NBAPlayers nbaPlayersXml = new NBAPlayers();
        nbaPlayersXml.setPlayers(extractPlayers(nbaPlayersJson));
        return nbaPlayersXml;
    }
}

