public class Functions {
    public static int max(int a, int b, int c) {
        if (a > b) {
            if (a > c) return a;
            else return c;
        } else {
            if (b > c) return b;
            else return a;
        }
    }
    
    public static double power(double base, int exp) {
        if (base == 0.0 && exp <= 0) {
            return Double.NaN;
        } else {
            double out = 1.0;
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
    }
}