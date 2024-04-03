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
        simpleTest("schedule", "1");
    }

    @Test
    public void tes2() {
        simpleTest("garage", "0");
    }

    @Test
    public void test3() {
        simpleTest("player", "1");
    }

    @Test
    public void test4() {
        simpleTest("biiiiig", "2");
    }

    @Test
    public void test5() {
        simpleTest("hello", "0");
    }

    @Test
    public void test6() {
        simpleTest("banana", "0");
    }

    @Test
    public void test7() {
        simpleTest("strengths", "3");
    }

    @Test
    public void test8() {
        simpleTest("facetious", "1");
    }

    @Test
    public void test9() {
        simpleTest("obsequious", "1");
    }

    public void simpleTest(String input, String expectedOutput) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}