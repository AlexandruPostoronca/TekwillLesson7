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
    public void testInputWithOneCharacter() {
        simpleTest("A", "A");
    }

    @Test
    public void testInputWithTwoCharacters() {
        simpleTest("Ab", "Ab");
    }

    @Test
    public void testInputWithThreeCharacters() {
        simpleTest("AbC", "aBc");
    }

    @Test
    public void testInputWithSpecialCharacters() {
        simpleTest("AbC123!@#", "aBc123!@#");
    }

    @Test
    public void testInputWithUpperCaseOnly() {
        simpleTest("PrOgRaMmInG", "PROGRAMMING");
    }

    @Test
    public void testInputWithLowerCaseOnly() {
        simpleTest("CoMpUtEr", "computer");
    }

    @Test
    public void testInputWithNumbersOnly() {
        simpleTest("1a2b3c", "1A2B3C");
    }

    @Test
    public void testInputWithMixedCase() {
        simpleTest("CoMpUtEr123!@#", "computer123!@#");
    }

    public void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}