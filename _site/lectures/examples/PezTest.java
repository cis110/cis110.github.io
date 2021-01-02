import static org.junit.Assert.*;

import org.junit.*;

public class PezTest {
    @Test
    public void testPezLoadEmpty() {
        PezDispenser pd = new PezDispenser("Test", "Brown", 12);
        
        pd.load();
        
        assertEquals(12, pd.getCount());
        assertEquals("Brown", pd.getColor());
    }
    
    @Test
    public void testDispenseEmpty() {
        PezDispenser pd = new PezDispenser("Test", "Brown", 12);
        
        assertFalse(pd.dispense());
        
        assertEquals(0, pd.getCount());
        assertEquals("Brown", pd.getColor());
    }
    
    @Test
    public void testDispenseNotEmpty() {
        PezDispenser pd = new PezDispenser("Test", "Brown", 12);
        pd.load();
        
        assertTrue(pd.dispense());
        
        assertEquals(11, pd.getCount());
        assertEquals("Brown", pd.getColor());
    }
        
}