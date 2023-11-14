package vyatsu.converters;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import vyatsu.structure.*;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

public class JsonToXmlConverter {
    public static List<Player> extractPlayers(NBAPlayersJson nbaPlayersJson) {
        List<Player> players = new ArrayList<>();

        for (Teams teams : nbaPlayersJson.getTeams()) {
            Team team = teams.getTeam();
            String teamName = team.getTeamName();
            List<Player> teamPlayers = team.getPlayers();

            for (Player player : teamPlayers) {
                player.setTeamName(teamName);
                players.add(player);
            }
        }
        return players;
    }

    public static void convertToXml(NBAPlayersJson nbaPlayersJson, String fileName) {
        List<Player> players = JsonToXmlConverter.extractPlayers(nbaPlayersJson);
        NBAPlayers nbaPlayersXml = new NBAPlayers();
        nbaPlayersXml.setPlayers(players);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);

        try {
            File file = new File(fileName);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(file, nbaPlayersXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
