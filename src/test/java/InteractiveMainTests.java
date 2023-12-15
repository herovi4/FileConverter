import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vyatsu.fileconverter.Main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainInteractiveTest {
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private ByteArrayOutputStream testOut = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpOutput() {
        try {
            testOut = new ByteArrayOutputStream();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        val printStreamOut = new PrintStream(testOut);
        setOut(printStreamOut);
    }
    private void setUpInput(final String data) {
        val testIn = new ByteArrayInputStream(data.getBytes());
        setIn(testIn);
    }
    @AfterEach
    public void restoreSystemInputOutput() {
        setIn(originalSystemIn);
        setOut(originalSystemOut);
    }

    @Test
    void testMainInteractiveModeWithCorrectInput() {
        setUpInput("src/test//players.json\nsrc/test/resources/players.xml\n");
        Main.main(new String[0]);
        assertTrue(testOut.toString().startsWith("Введите путь к исходному файлу:"+lineSeparator()+
                "Введите путь к выходному файлу:"));
    }
    @Test
    void testMainInteractiveModeWithInCorrectInput() {
        val input = "players.json";
        setUpInput(input);
        Main.main(new String[0]);
        assertTrue(testOut.toString().startsWith("Введите путь к исходному файлу:"+lineSeparator()+
                "Введите путь к выходному файлу:"+lineSeparator()+"Ошибка!"));
    }
}
