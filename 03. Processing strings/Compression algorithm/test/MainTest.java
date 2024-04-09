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
    public void testAllCharacters() {
        simpleTest("a20", "aaaaaaaaaaaaaaaaaaaa");
    }

    @Test
    public void testSingleCharacter() {
        simpleTest("a1", "a");
    }

    @Test
    public void testMultipleCharacters() {
        simpleTest("a3b2c1d3", "aaabbcddd");
    }

    @Test
    public void testUpperCase() {
        simpleTest("A3B3C3", "AAABBBCCC");
    }

    @Test
    public void testLowerCase() {
        simpleTest("a2b2c2", "aabbcc");
    }

    @Test
    public void testMixedCase() {
        simpleTest("A2b2C2", "AAbbCC");
    }

    @Test
    public void testLongString() {
        simpleTest("z1y1x1w1v1u1t1s1r1q1p1o1n1m1l1k1j1i1h1g1f1e1d1c1b1a1", "zyxwvutsrqponmlkjihgfedcba");
    }

    public void simpleTest(String expectedOutput, String... inputLines) {
        String inputString = String.join(System.lineSeparator(), inputLines);
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}