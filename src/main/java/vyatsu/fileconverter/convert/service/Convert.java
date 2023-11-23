package vyatsu.fileconverter.convert.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public interface Convert {
    void convert(final String input, final String output) throws IOException;

    static Convert convert(final String input) throws IOException, ConvertException {

        if (isXml(input)) {
            return new XmlToJsonConverter();
        } else if (isJson(input)) {
            return new JsonToXmlConverter();
        } else {
            throw new ConvertException("Исходный файл не содержит необходимой структуры");
        }
    }

    private static boolean isXml(final String filename) throws IOException {
        var fileData = readFile(filename);
        return fileData.trim().startsWith("<");

    }

    private static boolean isJson(final String filename) throws IOException {
        var fileData = readFile(filename);
        return fileData.trim().startsWith("{");
    }

    private static String readFile(final String input) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line.trim());
            }

            return stringBuilder.toString();
        } catch (Exception exception) {
            throw new IOException("Не удалось считать файл");
        }
    }
}





