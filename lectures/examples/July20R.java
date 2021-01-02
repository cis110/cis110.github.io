/**
 * This class contains the solutions to the July 20 recitation.
 * Exercises in recursion.
 * 
 * CIS 110 Summer 2017 Recitation
 */
public class July20R {
   
    /**
     * Takes in an int array and returns the largest element.
     * Solved recursively. This method makes use of the
     * int max(int arg1, int arg2) in the standard Java Math library.
     */
    public static int largestElement(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        // base case: empty array
        if (array.length == 0) {
            return maxValue;
        } else {
            // compare max with last element in array
            maxValue = Math.max(maxValue, array[array.length - 1]);
            // create a new array with all elements except the last one
            int[] subarray = new int[array.length - 1];
            for (int i = 0; i < subarray.length; i++) {
                subarray[i] = array[i];
            }
            // recursive step: compare this max with max of smaller case
            return Math.max(maxValue, largestElement(subarray));
        }
    }
    
    /*
     * Draws the Cantor set at the given depth
     * Inputs:
     *   numLevels: the number of levels of recursion
     *   x, y: the coordinates of the left endpoint of the line drawn at this
     *     level
     *   length: the length of the line to be drawn at this level
     */
    public static void cantor(int numLevels, double x, double y, double length) {
        System.out.println("x = " + x + ", y = " + y + ", depth = " + numLevels);
        
        if (numLevels == 0) {
            return;
        } else {
            // draw the actual line
            PennDraw.line(x, y, x + length, y);
            // recursive calls to handle the rest of the lines
            cantor(numLevels - 1, x, 
                   y - 0.15, length / 3.0);
            cantor(numLevels - 1, x + (2.0 / 3.0) * length, 
                   y - 0.15, length / 3.0);
        }
    }
    
    public static void main(String[] args) {
        int[] noElement = new int[0];
        System.out.println("Testing base case. Expected : " + Integer.MIN_VALUE
                               + ", Actual : " + largestElement(noElement));
        int[] oneElementArray = {-1};
        System.out.println("Testing one element case. Expected : -1, "
                               + "Actual : " + largestElement(oneElementArray));
        int[] genericArray = {-1, 20, 33, 14, 32};
        System.out.println("Testing generic case. Expected : 33, Actual : "
                               + largestElement(genericArray));
        
    }
    
    
    
    
}