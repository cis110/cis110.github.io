public class UnitDemo {
    
    public static int findMax(int a, int b, int c) {
        if (a > b) {
            if (a > c) return a;
            else return c;
        } else {
            if (b > c) return b;
            else return a;       // should be c
        }
    }
    
}