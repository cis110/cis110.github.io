public class PersonObjectDemo {
  public static void main(String[] args) {
    Person p1 = new Person("John", 123456789);
    Person p2 = new Person("Sally", 234567890);
    
    System.out.println("P1's name is " + p1.getName());
    System.out.println("P2's SSN is " + p2.getSSN());
    
    p1.sayHello();
    p2.sayHello();
    
  }
}

  

// Person object
// Fields: name, ssn
// Methods: 
//    Person(String myName, int mySSN)
//    String getName()
//    int getSSN()
//    void sayHello()

class Person {
  // fields
  private String name;
  private int ssn;
  private static int numPeople = 0;
  
  // constructor
  public Person(String myName, int mySSN) {
    name = myName;
    ssn = mySSN;
    numPeople++;
    System.out.println("There are "+ numPeople +" Person instances.");
  }
  
  // methods
  public String getName() {  return name;  }
  
  public int getSSN() {  return ssn;  }
  
  public void sayHello() {
    System.out.println("Hello, my name is " + getName()+ ".");
  }
}
  
  