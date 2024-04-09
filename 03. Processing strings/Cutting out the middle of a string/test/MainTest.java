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
    public void test1() {
        // Basic input with odd length
        simpleTest("Hello", "Helo");
    }

    @Test
    public void test2() {
        // Basic input with even length
        simpleTest("abcd", "ad");
    }

    @Test
    public void test3() {
        // Input with only one character
        simpleTest("a", "");
    }

    @Test
    public void test4() {
        // Input with special characters
        simpleTest("#$%^&", "#$^&");
    }

    @Test
    public void test5() {
        // Input with mix of upper and lower case characters
        simpleTest("HaPpY", "HapY");
    }

    @Test
    public void test6() {
        // Input with digits
        simpleTest("Hello123", "Hel123");
    }

    @Test
    public void test7() {
        // Input with only middle character
        simpleTest("abcdefg", "abcefg");
    }

    @Test
    public void test8() {
        // Test Case 10 - Input with only two middle characters
        simpleTest("abcdefgh", "abcfgh");
    }

    public void simpleTest(String inputString, String expectedOutput) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}