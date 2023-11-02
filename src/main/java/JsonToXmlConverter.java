
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import structure.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public static void convertToXml(NBAPlayers nbaPlayersXml, String fileName) {
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
