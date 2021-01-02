public class Body {
    
    /**
     * DO NOT EDIT ANY CODE BELOW THIS LINE
     * 
     * You will get a style warning that reads:
     * "Variable '[some name]' must be private and have get/set methods."
     * Ignore any style warnings of this form. Our tests rely on these
     * variables being public. We will discuss public vs. private next week
     * in class. You are not expected to know it now.
     */
    public double px, py; //position
    public double vx, vy; //velocity
    public double m; //mass
    public String img; //image file
    
    public static final double G = 6.67e-11; //gravity constant
    
    /*DO NOT EDIT ANY CODE ABOVE THIS LINE*/
    
    /**
     * Constructor: This creates a new instance of a body object.
     */
    public Body(double mass, double posX, double posY, 
                double velX, double velY, String imageFile) {
        //TODO: Implement this constructor
    }
    
    /**
     * Description: returns a string representation of the body for the
     * purposes of printing. We will discuss toString methods in class.
     * 
     * DO NOT EDIT THIS METHOD AT ALL!
     */
    public String toString() {
        return String.format("%12.5e %12.5e %12.5e %12.5e %12.5e %12s", 
                             m, px, py, vx, vy, img);
    }
    
    // TODO: Add a method header comment
    public double distanceToX(Body other) {
        //TODO: Implement this method
        return 0.0; // dummy return
    }
    
    
    // TODO: Add a method header comment
    public double distanceToY(Body other) {
        //TODO: Implement this method
        return 0.0; // dummy return
    }
    
    // TODO: Add a method header comment
    public double distanceTo(Body other) {
        //TODO: Implement this method
        return 0.0; // dummy return
    }

    // TODO: Add a method header comment
    public double force(Body other) {
        //TODO: Implement this method
        return 0.0; // dummy return
    }
    
    // TODO: Add a method header comment
    public double forceX(Body other) {
        //TODO: Implement this method
        return 0.0; // dummy return
    }
    
    // TODO: Add a method header comment
    public double forceY(Body other) {
        //TODO: Implement this method
        return 0.0; // dummy return
    }

    // TODO: Add a method header comment
    public void draw() {
        //TODO: Implement this method
    }
    
    // TODO: Add a method header comment
    public void move(double timeStep) {
        //TODO: Implement this method
    }
    
    // TODO: Add a method header comment
    public void getAffectedBy(Body other, double timeStep) {
        //TODO: Implement this method
    }    
}
