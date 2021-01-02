/**
 * Author: Paul "Will" McBurney
 * 
 * Description: calculate b^e with the following limitations:
 * b and e both positive.
 * 
 * Execution: java Exponent base exp
 * 
 * Prints base ^ exp
 */

public class Exponent {
    public static void main(String[] args) {
        //1. get the user input
        int base = Integer.parseInt(args[0]);
        int exp = Integer.parseInt(args[1]);
        
        int answer = 1;
        
        //2. perform calculation
        for (int mults = 0; mults < exp; mults++) {
            answer *= base;
        }
        
        //3. print out the result
        System.out.println(answer);
    }
}