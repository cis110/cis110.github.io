public class Ball {
    
    //TODO: add instance fields
    
    //TODO: add static fields
    
    //TODO: make constructor
    
    //Pre-written method to handle collisions, uncomment when fields and
    //constructor are done.
    /*
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
     */
    
    //Partially written method to fully update the position of the ball and
    //repaint it on the canvas. Uncomment when handleCollisions() is done.
    /*
     public void update() {
     
     //TODO: handle collisions
     
     //apply gravity
     if (posY - radius > 0) {
     //TODO: apply gravity
     }
     
     //update position
     posX += velX / 60;
     posY += velY / 60;
     
     //TODO: draw ball
     }
     */
    
    public static void main(String[] args) {
        //TODO: create an array of Ball objects of length args[0] and create an
        //animation of their movement
        
        //Effective random number for velocites: Math.random() * 2
    }
}