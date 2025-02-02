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
    public void testOneSubstringOccurrence() {
        simpleTest("1", "ababa", "aba");
    }

    @Test
    public void testOneSubstringOccurrence2() {
        simpleTest("1", "hello there", "the");
    }

    @Test
    public void testMultipleSubstringOccurrences() {
        simpleTest("3", "hello yellow jello", "ll");
    }

    @Test
    public void testNoSubstringOccurrences() {
        simpleTest("0", "hello there", "nope");
    }

    @Test
    public void testEmptyInput() {
        simpleTest("0", "", "ll");
    }

    @Test
    public void testSubstringLongerThanString() {
        simpleTest("0", "abc", "abcd");
    }

    @Test
    public void testSubstringNotFound() {
        simpleTest("0", "abc", "def");
    }

    @Test
    public void testSubstringAtBeginning() {
        simpleTest("1", "abcde", "abc");
    }

    @Test
    public void testSubstringAtEnd() {
        simpleTest("1", "abcde", "cde");
    }

    @Test
    public void testStringAndSubstringSameCharacter() {
        simpleTest("6", "aaaaaa", "a");
    }

    @Test
    public void testSubstringRepeatedInString() {
        simpleTest("3", "ssssss", "ss");
    }

    public void simpleTest(String expectedOutput, String... inputLines) {
        String inputString = String.join(System.lineSeparator(), inputLines);
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}