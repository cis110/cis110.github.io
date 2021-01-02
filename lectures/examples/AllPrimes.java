public class AllPrimes {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        
        //OUTER LOOP - to check every number from 2 to num for primeness
        for (int i = 2; i <= num; i++) {
            //determine if i is prime
            //if it is, I print i
            boolean isPrime = true;
            int maxFactor = (int) Math.sqrt(i);
            //INNER LOOP - check a specific number (i) for primeness
            for (int j = 2; j <= maxFactor; j++) {
                if (i % j == 0) { // j evenly divides i
                    isPrime = false;
                    break;
                }
            }            
            if (isPrime) {
                System.out.println(i);
            }
        }
    }
}