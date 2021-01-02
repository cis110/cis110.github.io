public class ArrayFunctions {
    /**
     * This function prints and integer array. Example, if an array were
     * [3, 2, 1, 0] - this function would print "3, 2, 1, 0".
     * Input: arr - array to be printed
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.println(arr[i] + ", ");
            }
        }
    }
    
    /**
     * This function gets the sum total of every integer in an array
     * Input: arr - the input array to sum
     * Output: sum - the combined total of every integer in the input array
     */
    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    
    /**
     * Return the smallest element in the int array
     * Input: arr - an array of integer values
     * Output: The smallest numeric value in arr
     */
    public static int min(int[] arr) {
        if (arr.length == 0) {//there is no valid minimum
            throw new RuntimeException("Error: cannot get min of 0 sized array");
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
    
    public static void main(String[] args) {
        int[] x = {5, 2, 3, 0};
        int[] y = {};
        System.out.println(sum(x) + " should be 10");
        System.out.println(sum(y) + " should be 0");
        
        System.out.println(min(x) + " should be 0");
        System.out.println(min(y) + " should crash");
    }
    
}