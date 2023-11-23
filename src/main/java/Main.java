import lombok.val;
import vyatsu.fileconverter.Menu;
import vyatsu.fileconverter.Type;
import vyatsu.fileconverter.convert.service.Convert;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            if (args.length != 2 && args.length != 0) {
                System.err.println("Получено некорректное количество аргументов");
                return;
            }
            if (args.length == 2) {
                val inputFileName = args[0];
                val outputFileName = args[1];

                Convert converter = Convert.convert(inputFileName);
                converter.convert(inputFileName, outputFileName);
            } else {
                String inputFileName;
                String outputFileName;
                Convert converter;

                int choice = Menu.chooseOperation();

                switch (Type.byInt(choice)) {
                    case XML_TO_JSON -> {
                        inputFileName = Menu.getInputFilePath();
                        outputFileName = Menu.getOutputFilePath();
                        converter = Convert.convert(inputFileName);
                        converter.convert(inputFileName, outputFileName);
                        logger.info("Преобразование из xml в json прошло успешно.");
                    }
                    case JSON_TO_XML -> {
                        inputFileName = Menu.getInputFilePath();
                        outputFileName = Menu.getOutputFilePath();
                        converter = Convert.convert(inputFileName);
                        converter.convert(inputFileName, outputFileName);
                        logger.info("Преобразование из json в xml прошло успешно.");
                    }
                }
            }
        } catch (Exception exception) {
            System.err.println("Произошла ошибка " + exception.getMessage());
        }
    }
}

