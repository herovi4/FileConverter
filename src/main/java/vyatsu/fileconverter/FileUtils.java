package vyatsu.fileconverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import vyatsu.fileconverter.JsonStructure.NBAPlayersJson;
import vyatsu.fileconverter.XmlStructure.NBAPlayers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
@Slf4j
@UtilityClass
public class FileUtils {
    XmlMapper xmlMapper = new XmlMapper();
    ObjectMapper objectMapper = new ObjectMapper();

    public NBAPlayers readFromXML(final String filename) {
        try {
            return xmlMapper.readValue(new File(filename), NBAPlayers.class);
        } catch (Exception exception) {
            log.error("Ошибка при чтении из XML файла {}: {}", filename, exception.getMessage(), exception);
            return null;
        }
    }

    public void writeXmlFile(final NBAPlayers nbaPlayersXml, final String fileName) {
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        try {
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), nbaPlayersXml);
        } catch (Exception exception) {
            log.error("Ошибка при записи в XML файл {}: {}", fileName, exception.getMessage(), exception);
        }
    }

    public NBAPlayersJson readFromJson(final String filename) {
        try {
            return objectMapper.readValue(new FileReader(filename), NBAPlayersJson.class);
        } catch (IOException exception) {
            log.error("Ошибка при чтении из JSON файла {}: {}", filename, exception.getMessage(), exception);
            return null;
        }
    }

    public void writeJsonFile(final NBAPlayersJson nbaPlayersJson, final String fileName) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), nbaPlayersJson);
        } catch (IOException exception) {
            log.error("Ошибка при записи в JSON файл {}: {}", fileName, exception.getMessage(), exception);
        }
    }
}
