package vyatsu.fileconverter.converters;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import lombok.experimental.UtilityClass;
import vyatsu.fileconverter.JsonStructure.NBAPlayersJson;
import vyatsu.fileconverter.JsonStructure.Team;
import vyatsu.fileconverter.XmlStructure.NBAPlayers;
import vyatsu.fileconverter.XmlStructure.Player;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class JsonToXmlConverter {
    public List<Player> extractPlayers(final NBAPlayersJson nbaPlayersJson) {
        return nbaPlayersJson.getTeams().stream()
                .flatMap(teams -> {
                    Team team = teams.getTeam();
                    String teamName = team.getTeamName();
                    return team.getPlayers().stream().map(player -> {
                        player.setTeamName(teamName);
                        return player;
                    });
                })
                .collect(Collectors.toList());
    }

    public void convertToXml(final NBAPlayersJson nbaPlayersJson, final String fileName) {
        List<Player> players = extractPlayers(nbaPlayersJson);
        NBAPlayers nbaPlayersXml = new NBAPlayers();
        nbaPlayersXml.setPlayers(players);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);

        try {
            File file = new File(fileName);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(file, nbaPlayersXml);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

