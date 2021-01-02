 /**
 * Name : Paul McBurney
 * PennKey : paulmcb
 * Recitation : 110
 * 
 * Execution: java MySketch
 */
   public class MySketch{
    public static void main(String [] args){
        PennDraw.setCanvasSize(500,500);
        PennDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
        PennDraw.setPenColor(PennDraw.BLUE);
        PennDraw.filledSquare(0.5, 0.5, 0.25, 0.25, 45);
        PennDraw.setPenColor(PennDraw.BLUE);
        PennDraw.filledSquare(0.5, 0.5, 0.125, 0.125);
    }
}
