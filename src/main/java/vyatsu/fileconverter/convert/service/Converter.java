package vyatsu.fileconverter.convert.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public interface Converter {
    void getConverter(final String inputFileName, final String outputFileName) throws IOException;

    static Converter getConverter(final String inputFileName) throws IOException, ConvertException {
        if (isXml(inputFileName)) {
            return new ConverterToJson();
        } else if (isJson(inputFileName)) {
            return new ConverterToXml();
        } else {
            throw new ConvertException("Исходный файл не содержит необходимой структуры");
        }
    }

    private static boolean isXml(final String filename) throws IOException {
        return readFile(filename).trim().startsWith("<");
    }

    private static boolean isJson(final String filename) throws IOException {
        return readFile(filename).trim().startsWith("{");
    }

    private static String readFile(final String inputFileName) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName))) {
            int nextChar;
            while ((nextChar = bufferedReader.read()) != -1) {
                var character = (char) nextChar;
                if (!Character.isWhitespace(character)) {
                    return Character.toString(character);
                }
            }
            return null;
        } catch (Exception exception) {
            throw new IOException("Не удалось считать файл");
        }
    }
}





