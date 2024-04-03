import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testBasic() {
        simpleTest("loHel", "Hello 3");
    }

    @Test
    public void testNoMove() {
        simpleTest("Hello", "Hello 0");
    }

    @Test
    public void testMoveAll() {
        simpleTest("abcde", "abcde 5");
    }

    @Test
    public void testMoveMoreThanLength() {
        simpleTest("abcde", "abcde 5");
    }

    @Test
    public void testSingleChar() {
        simpleTest("a", "a 1");
    }

    public void simpleTest(String expectedOutput, String... inputLines) {
        String inputString = String.join(System.lineSeparator(), inputLines);
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}