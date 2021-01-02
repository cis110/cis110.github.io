/**
 * CIS 110 Hello Codio
 * 
 * Description: Calculates if a number is prime.
 * 
 * Execution: java Primes [INTEGER]
 */
public class Primes {

    private static boolean isPrime(int x) {
        for (int i = 2; i <= (int) (Math.ceil(Math.sqrt(x))); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Primes [INTEGER]");
        } else {
            int number = Integer.parseInt(args[0]);
            String primality = isPrime(number) ? "prime" : "not prime";
            System.out.println(number + " is " + primality);
        }
    }
}