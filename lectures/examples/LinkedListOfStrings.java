// please note that this is an INCOMPLETE implementation

public class LinkedListOfStrings {
  
    private Node first = null;
    
    private class Node { String item; Node next; }
    
    
    // Constructors, other methods, etc. go here...
   
   
    public String get(int index) {
      
      if (index < 0 || index >= size()) {
        throw new IllegalArgumentException(
                     "invalid index " + index);
      }
      
      int currIdx = 0;
      for (Node curr = first; curr != null; curr = curr.next) {
        if (currIdx == index) {
          return curr.item;
        }
        currIdx++;
      }
      return null;
    }
    
    
    public String toString() {
      String s = "";
      for (Node curr = first; curr != null; curr = curr.next) {
        s += node.item + " ";
      }
      return s;
    }
    
    
    
    public static void main(String[] args) {
      
      LinkedListOfStrings list = new LinkedListOfStrings();
      list.add("Apples");
      list.add("Oranges");
      list.add("Pears");
      System.out.println(list);  // should print "Apples Oranges Pears "
      
      list.remove(2);
      System.out.println(list);  // should print "Apples Oranges "
    }
                 
}