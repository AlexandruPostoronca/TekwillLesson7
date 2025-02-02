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
        simpleTest("string\nstring", "true");
    }

    @Test
    public void test2() {
        simpleTest("string\nstr ing", "true");
    }

    @Test
    public void test3() {
        simpleTest("string\nmy string", "false");
    }

    @Test
    public void test4() {
        simpleTest("hello\nhello ", "true");
    }

    @Test
    public void test5() {
        simpleTest("world\nworld  ", "true");
    }

    @Test
    public void test6() {
        simpleTest("\n\n", "true");
    }

    @Test
    public void test7() {
        simpleTest("  \n   ", "true");
    }

    @Test
    public void test8() {
        simpleTest("This is a string\nThisisastring", "true");
    }

    @Test
    public void test9() {
        simpleTest("A\nA", "true");
    }

    @Test
    public void test10() {
        simpleTest("\n\n", "true");
    }

    @Test
    public void test11() {
        simpleTest("hello\nhi", "false");
    }

    @Test
    public void test12() {
        simpleTest("hello world\nhelloworld", "true");
    }

    public void simpleTest(String inputString, String expectedOutput) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}