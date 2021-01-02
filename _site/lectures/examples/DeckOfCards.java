public class DeckOfCards {
    public static void main(String[] args) {
        String[] rank = {
            "2", "3", "4", "5", "6", "7", "8", "9",
            "10", "Jack", "Queen", "King", "Ace"
        };
        String[] suit = {
            "Clubs", "Diamonds", "Hearts", "Spades"
        };
        
        for (int i = 0; i < rank.length; i++) {
            String r = rank[i];
            for (int j = 0; j < suit.length; j++) {
                String s = suit[j];
                System.out.println(r + " of " + s);
            }
        }
    }
}
