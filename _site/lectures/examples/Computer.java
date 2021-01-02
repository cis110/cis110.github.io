/**
 * Auto Generated Java Class.
 */
public class Computer {
  
  /* Encapsulation
   * Data Fields */
  private String processor;
  private int numCores;
  private double processorSpeed;
  
  //count the number of computers created
  private static int counter = 0;


  // static means that a variable or method belongs to the whole
  // class, and is shared among all objects. 
  // There is only one variable called manufacturer!
  public static String manufacturer = "CIS110";

  //final makes a variable immutable
  //a final variable cannot be changed after being initialized.
  //used to declare constants
  //final variables are often static
  public static final String manufacturer2 = "CIS110";
  
  // Methods
  //no args constructor, for default values
  public Computer(){
    this.processor = "nothing";
    this.numCores = 0;
    this.processorSpeed = 0;    
    counter++;
  }
  
  //args constructor
  public Computer(String processor,
                   int numCores,
                   double processorSpeed){  
    this.processor = processor;
    this.setNumCores(numCores);
    this.processorSpeed = processorSpeed; 
    counter++;
  }
  
  //setter or mutator for numCores
  public void setNumCores(int numCores){
    if(numCores > 0 && numCores < 50){
      this.numCores = numCores;
    }
    else{
     System.out.println("Noooo: illegal argument.."); 
    }
  }
  
  //can a non-static method manipulate static variables?
  public int getNumComputers(){
    return counter;
  }
  
  //can a static method manipulate static variables? 
  public static int getNumComputers2(){
    return counter;
  }
  
  //can a static method manipulate a non-static variable?
 // public static double getprocessorSpeed2(){
  //  return processorSpeed;
  //}
  
  //getter or accessor for numCores
  public int getNumCores(){
    return this.numCores;
  }
  
}
