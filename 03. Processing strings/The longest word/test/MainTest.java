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
    public void testFirstLongestWord1() {
        // comment about the test
        simpleTest("one two three four five six", "three");
    }

    @Test
    public void testFirstLongestWord2() {
        // comment about the test
        simpleTest("apple mango banana cherry", "banana");
    }

    @Test
    public void testFirstLongestWord3() {
        // comment about the test
        simpleTest("car bike scooter", "scooter");
    }

    @Test
    public void testLongestWord_singleWord() {
        // Testing a single word input
        simpleTest("hello", "hello");
    }

    @Test
    public void testLongestWord_onlySpacesAndWords() {
        // Testing a string with only spaces and words
        simpleTest("   hello   world   ", "hello");
    }

    public void simpleTest(String inputString, String expectedOutput) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}