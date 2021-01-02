/*
 * this is the class used for the clicker poll.
 * as an exercise, try and fix the two issues in it.
 */
public class RepeatedStrings {
    
    /**
     * given an int n and a string str
     * return a string that is the copy of string n times.
     */
    public static String stringTimes(String str, int n) {
        String answer = "";
        for (int i = 0; i < n; i++ ) {
            answer += str;
        }
        
    }
    
    public static void main(String[] args) {
        String doubledStr = stringTimes(5, "NBody");
        System.out.println(doubledStr);
    }
}