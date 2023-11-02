
import com.google.gson.Gson;
import structure.NBAPlayers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import structure.NBAPlayersJson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


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
    public static NBAPlayersJson readFromJson(String filename) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(filename);
            return gson.fromJson(reader, NBAPlayersJson.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private ReaderFromFile() {
        throw new IllegalStateException("Utility class");
    }
}
