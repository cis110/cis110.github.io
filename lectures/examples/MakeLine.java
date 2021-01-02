/*
 * class that demonstrates hasNextKeyTyped
 */
public class MakeLine {
    public static void main(String[] args) {
        int canvasX = 500;
        int canvasY = 500;
        StdDraw.setCanvasSize(canvasX, canvasY);
        int step = 1;
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                StdDraw.nextKeyTyped();
                StdDraw.line(0, 0.5,  step * 3.0 / canvasX, 0.5);
                step = step + 1;
            }
        }
    }
}