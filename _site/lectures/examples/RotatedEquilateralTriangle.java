public class RotatedEquilateralTriangle extends EquilateralTriangle {
    double angle;
    
    public RotatedEquilateralTriangle(double x, double y, 
                                      double side, double angle) {
        super(x, y, side);
        this.angle = angle;
    }
    
    public void draw() {
        double k = sideA / (Math.sqrt(3));
        double topAngle = degToRad(90.0 + angle);
        double x0 = x + k * Math.cos(topAngle);
        double y0 = y + k * Math.sin(topAngle);
        
        double botLeftAngle = degToRad(-30.0 + angle);
        double x1 = x + k * Math.cos(botLeftAngle);
        double y1 = y + k * Math.sin(botLeftAngle);
        
        double botRightAngle = degToRad(-150.0 + angle);
        double x2 = x + k * Math.cos(botRightAngle);
        double y2 = y + k * Math.sin(botRightAngle);
        
        PennDraw.polygon(x0, y0, x1, y1, x2, y2);
    }
    
    private static double degToRad(double degrees) {
        return degrees * Math.PI / 180.0;
    }
}