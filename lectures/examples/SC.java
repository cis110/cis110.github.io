public class SC {
    public int a;
    public static int b;

    public static void main(String[] args) {
        SC s = new SC();
        s.a = 1;
        s.b = 2;

        // Uncomment the statements below and see which compile
        // and which do not.  Why?

        // System.out.println("a = " + a);
        // System.out.println("s.a = " + s.a);
        // System.out.println("Static.a = " + SC.a);

        // System.out.println("b = " + b);
        // System.out.println("s.b = " + s.b);
        // System.out.println("Static.b = " + SC.b);
    }
}