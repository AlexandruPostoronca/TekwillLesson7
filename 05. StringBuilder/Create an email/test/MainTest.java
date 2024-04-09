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
    public void testBothNameAndSurnameInputs() {
        simpleTest("JohnSmith@work.net", "John", "Smith");
    }

    @Test
    public void testLongSurnameInput() {
        simpleTest("ABCDEFGHIJKLMNOPQRSTUVWXYYZabcdefghijklmnopqrstuvwxYYZ0123456789ABCDEFGHIJKLMNOPQRSTUVWXYYZabcdefghijklmnopqrstuvwxYYZ0123456789@work.net",
                "ABCDEFGHIJKLMNOPQRSTUVWXYYZabcdefghijklmnopqrstuvwxYYZ0123456789", "ABCDEFGHIJKLMNOPQRSTUVWXYYZabcdefghijklmnopqrstuvwxYYZ0123456789");
    }

    @Test
    public void testSpecialCharactersInput() {
        simpleTest("John$%&Smith%^@work.net", "John$%&", "Smith%^");
    }

    @Test
    public void testMultipleSpacesInput() {
        simpleTest("JohnSmith@work.net", "John", "Smith");
    }

    @Test
    public void testMixedCaseInput() {
        simpleTest("JoHnSmItH@work.net", "JoHn", "SmItH");
    }

    public void simpleTest(String expectedOutput, String... inputLines) {
        String inputString = String.join(System.lineSeparator(), inputLines);
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        EmployeeManagement.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}