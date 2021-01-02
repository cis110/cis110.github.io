/**
 * This file is covered in class March 29
 * 
 * This is to give more practice with linked lists,
 * specifically in looping through linked lists and
 * using recursive functions in linked list.
 */

public class LinkedListDoubles {
    /*
     * Private Inner Node class
     */
    private class DoubleNode {
        private double value;
        private DoubleNode next;
        
        public DoubleNode (double value) {
            this.value = value;
        }
    }
    
    public DoubleNode head; //front of the list (index 0)
    public DoubleNode tail; //last node of the list (index size - 1)
    public int size; //number of nodes in the list
    
    /**
     * Constructor - creates empty list.
     */
    public LinkedListDoubles() {
        head = null;
        tail = null;
        size = 0;
    }
    /**
     * This method returns whether or not the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * returns the current number of nodes in the list.
     */
    public int size() {
        return size;
    }
    
    /**
     * Inserts a new element at the start of the list    
     */
    public void insertAtHead(double r) {
        if (isEmpty()) {
            insertIntoEmptyList(r);
        } else {
            DoubleNode newNode = new DoubleNode(r); 
            newNode.next = head; 
            head = newNode; 
            size++; 
        }
    }
    /**
     * Inserts a new element at the end of the list    
     */
    public void insertAtTail(double r) {
        if (isEmpty()) {
            insertIntoEmptyList(r);
        } else {
            DoubleNode newNode = new DoubleNode(r); 
            tail.next = newNode; 
            tail = newNode; 
            size++; 
        }
    }
    
    /**
     * Private helper function to insert into an empty list.
     */
    private void insertIntoEmptyList(double r) {
        DoubleNode newNode = new DoubleNode(r);
        head = newNode;
        tail = newNode;
        size++;
    }
    
    /**
     * Gets the i-th element of the list, where 0 is the "head" element.
     */
    public double get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("ERROR: out of bounds on get()");
        }
        DoubleNode t = head;
        for (int i = 0; i < index ; i++) {
            t = t.next; 
        }
        return t.value; 
    }
    
    /**
     * Insert the element r at the i-th position.
     * Example: if the list is 5 -> 4 -> 3 -> null
     * If you called insertAt(2, 2); you would get:
     * 5 -> 4 -> 2 -> 3 -> null
     */
    public void insertAt(double r, int index) {
        if (index == 0) {
            insertAtHead(r);
        } else if (index == size) {
            insertAtTail(r);
        } else if (index < 0 || index > size) {
            throw new RuntimeException("ERROR: out of bounds on insertAt()");
        } else {
            DoubleNode t = head;
            for (int i = 0; i < index - 1; i++) {
                t = t.next; 
            }
            DoubleNode newNode = new DoubleNode(r); 
            newNode.next = t.next; 
            t.next = newNode; 
            size++; 
        }
    }
    
    /**
     * Recursive sum function
     */
    public double sum() {
        return sumHelper(head);
    }
    
    private double sumHelper(DoubleNode node) {
        if (node == null) {
            return 0; 
        } else {
            return node.value + sumHelper(node.next); 
        }
    }
    
    /**
     * Recursive max function
     */
    public double max() {
        return maxHelper(head);
    }
    
    private double maxHelper(DoubleNode node) {
        if (node == null) {
            throw new RuntimeException("Can't find the max of an emtpy list");
        } else if (node.next == null) {
            return node.value;
        } else {
            double maxOfRest = maxHelper(node.next);
            return Math.max(node.value, maxOfRest);
        }
    }
    
    public String toString() {
        String out = "";
        for (DoubleNode t = head; t != null; t = t.next) {
            out += t.value + " -> ";
        }
        return out + " null";
    }
    
    public static void main(String[] args) {
        LinkedListDoubles list = new LinkedListDoubles();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        list.insertAtHead(4);
        list.insertAtHead(5);
        list.insertAt(10, 3);
        System.out.println(list);
    }
}