/**
 * Author: Paul "Will" McBurney
 * 
 * Description: This is an implementation of a doubly linked list 
 * of integer values.
 */

public class DoublyLinkedList {
    
    //Doubly Linked Node
    private class Node {
        public int value;
        public Node next; //node after
        public Node prev; //node before
        
        //Constructor
        public Node(int x) {
            value = x;
            next = null;
            prev = null;
        }
    }
    //fields
    private Node head; //first node
    private Node tail; //last node
    private int size; //current size
    
    //Constructor
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * Returns whether or not the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns the number of elements in the list
     */
    public int length() {
        return size;
    }
    
    /**
     * Adds the value x to the head of the linked list.
     */
    public void enqueue(int x) { //to the head
        //create the node to insert
        Node newNode = new Node(x);
        
        if (isEmpty()) { //if the list is empty
            //we only have 1 node, so head and tail point to it
            head = newNode;
            tail = newNode;
            size++;
        } else { //else, add it BEFORE head
            head.prev = newNode; //New Node is before head
            newNode.next = head; //head is after newNode
            head = newNode; //update head pointer
            size++; //increment size
        }
    }
    /**
     * Removes and returns the value from the tail of the linked list.
     */
    public int dequeue() { //from the tail;
        //cannot dequeue from empty list
        if (isEmpty()) {
            throw new RuntimeException("Error: dequeue from empty list");
        }
        //store value for later output
        int out = tail.value;
        //update tail pointer and decrement size
        tail = tail.prev;
        size--;
        //if the list is not now empty
        if (!isEmpty()) {
            tail.next = null;//unlink the old tail from the list
        } else { //if it is empty
            head = null; //remove the head pointer as well since the list is empty
        }
        
        return out;
    }
    
    /**
     * This node gets the value at index in the Linked List.
     * Example: 4 -> 2 -> 3 -> 5 -> 7
     * 
     * get(3) would return 5, the value at index 3
     */
    public int get(int index) {
        //Out of bounds index check
        if (index < 0 || index >= size) {
            throw new RuntimeException("Error: get() out of bounds");
        }
        
        //create traveling node
        Node t = head;
        
        //travel to the target node
        while (index > 0) {
            index--;
            t = t.next;
        }
        
        //return that node's value.
        return t.value;
    }
    
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.enqueue(3);
        list.enqueue(5);
        System.out.println(list.dequeue());
        System.out.println(list.dequeue());
    }
    
}