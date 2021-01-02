/**
 * BouncingBall using objects
 * Eric Eaton
 * 
 */

import processing.core.*; 
 
public class BouncingBallNObj extends PApplet { 
 
    public static void main(String[] args) { 

        PApplet.main(new String[]{"BouncingBallNObj"});  
    }  
    
    static Ball[] balls = new Ball[20];

    public void setup() { 
        // setup the sketch     
        size(500, 500);
        smooth();
       
        for (int i = 0; i < balls.length; i++) {
          balls[i] = new Ball();
        }
    } 

 
    public void draw() {
        background(255);
        for (int i = 0; i < balls.length; i++) {
          balls[i].update();
          balls[i].draw();
        }
        
    }
    
    class Ball {
      // fields
      private double x, y;
      private double vx, vy;
      private double ay;
      private int diameter;
      private int ballColor;
      private double theta, dTheta;
      
      // default constructor
      public Ball() {
        this(Math.random() * width, 
             Math.random() * height / 2);
      }
      
      // constructor to create a ball at position x, y
      public Ball(double x, double y) {
        this.x = x;
        this.y = y;
        vx = Math.random();
        vy = 0;
        ay = 0.3;
        diameter = 20;
        ballColor = color(random(0,255), random(0, 255), random(0, 255));
        theta = 0;
        dTheta = Math.random() * 0.03;
      }
        
      // update the ball's position
      public void update() {
        
        // update positions
        x += vx;
        y += vy;
        // rotate in the direction of motion
        if (vx < 0)
          theta -= dTheta;
        else 
          theta += dTheta;
        
        // accelerate velocity
        vy += ay;
        
        // bounce off floor
        if (y + diameter / 2 >= height) {
          vy *= -0.9;          // bounce and lose some energy in the bounce
          y = height - diameter / 2;  // move ball y[i] position to top of floor
          ballColor = color(random(0,255), random(0, 255), random(0, 255));
        }
        
        // bounce off walls
        if ((x - diameter / 2) <= 0 || 
            (x + diameter / 2) >= width) {
          vx = -vx;
        }
      }
      
      // draw the ball
      public void draw() {
        pushMatrix();
        
        float fx = (float) x;
        float fy = (float) y;
        float d = (float) diameter;
        
        fill(ballColor);
        translate(fx, fy);
        rotate((float) theta);
        ellipse(0, 0, d, d);
        line(-d/2, 0, d/2, 0);
        line(0, -d/2, 0, d/2);
        
        popMatrix();
        
      }
      
    } // end Ball class
    
    
} 