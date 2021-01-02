/**
 * Auto Generated Java Class.
 */
public class TestStringArrayList {
  
  
  public static void main(String[] args) { 
    //StringLinkedList list = new StringLinkedList();
     StringList list = new StringArrayList();
    
    
        //0
        System.out.println(list.size());
        //[]
        System.out.println(list);
        System.out.println(list.isEmpty());
        
        list.append("Hello");
        
         //System.out.println(list.remove(0));
        
        //[<Hello>]
        System.out.println(list);
        //1
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        
        list.append("world");
        System.out.println(list);
        //System.out.println(list.remove(1));
        System.out.println(list.size());
         System.out.println(list);
      
       
        list.insert(1, "class");
        System.out.println(list);
        System.out.println(list.size());
        
        list.insert(1, "CIS110");
        System.out.println(list);
         
        
        System.out.println(list.size());
        
        System.out.println(list);
        System.out.println(list.remove(0));
        System.out.println(list);

   
  }
  
  /* ADD YOUR CODE HERE */
  
}
