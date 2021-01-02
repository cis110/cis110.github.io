/**
 * This is an example of JUnit testing with objects.
 * 
 * The idea of testing objects is that you check every field
 * after you call a method that has side effects. This is to
 * ensure that:
 *  a) The side effects you want to happen (like load() setting
 *     the number of candies to 12) happen
 *  b) No side effects that you do not anticipate happen (like
 *     load() changing the color of a PezDispenser)
 */

import static org.junit.Assert.*;
import org.junit.*;

public class PezJunitTestMar15 {
    PezDispenserMar15 test;
    
    /**
     * This before method is called BEFORE every test
     * We use this so we do not have to redundantly write code to
     * create a new Pez Dispenser for every test.
     * 
     * If you have trouble understanding what's happening here,
     * it is fine just to create a new Dispenser in every test.
     * You will not lose points.
     */
    
    @Before
    public void setup() {
        test = new PezDispenserMar15("Test","Brown");
    }
    
    /**
     * This method tests the constructor to ensure it
     * instantiates Pez Dispensers correctly
     */
    @Test
    public void constructorTest() {
        assertEquals("Test", test.characterName);
        assertEquals("Brown", test.sleeveColor);
        assertEquals(0, test.count);
        assertEquals(12, test.capacity);
    }
    
    /**
     * This method tests loading an initially empty PezDispenser
     */
    @Test
    public void loadTest() {
        test.load();
        assertEquals(12, test.count);
        assertEquals("Test", test.characterName);
        assertEquals("Brown", test.sleeveColor);
        assertEquals(12, test.capacity);
    }
    
    /**
     * This method tests dispensing from an empty PezDispenser
     */
    @Test
    public void dispenseEmptyTest() {
        assertFalse(test.dispense());
        assertEquals(0, test.count);
        assertEquals("Test", test.characterName);
        assertEquals("Brown", test.sleeveColor);
        assertEquals(12, test.capacity);
    }
    
    /**
     * This method tests dispensing from a non-empty PezDispenser
     */
    @Test
    public void dispenseNotEmptyTest() {
        test.load();
        assertTrue(test.dispense());
        assertEquals(11, test.count);
        assertEquals("Test", test.characterName);
        assertEquals("Brown", test.sleeveColor);
        assertEquals(12, test.capacity);
    }
    
    /**
     * This method tests loading a fixed number of candies 
     * into an empty Pez Dispenser
     */
    @Test
    public void loadIntPDEmptyTest() {
        test.load(2);
        assertEquals(2, test.count);
        assertEquals("Test", test.characterName);
        assertEquals("Brown", test.sleeveColor);
        assertEquals(12, test.capacity);
    }
    
    
    /**
     * This method tests trying to load a fixed number of candies 
     * into an empty Pez Dispenser that is more than the Pez
     * Dispenser can hold
     */
    @Test
    public void loadIntTooManyCandiesTest() {
        test.load(10000);
        assertEquals(12, test.count);
        assertEquals("Test", test.characterName);
        assertEquals("Brown", test.sleeveColor);
        assertEquals(12, test.capacity);
    }
    /**
     * This method tests trying to load a fixed number of candies 
     * into a non-empty Pez Dispenser that is more than the Pez
     * Dispenser can hold
     */
    @Test
    public void loadIntTooManyCandiesTestNotEmpty() {
        test.load();
        test.dispense();
        //test has 11 candies
        test.load(2);
        assertEquals(12, test.count);
        assertEquals("Test", test.characterName);
        assertEquals("Brown", test.sleeveColor);
        assertEquals(12, test.capacity);
    }
    
    /**
     * This test checks to ensure we don't allow people to load
     * negative candies.
     */
    @Test (expected = RuntimeException.class)
    public void loadIntNegativeInputTest() {
        test.load(-3);
    }
}