/* Name: Joe Smith
 * Pennkey: jsmith
 * 
 * Execution: java BouncingBall
 * 
 * Animate a ball bouncing within the boundaries of the PennDraw window.
 * 
 */

public class BouncingBall {
    public static void main(String[] args) {
        PennDraw.setCanvasSize(500, 500);
        // Position
        double ballPosX = 0.5, ballPosY = 0.5;
        // Velocity
        double ballVelX = 0.01, ballVelY = -0.01;
        double ballRadius = 0.1;
        PennDraw.enableAnimation(30); // 30 frames per second (FPS)
        
        while (true) {
            // Make the screen white
            PennDraw.clear();
            PennDraw.setPenColor(PennDraw.BLUE);
            PennDraw.filledRectangle(0.5, 0.25, 0.5, 0.25);
            PennDraw.setPenColor(PennDraw.RED);
            PennDraw.filledCircle(ballPosX, ballPosY, ballRadius);

            // Update position X and Y coords with velocity components
            ballPosX = ballPosX + ballVelX;
            ballPosY = ballPosY + ballVelY;

            /* Check the ball's position relative to the screen's bounds,
             * and if it's close enough to the bounds, flip the ball's X or Y
             * velocity depending on if it's by a vertical or horizontal wall
            */
            if ((ballPosY - ballRadius <= 0.0 && ballVelY < 0.0) ||
               (ballPosY + ballRadius >= 1.0 && ballVelY > 0.0)) {
                ballVelY = ballVelY * -1 + (Math.random() - 0.5) * 0.001;
            }
            if ((ballPosX - ballRadius <= 0.0 && ballVelX < 0.0) ||
               (ballPosX + ballRadius >= 1.0 && ballVelX > 0.0)) {
                ballVelX = ballVelX * -1 + (Math.random() - 0.5) * 0.001;
            }
            PennDraw.advance();
        }
    }
}