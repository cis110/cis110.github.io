/**
 * Auto Generated Java Class.
 */
public class LinearSearch {
  
  //recursive function that takes an array of ints and 
  //a target value (x) and returns true if x was found in arr
  //and false otherwise
  //wrapper function
  public static boolean linearSearch(int[] arr, int x){
    //call helper function- launch the recursion
    return linearSearch(arr, x, 0);
    
  }
  
  //helper
  public static boolean linearSearch(int[] arr, int x, int pos){
    //base case(s)
    
    // (2) x was not found in arr
    if(pos >= arr.length){
      return false;
    }    

    // (1)we found x
    if(arr[pos] == x){
      return true;
    }
    
    
    
    //recursive call(s)
    return linearSearch(arr, x, pos + 1);
    
  }
  
  
  public static void main(String[] args) { 
    
    int[] y = {6, 7, 9, 4, 23, 8, 1};
    System.out.print(linearSearch(y, 4));
    
  }
  
  
}
