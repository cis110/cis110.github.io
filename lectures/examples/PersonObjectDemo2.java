public class PersonObjectDemo2 {
  
  public static void main(String[] args) {
    Person p1 = new Person("John", 20);
    Person p2 = new Person("Sally", 23);
    
    System.out.println("P1's name is "+ p1.getName());
    System.out.println("P2's age is "+ p2.getAge());
    
    p1.sayHello(p1);
    p2.sayHello(p1);
  }
}


// Person
// Fields: name, age
// Methods: 
//   Person(String myName, int myAge)
//   String getName()
//   int getAge()
//   void sayHello()
class Person {
  // fields
  private String name;
  private int age;
  
  // constructor
  public Person(String myName, int myAge) {
    name = myName;
    age = myAge;
  }
  
  public String getName() { return name; }
  public int getAge() { return age; }
  
  public void sayHello(Person p) {
    System.out.println("Hello "+p.getName()+". My name is "+getName()+".");
  }
  
  
}

