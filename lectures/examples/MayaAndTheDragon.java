/**
 * Recursion: function that call itself
 * Recursive function:
 * (1) Base Case (one or more)
 *  stop the recursion
 *  often use a conditional
 *  often have a return statement in the body of the conditional
 * 
 * (2) Recursive call (one or more)
 *   call the function
 *   collect partial result (when the function returns a value)
 *   return statement if the function return a value
 *   the parameter(s) of the recursive call should be modified
 *   so that the base case is reached
 * 
 */
public class MayaAndTheDragon {
  
  //write a recursive function that will print all elements in an array
  public static void printArray(int[] arr){
    printArray(arr, 0);
  }
  
  //helper
  public static void printArray(int[] arr, int index){
    //base case
    if(index >= arr.length){
      return;
    }
    
    
    //print the element at index
    System.out.print(arr[index] + " ");
    
    //recursive call
    printArray(arr, index + 1);
    
    //add a print statement after recursive call
    
  }
  
  
  //write a recursive fucntion that will print all the letters in a string
  //input: String
  //output: void
  //wrapper function
  public static void printLetterOneAtATime(String s){
    //call helper function
    printLetterOneAtATime(s, 0);
    
  }
  
  //we want to use s.charAt(). we need an extra parameter
  // the position of the letter in the string
  
  //lets create another function
  //Helper recursive function
  //overload the non-recursive function
  public static void printLetterOneAtATime(String s, int index){
    //base case
    if(index >= s.length()){
      return; //will stop the recursion
    }
    //we print the char at index
    System.out.print(s.charAt(index) + " ");
    //recursive call
    printLetterOneAtATime(s, index + 1); 
  }
  
  
  //we need the array and the position where to look in the array
  public static boolean isAnyOdd(int[] A, int pos){
    System.out.println("Value of pos: " + pos);
    //base case. Stops the recursion
    if(pos >= A.length){
      System.out.println("base case pos >= A.length"); 
     return false; 
    }
    
    //recursive call. Collects a partial result 
    //and combines it with the result of the 
    //recursive calls
    return (A[pos] % 2 == 1) || isAnyOdd(A, pos + 1);
    
    
  }
  
  
  public static void main(String[] args) { 
    
    int[] X = {2, 4 , 15, 8};
    // boolean value = isAnyOdd(X, 0);
    // System.out.print(value);
    //printLetterOneAtATime("Hello... Class!");
    printArray(X);
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
