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
    public void testOnlyG() {
        simpleTest("100.0", "GGGG");
    }

    @Test
    public void testOnlyC() {
        simpleTest("100.0", "CCCC");
    }

    @Test
    public void testMixedString() {
        simpleTest("40.0", "acggtgttat");
    }

    @Test
    public void testAllChars() {
        simpleTest("40", "acgtxuCYG");
    }

    @Test
    public void testSingleChar() {
        simpleTest("0.0", "T");
    }

    @Test
    public void theSingleG() {
        simpleTest("100.0", "G");
    }

    public void simpleTest(String expectedOutput, String... inputLines) {
        String inputString = String.join(System.lineSeparator(), inputLines);
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}