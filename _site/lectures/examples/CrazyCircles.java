/*
 * A class that demonstrates for loops
 * via concentric circles
 */
public class CrazyCircles {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(500, 500);
        for (double radius = 0.5; radius > 0.002; radius -= 0.02) {
            StdDraw.circle(0.5, 0.5, radius);
            //the show controls the animation
            StdDraw.show(100);
        }   
    }
}
