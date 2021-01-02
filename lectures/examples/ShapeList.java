public class ShapeList {
    private ShapeNode head;
    
    private class ShapeNode {
        public Shape value;
        public ShapeNode next;
        
        public ShapeNode(Shape s) {
            value = s;
            next = null;
        }
    }
    
    public void add(Shape s) {
        ShapeNode sn = new ShapeNode(s);
        sn.next = head;
        head = sn;
    }
    
    public void drawAll() {
        for (ShapeNode temp = head; temp != null; temp = temp.next) {
            temp.value.draw();
        }
    }
    
    public static void main(String[] args) {
        ShapeList list = new ShapeList();
        
        Circle c = new Circle(0.5, 0.5, 0.33);
        Square sq = new Square(0.5, 0.5, 0.5);
        
        list.add(c);
        list.add(sq);
        
        list.add(new Square(0.25, 0.25, 0.2));
        
        list.drawAll();
        
    }
}
