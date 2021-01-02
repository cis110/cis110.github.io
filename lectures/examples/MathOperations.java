/**
 * a couple of example of 'math' functions
 * 
 */
public class MathOperations {
    public static void main(String[] args) {
        if (sameSecondLast(143, 345)) {
            System.out.println("same second last");
        }
        else {
           System.out.println("not same second last");
        }                                 
    }
    /**
     * returns whether or not 
     * two numbers have the same second last digit.
     * this is what was done in the 1pm lecture
     * (since I forgot to erase the 12pm example :) )
     */
    public static boolean sameSecondLast(int a, int b) {
        String aString = "" + a;
        String bString = "" + b;
        char c1 = aString.charAt(aString.length() - 2);
        char c2 = bString.charAt(bString.length() - 2);
        if (c1 == c2 ){
            return true;
        }
        return false;
    }
    
    /**
     * returns whether or not 
     * two numbers have the same last digit.
     * this was covered in the 12pm lecture
     */
    public static boolean sameLast(int a, int b) {
        if (a % 10 == b % 10 ){
            return true;
        }
        return false;
    }
}