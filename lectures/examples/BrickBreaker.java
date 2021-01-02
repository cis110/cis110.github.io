import processing.core.*; 
 
public class BrickBreaker extends PApplet { 
 
    public static void main(String[] args) { 
        PApplet.main(new String[]{"BrickBreaker"});  
    } 
    
    Paddle paddle;
    Ball ball = null;
    
    static double BALL_DIAMETER = 10;
    
    public void setup() {
      size(400, 400);
      smooth();
      
      paddle = new Paddle(width / 5);
    }
    
    public void draw() {
      background(255);
      
      if (ball != null) {
        ball.display();
        ball.update();
        
        if (paddle.collision(ball)) {
          ball.bounceVertical();
          if (paddle.movingLeft()) {
            ball.nudgeLeft();
          } else {
            ball.nudgeRight();
          }
        }
      }
      
      paddle.display();
      
      
      
    }
    
    public void keyPressed() {
      ball = new Ball(mouseX, height-10, BALL_DIAMETER);
    }
    
    public class Brick {
      private double x;
      private double y;
      private double WIDTH = 30;
      private double HEIGHT = 20;
      private int color;
      
      public Brick(double x, double y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
      }
      
      public void display() {
        fill(color);
        rectMode(CENTER);
        rect((float) x, (float) y, (float) WIDTH, (float) HEIGHT);
      }
    }
//   boolean collision(Ball b)
//   - break brick // save for later
    
    
    
    class Ball {
      private double x, y;
      private double diameter;
      private double dx, dy;
      private double BALL_SPEED = 5;
      
      public Ball(double x, double y, double diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        dx = 0;
        dy = -BALL_SPEED;
      }
      
      public double getX() { return x; }
      
      public double getY() { return y; }
      
      public void display() {
        fill(255, 0, 0);
        ellipse((float) x, (float) y, (float) diameter, (float) diameter);
      }
      
      // update position, and bounce off walls and ceilings
      public void update() {
        // update position
        x += dx;
        y += dy;
        
        double radius = diameter / 2;
        // bounce off walls and ceiling
        if (x <= 0 + radius || x >= width - radius) {
          bounceHorizontal();
        }
        if (y <= 0 + radius) {
          bounceVertical();
        }
      }
      
      public void bounceVertical() {
        dy = -dy;
      }
      
      public void bounceHorizontal() {
        dx = -dx;
      }
      
      public void nudgeLeft() {
        dx -= 1;
      }
      
      public void nudgeRight() {
        dx += 1;
      }
    }
    
    
    class Paddle {
      private float size;
      private float previousX;
      private float PADDLE_HEIGHT = 10;
      
      public Paddle(float size) {
        this.size = size;
      }
      
      public boolean movingLeft() {
        return (mouseX - previousX) < 0;
      }
      
      public void display() {
        fill(0);
        rectMode(CENTER);
        rect(mouseX, height - PADDLE_HEIGHT / 2, size, PADDLE_HEIGHT);
        previousX = mouseX;
      }
      
      public boolean collision(Ball b) {
        double paddleXLeft = mouseX - size / 2;
        double paddleXRight = mouseX + size / 2;
        double paddleYTop = height - PADDLE_HEIGHT;
        return (b.getX() >= paddleXLeft && 
                b.getX() <= paddleXRight &&
                b.getY() >= paddleYTop);
      }
    }
}

//

//  

//  
//  Score
//    fields: score
//    void display()
//    void increment()
//    void reset()
//    int getScore() // could eliminate
//
//  