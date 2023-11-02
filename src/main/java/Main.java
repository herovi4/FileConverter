import structure.NBAPlayers;
import structure.NBAPlayersJson;

public class Main {
    public static void main(String[] args) {
        NBAPlayersJson players = ReaderFromFile.readFromJson("players.json");
        if (players != null) {
            JsonToXmlConverter.transformToXml(players, "players.xml");
        }
    }
}
