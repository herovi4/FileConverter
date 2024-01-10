import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vyatsu.fileconverter.Main;
import vyatsu.fileconverter.Menu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class MainInteractiveTest {
    private static final String OUTPUT_DIR = "src/test/resources/result/";

    private PrintStream printStreamOut;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        printStreamOut = new PrintStream(testOut);
        setOut(printStreamOut);
    }

    private void setUpInput(final String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        Menu.setSCANNER(new Scanner(testIn));
    }

    @AfterEach
    public void restoreSystemInputOutput() throws IOException {
        if (testIn != null) {
            testIn.close();
        }
        Menu.setSCANNER(new Scanner(in));

        if (printStreamOut != null) {
            printStreamOut.close();
        }
        setOut(System.out);
    }

    @Test
    void testMainInteractiveModeWithCorrectInput() {
        setUpInput("src/test/resources/players.json\nsrc/test/resources/result/players.xml");
        Main.main(new String[0]);
        assertTrue(testOut.toString().startsWith("Введите путь к исходному файлу:" + lineSeparator() +
            "Введите путь к выходному файлу:"+ lineSeparator() + "Успех!"));
    }

    @Test
    void testMainInteractiveModeWithInCorrectInput() {
        setUpInput("\nincorrect.json\nfdgf");
        Main.main(new String[0]);
        assertTrue(testOut.toString().startsWith("Введите путь к исходному файлу:" + lineSeparator() +
            "Введите путь к выходному файлу:" + lineSeparator() + "Ошибка!"));
    }
    @AfterEach
    void cleanUp() throws IOException {
        try {
            Files.list(Paths.get(OUTPUT_DIR))
                .filter(path -> path.toString().endsWith(".json") || path.toString().endsWith(".xml"))
                .forEach(path -> {
                    try {
                        Files.deleteIfExists(path);
                    } catch (IOException exception) {
                        log.error("Ошибка удаления файла: {}", path.toString(), exception);
                    }
                });
        } catch (IOException exception) {
            log.error("Ошибка при чтении файлов в каталоге: {}", OUTPUT_DIR, exception);
            throw new IOException("Ошибка при чтении файлов в каталоге: " + OUTPUT_DIR, exception);
        }
    }
}
