import lombok.val;
import org.junit.jupiter.api.Test;
import vyatsu.fileconverter.convert.service.Convert;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ConversionTests {
    @Test
    void ConvertXMLtoJSONCreatesFileTest() throws Exception {

        val outputFilePath = Paths.get("src/test/resources/out/players.json");
        val inputFilePath = Paths.get("src/test/resources/in/players.json");
        Convert converter = Convert.convert(inputFilePath.toString());
        converter.convert(inputFilePath.toString(), outputFilePath.toString());

        assertTrue(Files.exists(outputFilePath));

    }

    @Test
    void ConvertJSONtoXMLCreatesFileTest() throws Exception {

        val outputFilePath = Paths.get("src/test/resources/out/players.xml");
        val inputFilePath = Paths.get("src/test/resources/in/players.json");
        Convert converter = Convert.convert(inputFilePath.toString());
        converter.convert(inputFilePath.toString(), outputFilePath.toString());

        assertTrue(Files.exists(outputFilePath));


    }
}
