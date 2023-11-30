package vyatsu.fileconverter;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.google.gson.GsonBuilder;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;
import vyatsu.fileconverter.JsonStructure.NBAPlayersJson;
import vyatsu.fileconverter.XmlStructure.NBAPlayers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
@UtilityClass
@FieldDefaults(makeFinal = true)
public class WriterToFile {
    XmlMapper xmlMapper = new XmlMapper();
    public  void writeJsonFile(NBAPlayersJson nbaPlayersJson, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            var gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(nbaPlayersJson, writer);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    public  void writeXmlFile(NBAPlayers nbaPlayersXml, String fileName){
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        try {
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), nbaPlayersXml);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
