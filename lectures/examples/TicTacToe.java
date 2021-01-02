// A tic-tac-toe example coded in class.
// Draws the nine cells of the board and colors them red or cyan depending
// on which player clicks on them. Does not do any turn checking.

public class TicTacToe {
    public static void main(String[] args) {
        // 0 is unfilled
        // 1 is Red
        // 2 is Blue
        int[][] board = new int[3][3];
        PennDraw.enableAnimation(60);
        
        while(true) {
            // Check if the player is currently pressing the mouse
            // so it can update the board cell the player is clicking on.
            if(PennDraw.mousePressed()) {
                // Handle P1 vs P2
                // P2 when the player is holding the "A" key on the keyboard
                // P1 any other time.
                
                // Stores the character being pressed on the keyboard
                char c = '\0';
                // The value to write to the board based on which player
                // is clicking.
                int valueToSet = 0;
                if(PennDraw.hasNextKeyTyped()) {
                    c = PennDraw.nextKeyTyped();
                }
                // Player 2 is clicking
                if(c == 'a') {
                    valueToSet = 2;
                }
                // Player 1 is clicking
                else {
                    valueToSet = 1;
                }
                // Get mouse pos and find the right square to update.
                // Mouse pos is [0.0, 1.0) and board is [0, 2]
                // so multiply mouse pos by 3 and cast to int to map
                // mouse position to the 2D array that is the board.
                int x = (int)(PennDraw.mouseX() * 3);
                int y = (int)(PennDraw.mouseY() * 3);
                board[x][y] = valueToSet;
                c = '\0';
            }
            // Draw the board as a set of nine squares
            for(int x = 0; x < 3; ++x) {
                for(int y = 0; y < 3; ++y) {
                    switch(board[x][y]) {
                        case 0:
                            // No player has clicked here yet
                            PennDraw.setPenColor(PennDraw.WHITE);
                            break;
                        case 1:
                            // Player 1 has clicked this cell
                            PennDraw.setPenColor(PennDraw.RED);
                            break;
                        case 2:
                            // Player 2 has clicked this cell
                            PennDraw.setPenColor(PennDraw.CYAN);
                            break;
                    }
                    PennDraw.filledSquare((x + 0.5) / 3.0, (y + 0.5) / 3.0, 1.0 / 6.0);
                    PennDraw.setPenColor(PennDraw.BLACK);
                    PennDraw.square((x + 0.5) / 3.0, (y + 0.5) / 3.0, 1.0 / 6.0);
                }
            }
            PennDraw.advance();
        }
    }
}