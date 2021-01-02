/**
 * Auto Generated Java Class.
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class SortableComputerTest {
  
  
  public static void main(String[] args) { 
    SortableComputer c1 = new SortableComputer("Intel", 4, 2.5);
    SortableComputer c2 = new SortableComputer("AMD", 5, 2.7);
    SortableComputer c3 = new SortableComputer("Intel", 8, 2.5);
    SortableComputer c4 = new SortableComputer("QC", 4, 3.1);
    SortableComputer c5 = new SortableComputer("AMD", 6, 3.7);
    SortableComputer c6 = new SortableComputer("QC", 4, 2.5);
    
    //compare c1 and c2
    System.out.println(c1.compareTo(c2)); // -1
    System.out.println(c1.compareTo(c6)); // 0
    System.out.println(c5.compareTo(c2)); //1
    
//    SortableComputer[] computer1 = new SortableComputer[6];
//    computer1[0] = c1;
//    computer1[1] = c2;
//    computer1[2] = c3;
//    computer1[3] = c4;
//    computer1[4] = c5;
//    computer1[5] = c6;
//    
//    System.out.println("Before Sort");
//      for(int i = 0; i < 6; i++){
//      System.out.println(computer1[i]);
//    }
//      
//      //sort the array
//      //sort will use the compaTo metho defined in 
//      //SortableComputer
//      Arrays.sort(computer1);
//    
//      System.out.println("After Sort");
//      for(int i = 0; i < 6; i++){
//      System.out.println(computer1[i]);
//    }
    
    
    // Collections (ADT) <--- List (ADT) <--- {ArrayList, LinkedList}
    List computerList = new LinkedList();
    computerList.add(c1);
    computerList.add(c2);
    computerList.add(c3);
    computerList.add(c4);
    computerList.add(c5);
    computerList.add(c6);
    System.out.println("Before Sort");
      for(int i = 0; i < 6; i++){
      System.out.println(computerList.get(i));
    }
      
      Collections.sort(computerList);
      
       System.out.println("After Sort");
      for(int i = 0; i < 6; i++){
      System.out.println(computerList.get(i));
    }
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
