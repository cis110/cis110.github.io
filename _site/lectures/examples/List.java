public interface List {
    
    //appends specified element to the end of this list
    void add(double d);
    
    //inserts the specified element at the specified position in the list
    void add(int index, double d);
    
    //removes all of the elements from the list
    void clear();
    
    //returns true if this list contains d
    boolean contains(double d);
    
    //returns the element at the specified position in the list
    double get(int index);
    
    //returns the index of the first occurrence of the specified element in the list or -1 if the list does not contain
    //the element
    int indexOf(double d);
    
    //returns true if this list contains no elements
    boolean isEmpty();
    
    //removes the element at the specified position in the list
    double remove(int index);
    
    //removes the first occurrence of the specified element from the list
    boolean remove(double d);
    
    //replaces the element at the specified location
    double set(int index, double d);
    
    //returns the number of elements in the list
    int size();
}