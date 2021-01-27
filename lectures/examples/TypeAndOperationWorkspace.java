/**
 * Name: Harry Smith Pennkey: sharry
 * 
 * Usage: java TypeAndOperationWorkspace
 * 
 * Description: Simple file for testing Java operations over types
 */

public class TypeAndOperationWorkspace {
    public static void main(String[] args) {
        int fivePlusThree = 5 + 3;
        System.out.println("5 + 3 evaluates to " + fivePlusThree);

        int fiveMinusThree = 5 - 3;
        System.out.println("5 - 3 evaluates to " + fiveMinusThree);

        int fiveTimesThree = 5 * 3;
        System.out.println("5 * 3 evaluates to " + fiveTimesThree);

        int fiveDividedThree = 5 / 3;
        System.out.println("5 / 3 evaluates to " + fiveDividedThree);
        
        int fiveModThree = 5 % 3;
        System.out.println("5 % 3 evaluates to " + fiveModThree);
        
        System.out.println("4 % 2 is: " + (4 % 2));
        System.out.println("4.0 % 2.0 is:" + (4.0 % 2.0));
        
        /**
         * MOD:
         * 8 % 3:
             * 3 goes in to 8 two times: 3 * 2 = 6
             * 8 - 6 = 2;
             * 2 is called the "remainder after division" or "mod"
         * 483.2 % 5.435345345345
             * 5.342348203489 goes into 483.2 t times: 5..... * t = x;
             * 483.2 - x = 1.99....
             * 1.99 is called the remainder after division
         */
        
        System.out.println("483.2 % 5.3467123253 is:" + (483.2 % 5.3467123253));
        
        
        
        System.out.println("5 % 2 is: " + (5 % 2));
        System.out.println("6 % 2 is: " + (6 % 2));
        System.out.println("7 % 2 is: " + (7 % 2));


        System.out.println("5.0 + 1.0 evaluates to " + (5.0 + 1.0));
        System.out.println("5.0 / 3.0 evaluates to " + (5.0 / 3.0));
        System.out.println("5 / 3.0 evaluates to " + (5 / 3.0));
        
        System.out.println("Math.sqrt(2) evaluates to " + Math.sqrt(2));
        System.out.println("Math.sqrt(2) squared evaluates to " + (Math.sqrt(2) * Math.sqrt(2)));

    }
}