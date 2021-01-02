/* StringCounter.java
 *
 * Name: 
 * 
 * Pennkey: 
 * 
 * USAGE: java StringCounter <option> inputString
 * 
 * Examples:
 * 
 * $ java StringCounter uppercase HellO!
 * > HellO! has 2 uppercase letters.
 * 
 * $ java StringCounter numbers m33t1ng
 * > m33t1ng has 3 numbers.
 * 
 * Description:
 * StringCounter takes two inputs. The first is the option about what to count:
 * either "uppercase" to count upper case letters,
 * or "number" to count the amount of individual digits in the given string.
 * The second argument is the input string (no spaces).
 * 
 */

public class StringCounter {
    public static void main(String[] args) {
        String setting = args[0];
        String inputString = args[1];

        switch (setting) {
            case "uppercase":
                int numberUpperCase = countUpperCase(inputString);
                System.out.println(inputString + " has " + numberUpperCase + " uppercase letters.");
                break;
            case "number":
                int numberNumbers = countNumbers(inputString);
                System.out.println(inputString + " has " + numberNumbers + " numbers.");
                break;
        }
    }

    public static int countUpperCase(String s) {
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                counter++;
            }
        }

        return counter;
    }

    public static int countNumbers(String s) {
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                counter++;
            }
        }

        return counter;
    }
}