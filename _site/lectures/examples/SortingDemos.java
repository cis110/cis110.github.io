
public class SortingDemos {
    
    // Wrapper function
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }
    
    // Helper function (recursive)
    private static void mergeSort(int[] arr, int left, int right) {
        // Need to split our array into two halves, then merge the
        // halves
        
        // Base case: Left index is equal to or past the right index
        // Similar to binary search
        if(left >= right) {
            return;
        }
        
        // How to split our array if we're using indices rather than literally
        // making two new array halves?
        int mid = (left + right) / 2;
        // First half is left to mid, second half is mid + 1 to right
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        // Final step: merge [left, mid] sub-array with [mid + 1, right] sub-array
        merge(arr, left, mid, right);
        System.out.print("Merged sub-array:\n");
        printArr(arr, left, right);
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        // 4 possible states:
        // 1) index a for left array and index b for right array are both still in their sub-array bounds
        // 2) index a for left array is out of its bounds but b is still in bounds
        // 3) index b for right array is out of its bounds but a is still in bounds
        // 4) a and b are out of bounds, so we're done
        int a = left;
        int b = mid + 1;
        int[] temp = new int[right - left + 1];
        int tempIndex = 0;
        // Handle (1):
        while(a <= mid && b <= right) {
            if(arr[a] < arr[b]) {
                temp[tempIndex] = arr[a];
                ++tempIndex;
                ++a;
            }
            else { // arr[b] <= arr[a]
                temp[tempIndex] = arr[b];
                ++tempIndex;
                ++b;
            }
        }
        // Handle(2)
        while(b <= right) {
            temp[tempIndex] = arr[b];
            ++tempIndex;
            ++b;
        }
        // Handle (3)
        while(a <= mid) {
            temp[tempIndex] = arr[a];
            ++tempIndex;
            ++a;
        }
        // Copy the values in our temporary array
        // back into the array we want to be all values
        // merged overall
        for(int i = 0; i < temp.length; ++i) {
            arr[left + i] = temp[i];
        }
    }
    
    
    public static void main(String[] args) { 
        int[] random = randomArray(8, 20);
        System.out.println("Unsorted:");
        printArr(random);
        mergeSort(random);
        System.out.println("Sorted:");
        printArr(random);
    }
    
    public static void printArr(int[] arr) {
        // For-each loop
        for(int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    
    public static void printArr(int[] arr, int left, int right) {
        // For-each loop
        for(int i = left; i <= right; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static int[] randomArray(int size, int max) {
        int[] result = new int[size];
        for(int i = 0; i < size; ++i) {
            result[i] = StdRandom.uniform(0, max);
        }
        return result;
    }
    
    public static void swapElements(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    // This function sorts the array in-place, i.e. the input
    // array is directly modified. It does not return a new array.
    public static void selectionSort(int[] arr) {
        // Outer loop that tells us where to begin our search
        // for the smallest element in our (sub-)array
        for(int i = 0; i < arr.length; ++i) {
            int min = arr[i]; // init our comparison variable
            int indexOfMin = i;
            // Inner loop compares the rest of the elements in the array
            // to the element we began at to determine which one is the smallest
            // element of the remaining un-sorted array
            for(int j = i + 1; j < arr.length; ++j) {
                if(arr[j] < min) {
                    min = arr[j];
                    indexOfMin = j;
                }
            }
            // Swap min element with ith element
            swapElements(arr, i, indexOfMin);
            printArr(arr);
        }
    }
    
    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; ++i) {
            for(int j = i; j > 0; --j) {
                if(arr[j - 1] > arr[j]) {
                    //Swap
                    swapElements(arr, j, j - 1);
                }
                // Because all elements in our array to the left of i
                // are known to be sorted, we can end our j iteration
                // as soon as arr[j - 1] is LESS THAN arr[j]
                else {
                    break;
                }
            }
            printArr(arr);
        }
    }
    
}
