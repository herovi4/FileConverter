import structure.NBAPlayers;
import structure.NBAPlayersJson;
import structure.Player;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        NBAPlayersJson nbaPlayersJson = ReaderFromFile.readFromJson("players.json");
        List<Player> players =JsonToXmlConverter.extractPlayers(nbaPlayersJson);

        NBAPlayers nbaPlayersXml = new NBAPlayers();
        nbaPlayersXml.setPlayers(players);

        JsonToXmlConverter.convertToXml(nbaPlayersXml,"players.xml");
    }
}
