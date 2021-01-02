// /***********************************************************
// * Bouncing Ball Author: Harry Smith
// *
// * Description: Simulates a ball bouncing off the walls and floor with
// * acceleration due to gravity
// *
// * Compilation: javac BouncingBallN.java Execution: java BouncingBallN 3
// *
// * Program Arguments: nBalls - the number of balls to draw
// *
// ***********************************************************/

public class BouncingBallN {
    public static void main(String[] args) {
        // read in the number of balls
        int nBalls = Integer.parseInt(args[0]);

        // setup the window
        PennDraw.setXscale(0, 100);
        PennDraw.setYscale(0, 100);

        // set up the parallel arrays to store ball info
        double[] x = new double[nBalls];
        double[] y = new double[nBalls];
        double[] dx = new double[nBalls];
        double[] dy = new double[nBalls];
        double[] accel = new double[nBalls];

        double ballRadius = 2; // all balls are the same size

        // set up the balls' initial parameters
        for (int i = 0; i < nBalls; i++) {
            x[i] = 100 * Math.random(); // random x from 0 to 100
            y[i] = 50 + 50 * Math.random(); // y from 50 to 100
            dx[i] = Math.random(); // dx from 0 and 1
            dy[i] = .5 + .5 * Math.random(); // dy from .5 and 1
            accel[i] = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        }

        PennDraw.enableAnimation(30);
        while (true) {
            // draw the balls
            PennDraw.clear(PennDraw.WHITE);
            PennDraw.setPenColor(PennDraw.RED);
            for (int i = 0; i < nBalls; i++) {
                PennDraw.filledCircle(x[i], y[i], ballRadius);
            }
            PennDraw.setPenColor(PennDraw.BLACK);
            PennDraw.square(50, 50, 50);

            // simulate motion
            for (int i = 0; i < nBalls; i++) {
                x[i] = x[i] + dx[i];
                y[i] = y[i] - dy[i];
                dy[i] = dy[i] + accel[i];

                // bounce off floor
                if (y[i] <= ballRadius) {
                    dy[i] = -0.9 * dy[i];
                }

                // bounce off walls
                if (x[i] <= ballRadius || x[i] >= (100 - ballRadius)) {
                    dx[i] = -dx[i];
                }
            }

            // animate
            PennDraw.advance();
        }
    }
}
