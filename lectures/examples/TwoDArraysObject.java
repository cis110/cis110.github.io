/**
 * Auto Generated Java Class.
 */
public class TwoDArraysObject {
  
  //print the content of the 2D array
  public static void printArray(Computer[][] x){
    //2DArray iteration
    for(int i = 0; i < x.length; i++){// rows
      for(int j = 0; j < x[i].length; j++){ //columns
        System.out.print(x[i][j] + " ");
      } 
      System.out.println();
    }
  }
  
  //fill the 2D array with Computer objects
  public static void fillArray(Computer[][] x){
    for(int i = 0; i < x.length; i++){// rows
      for(int j = 0; j < x[i].length; j++){ //columns
        x[i][j] = new Computer();
      } 
    }
    
  }
  
  
  public static void main(String[] args) { 
    
    //2D array (double) declaration
    double[][] matrix = new double[4][5];
    System.out.println(matrix[0]); //what will be printed?
    System.out.println(matrix[0][1]); // 0 vs null
    System.out.println(matrix[3].length);
    System.out.println(matrix.length);
    //System.out.println(matrix[4].length);//?? Error
    //rows indices 0-3
    //System.out.println(matrix[1][5]); //??
    //columns indices 0-4
    matrix[0][1] = 9.4;
    System.out.println(matrix[0][1]);
    
    //2D array of Objects
    Computer[][] computers = new Computer[3][3];
    System.out.println(computers[1][1]); 
    System.out.println(computers[1]);//??
    printArray(computers);
    fillArray(computers);
    //printArray(computers);
    System.out.println(computers[0][0]);
    
    computers[0][0] = new Computer("intel", 4, 3.6);
    //printArray(computers);
    System.out.println(computers[0][0]);
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
