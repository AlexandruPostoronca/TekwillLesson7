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
        //Leap year
        simpleTest("2020-02-29", "02/29/2020");
    }

    @Test
    public void test2() {
        simpleTest("2022-01-31", "01/31/2022");
    }

    @Test
    public void test3() {
        simpleTest("2023-03-28", "03/28/2023");
    }

    @Test
    public void test4() {
        simpleTest("1999-12-31", "12/31/1999");
    }

    @Test
    public void test5() {
        simpleTest("2023-12-31", "12/31/2023");
    }

    @Test
    public void test6() {
        simpleTest("2023-04-01", "04/01/2023");
    }

    public void simpleTest(String inputString, String expectedOutput) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}