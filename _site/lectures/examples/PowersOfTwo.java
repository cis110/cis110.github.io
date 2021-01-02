public class PowersOfTwo {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int v = 1;
        for (int i = 0; i <= n; i++) {
            System.out.println(i + " " + v);
            n = -1;
            System.out.println("hi");
            v *= 2;
        }
    }
}