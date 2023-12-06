package vyatsu.fileconverter.convert.service;

import lombok.experimental.UtilityClass;
import lombok.val;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

@UtilityClass
public class ConverterUtils {
    public Converter getConverter(final String inputFileName) throws ConvertException {
        try {
            if (isXml(inputFileName)) {
                return new ConverterToJson();
            } else if (isJson(inputFileName)) {
                return new ConverterToXml();
            }
        } catch (IOException e) {
            throw new ConvertException("Исходный файл не содержит необходимой структуры", e);
        }

        throw new ConvertException("Исходный файл не содержит необходимой структуры");
    }

    private boolean isXml(final String filename) throws IOException {
        return Objects.requireNonNull(readFirstCharOfFile(filename)).trim().startsWith("<");
    }

    private boolean isJson(final String filename) throws IOException {
        return Objects.requireNonNull(readFirstCharOfFile(filename)).trim().startsWith("{");
    }

    private String readFirstCharOfFile(final String inputFileName) throws IOException {
        try (val bufferedReader = new BufferedReader(new FileReader(inputFileName))) {
            int nextChar;
            while ((nextChar = bufferedReader.read()) != -1) {
                val character = (char) nextChar;
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
