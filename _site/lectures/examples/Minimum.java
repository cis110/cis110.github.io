public class Minimum {
    public static void main(String[] args) {
        int[] randomArray = {10000, -123, 40, 0, -5, 3};
        
        for (int i = 0; i < randomArray.length; i++) {
            System.out.print(randomArray[i] + " ");
        }
        
        int minimum = randomArray[0];
        
        for (int i = 1; i < randomArray.length; i++) {
            if (randomArray[i] < minimum) {
                minimum = randomArray[i];
            }
        }
        
        System.out.println("\n" + "The minimum is: " + minimum);
    }
}