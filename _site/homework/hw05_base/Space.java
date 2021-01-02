public class Space {
    
    /**
     * DO NOT EDIT ANY CODE BELOW THIS LINE
     * 
     * You will get a style warning that reads:
     * "Variable '[some name]' must be private and have get/set methods."
     * Ignore any style warnings of this form. Our tests rely on these
     * variables being public. We will discuss public vs. private next week
     * in class. You are not expected to know it now.
     */
    public Body[] bodies; //array of Body objects in the space
    public double radius; //radius of the universe
    
    /* DO NOT EDIT ANY CODE ABOVE THIS LINE */
    
    /**
     * Constructor: This creates a new instance of a space object.
     */
    public Space(String filename) {
        //TODO: Implement this constructor
    }
    
    /**
     * Description: returns a string representation of space for the purposes 
     * of printing. We have discussed toString methods in class.
     * 
     * DO NOT EDIT THIS METHOD AT ALL!
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("" + bodies.length + "\n");
        sb.append(String.format("%.2e\n", radius) + "\n");
        for (int i = 0; i < bodies.length; i++) {
            sb.append(bodies[i].toString() + "\n");
        }
        return sb.toString();
    }
    
    // TODO: Add a method header comment
    public void draw() {
        //TODO: Implement this method
    }
    
    // TODO: Add a method header comment
    public void simulate(double timeStep) {
        //TODO: Implement this method
    }   
}