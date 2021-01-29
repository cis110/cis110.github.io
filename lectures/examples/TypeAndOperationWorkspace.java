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
         * MOD: 8 % 3: 3 goes in to 8 two times: 3 * 2 = 6 8 - 6 = 2; 2 is called the
         * "remainder after division" or "mod" 483.2 % 5.435345345345 5.342348203489
         * goes into 483.2 t times: 5..... * t = x; 483.2 - x = 1.99.... 1.99 is called
         * the remainder after division
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

        // middle initial example
        // first candidate
        // char middleInitial = S;

        // second candidate
        char middleInitial = 'S';

        // third candidate
        // char middleInitial = "S";

        // Here comes char stuff

        char capitalA = 'A';
        System.out.println(capitalA);

        System.out.println('A' + 0);

        System.out.println((int) 'A');

        System.out.println((char) 65);

        System.out.println((int) 'a');

        System.out.println((int) '0');

        // Boolean work
        System.out.println(true);
        System.out.println(false);

        // NOT
        System.out.println(!true);
        System.out.println(!false);

        // AND
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && true);
        System.out.println(false && false);

        // OR
        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(false || false);

        // other operators:
        System.out.println(5 == 5);
        System.out.println(5 == 6);
        System.out.println(5 != 6);
        System.out.println(5 < 6);
        System.out.println(5.0 > 6);
        System.out.println(5 >= 6);
        System.out.println(5 <= 6.457894);

    }
}