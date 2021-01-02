public class Sorting {
  
  public static void insertionSort(int[] A) {
  for (int i=1; i<A.length; i++) // Insert i'th record
    for (int j=i; (j>0); j--){
     if(A[j] < A[j-1]){
      swap(A, j, j-1);
    }
   }
  }
  
  public static void bubbleSort(int[] A) {
    for (int i=0; i<A.length-1; i++) {
      for (int j=1; j<A.length-i; j++){
        if (A[j-1] > A[j] ){
        swap(A, j-1, j);
        }
      }
    }
  }
  
  public static void selectionSort(int[] A) {
  for (int i=0; i<A.length-1; i++) {       
    int bigindex = 0;                      
    for (int j=1; j<A.length-i; j++)  {     
      if (A[j] > A[bigindex])  { 
        bigindex = j;  
      }
    swap(A, bigindex, A.length-i-1);  
    }
  }
}
  
  public static void swap(int[] x, int i, int j){
    int c = x[i];
    x[i] = x[j];
    x[j] = c;
  }
  
  public static void pritnArray(int[] x){
    for(int i = 0; i < x.length; i++){
      System.out.print(x[i] + " ");
    }
    System.out.println();
  }
  
  public static void main(String[] args) { 
    int[] arr = {5, 7, 3, 9, 2, 67, 1};
    pritnArray(arr);
    //insertionSort(arr);
    //bubbleSort(arr);
    selectionSort(arr);
    pritnArray(arr);
  }  
}