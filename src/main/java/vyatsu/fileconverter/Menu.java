package vyatsu.fileconverter;

import lombok.experimental.UtilityClass;
import lombok.val;

import java.util.InputMismatchException;
import java.util.Scanner;

@UtilityClass
public final class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public int chooseOperation() {
        while (true) {
            System.out.println("Выберите операцию:\n1. Преобразовать XML в JSON\n2. Преобразовать JSON в XML");
            try {
                val choice = scanner.nextInt();
                if (choice >= 1 && choice <= 2) {
                    return choice;
                }
                System.out.printf("Неверный выбор: %s. Пожалуйста, выберите 1 или 2%n", choice);
            } catch (InputMismatchException invalidInputException) {
                System.err.println("Введено некорректное значение. Пожалуйста, введите число.");
                scanner.nextLine();
            }
        }
    }

    public String getInputFilePath() {
        System.out.println("Введите путь к исходному файлу:");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public String getOutputFilePath() {
        System.out.println("Введите путь к выходному файлу:");
        return scanner.nextLine();
    }

}
