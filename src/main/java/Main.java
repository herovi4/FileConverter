import converters.XMLToJsonConverter;
import structure.NBAPlayers;
import structure.Player;
import structure.NBAPlayers;
import structure.NBAPlayersJson;
import structure.Player;
import java.util.List;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        NBAPlayers players = ReaderFromFile.readFromXML("C:\\5 семестр\\Практика\\FileConverter\\players.xml");
        XMLToJsonConverter.transform(players);
        NBAPlayersJson nbaPlayersJson = ReaderFromFile.readFromJson("players.json");
        List<Player> players =JsonToXmlConverter.extractPlayers(nbaPlayersJson);

        NBAPlayers nbaPlayersXml = new NBAPlayers();
        nbaPlayersXml.setPlayers(players);

        JsonToXmlConverter.convertToXml(nbaPlayersXml,"players.xml");
    }
}
