/**
 * A Growing Bouncing Ball using objects
 * Eric Eaton
 * 
 */

import processing.core.*; 
 
public class GrowingBallNObj extends PApplet { 
 
    public static void main(String[] args) { 

        PApplet.main(new String[]{"GrowingBallNObj"});  
    }  
    
    static Ball[] balls = new Ball[30];

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
        //scale(0.1f, 0.1f);
        //rect(0, 0, width, height);
        for (int i = 0; i < balls.length; i++) {
          if (balls[i] != null) {
            balls[i].update();
            balls[i].draw();
          }
        }
        
        // check all pairs of balls
        for (int i = 0; i < balls.length; i++) {
          for (int j = i + 1; j < balls.length; j++) {
            // check for intersection
            if (balls[i] != null && balls[j] != null &&
                balls[i].intersect(balls[j])) {
              // merge them
              balls[i].merge(balls[j]);
              // delete balls[j]
              balls[j] = null;
            }
          }
        }
        
    }
    
    class Ball {
      // fields
      private double x, y;
      private double vx, vy;
      private double ay;
      private double diameter;
      private int ballColor;
      private double theta;
      
      // methods
      public Ball() {
        this(Math.random() * width, 
             Math.random() * height / 2);
      }
      
      public Ball(double x, double y) {
        this.x = x;
        this.y = y;
        vx = Math.random();
        vy = 0;
        ay = 0.3;
        diameter = 20;
        ballColor = color(random(0,255), random(0, 255), random(0, 255));
        theta = 0;
      }
        
      public void update() {
        
        // update positions
        x += vx;
        y += vy;
        if (vx < 0)
          theta -= 0.03;
        else 
          theta += 0.03;
        
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
      
      public boolean intersect(Ball b) {
        double radiusThis = this.diameter / 2;
        double radiusB = b.diameter / 2;
        double distance = dist((float) this.x, (float) this.y,
                               (float) b.x,    (float) b.y);
        return (distance < radiusThis + radiusB);
      }
      
      public void merge(Ball b) {
        //println("Merging...");
        double areaThis = this.getArea();
        double areaB = b.getArea();
        double weightThis = areaThis / (areaThis + areaB);
        double weightB = 1 - weightThis;
        x = weightThis * x + weightB * b.x;
        y = weightThis * y + weightB * b.y;
        // solve for r where (areaThis + areaB) = PI * r * r
        diameter = 2 * Math.sqrt((areaThis + areaB) / Math.PI);
        b.diameter = 0;
      }
      
      public double getArea() {
        return Math.PI * diameter / 2 * diameter / 2;
      }
      
      
    } // end Ball class
    
    
} 
