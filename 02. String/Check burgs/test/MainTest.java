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
    public void test2() {
        simpleTest("Augsburg", "true");
    }

    @Test
    public void test3() {
        simpleTest("Saint Petersburg", "true");
    }

    @Test
    public void test4() {
        simpleTest("Tu", "false");
    }

    @Test
    public void test5() {
        simpleTest("Eisenhüttenstadt", "false");
    }

    @Test
    public void test6() {
        simpleTest("Salzburg", "true");
    }

    @Test
    public void test7() {
        simpleTest("Baden-Baden", "false");
    }

    @Test
    public void test8() {
        simpleTest("Strasbourg", "false");
    }

    @Test
    public void test9() {
        simpleTest("Hamburg", "true");
    }

    @Test
    public void test10() {
        simpleTest("New York", "false");
    }

    @Test(expected = Exception.class)
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