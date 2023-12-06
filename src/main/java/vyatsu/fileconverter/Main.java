package vyatsu.fileconverter;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import vyatsu.fileconverter.convert.service.ConverterUtils;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            if (args.length == 2) {
                val inputFileName = args[0];
                val outputFileName = args[1];

                ConverterUtils.getConverter(inputFileName).convert(inputFileName, outputFileName);
            } else if (args.length == 0) {
                val inputFileName = Menu.getInputFilePath();
                val outputFileName = Menu.getOutputFilePath();
                ConverterUtils.getConverter(inputFileName).convert(inputFileName, outputFileName);
                log.info(String.format("Файл %s успешно конвертирован в файл %s", inputFileName, outputFileName));
            } else {
                log.error("Получено некорректное количество аргументов");
            }
        } catch (Exception exception) {
            System.out.println("Ошибка!");
            log.info(String.format("Произошла ошибка: %s", exception.getMessage()));
            log.error("Ошибка: {} {}.\nДетали: {}", exception.getMessage(), exception.getCause(), exception.getStackTrace());
        }
    }
}

