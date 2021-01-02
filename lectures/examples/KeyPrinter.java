public class KeyPrinter {
    public static void main(String[] args) {
        PennDraw.setFontSize(200);
        while (true) {
            if (PennDraw.hasNextKeyTyped()) {
                PennDraw.clear();
                char ch = PennDraw.nextKeyTyped();
                PennDraw.text(0.5, 0.5, "" + ch);
            }
        }
    }
}