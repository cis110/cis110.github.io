/**
 * Auto Generated Java Class.
 */
public class TestNodes {
  
  //we will create a chain of nodes
  // Alex-> Ellen -> Christine ->Zoe -> null
  public static void main(String[] args) { 
    //Alex-> null
    Node head = new Node("Alex", null);
    // Alex-> Ellen -> null
    head.next = new Node("Ellen", null);
    
    // Alex-> Ellen -> Christine  -> null
    head.next.next = new Node("Christine", null);
    
    // Alex-> Ellen -> Christine ->Zoe -> null
    head.next.next.next = new Node("Zoe", null);
    
    //print all the names in our list
    System.out.println("Before");
    for(Node curr = head; curr != null; curr = curr.next){
      System.out.println(curr.data);
    }
    
    //We will insert Emma between Ellen and Christine
    // Alex-> Ellen -> Christine ->Zoe -> null
    // Alex-> Ellen -> Emma -> Christine ->Zoe -> null
    Node chrisRef = head.next.next;
    //System.out.println("Christine? " + chrisRef.data);
    head.next.next = new Node("Emma", chrisRef);
    //print all the names in our list
    System.out.println();
    System.out.println();
    System.out.println("After");
    for(Node curr = head; curr != null; curr = curr.next){
      System.out.println(curr.data);
    }
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
