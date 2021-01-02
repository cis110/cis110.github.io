
public class Sorts
{
    /**
     * Swaps values at positions i and j inside an array
     * 
     * @param A the array
     * @param i the position of the first element
     * @param j the position of the second element
     */
    public static void swap(Comparable[] A, int i, int j)
    {
        Comparable tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }


    /**
     * insertion sort implementation
     * @param A the array to sort
     */
    public static void insertionSort(Comparable[] A)
    {
        for (int i = 1; i < A.length; i++) // Insert i'th record
            for (int j = i; (j > 0) && (A[j].compareTo(A[j - 1]) < 0); j--)
                swap(A, j, j - 1);
    }


    /**
     * bubble sort implementation
     * @param A the array to sort
     */
    public static void bubbleSort(Comparable[] A)
    {
        for (int i = 0; i < A.length - 1; i++) // Insert i'th record
            for (int j = 1; j < A.length - i; j++)
                if (A[j - 1].compareTo(A[j]) > 0)
                    swap(A, j - 1, j);
    }


    /**
     * selection sort implementation
     * @param A the array to sort
     */
    public static void selectionSort(Comparable[] A)
    {
        for (int i = 0; i < A.length - 1; i++)
        { // Select i'th biggest record
            int bigindex = 0; // Current biggest index
            for (int j = 1; j < A.length - i; j++) // Find the max value
                if (A[j].compareTo(A[bigindex]) > 0) // Found something bigger
                    bigindex = j; // Remember bigger index
            swap(A, bigindex, A.length - i - 1); // Put it into place
        }
    }
}
