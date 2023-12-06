import lombok.val;
import org.junit.jupiter.api.Test;
import vyatsu.fileconverter.Main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainClassTests {
    private final String inputFilePath = "src/test/resources/players.xml";
    private final String outputFilePath = "src/test/resources/result/players.json";
    @Test
    void MainWithCorrectArgsTest() {
        String[] args = {inputFilePath, outputFilePath};

        try {
            Main.main(args);

            val outputFile = new File(outputFilePath);
            assertTrue(outputFile.exists());
        } finally {
            val outputFile = new File(outputFilePath);
            if (outputFile.exists()) {
                outputFile.delete();
            }
        }
    }

    @Test
    void MainWithIncorrectArgsTest() {
        val errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));

        try {
            String[] args = {inputFilePath};
            Main.main(args);

            assertTrue(errContent.toString().contains("Получено некорректное количество аргументов"));
        } finally {
            System.setErr(System.err);
        }
    }
}
