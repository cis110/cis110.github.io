public class RecursiveTree {
    public static void main(String[] args) {
    	PennDraw.enableAnimation(60);
        PennDraw.setCanvasSize(500, 500);
        int depth = 4;
        drawTree(0.5, 0, 90, 0.5, depth);
    }
    
    public static void drawTree(double x, double y, double angle, double length, int depth) {
        // base case
        if (depth == 0) {
            // draw leaf
            PennDraw.setPenColor(0, 150, 0);
            PennDraw.filledCircle(x, y, length);
        	PennDraw.advance();
            return;
        }
        // determine the endpoint
        double x2 = x + Math.cos(Math.toRadians(angle)) * length;
        double y2 = y + Math.sin(Math.toRadians(angle)) * length;
        // draw this branch
        PennDraw.setPenColor(PennDraw.BLACK);
        PennDraw.line(x,y,x2,y2);
    	PennDraw.advance();
        
        int numBranches = StdRandom.uniform(4) + 2;
        for(int i = 0; i < numBranches; ++i) {
        	double newAngle = angle + StdRandom.uniform(-50, 50);
        	double newLength = length * StdRandom.uniform(0.33, 0.85);
        	drawTree(x2, y2, newAngle, newLength, depth - 1);
        }
        /*
        // determine the branch angles
        double angle1 = angle - StdRandom.uniform(15, 60);
        double angle2 = angle + StdRandom.uniform(15, 60);
        // draw the branches (recursive call is here!)
        drawTree(x2, y2, angle1, length * 0.5, depth-1);
        drawTree(x2, y2, angle2, length * 0.5, depth-1);
        */
    }
}