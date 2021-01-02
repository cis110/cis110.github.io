/*********************************************
 * Bouncing Ball
 * Author:  Eric Eaton
 * 
 * Description:
 * Simulates a ball bouncing off the walls
 * and floor with acceleration due to gravity
 * 
 * Compilation:  javac BouncingBall.java
 * Execution:    java BouncingBall
 * 
 * Program Arguments:  none
 * 
 *********************************************/

public class BouncingBall {

  public static void main(String[] args) {
      
      // setup the window
      PennDraw.setXscale(0, 100);
      PennDraw.setYscale(0, 100);
      
      // setup the ball's initial parameters
      double x = 50;
      double y = 100;
      double ballRadius = 10;
      double dx = .5;
      double dy = .1;
      double accel = .1;
      int color = 0;     // 0 = RED, 1 = BLUE, 2 = GREEN
      
      PennDraw.enableAnimation(30);

      while (true) {
          PennDraw.clear(PennDraw.WHITE);
     
          // draw the ball
          switch (color) {
              case 0:  PennDraw.setPenColor(PennDraw.RED); break;
              case 1:  PennDraw.setPenColor(PennDraw.BLUE); break;
              case 2:  PennDraw.setPenColor(PennDraw.GREEN); break;
          }
          PennDraw.filledCircle(x, y, ballRadius);
          PennDraw.setPenColor(PennDraw.BLACK);
          PennDraw.square(50,50,50);
          
          // simulate motion
          x = x + dx;
          y = y - dy;
          dy = dy + accel;
          
          // bounce off floor
          if (y <= ballRadius && dy > 0) {
              dy = -0.9 * dy;
          }
          
          // bounce off walls
          if (x <= ballRadius || x >= (100 - ballRadius) ) {
              dx = -dx;
              
              // change the ball color randomly when bouncing off the walls
              color = (color + 1) % 3; // loop through all three colors
          }
          
          PennDraw.advance();
      }
  }
}
