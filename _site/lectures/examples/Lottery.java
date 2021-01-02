/*
 * command line example:
 * Lottery guess
 */

public class Lottery
{
    //Constants
    public static final int WINNINGNUMBER = 12345;
    //The number an idiot puts on his briefcase
    
    public static void main(String[] args) {
        if (Integer.parseInt(args[0]) == WINNINGNUMBER) {
            System.out.println("Congratulations, you won the lottery!");
        } else {
            System.out.println("Sorry, you are not a winner");
        }
        System.out.println("Thank you for playing");
    }
}
    
