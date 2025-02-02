import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

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
    public void testStringStartsWithJ() {
        simpleTest("Java", "true");
    }

    @Test
    public void testStringStartsWithLowercaseJ() {
        simpleTest("java", "true");
    }

    @Test
    public void testStringDoesNotStartWithJ() {
        simpleTest("Kotlin", "false");
    }

    @Test
    public void testEmptyString() {
        simpleTest("\n", "false");
    }

    @Test(expected = NoSuchElementException.class)
    public void testNullString() {
        Main.main(new String[0]);
    }

    public void simpleTest(String inputString, String expectedOutput) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}