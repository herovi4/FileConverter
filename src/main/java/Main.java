import vyatsu.Convert;
import vyatsu.Type;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            String inputFileName = args[0];
            String outputFileName = args[1];

            Convert converter = Convert.convert(inputFileName);
            System.out.println(converter.convert(inputFileName,outputFileName));
        }
        else if(args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            String inputFileName;
            String outputFileName;
            Convert converter;
            System.out.println("Выберите операцию:\n1. Преобразовать XML в JSON\n2. Преобразовать JSON в XML");
            Scanner inFile = new Scanner(System.in);
            Scanner outfile = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (Type.byInt(choice)) {
                case XML_TO_JSON -> {
                    System.out.println("Введите путь к исходному файлу:");
                    inputFileName = inFile.nextLine();
                    System.out.println("Введите путь к выходному файлу:");
                    outputFileName = outfile.nextLine();
                    converter = Convert.convert(inputFileName);
                    System.out.println(converter.convert(inputFileName, outputFileName));
                }
                case JSON_TO_XML -> {
                    System.out.println("Введите путь к исходному файлу:");
                    inputFileName = inFile.nextLine();
                    System.out.println("Введите путь к выходному файлу:");
                    outputFileName = outfile.nextLine();
                    converter = Convert.convert(inputFileName);
                    System.out.println(converter.convert(inputFileName, outputFileName));
                    System.out.println("Преобразование JSON в XML завершено.");
                }
                default -> System.out.println("Неверный выбор. Пожалуйста, выберите операцию снова.");
            }
        }
    }
}

