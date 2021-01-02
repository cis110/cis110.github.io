/***********************************************************
 * Bouncing Ball
 * Author:  Benedict Brown
 * 
 * Description:  copy the list of command line
 *                 arguments to a new array
 *               print out the new array's entries
 *                 before and after copying the values
 * 
 * Compilation:  javac PrintArguments
 * Execution:    java a b c ...
 * 
 * Before 0: null
 * After  0: a
 * Before 1: null
 * Before 1: b
 * Before 2: null
 * Before 2: c
 * ...
 * 
 ***********************************************************/
public class PrintArguments {
    public static void main(String[] args) {
        // make an array of the same length as args to copy to
        System.out.println("Length: " + args.length);
        String[] argsCopy = new String[args.length];

        // print each element of the new array, copy in the
        // corresponding element from args, then print it again
        for (int i = 0; i < args.length; i++) {
            System.out.println("Before " + i + ": " +
                               argsCopy[i]);
            argsCopy[i] = args[i];
            System.out.println("After  " + i + ": " +
                               argsCopy[i]);
        }
    }
}