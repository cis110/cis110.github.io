public interface StringList { 
// List of String interface ADT  
    // Remove all contents from the list, so it is once again empty  
    public void clear();  
    // Insert "it" at the position index in this list.  
    // throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > length) 
    public boolean insert(int index, String it);  
    // Append "it" at the end of the list 
    public boolean append(String it);  
    // Removes and return the element at the specified position in this list 
    // throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= length) 
    public String remove(int index); 
    // Returns the element at the specified position in this list 
    // throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= length) 
    public String get(int index); 
    // Returns true if this list contains the specified element. The empty String otherwise  
    public boolean contains(String o);  
    // Returns the length / number of elements in this list 
    public int size();  
    // Returns true if this list is empty 
    public boolean isEmpty();  
}
