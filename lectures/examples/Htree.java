public class Htree {
    
    // plot an H, centered on (x, y) 
    // of the given side length. The H has the same width and height
    public static void drawH(double x, double y, double size) {
        PennDraw.line(x - size / 2, y, x + size / 2, y);
        PennDraw.line(x - size / 2, y + size / 2
                          , x - size / 2, y - size /2);
        PennDraw.line(x + size / 2, y + size / 2,
                      x + size / 2, y - size / 2);
        PennDraw.advance();
    }
    
    // plot an order H-tree of depth n, 
    //centered on (x, y) of the given side length
    public static void draw(int n, double x, 
                            double y, double size) {
        if (n == 0) return; //base case
        
        //begin by drawing an H
        drawH(x, y, size);
        
        //now recursively make 4 smaller H trees
        double x0 = x - size / 2;
        double y0 = y - size / 2;
        double x1 = x + size / 2;
        double y1 = y + size / 2;
        //first draw the bottom left subtree
        draw(n - 1, x0, y0, size / 2);
        //then draw the top left subtree
        draw(n - 1, x0, y1, size / 2);        
    
        
        //then the bottom right subtree
        draw(n - 1, x1, y0, size / 2);
        //finish up with the top right subtree
        draw(n - 1, x1, y1, size / 2);
    }
    
    // read in a command-line argument N 
    //and plot an order N H-tree
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double x = 0.5, y = 0.5;   // center of H-tree
        double size = 0.5;         // side length of H-tree
        PennDraw.enableAnimation(5);
        draw(N, x, y, size);
    }
}
