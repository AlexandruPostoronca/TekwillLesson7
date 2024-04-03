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
    public void testSingleStringWithoutDigits() {
        simpleTest("abcde", "abcde");
    }

    @Test
    public void testSingleStringWithDigits() {
        simpleTest("abcde", "a1b2c3d4e");
    }

    @Test
    public void testMultipleStringsWithoutDigits() {
        simpleTest("abcdefg", "abc de fg");
    }

    @Test
    public void testMultipleStringsWithDigits() {
        simpleTest("acdefg", "a1 c2d e3fg");
    }

    @Test
    public void testAllStringsContainOnlyDigits() {
        simpleTest("", "123 456 7890");
    }

    @Test
    public void testAllStringsContainOnlyNonDigits() {
        simpleTest("abcdefghijklmno", "abcde fghij klmno");
    }

    @Test
    public void testMixedStrings() {
        simpleTest("abcdefg", "a1b2c d3e4 f5g");
    }

    @Test
    public void testInputWithSpaces() {
        simpleTest("abcdefg", "a1b c2d e3f g");
    }

    public void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}