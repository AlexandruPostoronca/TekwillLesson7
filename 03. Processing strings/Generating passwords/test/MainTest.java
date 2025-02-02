import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void testFromProblem() {
        simpleTest(3, 2, 3, 10);
    }

    @Test
    public void test1() {
        simpleTest(1, 2, 2, 7);
    }

    @Test
    public void test2() {
        simpleTest(3, 3, 3, 9);
    }

    @Test
    public void test3() {
        simpleTest(0, 1, 2, 6);
    }

    @Test
    public void test4() {
        simpleTest(1, 0, 1, 5);
    }

    @Test
    public void testMinLengthPassword() {
        simpleTest(1, 1, 1, 3);
    }

    @Test
    public void testMinLengthPasswordWith2OfEach() {
        simpleTest(2, 2, 2, 6);
    }

    @Test
    public void testOneDigitPassword() {
        simpleTest(0, 0, 1, 1);
    }

    @Test
    public void testOneLowerCaseLetterPass() {
        simpleTest(0, 1, 0, 1);
    }

    @Test
    public void testOneUpperCaseLetterPass() {
        simpleTest(1, 0, 0, 1);
    }

    public void simpleTest(int a, int b, int c, int n) {
        String input = a + " " + b + " " + c + " " + n;
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        String output = outputStreamCaptor.toString().trim();

        String message = "The password must have exactly " + n + " characters. Output: " + output;
        assertEquals(message, n, output.length());

        message = "The password must contain at least " + a + " uppercase letters, at least " + b +
                  " lowercase letters, and at least " + c + " digits. Output: " + output;
        assertTrue(message, checkABC(output, a, b, c));

        message = "The password must not contain two or more of the same characters in a row. Output: " + output;
        assertTrue(message, checkNoSameCharacterInRow(output));
    }

    private boolean checkNoSameCharacterInRow(String password) {
        // Check if the password contains two or more of the same characters in a row
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkABC(String password, int a, int b, int c) {
        // Check if the password contains at least A uppercase letters,
        // at least B lowercase letters, and at least C digits
        int numUpperCase = 0;
        int numLowerCase = 0;
        int numDigits = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                numUpperCase++;
            } else if (Character.isLowerCase(ch)) {
                numLowerCase++;
            } else if (Character.isDigit(ch)) {
                numDigits++;
            }
        }
        return numUpperCase >= a || numLowerCase >= b || numDigits >= c;
    }

}