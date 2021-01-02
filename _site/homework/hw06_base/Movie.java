/**
 * Name: TODO
 * Pennkey: TODO
 * Execution: TODO
 *
 * Description: TODO
**/
public class Movie {
    
    private static final String[] GENRES = {"RomCom", "Horror", "Action", 
                                            "Mystery", "Thriller"};
    
    private String name;
    private String genre;
    private String rating;
    private int ticketsLeft;
    private Review[] reviews;
    private int reviewIndex;
    
    public Movie(String name, String genre, String rating, int maxReviews, 
                 int tickets) {
        // TODO - Implement
    }

    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public boolean hasTicketsLeft() {
        // TODO - implement
        return false;
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public void seen() {
        // TODO - Implement
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public void leaveReview(Review review) {
        // TODO - implement
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public double rottenTomatoes() {
        // TODO - implement
        return -1.0;
    }

    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public int getTicketsLeft() {
        // TODO - implement
        return 0;
    }
    
    // TODO - implement getters
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public String getName() {
        return null;
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public String getGenre() {
        return null;
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public String getRating() {
        return null;
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Movie name: ").append(this.name).append('\n');
        sb.append("Genre: ").append(this.genre).append('\n');
        sb.append("Rating: ").append(this.rating).append('\n');
        sb.append("Rotten Tomatoes Score: ").append(this.rottenTomatoes()).append('\n');
        return sb.toString();
    }
    
    // DO NOT DELETE
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Movie)) {
            return false;
        }
        Movie otherMovie = (Movie) o;
        
        return this.name.equals(otherMovie.name) &&
        this.genre.equals(otherMovie.genre) &&
        this.rating.equals(otherMovie.rating);
    }
    
}
