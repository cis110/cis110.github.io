public class TwoDArrayExample {
    public static void main(String[] args){
        char[][] board = new char[3][3];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
        
        board[1][1] = 'x';
        board[0][2] = 'o';
        board[1][0] = 'x';
        board[2][1] = 'o';
        board[1][2] = 'x';
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}