public class GuessTheNumber{
    public static void main(String[] args) {
        System.out.println("Guess a number 0 through 9. You have three tries.");
        int answer = (int)(Math.random()*10);
        //First Guess
        int guess = StdIn.readInt();
        if (guess == answer) {//They guessed correctly
            System.out.println("Congratulations! You win!");
        }
        else {
            if (guess > answer) {//If number is smaller
                System.out.println("Try again, the number is smaller");
            }
            else {//If number is higher
                System.out.println("Try again, the number is larger");
            }
            //Second Guess
            guess = StdIn.readInt();
            if (guess == answer) {//Second guess correct
                System.out.println("Congratulations! You win!");
            }
            else {//Second guess incorrect
                if (guess > answer) {
                    System.out.println("Try again, the number is smaller");
                }
                else {
                    System.out.println("Try again, the number is larger");
                }
                
                guess = StdIn.readInt();
                if (guess == answer) {//SThird guess correct
                    System.out.println("Congratulations! You win!");
                }
                else {//final guess incorrect
                    System.out.println("Sorry, the correct answer was " + answer);
                }
            }
        }
    }
}
