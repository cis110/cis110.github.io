public class BookRecommender {
    private Book[] bookList;

    public BookRecommender(Book[] bookList) {
        this.bookList = bookList;
    }

    public void recommendByGenre(String genre) {

        for (int i = 0; i < bookList.length; i++) {
            Book currentBook = this.bookList[i];
            if (currentBook.getGenre().equals(genre)) {
                System.out.println(currentBook.getTitle());
            }
        }
    }

    public static void main(String[] args) {
        Book myBrilFriend = new Book("My Brilliant Friend", "Elena Ferrante", 2012, "Fiction", 331, 3.96);
        Book actualAir = new Book("Actual Air", "David Berman", 2000, "Poetry", 106, 4.33);
        Book evicted = new Book("Evicted", "Matthew Desmond", 2016, "Nonfiction", 418, 4.47);
        Book lyingLife = new Book("The Lying Life of Adults", "Elena Ferrante", 2020, "Fiction", 336, 3.77);
        Book longWay = new Book("A Long Way From Home", "Peter Carey", 2018, "Fiction", 336, 3.55);

        Book[] books = { myBrilFriend, actualAir, evicted, lyingLife, longWay };

        BookRecommender br = new BookRecommender(books);

        br.recommendByGenre("Fiction");
    }
}
