/**
 * Name: Harry Smith Pennkey: sharry
 * 
 * Usage: java Pacman
 * 
 * Description: Draws a simple image of the character Pacman on a black
 * background
 */

public class Pacman {
    public static void main(String[] args) {
        // color the background black
        PennDraw.clear(PennDraw.BLACK);

        // draw pacman's body
        PennDraw.setPenColor(PennDraw.YELLOW);
        PennDraw.filledEllipse(0.5, 0.5, 0.2, 0.2);

        PennDraw.setPenColor(PennDraw.BLACK);
        PennDraw.filledPolygon(0.5, 0.5, 0.8, 0.3, 0.8, 0.7);
    }
}