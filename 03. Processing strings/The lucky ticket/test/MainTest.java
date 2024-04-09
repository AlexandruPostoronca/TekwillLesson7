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
        //A regular ticket
        simpleTest("123456", "Regular");
    }

    @Test
    public void test2() {
        //A lucky ticket
        simpleTest("090234", "Lucky");
    }

    @Test
    public void test3() {
        //A ticket with sum of first three digits > sum of last three digits
        simpleTest("875311", "Regular");
    }

    @Test
    public void test4() {
        //A ticket with sum of first three digits < sum of last three digits
        simpleTest("345789", "Regular");
    }

    @Test
    public void test5() {
        //All digits are zero
        simpleTest("000000", "Lucky");
    }

    @Test
    public void test6() {
        //Only one digit is non-zero
        simpleTest("000001", "Regular");
    }

    public void simpleTest(String inputString, String expectedOutput) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}