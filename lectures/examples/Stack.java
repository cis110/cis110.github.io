/** LIFO Stack built using arrays in-class
  * Author: Eric Eaton
  */
public class Stack {
  private int capacity;
  private int size;
  private String[] data;
  
  /** Constructor 
   *  Creates a stack with a capacity of 10 elements
   */
  public Stack() {
    this(10);
  }
    
 /** Constructor
  *  Creates a stack with the specified capacity
  *  Preconditions:  capacity must be >= 0, otherwise the 
  *                  capacity default to 10
  */
  public Stack(int capacity) {
      
    if (capacity <= 10)
      capacity = 10;
      
    this.capacity = capacity;
    size = 0;
    data = new String[capacity];
  }
  
  /** Pops an element from the stack
   *  Returns: the string element, or null if the stack is empty
   */
  public String pop() {
    if (size <= 0) return null;
    String s = data[size-1];
    size--;
    return s;
  }
  
  /** Pushes an element onto the stack
   *  Parameter:  s - the string to push on the stack, cannot be null
   *  Returns:  true if the push succeeded, false otherwise
   */
  public boolean push(String s) {
    if (size >= capacity || s == null) return false;
    data[size] = s;
    size++;
    return true;
  }
  
  /** Getter for capacity
    * Returns: the stack's capacity
    */
  public int getCapacity() { return capacity; }
  
  /** Unit testing code for the Stack object
    */ 
  public static void main(String[] args) {
      Stack stack = new Stack();
      // fill up the stack
      for (int i = 0; i < stack.getCapacity() + 5; i++) {
          boolean b = stack.push("" + i);
          if (b) System.out.println("Pushed "+i);
          else   System.out.println("Failed to push "+i);
      }
      // empty the stack
      for (int i = 0; i < stack.getCapacity() + 5; i++) {
          System.out.println("Popped "+stack.pop());
      }
  }
      
      
}