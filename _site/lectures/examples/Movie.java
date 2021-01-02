/**
 * Auto Generated Java Class.
 */
public class Movie
{
    // create a public static movie counter
    // static creates a variable that is shared by all instances of the class
    public static int movieCounter = 0;
    
    
    // final makes a variable immutable / constant
    // final variables are often static (shared by all instances of the class)
    public static final String DEFAULT_TITLE = "CIS110";
  
    /* data fields */
    private String title;
    private int    year;
    private int    length;
    private String genre;
    private String format;
    private double price;


     
    /**
     * constructor with arguments
     * Create a new Movie instance/object
     * @param title  the title of this movie
     * @param year   the year this movie was released
     * @param length the length of this movie
     * @param genre  the genre of this movie
     * @param format the format of this movie
     * @param price  the price of this movie
     */
    public Movie(
        String title,
        int year,
        int length,
        String genre,
        String format,
        double price)
    {
        setTitle(title);
        setYear(year);
        setLength(length);
        setGenre(genre);
        setFormat(format);
        setPrice(price);
        //increment movieCounter
        movieCounter++;
    }


    /**
     * constructor no arguments
     * Create a new Movie instance/object
     */
    public Movie()
    {
        setTitle(DEFAULT_TITLE);
        setYear(2020);
        setLength(1);
        setGenre("TBD");
        setFormat("TBD");
        setPrice(0.1);
        //increment movieCounter
        movieCounter++;
    }
    
  
    /**
     * @return movieCounter
     */
    public int getMovieCounter(){
      return movieCounter;
    }
    
    
    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }


    /**
     * @param title the title to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }


    /**
     * @return the year
     */
    public int getYear()
    {
        return year;
    }


    /**
     * @param year the year to set
     */
    public void setYear(int year)
    {
        this.year = year;
    }


    /**
     * @return the length
     */
    public int getLength()
    {
        return length;
    }


    /**
     * @param length the length to set
     * @throws IllegalArgumentException if price is negative or 0
     */
    public void setLength(int length)
    {
        if(length <= 0) {
            throw new IllegalArgumentException("The length cannot be negative or 0");
        }
        this.length = length;
    }


    /**
     * @return the genre
     */
    public String getGenre()
    {
        return genre;
    }


    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre)
    {
        this.genre = genre;
    }


    /**
     * @return the format
     */
    public String getFormat()
    {
        return format;
    }


    /**
     * @param format the format to set
     */
    public void setFormat(String format)
    {
        this.format = format;
    }


    /**
     * @return the price
     */
    public double getPrice()
    {
        return price;
    }


    /**
     * @param price the price to set
     * @throws IllegalArgumentException if price is negative or 0
     */
    public void setPrice(double price)
    {
        if(price <= 0) {
            throw new IllegalArgumentException("The price cannot be negative or 0");
        }
        this.price = price;
    }

}
