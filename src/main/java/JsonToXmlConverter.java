import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import structure.NBAPlayers;
import structure.NBAPlayersJson;

import java.io.FileWriter;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void transformToXml(NBAPlayersJson players, String xmlFilename) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(players);
            FileWriter writer = new FileWriter(xmlFilename);
            writer.write(xml);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
