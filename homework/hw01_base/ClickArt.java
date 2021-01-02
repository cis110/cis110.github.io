/**
 * TODO - make header
 * 
 */
public class ClickArt {
    public static void main(String[] args) {
        /* Is this the first time we are drawing the background?
         * Make sure you utilize this variable somewhere within the 
         * while loop below
         */
        boolean firstTime = true;

        while (true) {
            // if a key is pressed, redraw background
            
            // TODO - figure the logic here
            if (true) {
                // TODO - draw a random background
                // some aspect of the background must involve a loop.
                firstTime = false;
            }

            //if the mouse is clicked...
            if (PennDraw.mousePressed()) {
                //get and store the coordinates of the mouse cursor
                double x = PennDraw.mouseX();
                double y = PennDraw.mouseY();
                
                // TODO - check which region the mouse click was in
                // draw a scaled shape using the mouse coordinates
            }
        }
    }
}
