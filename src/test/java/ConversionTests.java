import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import vyatsu.fileconverter.convert.service.Converter;
import vyatsu.fileconverter.convert.service.ConverterToJson;
import vyatsu.fileconverter.convert.service.ConverterToXml;
import vyatsu.fileconverter.convert.service.ConverterUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Slf4j
class ConversionTests {
    private static final String OUTPUT_DIR = "src/test/resources/result/";

    private static Stream<Object[]> converterProvider() {
        return Stream.of(
            new Object[]{new ConverterToJson(), "xml", "json"},
            new Object[]{new ConverterToXml(), "json", "xml"}
        );
    }

    @ParameterizedTest
    @MethodSource("converterProvider")
    void convertCreatesFileTest(Converter converter, String inputExtension, String outputExtension) throws Exception {
        val outputFilePath = Paths.get(OUTPUT_DIR, "players." + outputExtension);
        val inputFilePath = getResourcePath("players." + inputExtension);
        val compareFilePath = getResourcePath("players." + outputExtension);

        converter.convert(inputFilePath.toString(), outputFilePath.toString());

        assertFileContentsEqual(outputFilePath, compareFilePath);
    }

    @Test
    void convertJSONtoXMLCreatesFileTest() throws Exception {
        val outputFilePath = Paths.get(OUTPUT_DIR, "players.xml");
        val inputFilePath = getResourcePath("players.json");
        val compareFilePath = getResourcePath("players.xml");

        ConverterUtils.getConverter(inputFilePath.toString()).convert(inputFilePath.toString(), outputFilePath.toString());

        assertFileContentsEqual(outputFilePath, compareFilePath);
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

    private void assertFileContentsEqual(final Path actualFilePath, final Path expectedFilePath) throws IOException {
        val actualContent = Files.readString(actualFilePath);
        val expectedContent = Files.readString(expectedFilePath);

        assertEquals(removeWhiteSpaces(actualContent.trim()), removeWhiteSpaces(expectedContent.trim()));
    }

    private Path getResourcePath(final String fileName) {
        try {
            return Paths.get(ClassLoader.getSystemResource(fileName).toURI());
        } catch (URISyntaxException exception) {
            log.error("Ошибка преобразования URI для ресурса: {}", fileName, exception);
            throw new RuntimeException("Ошибка преобразования URI для ресурса: " + fileName, exception);
        }
    }

    private String removeWhiteSpaces(final String input) {
        return input.replaceAll("\\s+|(?<=\\>)\\s+(?=\\<)|\"([^\"]*)\"", "$1");
    }
}
