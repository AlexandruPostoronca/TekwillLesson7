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
    public void testSubstringWithinBounds() {
        // Test for when substring range is within the bounds of the string
        simpleTest("hello world\n2 8", "llo wor");
    }

    @Test
    public void testSubstringEntireString() {
        // Test for when substring range is the entire string
        simpleTest("hello world\n0 10", "hello world");
    }

    @Test
    public void testSubstringFirstCharacter() {
        // Test for when substring range is the first character only
        simpleTest("hello world\n0 0", "h");
    }

    @Test
    public void testSubstringLastCharacter() {
        // Test for when substring range is the last character only
        simpleTest("hello world\n10 10", "d");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testSubstringOutOfRange1() {
        // Test for when substring range is out of bounds (i < 0)
        simpleTest("hello world\n-1 5", "");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testSubstringOutOfRange2() {
        // Test for when substring range is out of bounds (j > str.length() - 1)
        simpleTest("hello world\n2 11", "");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testSubstringOutOfRange3() {
        // Test for when substring range is out of bounds (i > j)
        simpleTest("hello world\n5 2", "");
    }

    public void simpleTest(String inputString, String expectedOutput) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}