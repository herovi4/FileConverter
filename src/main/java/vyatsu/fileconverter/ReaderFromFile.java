package vyatsu.fileconverter;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;
import vyatsu.fileconverter.JsonStructure.NBAPlayersJson;
import vyatsu.fileconverter.XmlStructure.NBAPlayers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@UtilityClass
public class ReaderFromFile {
    public NBAPlayers readFromXML(final String filename) {
        try {
            File xmlFile = new File(filename);
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(xmlFile, NBAPlayers.class);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public NBAPlayersJson readFromJson(final String filename) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(filename);
            return gson.fromJson(reader, NBAPlayersJson.class);
        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
