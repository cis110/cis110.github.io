/*
 * This program waits for keyboard input
 * As the user presses any key the line grows horizontally
 * If you forget to put the StdDraw.nextKeyTyped() line,
 * a single key press will make the line go all the way across
 */
public class NeverEndingLine {
    public static void main(String[] args) {
        int canvasX = 800;
        int canvasY = 500;
        StdDraw.setCanvasSize(canvasX, canvasY);
        //this numSteps variable will be used to control the line length
        int numSteps = 1;
        //while true - so this loop keeps running
        while (true) {
            //if a key is typed
            if (StdDraw.hasNextKeyTyped()) {
                /*
                each time a key is pressed we want to move 3 more pixels
                the way we do this is by having this numSteps variable
                the numSteps variable increments by 1
                each time a key is pressed.
                */
                StdDraw.line(0, 0.5,  
                             numSteps * 3.0 / canvasX, 0.5);
                numSteps = numSteps + 1;
            }
        }
    }
}