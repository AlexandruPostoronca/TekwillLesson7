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
    public void testSingleCharacter() {
        simpleTest("true", "a");
    }

    @Test
    public void testSubstring() {
        simpleTest("true", "abcd");
    }

    @Test
    public void testSubstringCaseSensitive() {
        simpleTest("false", "azcd");
    }

    @Test
    public void testNotSubstring() {
        simpleTest("false", "xyzz");
    }

    @Test
    public void testNotSubstringRepeatingLetters() {
        simpleTest("false", "abcabc");
    }

    public void simpleTest(String expectedOutput, String... inputLines) {
        String inputString = String.join(System.lineSeparator(), inputLines);
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}