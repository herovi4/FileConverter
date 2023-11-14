package vyatsu;

import vyatsu.converters.XMLToJsonConverter;
import vyatsu.structure.NBAPlayers;
import vyatsu.structure.NBAPlayersJson;

import java.io.*;

public interface Convert {
    String convert(String input,String output ) throws IOException;
    static Convert convert(String input) throws IOException {
        if (isXml(input)) {
            return new XmlToJsonConverter();
        } else if (isJson(input)) {
            return new JsonToXmlConverter();
        } else {
            throw new IllegalArgumentException("Не удалось определить формат входных данных.");
        }
    }
    private static boolean isXml(String filename) throws IOException {
        String fileData = readFile(filename);
        return fileData.trim().startsWith("<");
    }

    private static boolean isJson(String filename) throws IOException {
        String fileData = readFile(filename);
        return fileData.trim().startsWith("{");
    }
    private  static String readFile(String input) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(input)));
        String line;
        StringBuilder sb = new StringBuilder();
        while((line=br.readLine())!= null){
            sb.append(line.trim());
        }
        return  sb.toString();
    }
}
class XmlToJsonConverter implements Convert{
    @Override
    public String convert(String inputFileName, String outputFileName) throws IOException {
        NBAPlayers playersXML = ReaderFromFile.readFromXML(inputFileName);
        XMLToJsonConverter.transform(playersXML, outputFileName);
        return "Преобразование XML в JSON завершено.";
    }
}
class JsonToXmlConverter implements Convert{
    @Override
    public String convert(String inputFileName, String outputFileName) throws IOException {
        NBAPlayersJson nbaPlayersJson = ReaderFromFile.readFromJson(inputFileName);
        vyatsu.converters.JsonToXmlConverter.convertToXml(nbaPlayersJson, outputFileName);
        return "Преобразование JSON в XML завершено.";
    }
}





