/*
 * class that demonstrates keyboard interaction
 */
public class KeyBoardInput {
    public static void main(String[] args) {
        String c = "0";
        double radius = 1 / 500.0;
        PennDraw.enableAnimation(20);
        while (c != "q") {
            if (PennDraw.hasNextKeyTyped()) {
                c = PennDraw.nextKeyTyped();
                System.out.println(c);
            }
            PennDraw.circle(0.5, 0.5, radius);
            radius = radius + 1 / 500.0;
            PennDraw.advance();
        }
    }
}