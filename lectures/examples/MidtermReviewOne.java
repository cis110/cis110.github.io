/**
 * Code from in class examples today. This code likely has lines that 
 * cause crashes because that answered some questions that day.
 */


public class MidtermReviewOne {
    public static int x = 5;
    
    /*****
      Start of Noon Class */
    public static void main(String[] args) {
        String s = "Cat";
        System.out.println(s.charAt(0));
        int[] x = {1,2,3};
        System.out.println(x[0]);
        //int[] x = {1,2,3,4};
        System.out.println(sumArray(x));
        //int[] y = new int[0];
        //System.out.println(sumArray(x, 2) + " should be 7");
        //System.out.println(sumArray(y, 0) + " should be 0");
    }
    
    public static int sumArray(int[] arr) {
        System.out.println("x = " + x);
        return sumArray(arr, 0);
    }
    
    public static int sumArray(int[] arr, int n) {
        /** CHECKPOINT **/
        if (n == arr.length) { //base case
            return 0;
        } else {
            return arr[n] + sumArray(arr, n+1);//recursive
        }
    }
     /** END OF NOON CLASS SECTION */
}