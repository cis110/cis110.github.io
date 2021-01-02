import processing.core.*; 
import java.util.LinkedList;
 
public class FlappyBird extends PApplet { 
 
    public static void main(String[] args) { 
        PApplet.main(new String[]{"FlappyBird"});  
    } 
    
    Bird bird;
    float xWindow = 0;
    LinkedList<Obstacle> obstacles;
    EnvironmentGenerator env = new EnvironmentGenerator();
    boolean birdHit = false;
    
    static final double INITIAL_SCROLL_VELOCITY = 1;
    static final double ACCEL_GRAVITY = 0.1;

    public void setup() {
      size(400, 400);
      smooth();
      
      bird = new Bird(width * 0.3, height * 0.5, 0);
      
      obstacles = new LinkedList<Obstacle>();
      
      birdHit = false;
      
    }
    
    public void draw() {
      
      // draw background
      background(100, 100, 255);
      fill(100, 255, 100);
      rect(0, height - 20, width, 20);
      
      ellipse(xWindow, 0, 10, 10);
      

      
      // scroll window
      xWindow -= INITIAL_SCROLL_VELOCITY;

      
      // simulate bird
      bird.display();
      bird.update();
      
      // simulate obstacles
      for (int i = 0; i < obstacles.size(); i++) {
        Obstacle o = obstacles.get(i);
        o.display();
        o.update();
      }
      
      // remove offscreen obstacles
      for (int i = obstacles.size() - 1; i >= 0; i--) {
        Obstacle o = obstacles.get(i);
        if (o.isOffscreen()) {
          obstacles.remove(i);
        }
      }
      
      // consider adding new obstacles
      Obstacle newO = env.produceObstacle();
      if (newO != null) {
        obstacles.add(newO);
      }
      
      // advance the environment by one timestep
      env.step();
      
      // check for collision with each obstacle
      for (int i = obstacles.size() - 1; i >= 0; i--) {
        Obstacle o = obstacles.get(i);
        if (o.impact(bird)) {
          birdHit = true;
        }
      }
      
      // if the bird ever hit an obstacle, paint the screen red
      if (birdHit) {
        fill(255, 0, 0, 180);
        rectMode(CORNER);
        rect(0, 0, width, height);
      }
      
      // if the bird drops low, reset the program
      if (bird.getY() > height + bird.getRadius()) {
        setup();
      }
      
    } // end draw
    
    public void keyPressed() {
      bird.flap();
    }
    
    
    class Bird {
      private double x, y;
      private double dx, dy;
      private float size = 1.0f;
      private double FLAP_AMOUNT = -3; 
      
      public Bird(double x, double y, double dx) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = 0;
      }
      
      public double getX() { return x; }
      
      public double getY() { return y; }
      
      public double getRadius() { return size * 30 / 2; }
      
      public void flap() {
        dy = FLAP_AMOUNT;
      }
      
      public void update() {
        x += dx;
        y += dy;
        dy += ACCEL_GRAVITY;
      }
      
      public void display() {
        pushMatrix();
        translate((float) x, (float) y);
        scale(size);
        
        // draw body
        fill(255, 255, 0);
        ellipse(0, 0, 30, 30);
        
        // draw beak
        fill(255, 120, 0);
        triangle(14, -5, 22, 5, 14, 5);
        
        // draw eye
        fill(255);
        ellipse(5,-5, 12, 12);
        fill(0);
        ellipse(7, -5, 2, 2);
        
        // draw wing
        fill(255, 230, 0);
        triangle(1, 6, -18, 15, -10, -3);
        popMatrix();
      }
    }
    
    public class Obstacle {
      private double x;
      private double gapStart;
      private double gapStop;
      private double width = 30;
      private double dx;
      
      Obstacle(double x,  double gapStart, 
               double gapStop, double dx) {
        this.x = x;
        this.gapStart = gapStart;
        this.gapStop = gapStop;
        this.dx = dx;
      }
      
        
      // updates position, scrolling block
      public void update() { 
        x += dx;
      }
      
      public void display() {
        pushMatrix();
        rect((float) x, 0, (float) width, (float) gapStop);
        rect((float) x, (float) gapStart, (float) width, 
             (float) (height - gapStart));
        popMatrix();
      }
      
      public boolean isOffscreen() {
        return (x + width < -10);
      }
      
      public boolean impact(Bird b) {
        return intersectCircleRect(
                  b.getX(), b.getY(), b.getRadius(),
                  x, 0, width, gapStop) ||
               intersectCircleRect(
                  b.getX(), b.getY(), b.getRadius(),
                  x, gapStart, width,height - gapStart);
      }
      
      // cx, cy - center point of circle
      // radius - radius of circle
      // rx, ry - upper left corner of rect
      // rWidth, rHeight - width and height of rect
      private boolean intersectCircleRect(
         double cx, double cy, double radius,
         double rx, double ry, double rWidth, double rHeight) {
        
        // find closest point on rect to circle center
        double xMax = rx + rWidth;
        double yMax = ry + rHeight;
        double xClosest = constrain(cx, rx, xMax);
        double yClosest = constrain(cy, ry, yMax);
        // measure distance
        double distance = dist((float) cx, (float) cy, (float) xClosest, (float) yClosest);
        // detect collision
        return (distance < radius);
      }
      
      private double constrain(double x, double min, double max) {
        if (x < min) return min;
        if (x > max) return max;
        return x;
      }
                                          
    }
      
    
    
    class EnvironmentGenerator {
      private int timestepsBetwnObstacles = 100;
      private int obstacleGap = 100;
      private int step = 0;
      private int OBSTACLE_SPEED = 2;
      
      public EnvironmentGenerator() {
      }
      
      public void step() { step++; }

      public Obstacle produceObstacle() {
        if (step % timestepsBetwnObstacles == 0) {
          float obstacleHeight = random(30, 300);
          return new Obstacle(width, 
                              obstacleHeight + obstacleGap,
                              obstacleHeight, 
                              -OBSTACLE_SPEED);
        } else {
          return null;
        }
      }
    }
}
