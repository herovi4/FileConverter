import lombok.val;
import org.junit.jupiter.api.Test;
import vyatsu.fileconverter.Main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainClassTests {
    private final String inputFilePath = "src/test/resources/in/players.xml";
    private final String outputFilePath = "src/test/resources/result/players.json";
    @Test
    void MainWithCorrectArgsTest() {
        val args = new String[]{inputFilePath, outputFilePath};
        Main.main(args);
        val outputFile = new File(outputFilePath);
        assertTrue(outputFile.exists());
        outputFile.delete();
    }

    @Test
    void MainWithIncorrectArgsTest() {
        val errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        try {
            val args = new String[]{inputFilePath};
            Main.main(args);

            assertThat(errContent.toString()).contains("Получено некорректное количество аргументов");
        } finally {
            System.setErr(System.err);
        }
    }
}
