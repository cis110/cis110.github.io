import java.util.Random;
import java.util.ArrayList;
import java.util.List;

//-------------------------------------------------------------------------
/**
 * This class represents an implementation of a bag collection
 * that internally uses an ArrayList or a LinkedList to hold the items.
 *
 * We will complete this class.
 *

 */
public class ListBasedBag
    implements Bag
{
    

    // You write the declaration for this field:
       private ArrayList contents;  // the bag contents


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates an empty bag using the default capacity.
     */
    public ListBasedBag()
    {
        contents = new ArrayList();
    }


    // ----------------------------------------------------------
    /**
     * Creates an empty bag using the specified capacity.
     * @param initialCapacity
     */
    public ListBasedBag(int initialCapacity)
    {
        contents = new ArrayList(5);
    }


    

    @Override
    public void add(Book book)
    {
      //we add book to the list
        contents.add(book);
        
    }


    @Override
    public Book remove(Book target)
    {
      //check if target is in bag
      if(!this.contains(target)){
        return null;
      }
        //get the position of target
      int pos = contents.indexOf(target);
        return (Book)contents.remove(pos);
    }


    @Override
    public Book removeRandom()
    {
        //random position
      int pos = (int)(Math.random() * this.size());
        return (Book)contents.remove(pos);
    }


    @Override
    public boolean contains(Book target)
    {
      //we call the contains of the List ADT
        return contents.contains(target);
    }


    @Override
    public boolean isEmpty()
    {
  
        return contents.isEmpty(); //contents.size()==0;
    }


    @Override
    public int size()
    {       
        return contents.size();
    }
    
    @Override
    public String toString(){
      if(this.isEmpty()){
        return "{}";
      }
      
      String result = "{";
      for(int i = 0; i < this.size()-1; i++){
        result = result + contents.get(i).toString() + ", ";
      }
      //add the last element
      result = result + contents.get(this.size()-1).toString() + "}";
     return result;
    }
}
