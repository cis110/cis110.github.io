public class RightTriangle extends Triangle {
    double centerX, centerY;
    
    public RightTriangle(double x, double y, double a, double b) {
        super(a, b, getHypotenuse(a, b));
        centerX = x;
        centerY = y;
    }
    
    private static double getHypotenuse(double a, double b) {
        return Math.sqrt(a * a + b* b);
    }
    
    public double getCenterX() {
        return centerX;
    }
    
    public double getCenterY() {
        return centerY;      
    }
    
    public double area() {
        return 0.5 * sideA * sideB;  
    }
    
    public void draw() {
        //bottom left
        double x0 = centerX - 0.5 * sideB;
        double y0 = centerY - 0.5 * sideA;
        
        //bottom right
        double x1 = x0 + sideB;
        double y1 = y0;
        
        //top left
        double x2 = x0;
        double y2 = y0 + sideA;
        
        PennDraw.polygon(x0, y0, x1, y1, x2, y2);
    }
}