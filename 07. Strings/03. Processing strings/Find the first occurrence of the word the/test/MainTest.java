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
    public void testFirstOccurrenceOfThe1() {
        simpleTest("The apple is red.", "0");
    }

    @Test
    public void testFirstOccurrenceOfThe2() {
        simpleTest("I ate the red apple.", "6");
    }

    @Test
    public void testFirstOccurrenceOfThe3() {
        simpleTest("I love apples.", "-1");
    }

    @Test
    public void testFirstOccurrenceOfThe4() {
        simpleTest("The sea is near the beach.", "0");
    }

    @Test
    public void testFirstOccurrenceOfThe5() {
        simpleTest("Theater is my favorite place.", "0");
    }

    @Test
    public void testFirstOccurrenceOfThe6() {
        simpleTest("They are playing in the garden.", "0");
    }

    @Test
    public void testFirstOccurrenceOfThe7() {
        simpleTest("there is a book on the table.", "0");
    }

    @Test
    public void testFirstOccurrenceOfThe8() {
        simpleTest("Theme parks are my favorite.", "0");
    }

    @Test
    public void testFirstOccurrenceOfThe_OnlyThe() {
        simpleTest("the", "0");
    }

    @Test
    public void testFirstOccurrenceOfThe_OnlyOneWordNotThe() {
        simpleTest("apple", "-1");
    }

    @Test
    public void testFirstOccurrenceOfThe_TheIsPartOfAnotherWord() {
        simpleTest("theater", "0");
    }

    @Test
    public void testFirstOccurrenceOfThe_TheIsPartOfAWord() {
        simpleTest("theme park", "0");
    }

    @Test
    public void testFirstOccurrenceOfThe_TheIsLastWord() {
        simpleTest("red apple the", "10");
    }

    @Test
    public void testFirstOccurrenceOfThe_AllThe() {
        simpleTest("the the the the the", "0");
    }

    public void simpleTest(String inputString, String expectedOutput) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}