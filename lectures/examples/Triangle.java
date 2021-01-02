public abstract class Triangle implements Shape{
    public double sideA, sideB, sideC;
    
    public Triangle(double a, double b, double c) {
        sideA = a;
        sideB = b;
        sideC = c;
    }
    
    public abstract double getCenterX();
    public abstract double getCenterY();
    public double perimeter() {
        return sideA + sideB + sideC;
    }
    public abstract double area();
    public abstract void draw();
}