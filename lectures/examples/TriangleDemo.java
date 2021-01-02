import java.util.List;
import java.util.ArrayList;

public class TriangleDemo {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new EquilateralTriangle(0.25, 0.25, 0.42));
        shapes.add(new RotatedEquilateralTriangle(0.25, 0.25, 0.42, 180.0));
        shapes.add(new Circle(0.75, 0.25, 0.25));
        shapes.add(new Square(0.25, 0.75, 0.5));
        shapes.add(new RightTriangle(0.75, 0.75, 0.5, 0.5));
        
        for (Shape s : shapes) {
            s.draw();
        }
        
    }
}