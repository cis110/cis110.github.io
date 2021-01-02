/**
 * Auto Generated Java Class.
 */
public class TestArrays {
  
  
  public static void main(String[] args) {
    
    String[] authors = {"Maya Angelou", "James Baldwin", "Richard Wright"};
    String[] y = authors;
    
    System.out.println("1=== authors ===");
    for(int i = 0; i < authors.length; i ++){
      System.out.println(authors[i]); 
    }
    System.out.println("1=== y ====");
    for(int i = 0; i < y.length; i ++){
      System.out.println(y[i]); 
    }
    
    //we modify authors, the change is reflected in both arrays
    authors[2] = "Toni Morrison";
    
    System.out.println("2=== authors ===");
    for(int i = 0; i < authors.length; i ++){
      System.out.println(authors[i]); 
    }
    System.out.println("2=== y ====");
    for(int i = 0; i < y.length; i ++){
      System.out.println(y[i]); 
    }
    
    //we modify y
    y[2] = "Richard Wright";
    
    
    System.out.println("3=== authors ===");
    for(int i = 0; i < authors.length; i ++){
      System.out.println(authors[i]); 
    }
    System.out.println("3=== y ====");
    for(int i = 0; i < y.length; i ++){
      System.out.println(y[i]); 
    } 
  }
  
}
