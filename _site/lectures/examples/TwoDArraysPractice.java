/**
 * Auto Generated Java Class.
 */
public class TwoDArraysPractice {
  public static int getLargest(int[][] arr){ //8
    int largest = arr[0][0]; //3
    for(int r = 0; r < arr.length; r++){ //5
      for(int c = 0; c < arr[r].length; c++){ //9
        if(arr[r][c] > largest) {//4
          largest = arr[r][c];//11
          } // end if 7
        } // end column loop 2
      }// end row loop 6
    return largest; // 1
    } // end method  10
    
          
          
        
      
    
  
  
  
  public static void main(String[] args) { 
    int[][] ticketInfo = {{25,20,25}, 
                          {25,20,25}}; 
    String[][] seatingInfo = {{"Jamal", "Maria"}, 
                              {"Jake", "Suzy"}, 
                              {"Emma", "Luke"}};
    
    System.out.println(seatingInfo[2][1]);
    System.out.println(ticketInfo[1][0]);
    System.out.println(seatingInfo[0][1]);
    
    int[][] a = {{2, 4, 6, 8}, 
                 {1, 2, 3, 4}};
    //number of rows in a
    System.out.println(a.length);
    System.out.println(a[1][2]);
    
    //largest value
    System.out.println(getLargest(a));
    
    //value of sum
    int[][] matrix = {{1,1,2,2},
                      {1,2,2,4},
                      {1,2,3,4},
                      {1,4,1,2}}; 
    int sum = 0; 
    int col = matrix[0].length - 2; 
    for (int row = 0; row < 4; row++) { 
      sum = sum + matrix[row][col]; 
    }
    System.out.println(sum);
    
  
    
    //ragged array
    int[][] matrix1 = {{1,1,2,2, 5},
                      {1,2,2,4, 6, 9, 10},
                      {1,2,3,4},
                      {1,4,}};
    
     System.out.println(matrix1.length);
     
     int[][] rag = new int[4][];
     for(int i = 0; i < rag.length; i++){
       rag[i] = new int[(i + 1) * 2];
     }
    
    
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
