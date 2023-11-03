import structure.NBAPlayers;
import structure.NBAPlayersJson;
import structure.Player;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NBAPlayersJson nbaPlayersJson = ReaderFromFile.readFromJson("players.json");
        List<Player> players =JsonToXmlConverter.extractPlayers(nbaPlayersJson);

        NBAPlayers nbaPlayersXml = new NBAPlayers();
        nbaPlayersXml.setPlayers(players);

        JsonToXmlConverter.convertToXml(nbaPlayersXml,"players.xml");
    }
}