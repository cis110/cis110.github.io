import static org.junit.Assert.*;
import org.junit.*;

public class UnitDemoTest {
    
    @Test
    public void testFindMax_DifferentArgs() {
        // test 3, 2, 1 
        int expected = 3;
        int actual = UnitDemo.findMax(3,2,1);
        assertEquals("Testing findMax(3,2,1)", expected, actual);
        
        // 1, 2, 3
        assertEquals("Testing findMax(1,2,3)", 3, UnitDemo.findMax(1,2,3));
    }
    
    @Test
    public void testFindMax_SameArgs() {
        // 1, 1, 1
        assertEquals("Testing findMax(1,1,1)", 1, UnitDemo.findMax(1,1,1));
    }
}