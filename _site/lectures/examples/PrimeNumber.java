public class PrimeNumber {
    public static void main(String[] args) {
        //take in a number
        int n = Integer.parseInt(args[0]);
        
        //get its root
        double root = Math.sqrt(n);
        
        //prime flag
        boolean isPrime = true;
        
        for (int factor = 2; factor <= root && isPrime; factor++) {
            if (n % factor == 0) {
                isPrime = false;
            }
        }
        
        if (isPrime) {
            System.out.println("The number " + n + " is prime");
        } else {
            System.out.println("The number " + n + " is not prime");
        }
    }
}