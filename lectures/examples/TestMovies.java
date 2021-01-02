/**
 * Auto Generated Java Class.
 */
public class TestMovies {
  
  
  public static void main(String[] args) { 
    
    Movie m1 = new Movie("Moneyball", 2011, 133, "Sports", "Blueray", 15.00);
    
    //to acccess the attributes of m1 we use '.'
    System.out.println(m1.title);
    System.out.println(m1.price);
    //modify the price of m1
    m1.price = 12.00;
    System.out.println(m1.title);  
    System.out.println(m1.price);
    
    Movie m2 = new Movie("Sicko", 2007, 116, "Documentary", "Streaming", 11.75);
    System.out.println(m2.title);
    System.out.println(m2.genre);
    System.out.println(m2.price);
    
    Movie m3 = new Movie();
     System.out.println(m3.title);
    System.out.println(m3.genre);
    System.out.println(m3.price);
    System.out.println(m3.format);
    
  }
  
 
  
}
