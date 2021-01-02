import static org.junit.Assert.*;
import org.junit.Test;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link ListBasedBag} class.
 *
 * @author Partner 1's name (pid)
 * @author Partner 2's name (pid)
 * @version (place the date here, in this format: yyyy.mm.dd)
 */
public class ListBasedBagTest {
  // ~ Instance/static variables .............................................

  // ~ Constructor ...........................................................

  // ----------------------------------------------------------
  /**
   * Create a new test class
   */
  public ListBasedBagTest() {
    // The constructor is usually empty in unit tests, since it runs
    // once for the whole class, not once for each test method.
  }

  // ----------------------------------------------------------
  /**
   * Test method for {@link ListBasedBag#add(java.lang.Object)}. Left as an
   * exercise for you to test add.
   */
  @Test
  public void testAdd() {
    fail("Not yet implemented");
  }

  // ----------------------------------------------------------
  /**
   * Test method for {@link ListBasedBag#remove(java.lang.Object)}.
   */
  @Test
  public void testRemoveNoLongerContains() {
    Bag b = new ListBasedBag();
    Book beloved = new Book("Beloved", "T. Morrison", "823910");
    Book east = new Book("East of Eden", "J. Steinbeck", "839042");

    b.add(beloved);
    b.add(east);
    b.remove(east);
    assertFalse(b.contains(east));
  }

  @Test
  public void testRemoveContainsOther() {
    Bag b = new ListBasedBag();
    Book beloved = new Book("Beloved", "T. Morrison", "823910");
    Book east = new Book("East of Eden", "J. Steinbeck", "839042");

    b.add(beloved);
    b.add(east);
    b.remove(east);
    assertTrue(b.contains(beloved));
  }

  @Test
  public void testRemoveUpdatesSize() {
    Bag b = new ListBasedBag();
    Book beloved = new Book("Beloved", "T. Morrison", "823910");
    Book east = new Book("East of Eden", "J. Steinbeck", "839042");

    b.add(beloved);
    b.add(east);
    b.remove(east);
    assertEquals(1, b.size());
  }

  @Test
  public void testRemoveReturnsBook() {
    Bag b = new ListBasedBag();
    Book beloved = new Book("Beloved", "T. Morrison", "823910");
    Book east = new Book("East of Eden", "J. Steinbeck", "839042");

    b.add(beloved);
    b.add(east);
    Book returned = b.remove(east);
    assertEquals(east, returned);
  }

  @Test
  public void testRemoveUpdatesSize() {
    Bag b = new ListBasedBag();
    Book beloved = new Book("Beloved", "T. Morrison", "823910");
    Book east = new Book("East of Eden", "J. Steinbeck", "839042");

    b.add(beloved);
    b.add(east);
    Book returned = b.remove(east);
    assertEquals(1, b.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveOnEmpty() {
    Bag b = new ListBasedBag();
    Book east = new Book("East of Eden", "J. Steinbeck", "839042");
    Book returned = b.remove(east);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveNotPresent() {
    Bag b = new ListBasedBag();
    Book beloved = new Book("Beloved", "T. Morrison", "823910");
    b.add(beloved);
    Book east = new Book("East of Eden", "J. Steinbeck", "839042");
    Book returned = b.remove(east);
  }

  // ----------------------------------------------------------
  /**
   * Test method for {@link ListBasedBag#removeRandom()}.
   */
  @Test
  public void testRemoveRandomUpdatesSize() {
    Bag b = new ListBasedBag();
    Book beloved = new Book("Beloved", "T. Morrison", "823910");
    Book east = new Book("East of Eden", "J. Steinbeck", "839042");

    b.add(beloved);
    b.add(east);
    b.removeRandom();
    assertEquals(1, b.size());
  }

  @Test
  public void testRemoveRandomBookNotPresent() {
    Bag b = new ListBasedBag();
    Book beloved = new Book("Beloved", "T. Morrison", "823910");
    Book east = new Book("East of Eden", "J. Steinbeck", "839042");

    b.add(beloved);
    b.add(east);
    Book removed = b.removeRandom();
    assertFalse(b.contains(removed));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveRandomOnEmpty() {
    Bag b = new ListBasedBag();
    Book returned = b.removeRandom();
  }

  // ----------------------------------------------------------
  /**
   * Test method for {@link ListBasedBag#contains(java.lang.Object)}.
   */
  @Test
  public void testContainsEmptyBag() {
    Bag b = new ListBasedBag();
    Book beloved = new Book("Beloved", "T. Morrison", "823910");
    assertFalse(b.contains(beloved));
  }

  @Test
  public void testContainsOneBook() {
    Bag b = new ListBasedBag();
    Book beloved = new Book("Beloved", "T. Morrison", "823910");
    b.add(beloved);
    assertTrue(b.contains(beloved));
  }

  @Test
  public void testContainsWrongBook() {
    Bag b = new ListBasedBag();
    Book beloved = new Book("Beloved", "T. Morrison", "823910");
    Book east = new Book("East of Eden", "J. Steinbeck", "839042");

    b.add(beloved);
    assertFalse(b.contains(east));
  }

  @Test
  public void testContainsWrongEdition() {
    Bag b = new ListBasedBag();
    Book beloved = new Book("Beloved", "T. Morrison", "823910");
    Book belovedEdition2 = new Book("Beloved", "T. Morrison", "823911");

    b.add(beloved);
    assertFalse(b.contains(belovedEdition2));
  }

  // ----------------------------------------------------------
  /**
   * Test method for {@link ListBasedBag#isEmpty()}.
   */
  @Test
  public void testIsEmptyNewBag() {
    Bag b = new ListBasedBag();
    assertTrue("Bags start out empty", b.isEmpty());
  }

  @Test
  public void testIsEmptyOneBook() {
    Bag b = new ListBasedBag();
    Book beloved = new Book("Beloved", "T. Morrison", "823910");
    b.add(beloved);
    assertFalse("Bags start out empty", b.isEmpty());
  }

  // ----------------------------------------------------------
  /**
   * Test method for {@link ListBasedBag#size()}.
   */
  @Test
  public void testSizeEmpty() {
    Bag b = new ListBasedBag();

    assertEquals("Empty bag has size 0", 0, b.size());
  }

  @Test
  public void testSizeOne() {
    Bag b = new ListBasedBag();
    Book beloved = new Book("Beloved", "T. Morrison", "823910");
    b.add(beloved);

    assertEquals("One book added", 1, b.size());
  }

  @Test
  public void testSizeDuplicates() {
    Bag b = new ListBasedBag();
    Book beloved = new Book("Beloved", "T. Morrison", "823910");
    b.add(beloved);
    b.add(beloved);
    b.add(beloved);
    assertEquals("One book added three times", 3, b.size());
  }

  // ----------------------------------------------------------
  /**
   * Test method for {@link ListBasedBag#toString()}.
   */
  @Test
  public void testToString() {
    Book beloved = new Book("Beloved", "T. Morrison", "823910");
    Book east = new Book("East of Eden", "J. Steinbeck", "839042");
    Bag b = new ListBasedBag();

    b.add(beloved);
    b.add(east);

    String expectedResult = "Bag{" + beloved.toString() + "; " + east.toString() + "; }";
    String actualResult = b.toString();
    assertEquals(expectedResult, actualResult);
  }

}
