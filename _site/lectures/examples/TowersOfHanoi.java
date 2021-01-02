public class TowersOfHanoi {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        moves(N, true);
    }
    
    public static void moves(int n, boolean left) {
        if (n == 0) {
            return;
        } else {
            moves(n-1, !left); //move n-1 discs in opposite direction
            if (left) {
                System.out.println("Move disc #" + n + " to the left");
            } else {
                System.out.println("Move disc #" + n + " to the right");
            }
            moves(n-1, !left); //move n-1 discs in opposite direction
        }
    }
}