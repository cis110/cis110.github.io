/**
 * Starting point for Linked List
 */

public class LinkedListTemplate {
    //declare head node
    
    //node inner class
    private class Node {
        private double val;
        private Node next;
        
        public Node(double val) {
            this.val = val;
        }
        
        public Node(double val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    //constructs empty list
    public LinkedListTemplate() {
    }
    
    //constructs list with one element
    public LinkedListTemplate(double val) {  
    }
    
    //adds element to end of list
    public boolean add(double val) {
        return false;
    }
    
    //adds element at specified index
    public boolean add(int index, double val) {
        return false;
    }
    
    //returns number of elements in list
    public int size() {
        return -1;
    }
    
    //returns the element at specified index
    public double get(int index) {
        return -1;
    }
    
    //returns the element at specified index and
    //removes element from the list
    public double remove(int index) {
        return -1;
    }
    
    //sets the value at the given index to val
    //returns the value that was previously at index
    public double set(int index, double val) {
        return -1;
    }
    
    //checks if size of list is zero
    public boolean isEmpty() {
        return false;
    }
    
    //returns true if list contains given val
    public boolean contains(double val) {
        return false;
    }
    
    //returns the index of val in the list
    //return -1 if val is not in list
    public int indexOf(double val) {
        return -1;
    }
}



