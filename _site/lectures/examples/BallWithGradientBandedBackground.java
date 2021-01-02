/*  Demonstration program of Processing graphics library
 *  Eric Eaton
 */  

import processing.core.*; 
 
public class BallWithGradientBandedBackground extends PApplet { 
 
    public static void main(String args[]) { 
        PApplet.main(new String[]{"BallWithGradientBandedBackground"});  
    }  
 
    double x, y;  // position of ball
    double vx, vy, ay;  // velocity and acceleration of ball
    final int DIAMETER = 50;
    
    public void setup() { 
        // setup the sketch
        size(400, 400);
        smooth();
        x = width / 2;
        y = 0;
        vx = 3;
        vy = 0;
        ay = 0.3;
        fill(255, 0, 0);
    } 
 
    
    public void draw() { 
      
        background(255);
        
        // draw nested circles of increasingly dark color
        // designed to look like a tunnel
        float tunnelDiameter = 500.0f;
        int i = 0;
        noStroke();
        while (tunnelDiameter > 1.0) {
          // scale the color based on the circle diameter
          float scaledColor = 255 * tunnelDiameter / 500;
          if (i % 2 == 0) {
            fill(0, scaledColor, 0);  // shade of green
          } else {
            fill(scaledColor);
          }
          // draw the ellipse
          ellipse(width/2, height/2, tunnelDiameter, tunnelDiameter); 
          // reduce the diameter by a scale factor
          tunnelDiameter = tunnelDiameter * 0.9f;
          i++;
        } 

        // draw fancy red ball
        stroke(0);
        ellipse((float) x, (float) y, DIAMETER, DIAMETER); // draw outer ball first to get outline
        noStroke();
        // gradient fill ball
        for (int ballDiameter = DIAMETER-1; ballDiameter > 0; ballDiameter--) {
            float scaleColor = 255 - 100 * ballDiameter / DIAMETER; // ranges from red = 155 - 255
            fill(scaleColor, 0, 0);
            ellipse((float) x, (float) y, ballDiameter, ballDiameter);
        }
        
        // update position
        x = x + vx;
        y = y + vy;
        
        // accelerate
        vy = vy + ay;
        
        // bounce off floor
        if (y + DIAMETER/2 >= height) {
           vy = -0.9 * vy;
           y = height - DIAMETER / 2;  // bump up height to be at floor
        }
        
        // bounce off walls
        if (x-DIAMETER/2 <= 0 || x+DIAMETER/2 >= width) {
           vx = -vx;
        }
        
        // instructions
        fill(0);
        textSize(24);
        textAlign(CENTER, BOTTOM);
        text("Press L or R to control ball", width/2, 50);
    } 

    
    // pressing 'L' bumps the ball left; 'R' bumps the ball right
    public void keyPressed() { 
      switch(key) { 
        case 'l': 
        case 'L': 
          println("Bumping left");
          vx = vx - 1;
          break; 
        case 'r': 
        case 'R': 
          println("Bumping right");
          vx = vx + 1;
          break; 
      } 
      
      
    } 

 
}





