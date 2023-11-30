package vyatsu.fileconverter;

import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vyatsu.fileconverter.convert.service.Converter;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            if (args.length == 2) {
                val inputFileName = args[0];
                val outputFileName = args[1];

                Converter converter = Converter.getConverter(inputFileName);
                converter.getConverter(inputFileName, outputFileName);
            } else if (args.length == 0) {
                val inputFileName = Menu.getInputFilePath();
                val outputFileName = Menu.getOutputFilePath();
                val converter = Converter.getConverter(inputFileName);
                converter.getConverter(inputFileName, outputFileName);
            } else {
                System.err.println("Получено некорректное количество аргументов");
            }
        } catch (Exception exception) {
            System.err.printf("Произошла ошибка %s", exception.getMessage());
            LOGGER.error("Произошла ошибка %s", exception.getMessage(), exception.getStackTrace());
        }
    }
}

