import lombok.Cleanup;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vyatsu.fileconverter.Main;

import java.io.*;

import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InteractiveMainTests {
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        @Cleanup
        val testOut = new ByteArrayOutputStream();
        val printStreamOut = new PrintStream(testOut);
        setOut(printStreamOut);
    }

    private void setUpInput(final String data) {
        @Cleanup
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
        assertTrue(testOut.toString().startsWith("Введите путь к исходному файлу:" + System.lineSeparator() +
                "Введите путь к выходному файлу:"));
    }

    @Test
    void testMainInteractiveModeWithInCorrectInput() {
        val input = "players.json";
        setUpInput(input);
        Main.main(new String[0]);
        assertTrue(testOut.toString().startsWith("Введите путь к исходному файлу:" + System.lineSeparator() +
                "Введите путь к выходному файлу:" + System.lineSeparator() + "Ошибка!"));
    }
}
