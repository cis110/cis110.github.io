
/*************************************************************************
 * 
 * Name: Harry Smith
 * 
 * PennKey: sharry
 * 
 * Execution: java LeapYear
 * 
 * Prints true if N corresponds to a leap year, and false otherwise. Assumes N
 * >= 1582, corresponding to a year in the Gregorian calendar.
 * 
 * A leap year takes place every four years. BUT! If the year is divisible by
 * 100, it's not actually a leap year. BUT! If the year is divisible by 400, it
 * is again a leap year!
 *
 *
 *************************************************************************/

public class LeapYear {
    public static void main(String[] args) {

        int inputYear = 2020;
        boolean isLeapYear;

        // check if the year is divisible by 4
        isLeapYear = (inputYear % 4) == 0;

        // check that the year isn't divisible by 100
        isLeapYear = isLeapYear && (inputYear % 100) != 0;

        // if the year is divisible by 400, then it's a leap year anyway
        isLeapYear = isLeapYear || (inputYear % 400) == 0;

        System.out.println("Is " + inputYear + " a leap year?");
        System.out.println(isLeapYear);

    }
}
