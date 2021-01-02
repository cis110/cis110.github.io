public class BouncingBallObjectDemo2 {
  static Ball[] balls = new Ball[10];
  
  public static void main(String[] args) {
    setup();
    while(true) {
      draw();
      StdDraw.show(20);
    }
  }
  
  public static void setup() {
    for (int i = 0; i < balls.length; i++) {
      balls[i] = new Ball();
    }
  }
  
  public static void draw() {
    StdDraw.clear(StdDraw.WHITE);
    for (int i = 0; i < balls.length; i++) {
      balls[i].draw();
      balls[i].move();
    }
  }
}


// Ball object

// methods: constructor, draw(), move(), bounce()

class Ball {
  // fields: position, radius, color, velocity
  private double x;
  private double y;
  private double radius;
  private java.awt.Color color;
  private double vx;
  private double vy;
  
  public Ball() {
    // create a ball at a random location
    this(StdRandom.uniform(0.0,1.0), StdRandom.uniform(0.0,1.0));
  }
  
  public Ball(double initX, double initY) {
    x = initX;
    y = initY;
    radius = StdRandom.uniform(0.01, 0.02);
    color = StdDraw.RED;
    vx = StdRandom.uniform(-0.003, 0.003);
    vy = 0;
  }
  
  public double getX() { return x; }
  public double getY() { return y; }
  
  public void draw() {
    StdDraw.setPenColor(color);
    StdDraw.filledCircle(x, y, radius);
  }
  
  public void move() {
    x += vx;
    y -= vy;
    vy += 0.001;
    
    // bounce vertically
    if (y - radius < 0) {
      vy = -0.9 * vy;
    }
    
    // bounce horizontally
    if (x - radius < 0 || x + radius > 1) {
      vx = -vx;
    }
    
  }
  
}

  