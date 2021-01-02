/**
 * Auto Generated Java Class.
 */
public class TestComputerNode {
  
  //search for a Computer in a Linked list
  public static boolean searchComputer(ComputerNode n, 
                                       Computer target){
    while(n != null){
      //we are comparing computer 
      //stored in the data attribute/field
      if(n.data.equals(target)){
        return true;
      }
      n = n.next;
    }
   return false;  
  }
  
  
  //method to print all values in list
  //iterate through the list
  public static void printValues(ComputerNode n){
    while(n != null){
      System.out.println(n.data);
      n = n.next;
    }
   
  }
  
  //recursive print values
  public static void printValuesRec(ComputerNode n){
    //base case: end of the list
    if(n == null){
      return; 
    }
    //print value
    System.out.println(n.data);
    //recursive call - move n to the next node
    printValuesRec(n.next);
  }
  
  
  public static void main(String[] args) { 
    ComputerNode head = new ComputerNode(
                           new Computer("intel", 4, 2.5),null);
    head.next = new ComputerNode(
                           new Computer("AMD", 8, 3.7),null);
    // head ->"intel,4,5.5" ->"amd,8,3.7"->null
    //pass the head
    //printValues(head);   
    //printValuesRec(head); 
    //insert new node/value
    // before: head ->"intel,4,5.5" ->"amd,8,3.7"->null
    // after: head ->"intel,4,5.5" ->"qc,4,3.8" ->"amd,8,3.7"->null
    ComputerNode restOfList = head.next;
    //System.out.println(restOfList.data);
    ComputerNode newNode = new ComputerNode(
                              new Computer("qc", 4, 3.8), restOfList);
    
  //System.out.println(newNode.next.data); 
  head.next = newNode;
  printValuesRec(head);
  Computer c = new Computer("qc", 4, 3.8);
  System.out.println(searchComputer(head, c)); //true
  
  Computer d = new Computer("qc", 6, 3.8);
  System.out.println(searchComputer(head, d));//false
  
  }
  
  
}
