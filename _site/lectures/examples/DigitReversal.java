/**
 * Name: Harry Smith PennKey: sharry
 * 
 * Usage: java DigitReversal
 * 
 * Description: Takes a four-digit integer and identifies each of the digits.
 * Then, the program prints out the number with all digits reversed. We can
 * determine the value of each digit by repeated application of % and /
 * (remainder and integer division).
 * 
 * If we start with 4893, then thousands : 4, hundreds : 8, tens : 9, ones : 3.
 * 
 * Prints out "4893 backwards is 3984"
 */

public class DigitReversal {
    public static void main(String[] args) {

        int inputNumber = 4893;

        // Question: How could I use the mod operator to "read" the value
        // of the rightmost digit from this number?
        // ex: How to use % to get 3 from 4893
        // suggestions: 4893 % 1000 (we'll not do this, it *doesn't* work)
        // 4893 % 4890 (this would get 3, but it doesn't generalize for our problem)
        // 4893 % 10 (we'll use this)

        int firstDigit = inputNumber % 10;
        // 10 goes into 4893, 489 times. leaves 4890, which has 3 remaining from 4893
        System.out.println("first digit is: " + firstDigit);

        int workingNumber = inputNumber;
        workingNumber = workingNumber / 10;
        System.out.println("new working number is: " + workingNumber);

        int secondDigit = workingNumber % 10;
        System.out.println("second digit is: " + secondDigit);
        workingNumber = workingNumber / 10;
        System.out.println("new working number is: " + workingNumber);

        int thirdDigit = workingNumber % 10;
        System.out.println("thirdDigit is: " + thirdDigit);
        workingNumber = workingNumber / 10;
        System.out.println("new working number is: " + workingNumber);

        int fourthDigit = workingNumber;

        // we copied inputNumber into workingNumber so that we still have a variable
        // storing our original input.

        // 4893 backwards is 3984. We have each of the digits, and we can recognize
        // that 3984 = 3000 + 900 + 80 + 3

        int reversed = firstDigit * 1000 + secondDigit * 100 + thirdDigit * 10 + fourthDigit;
        System.out.println(inputNumber + " reversed is: " + reversed);

    }
}