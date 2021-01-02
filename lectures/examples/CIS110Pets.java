/**
 * New data type for pets
 * Attributes: name, age, race
 * atttributes types: String, double, String
 * Template to create objects
 */
public class CIS110Pets {
  //we declare the attributes in the outtermost scope
  //a.k.a. data fields
  String name;
  double age;
  String race;
  
  //constructor function/method
  // initialize the data fields
  //create a new CIS110Pets
  //The name of the constructor is the name of the class
  //the constructor has no return type
  //the constructor is not a static method
  
  public CIS110Pets(String pet_name, double pet_age, String pet_race){
    //initialize data fields
    name = pet_name;
    age = pet_age;
    race = pet_race;
  }
  
  
  public static void main(String[] args) { 
    //create a new pet
    //we can use our CIS110Pets data type
    // (1) declaration
    // CIS110Pets pet1;
    
    // (2) initialization: variable_name  = new constructor (arguments);
     // pet1 = new  CIS110Pets("Simba", 1, "lion");
    
    // (1) and (2) in one line
    CIS110Pets pet1 = new  CIS110Pets("Simba", 1, "lion");
    // to access an object's attribute
    // Syntax: variable_name.attribute_name 
    System.out.println(pet1.name + ", " + pet1.age + ", " + pet1.race);
    
    
    CIS110Pets pet2 = new  CIS110Pets("Layla", 0.5, "fish");
    // to access an object's attribute
    // Syntax: variable_name.attribute_name 
    System.out.println(pet2.name + ", " + pet2.age + ", " + pet2.race);
    
    CIS110Pets pet3;
    
    
    
    
  }
  
  
  
}
