package vyatsu.fileconverter.convert.service;

import lombok.experimental.UtilityClass;
import lombok.val;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

@UtilityClass
public class ConverterUtils {

    public Converter getConverter(final String inputFileName) throws ConvertException {
        try {
            if (isFileStartsWith(inputFileName, '<')) {
                return new ConverterToJson();
            }
            if (isFileStartsWith(inputFileName, '{')) {
                return new ConverterToXml();
            }
        } catch (IOException e) {
            throw new ConvertException("Исходный файл не содержит необходимой структуры", e);
        }
        throw new ConvertException("Исходный файл не содержит необходимой структуры");
    }

    private boolean isFileStartsWith(final String filename, final Character prefix) throws IOException {
        return Optional.ofNullable(readFirstCharOfFile(filename))
                .map(firstChar -> firstChar.equals(prefix))
                .orElse(false);
    }

    private Character readFirstCharOfFile(final String inputFileName) throws IOException {
        try (val bufferedReader = new BufferedReader(new FileReader(inputFileName))) {
            int nextChar;
            while ((nextChar = bufferedReader.read()) != -1) {
                val character = (char) nextChar;
                if (!Character.isWhitespace(character)) {
                    return character;
                }
            }
            return null;
        } catch (Exception exception) {
            throw new IOException("Не удалось считать файл");
        }
    }
}
