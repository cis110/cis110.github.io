/**
 * We want to keep track of all the pets
 * Each pet has a name, age, race
 */
public class Pets {
  
  public static int linearSearch(String[] arr, String x){
    //call helper function- launch the recursion
    return linearSearch(arr, x, 0);
    
  }
  
  //helper
  public static int linearSearch(String[] arr, String x, int pos){
    //base case(s)
    
    // (2) x was not found in arr
    if(pos >= arr.length){
      return -1;
    }    
    // (1)we found x
    if(arr[pos].equals(x)){
      return pos;
    }   
    //recursive call(s)
    return linearSearch(arr, x, pos + 1);
    
  }
  
  
  
  
  
  public static void main(String[] args) { 
    //the name of the pet
    String name = args[0];
    
    // store the values inside arrays
    
    String[] names= {"simba", "nala", "pet", "ethiopia"};
    
    double[] ages = {1, 1.5, 0.5, 4000};
    
    String[] race = {"lion", "dog", "iguana", "bacteria"};
    
    //we find the position of the pet in names
    int pos = linearSearch(names, name);
    System.out.println(pos);
    if(pos >= 0){
      //pet is in our database we print its information
      System.out.println(name + ",  " + ages[pos] + ", " + race[pos]);
    }
  }
  
  /* ADD YOUR CODE HERE */
  
}
