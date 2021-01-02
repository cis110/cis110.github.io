/**
 * Auto Generated Java Class.
 */
public class LoopScope {
  
  
  public static void main(String[] args) { 
    //int a = 5;
    //double b = 3;   
    //System.out.println(a + "" + b);
    //System.out.println(a + b);
    
    
    // for (int i = 0; i < 3; i++) {
    //  for (int j = i; j < 3; j++) { 
    //    int c = i;
    //  }
    //  System.out.println(c);   
    // }
    
    // for (int i = 0; i < 3; i++) { 
    //   int b = 0;
    //   for (int j = i; j < 3; j++) { 
    //     b++;
    //   }
    //   System.out.println(b);         
    // }
    
    int a = 0; 
    for (int i = 0; i < 3; i++) { 
      int b = 0;
      a++;
      for (int j = i; j < 3; j++) { 
        b++;
      }
      System.out.println(b);
    }
    
    System.out.println(a);
  
  }
  
  
}
