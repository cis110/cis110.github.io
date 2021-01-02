public class GuessTheNumberLoop {
    public static void main(String[] args){
        System.out.println("Guess a number 0 through 9. You have three tries.");
        int answer = (int)(Math.random()*10);
        //First Guess
        int numGuesses = 0;
        int guess = -1;
        while ((answer != guess) && (numGuesses < 3)) {
            System.out.println("Guess a number 0-9");
            guess = StdIn.readInt();
            numGuesses++; //numGuesses = numGuesses + 1;
            
            if (guess == answer){//They guessed correctly
                System.out.println("Congratulations! You win!");
            }
            else {
                if (guess > answer){//If number is smaller
                    System.out.println("Try again, the number is smaller");
                }
                else {//If number is higher
                    System.out.println("Try again, the number is larger");
                }
                
            }
        }
        System.out.println("Game over.");
    }
}