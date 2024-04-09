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
    public void testFromProblem() {
        simpleTest("kayak", "yes");
    }

    @Test
    public void testSingleCharString() {
        simpleTest("a", "yes");
    }

    @Test
    public void testPalindromeString() {
        simpleTest("racecar", "yes");
    }

    @Test
    public void testNonPalindromeString() {
        simpleTest("hello", "no");
    }

    @Test
    public void testLongPalindromeString() {
        simpleTest("wasitacaroracatisaw", "yes");
    }

    @Test
    public void testUpperCasePalindromeString() {
        simpleTest("AMANAPLANACANALPANAMA", "yes");
    }

    @Test
    public void testUpperCaseNonPalindromeString() {
        simpleTest("HELLO", "no");
    }

    @Test
    public void testRandomWord() {
        simpleTest("random", "no");
    }

    @Test
    public void testRandomWord2() {
        simpleTest("randomword", "no");
    }

    public void simpleTest(String inputString, String expectedOutput) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}