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
        simpleTest("The", "TThhee");
    }

    @Test
    public void test2() {
        // Input with spaces
        simpleTest("Hello World!", "HHeelllloo  WWoorrlldd!!");
    }

    @Test
    public void test3() {
        // Input with numbers and special characters
        simpleTest("Th1s $is @ Comp&uter", "TThh11ss  $$iiss  @@  CCoommpp&&uutteerr");
    }

    @Test
    public void test4() {
        // Input with all uppercase characters
        simpleTest("WORLD", "WWOORRLLDD");
    }

    @Test
    public void test5() {
        // Input with all lowercase characters
        simpleTest("hello", "hheelllloo");
    }

    @Test
    public void test6() {
        // Input with mix of uppercase and lowercase characters
        simpleTest("HapPy BiRthdAy", "HHaappPPyy  BBiiRRtthhddAAyy");
    }

    @Test
    public void test7() {
        // Input with only one character
        simpleTest("a", "aa");
    }

    @Test
    public void test9() {
        // Input with empty spaces
        simpleTest("\n", "");
    }

    @Test
    public void test10() {
        // Test Case 10 - Input with non-alphabetic characters
        simpleTest("1234", "11223344");
    }

    public void simpleTest(String inputString, String expectedOutput) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}