public class RecursionRecitation {

    /*
     * Function does nothing other than act as a visual aid for how Java
     * moves through recursive calls
     */
     public static void mystery(int x) {
        if (x == 0) {
            System.out.println(x);
            return;
        }
        
        System.out.println(x);
        mystery(x - 1);
        System.out.println(x);
        return;
    }
    
     /*
      * Reverses the given string
      */
    public static String reverse(String s) {
        if (s.length() <= 1) {
            return s;
        }
        
        return reverse(s.substring(1, s.length())) + s.charAt(0);
    }
    
    
    /*
     * Draws the Cantor set at the given depth
     * Inputs:
     *   depth: the number of levels of recursion
     *   x, y: the coordinates of the left endpoint of the line drawn at this
     *     level
     *   length: the length of the line to be drawn at this level
     */
    public static void cantor(int depth, double x, double y, double length) {
        System.out.println("x = " + x + ", y = " + y + ", depth = " + depth);
        
        if (depth <= 0) {
            return;
        } else {
            // draw the actual line
            PennDraw.line(x, y, x + length, y);
            // recursive calls to handle the rest of the lines
            cantor(depth - 1, x, 
                   y - 0.15, length / 3.0);
            cantor(depth - 1, x + (2.0 / 3.0) * length, 
                   y - 0.15, length / 3.0);
        }
    }
    
    public static void main(String[] args) {
    }

}