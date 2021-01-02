/**
 * Auto Generated Java Class.
 */
public class Overloading {
  
  //signature average(int , int )
  public static int  average(int a, int b){
    
    return (a + b) / 2; 
    
  }
  
  //signature average(int, int , int)
  //valid overloading
   public static int  average(int a, int b, int c){ 
    return (a + b + c) / 3;   
  }
   
   //signature average(double, double)
  //valid overloading
   public static double  average(double a, double b){ 
    return (a + b) / 2;   
  }
   
   //signature average(int , double )
  public static double  average(int a, double b){
    
    return (a + b) / 2; 
    
  }
  
  //signature average(double , int )
  //valid overloading
  public static double  average(double a, int b){
    
    return (a + b) / 2; 
    
  }
  
  //same signature average(int , int )
  //compiler error
  //public static int average(int x, int y){   
  //  return (x + y) / 2; 
  //}
  
  // return type not part of signature
  //compiler error
  //public static double average(int x, int y){   
  //  return (x + y) / 2.0; 
 //}
  
  
  public static void main(String[] args) { 
    
    System.out.println(average(3, 5));
    
  }
  
  
}
