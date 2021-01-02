/*
* TODO - make file header
*
*/
public class Rivalry {    
    public static void main(String[] args) {
        boolean rivalOneWins = false;       // has contestant 1 won the race?
        boolean rivalTwoWins = false;  // has contestant 2 won the race?

        /* the width of 1 pixel in window coordinate
         * use this variable when you get to the movement portion of the program 
         */
        double ONE_PIXEL = 1.0 / 512;   

        // TODO - define any variables you need here

        // TODO - set the initial image positions before the starting line

        // enable animation to 10 frames/second
        // TODO - you may change the frame rate to be any speed you like
        PennDraw.enableAnimation(10);
        
        //the loop in which he race takes place
        while (!rivalOneWins && !rivalTwoWins) {
            /* TODO the following
             * 1. clear the screen
             * 2. draw the start line
             * 3. draw the finish line
             * 4. draw the the contestants
             * 5. determine whether the first contestant's position changes 
             * 6. determine whether the second contestant's position changes
             * 7. based on current positions, determine if anyone has won. 
             * 
             */
            // show this frame and go on to the next one
            PennDraw.advance(); 
        }
       
        // the race is over so turn off animation
        PennDraw.disableAnimation(); 
        // TODO - draw text containing a victory message in the sketch
    }
}