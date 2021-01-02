/**
 * Auto Generated Java Class.
 */
public class TestRefComputer {
  
  
  public static void main(String[] args) { 
    //Computer[] computers = new Computer[10];
    // null references... NullPointerException
    // System.out.println("Computer: " + computers[0].getNumCores());
    //assign a pointee to computer[0]
    //computers[0] = new Computer();
    //System.out.println("Computer: " + computers[0]);
    //for(int i = 0; i < 10; i++){
    //  System.out.print(computers[i] + " ");
    //}
    
    Computer c1 = new Computer("intel", 4, 2.5);
    //System.out.println(c1);
    //assign  reference to another reference
    Computer c2 = c1; //sharing the same pointee - shallow copy
    System.out.println("C1: " + c1);
    System.out.println("C2: " + c2);
    //change C2 processor
    c2.setProcessor("AMD");
    System.out.println("C1: " + c1);
    System.out.println("C2: " + c2);
    //check if two references are sharing the same pointee
    //use ==
    System.out.println(c1 == c2); //true
    
    Computer c3 = new Computer("intel", 8, 4.5);
    Computer c4 = new Computer("intel", 8, 4.5); //deep copy
    //shallow equality
    System.out.println(c3 == c4); //false
    System.out.println(c3.equals(c4)); //true
    System.out.println(c1.equals(c2)); //true
    
  }
  
  
  
}
