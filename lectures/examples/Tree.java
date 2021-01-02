public class Tree {

    public static void drawTree(double x, double y, double angle, double length) {
        //draw branch
        double radians = Math.toRadians(angle);
        double endX = x + Math.cos(radians) * length;
        double endY = y + Math.sin(radians) * length;
        PennDraw.line(x, y, endX, endY);
        
        //base case
        if (length < .04) { 
            return;
        }

        //recurse on branches
        drawTree(endX, endY, angle + 25, 0.7 * length);
        drawTree(endX, endY, angle - 15, 0.8 * length);
    }

    public static void main(String[] args) {
        drawTree(0.5, 0.0, 90, 0.2);
    }
}