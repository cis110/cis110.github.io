/**
 * See the TestingExample.java from class slides. It's a class with a single
 * function: findMax(int a, int b, int c). The function from the slides has
 * an intentional error to cause one of these tests to fail.
 */

import static org.junit.Assert.*;

import org.junit.*;

public class TestingExampleTests {
    
    /**
     * This test passes because it doesn't execute the fault
     */
    @Test
    public void testFindMax0() {
        assertEquals("ERROR: findMax(3,2,1) returned the the incorrect result.",
                     3, TestingExample.findMax(3,2,1));
    }
    
    /**
     * This test fails because it executes the fault
     */
    @Test
    public void testFindMax1() {
        assertEquals("ERROR: findMax(1,2,3) returned the the incorrect result",
                     3, TestingExample.findMax(1,2,3));
    }
}