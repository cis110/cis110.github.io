public class InClassFunction{
    
    
    public static boolean isOdd(int x) {
        if (x % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public static boolean isEven(int x) {
        return !isOdd(x);
    }
    
    /**
     * This function return base^exp
     * 
     * Example: 2^3 = 8
     */
    public static double power(int base, int exp) {
        if (base == 0 && exp <= 0) {
            return Double.NaN;
        }
        double out = 1.0; //todo
        int loopTo = Math.abs(exp);
        for (int i = 0; i < loopTo; i++) {
            out *= base;
        }
        if (exp > 0) {
            return out;
        } else {
            return 1 / out;
        }
    }
    
    public static void main(String[] args) {
        
        //This block test isOdd
        /**
        boolean is5Odd = isOdd(5);
        System.out.println(is5Odd + " should be true.");
        boolean is4Odd = isOdd(4);
        System.out.println(is4Odd + " should be false.");
        */
        
        //Tests for power function
        
        double twoToTheThree = power(2,3);
        System.out.println(twoToTheThree + " should be 8");
        double zeroSquared = power(0,2);
        System.out.println(zeroSquared + " should be 0");
        double zeroToTheZero = power(0,0);
        System.out.println(zeroToTheZero + " should be " + Double.NaN);    
        double twoToNegTwo = power(2,-2);
        System.out.println(twoToNegTwo + " should be 0.25");
        
    }
}