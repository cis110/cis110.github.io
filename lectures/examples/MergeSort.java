/**
 * Auto Generated Java Class.
 */
public class MergeSort {
  
  //A and B must be sorted
  public static int[] merge(int[] A, int[] B)
    {
        int[] tmp = new int[A.length + B.length];
        int i1 = 0; // will iterate through A
        int i2 = 0; // will iterate through B
        for (int i = 0; i < tmp.length; i++)
        {
            if (i1 >= A.length)
            { // A exhausted
                tmp[i] = B[i2++]; //tmp[i] = B[i2]; i2++;
            }
            else if (i2 >= B.length)
            { // B exhausted
                tmp[i] = A[i1++];
            }
            else if (A[i1] <= B[i2])
            { // Get smaller value
                tmp[i] = A[i1++];
            }
            else
            {
                tmp[i] = B[i2++];
            }
        }

        return tmp;
    }
  
  public static void mergeSort(Comparable[] A, Comparable[] temp, int left, int right) {
        if (left == right) return;         // List has one record
        int mid = (left+right)/2;          // Select midpoint
        mergeSort(A, temp, left, mid);     // Mergesort first half
        mergeSort(A, temp, mid+1, right);  // Mergesort second half
        for (int i=left; i<=right; i++)    // Copy subarray to temp
          temp[i] = A[i];
        // Do the merge operation back to A
        int i1 = left;
        int i2 = mid + 1;
        for (int curr = left; curr <= right; curr++) {
          if (i1 == mid+1)                 // Left sublist exhausted
            A[curr] = temp[i2++];
          else if (i2 > right)             // Right sublist exhausted
            A[curr] = temp[i1++];
          else if (temp[i1].compareTo(temp[i2]) <= 0)  // Get smaller value
            A[curr] = temp[i1++];
          else
            A[curr] = temp[i2++];
        }
      }

  
  
  
  public static void main(String[] args) { 
    
//    int[]A = {3, 5, 7, 11, 21};
//    int[]B = {2, 4, 8, 10, 20, 24, 25};
//    
//    int[] X = merge(A, B);
    
    Integer[] X = {7, 1, 5, 3, 6, 2, 0, 6, 12, 10, 8};
        mergeSort(X, new Integer[11], 0, 10);
    for(int i = 0; i < X.length; i++){
      System.out.print(X[i] + " ");
    }
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
