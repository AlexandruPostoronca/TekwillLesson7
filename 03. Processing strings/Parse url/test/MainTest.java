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
    private final String N = System.lineSeparator();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testGetUrlParamsWithPassword() {
        // Tests the function when URL contains a password parameter
        simpleTest("https://target.com/index.html?pass=12345&port=8080&cookie=&host=localhost",
                "pass : 12345" + N + "port : 8080" + N + "cookie : not found" + N +
                "host : localhost" + N + "password : 12345");
    }

    @Test
    public void testGetUrlParamsWithoutPassword() {
        // Tests the function when URL does not contain a password parameter
        simpleTest("https://target.com/index.html?port=8080&cookie=&host=localhost",
                "port : 8080" + N + "cookie : not found" + N + "host : localhost");
    }

    @Test
    public void testGetUrlParamsWithEmptyPassword() {
        // Tests the function when password parameter is present but empty
        simpleTest("https://target.com/index.html?pass=&port=8080&cookie=&host=localhost",
                "pass : not found" + N + "port : 8080" + N + "cookie : not found" + N + "host : localhost");
    }

    public void simpleTest(String inputString, String expectedOutput) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}