import lombok.val;
import org.junit.jupiter.api.Test;
import vyatsu.fileconverter.Main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainClassTests {

    private final String inputFilePath = getResourcePath("players.xml");
    private final String outputFilePath = "src/test/resources/result/players.json";

    private String getResourcePath(final String fileName) {
        try {
            return Paths.get(ClassLoader.getSystemResource(fileName).toURI()).toString();
        } catch (URISyntaxException exception) {
            throw new RuntimeException("Ошибка преобразования URI для ресурса.: " + fileName, exception);
        }
    }

    @Test
    void mainWithCorrectArgsTest() {
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
    void mainWithIncorrectArgsTest() {
        val errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));

        try {
            String[] args = {inputFilePath};
            Main.main(args);
            assertTrue(errContent.toString().contains("некорректное количество аргументов"));
        } finally {
            System.setErr(System.err);
        }
    }
}
