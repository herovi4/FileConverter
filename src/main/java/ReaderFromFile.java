
import structure.NBAPlayers;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;


public class ReaderFromFile {
    public static NBAPlayers readFromXML(String filename){
        try {
            File xmlFile = new File(filename);
            XmlMapper xmlMapper = new XmlMapper();
            NBAPlayers nbaPlayers = xmlMapper.readValue(xmlFile, NBAPlayers.class);
            return nbaPlayers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private ReaderFromFile() {
        throw new IllegalStateException("Utility class");
    }
}
