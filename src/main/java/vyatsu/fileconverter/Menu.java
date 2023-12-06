package vyatsu.fileconverter;

import lombok.experimental.UtilityClass;

import java.util.Scanner;

@UtilityClass
public final class Menu {
    private final Scanner SCANNER = new Scanner(System.in);
    public String getInputFilePath() {
        System.out.println("Введите путь к исходному файлу:");
        return SCANNER.nextLine();
    }
    public String getOutputFilePath() {
        System.out.println("Введите путь к выходному файлу:");
        return SCANNER.nextLine();
    }
}
