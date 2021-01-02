/**
 * Auto Generated Java Class.
 */
public class Movie2
{
    //create a public static movie counter
    public static int movieCounter = 0;
    
    //create a private static movie counter
    private static int movieCounter2 = 0;
    
    //final makes a variable immutable /constant
    //final variables are often static
    public static final String studio = "CIS110";
  
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
    public Movie2(
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
        movieCounter2++;
    }


    /**
     * constructor no arguments
     * Create a new Movie instance/object
     */
    public Movie2()
    {
        setTitle("TBA");
        setYear(2020);
        setLength(0);
        setGenre("TBA");
        setFormat("TBA");
        setPrice(0.0);
        //increment movieCounter
        movieCounter++;
        movieCounter2++;
    }
    
  
    //non static getter for movieCounter2
    //can manipalete static variables
    public int getMovieCounter2(){
      return movieCounter2;
    }
    
    //static getter for movieCounter2
    //static methods can only maniplate static variables
    public static int getStaticMovieCounter2(){
      // System.out.println(title); error title is not static 
      return movieCounter2;
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
     */
    public void setLength(int length)
    {
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
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

}
