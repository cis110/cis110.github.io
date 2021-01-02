public class IsPrime {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        
        boolean isPrime = true;
        int maxFactor = (int) Math.sqrt(num);
        
        for (int i = 2; i <= maxFactor; i++) {
            if (num % i == 0) { // i evenly divides num
                isPrime = false;
                break;
            }
        }
        
        System.out.println(isPrime);
    }
}