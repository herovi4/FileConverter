import converters.XMLToJsonConverter;
import structure.NBAPlayers;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        NBAPlayers players = ReaderFromFile.readFromXML("C:\\5 семестр\\Практика\\FileConverter\\players.xml");
        XMLToJsonConverter.transform(players);
    }
}
