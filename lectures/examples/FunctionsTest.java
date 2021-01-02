import static org.junit.Assert.*;

import org.junit.*;

public class FunctionsTest {
    @Test
    public void testMaxDescending() {
        //test input
        int a = 3;
        int b = 2;
        int c = 1;
        //expected output
        int expected = 3;
        //actual output
        int actual = Functions.max(a, b, c);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMaxAscending() {
        //test input
        int a = 1;
        int b = 2;
        int c = 3;
        //expected output
        int expected = 3;
        //actual output
        int actual = Functions.max(a, b, c);
        assertEquals(expected, actual);
    }
    
    @Test
    public void textMaxAllEqual() {
        //test input
        int a = 3;
        int b = 3;
        int c = 3;
        //expected output
        int expected = 3;
        //actual output
        int actual = Functions.max(a, b, c);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testPowerPositiveWholeNumbers() {
        //input
        double base = 2;
        int exp = 5;
        double expected = 32;
        double actual = Functions.power(base, exp);
        assertEquals(expected, actual, 1e9);
    }
}
