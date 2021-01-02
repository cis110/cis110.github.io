/**
 * Auto Generated Java Class.
 */
public class TestMovies2 {
  
  
  public static void main(String[] args) { 
    //print the value of movieCounter
    //System.out.println(Movie2.movieCounter);
    System.out.println("Static getter " + Movie2.getStaticMovieCounter2());
    //print the value of movieCounter2
    // System.out.println(Movie2.movieCounter2); error movieCounter2 is private
    // System.out.println(Movie2.getMovieCounter2()); error getMovieCounter2 is not static
    Movie2 m1 = new Movie2("Moneyball", 2011, 133, "Sports", "Blueray", 15.00);
    //System.out.println("m1: "+ m1.movieCounter);
    System.out.println("m1: "+ m1.getMovieCounter2());
    System.out.println("Static getter " + Movie2.getStaticMovieCounter2());
    Movie2 m2 = new Movie2("Sicko", 2007, 116, "Documentary", "Streaming", 11.75);
    //System.out.println("m2: "+ m2.movieCounter);
    System.out.println("m2: "+ m2.getMovieCounter2());
    System.out.println("Static getter " + m2.getStaticMovieCounter2());
    Movie2 m3 = new Movie2();
    //System.out.println("m3: "+ m3.movieCounter);
    System.out.println("m3: "+ m3.getMovieCounter2());
    System.out.println("Static getter " + Movie2.getStaticMovieCounter2());
    
    System.out.println(m3.studio);
    // m3.studio = "CIS110 Fake"; error: cannot change the value of a final variable
  }
  
 
  
}
