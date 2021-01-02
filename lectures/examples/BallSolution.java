public class Ball {
    
    //instance fields
    private double posX, posY, velX, velY, radius;
    
    //static fields
    public static final double G = 0.1;
    
    //constructor
    public Ball(double posX, double posY, double velX, double velY, 
                double radius){
        this.posX = posX;
        this.posY = posY;
        this.velX = velX;
        this.velY = velY;
        this.radius = radius;
    }
    
    private void handleCollision() {
        //hit right wall
        if (posX + radius >= 1 && velX > 0) {
            velX *= -0.9;
        }
        
        //hit left wall
        if (posX - radius <= 0 && velX < 0) {
            velX *= -0.9;
        }
        
        //hit ceiling
        if (posY + radius >= 1 && velY > 0) {
            velY *= -0.9;
        }
        
        //hit floor
        if (posY - radius <= 0 && velY < 0) {
            velY *= -0.9;
        }
    }
    
    public void update() {
        
        //bounce off walls
        this.handleCollision();
        
        //apply gravity
        if (posY - radius > 0) {
            velY -= G;
        }
        
        //update position
        posX += velX / 60;
        posY += velY / 60;
        
        //draw ball
        PennDraw.filledCircle(posX, posY, radius);
    }
    
    public static void main(String[] args) {
        Ball[] NBalls = new Ball[Integer.parseInt(args[0])];
        for (int i = 0; i < NBalls.length; i++) {
            NBalls[i] = new Ball(0.8, 0.8, Math.random() * 2, Math.random() * 2, 
                                 Math.random() / 5);
        }
        PennDraw.enableAnimation(60);
        while (true) {
            PennDraw.clear();
            for (int i = 0; i < NBalls.length; i++) {
                NBalls[i].update();
            }
            PennDraw.advance();
        }
    }
}