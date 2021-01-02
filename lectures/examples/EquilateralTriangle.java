public class EquilateralTriangle extends Triangle{
    double x, y;
    
    public EquilateralTriangle(double sideLength, double x, double y) {
        super(sideLength, sideLength, sideLength);
        this.x = x;
        this.y = y;
    }
    
    public double getCenterX() {
        return x;
    }
    public double getCenterY() {
        return y;
    }
    
    public double area() {
        return Math.sqrt(3) * 0.25 * sideA * sideA;
    }
    public void draw() {
        //top coordinates
        double x0 = x;
        double y0 = y + sideA / Math.sqrt(3);
        
        //bottom left coordinates
        double x1 = x - (0.5 * sideA);
        double y1 = y - (sideA  / (2.0 * Math.sqrt(3)));
        
        //bottom right coordinates
        double x2 = x + (0.5 * sideA);
        double y2 = y1;
        
        PennDraw.polygon(x0, y0, x1, y1, x2, y2);
    }
}