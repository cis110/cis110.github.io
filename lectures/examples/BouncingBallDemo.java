public class BouncingBallDemo {
    public static void main(String[] args) {
        PennDraw.setCanvasSize(500, 500);
        PennDraw.enableAnimation(30);
        
        double ballRadius = 0.1;
        double x = ballRadius;
        double y = 1.0;
        double dy = 0;
        double dx = 0.01;
        double accelGravity = 0.001;
       
        
        while (true) {
            PennDraw.clear(PennDraw.WHITE);
            
            // our code here
            PennDraw.setPenColor(PennDraw.RED);
            PennDraw.filledCircle(x, y, ballRadius);
            x = x + dx;
            y = y - dy;
            dy = dy + accelGravity;
            
            // bounce horizontally
            if (y <= ballRadius) {
                dy = -0.9*dy;
                y = ballRadius;
            }
            
            // bounce off walls
            if (x <= ballRadius || x >= 1 - ballRadius) {
                dx = -dx;
            }
            
            PennDraw.advance(); // display next frame
        }
    }
}