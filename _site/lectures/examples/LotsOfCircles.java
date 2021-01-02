/*
 * class that demonstrates keyboard interaction
 * here concentric circles keep getting drawn until
 * the user presses the key q.
 */
public class LotsOfCircles {
    public static void main(String[] args) {
        char c = 0;
        int canvasX = 600;
        int canvasY = 600;
        double radius = 1.0 / canvasX;
        StdDraw.setCanvasSize(canvasX, canvasY);
        
        while (c != 'q') {
            if (StdDraw.hasNextKeyTyped()) {
                /* update the variable c 
                to hold the value of the key the user pressed */
                c = StdDraw.nextKeyTyped();
            }
            StdDraw.circle(0.5, 0.5, radius);
            /* in each iteration of the loop the radius goes up
             1 pixel */
            radius = radius + 1.0 / canvasX;
            StdDraw.show(10);
        }
    }
}