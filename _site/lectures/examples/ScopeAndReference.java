public class ScopeAndReference {
    public static int x = 5;
    
    /**
     * This function creates an array of side len where the default value
     * of every integer is 5
     */
    public static int[] arrayOfFives(int len) {
        int[] out = new int[len];
        for (int i = 0; i < out.length; i++) {
            out[i] = 5;
        }
        return out;
    }
    
    /**
     * Print the contents of an array
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * Return the input integer value + 1
     */
    public static int xPlusOne() {
        x++;
        return x;
    }
    
    /**
     * Add 1 to every value of the input array
     */
    public static void incrementArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]++;
        }
    }
    
    public static void main(String[] args) { 
        //primative data types are pass by value
        //The VALUE of x is passed, but not x itself
        int x = 5;
        System.out.println(xPlusOne(x) + " should be 6");
        System.out.println(x + " should 5");
        
        //array are pass by reference
        int[] arr = arrayOfFives(5);
        printArray(arr);
        //increment array modifies "arr" even though nothing is returned
        incrementArray(arr);
        printArray(arr);
    }
}
