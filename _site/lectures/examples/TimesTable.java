/**
 * Author: Paul "Will" McBurney
 * 
 * Description: Prints a times table for all numbers 1-10
 * 
 * Execution: java TimesTable
 */

public class TimesTable {
    public static void main(String[] args) {
        //outer loop - i - loops 10 times
        for (int i = 1; i <= 10; i++) {
            //inner loop - j - loops 10 time per i loop
            //                 100 times total
            for (int j = 1; j <= 10; j++) {
                System.out.print((i*j) + "\t");
            }
            System.out.println(); //"hit enter"
        }
    }
}