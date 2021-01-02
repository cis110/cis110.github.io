/**
 * BouncingBall using variables and conditionals
 * Eric Eaton
 * 
 */

import processing.core.*; 
 
public class BouncingSoccerBallN extends PApplet { 
 
    public static void main(String args[]) { 
        // read in the number of balls
        nBalls = Integer.parseInt(args[0]);

        PApplet.main(new String[]{"BouncingSoccerBallN"});  
    }  

    // number of balls to draw
    static int nBalls;
    
    // ball position
    double[] x, y; 
    
    // ball velocity
    double[] vx, vy;
        
    // acceleration due to gravity
    double[] accel;
    
    // ball properties
    PImage ballImage;
  
    public void setup() { 
        // setup the sketch     
        size(500, 500);
        smooth();
        
        // load the soccer ball image
        ballImage = loadImage(sketchPath("soccer_ball.png"));

        // set up the parallel arrays to store ball info
        x     = new double[nBalls];
        y     = new double[nBalls];
        vx    = new double[nBalls];
        vy    = new double[nBalls];
        accel = new double[nBalls];

        // setup initial ball properties
        for (int i = 0; i < x.length; i++) {
            x[i]  = width * Math.random();         // random x within window
            y[i]  = 0.5f * height * Math.random(); // random y in top half of window
            vx[i] = 1 + 3 * Math.random();         // random x velocity between 1 and 4
            vy[i] = 0;

            // random acceleration between 0.05 and 0.35
            accel[i] = 0.05f + 0.3f * Math.random();
        }
    } 

 
    public void draw() {
        // draw red balls
        background(255);
        fill(255, 0, 0);

        // center images on the given coordinates when we draw them
        imageMode(CENTER);

        for (int i = 0; i < x.length; i++) {
            image(ballImage, (float) x[i], (float) y[i]);
        }
        
        for (int i = 0; i < x.length; i++) {
            // update positions
            x[i] = x[i] + vx[i];
            y[i] = y[i] + vy[i];
        
            // accelerate velocity
            vy[i] = vy[i] + accel[i];
        
            // bounce off floor
            if (y[i] + DIAMETER / 2 >= height) {
                vy[i] = -0.9 * vy[i];          // bounce and lose some energy in the bounce
                y[i] = height - DIAMETER / 2;  // move ball y[i] position to top of floor
            }
        
            // bounce off walls
            if ((x[i] - DIAMETER / 2) <= 0 || (x[i] + DIAMETER / 2) >= width) {
                vx[i] = -vx[i];
            }
        }
    } 
} 
