public class JulyNineteen {    
    public static int factorial(int n) {
        if (n == 1) {//base case
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    
    public static int fib(int n) {
        //base cases
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else { //recursion step
            return fib(n - 1) + fib(n - 2);
        }
    }
    
    public static int iterFib(int n) {
        if (n == 0) {
            return 0;
        } else {
            int out = 0;
            int prev = 1;
            int prevPrev = 0;
            for (int i = 1; i < n; i++) {
                out = prev + prevPrev;
                prevPrev = prev;
                prev = out;
            }
            return out;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(iterFib(100));
    }
}