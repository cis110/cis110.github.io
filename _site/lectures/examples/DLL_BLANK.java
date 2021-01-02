public class DoublyLinkedList implements List {
    //declare head node, tail node and size
    private Node first;
    private Node last;
    private int size;
    
    //node inner class
    private static class Node {
        private double item;
        private Node next;
        private Node prev;
        
        public Node(double item) {
            this.item = item;
            next = null;
            prev = null;
        }
        
        public Node(double item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    //constructs empty list
    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }
    
    //constructs list with one element
    public DoublyLinkedList(double val) {
        Node n = new Node(val);
        first = n;
        last = n;
        size = 1;
    }
    
    //appends specified element to the end of this list
    public void add(double d) {
    }
    
    //inserts the specified element at the specified position in the list
    public void add(int index, double d) {
    }
    
    //removes all of the elements from the list
    public void clear() {
    }
    
    //returns true if this list contains d
    public boolean contains(double d) {
        return false;
    }
    
    //returns the element at the specified position in the list
    public double get(int index) {
        return -1;
    }
    
    //returns the index of the first occurrence of the specified element in the list or -1 if the list does not contain
    //the element
    public int indexOf(double d) {
        return -1;
    }
    
    //returns true if this list contains no elements
    public boolean isEmpty() {
        return false;
    }
    
    //removes the element at the specified position in the list
    public double remove(int index) {
        return -1;
    }
    
    //removes the first occurrence of the specified element from the list
    public boolean remove(double d) {
        return false;
    }
    
    //replaces the element at the specified location
    public double set(int index, double d) {
        return -1;
    }
    
    //returns the number of elements in the list
    public int size() {
        return -1;
    }
}