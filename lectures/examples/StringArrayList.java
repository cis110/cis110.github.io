/**
 * Array implementation of the List ADT
 */
public class StringArrayList implements StringList{
  
  //storage array
  private String[] listArray;
  private static final int INITIAL_SIZE = 10;
  private int size;
  
  public StringArrayList(){
    listArray = new String[INITIAL_SIZE];
    size = 0;
  }
  
  public void clear(){
    size = 0;
  }
  //empty size = 0, i element-> size 1
  public boolean append(String it){
    if (size >= INITIAL_SIZE)
    {
      return false; //list of full
    }
    listArray[size] = it;
    size++;
    return true;   
  }
  
  public boolean insert(int index, String it){
    if (index < 0 || index >= size)
    {
            throw new IndexOutOfBoundsException();
    }
    if (size >= INITIAL_SIZE)
    {
      return false; //list of full
    }
    //[A, B, C, D, E,"",""] insert(2, F)
    //[A, B,"", C, D, E,""] shift up
    //[A, B, F, C, D, E, ""]
    for (int i=size; i>index; i--) { // Shift elements up  
      listArray[i] = listArray[i-1];//   to make room
    }
    listArray[index] = it;
    size++;                        // Increment list size
    return true;
    
  }
  
  //[A, B, F, C, D, E, ""] remove(2)
  //[A, B, C, D, E, E, ""] shift down
  public String remove(int index){
     if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
    String it = listArray[index];       // Copy the element
    for(int i=index; i<size-1; i++){ // Shift elements down
      listArray[i] = listArray[i+1];
    }
    size--;                        // Decrement size
    return it;
  }
  
  public String get(int index){
    //TODO
    return "";
  }
  
  public boolean contains(String o){
    //TODO
   return false;    
  }
  
  public int size(){
    return size;    
  }
  
  public boolean isEmpty(){
    return size == 0;
  }
  //format: [<A><B>]
  public String toString() {
    String out = "[";
    for (int i = 0; i < size; i++) {
      out = out + "<" + listArray[i] + ">";
    }
    out = out + "]";
    return out;
  } 
}
