/**
 * Name: TODO
 * Pennkey: TODO
 * Execution: TODO
 *
 * Description: TODO
**/
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class ReviewTest {
    
    @Test
    public void testConstructorPositiveReview() {
        Movie expectedMovie = new Movie("Momento", "Thriller", "R", 100, 50);
        int expectedScore = 75;
        String expectedDescription = "Really great movie!";
        
        Review review = new Review(expectedMovie, expectedScore, expectedDescription);
        
        // TODO: Write the assert statements for this test.
    }
    
    @Test
    public void testConstructorNegativeReview() {
        Movie expectedMovie = new Movie("Cars 2", "Animated", "G", 100, 50);
        int expectedScore = 45;
        String expectedDescription = "Nowhere near as good as Cars 1!";
        
        Review review = new Review(expectedMovie, expectedScore, expectedDescription);
        
        // TODO: Write the assert statements for this test.
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorInvalidGenre() {
        //TODO: Constructo Movie object that will throw exception
    }
    
}
