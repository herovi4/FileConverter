import lombok.experimental.FieldDefaults;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import vyatsu.fileconverter.convert.service.ConverterUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@FieldDefaults(makeFinal = true)
class ConversionTests {
    private static final String OUTPUT_DIR = "src/test/resources/result/";

    @Test
    void convertXMLtoJSONCreatesFileTest() throws Exception {
        val outputFilePath = Paths.get("src/test/resources/result/players.json");
        val inputFilePath = Paths.get("src/test/resources/players.xml");
        val compareFilePath = Paths.get("src/test/resources/players.json");
        ConverterUtils.getConverter(inputFilePath.toString()).convert(inputFilePath.toString(), outputFilePath.toString());

        val actualContent = Files.readString(outputFilePath);
        val expectedContent = Files.readString(compareFilePath);

        assertThat(actualContent).isEqualTo(expectedContent);

    }

    @Test
    void convertJSONtoXMLCreatesFileTest() throws Exception {

        val outputFilePath = Paths.get("src/test/resources/result/players.xml");
        val inputFilePath = Paths.get("src/test/resources/players.json");
        val compareFilePath = Paths.get("src/test/resources/players.xml");
        ConverterUtils.getConverter(inputFilePath.toString()).convert(inputFilePath.toString(), outputFilePath.toString());

        val actualContent = Files.readString(outputFilePath);
        val expectedContent = Files.readString(compareFilePath);

        assertThat(actualContent).isEqualTo(expectedContent);

    }

    @AfterEach
    void cleanUp() throws IOException {
        Files.list(Paths.get(OUTPUT_DIR))
                .filter(path -> path.toString().endsWith(".json") || path.toString().endsWith(".xml"))
                .forEach(path -> {
                    try {
                        Files.deleteIfExists(path);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                });
    }
}
