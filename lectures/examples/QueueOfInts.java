/**
 * Author: Paul "Will" McBurney
 * 
 * This class implements a queue of integers values using
 * a Linked List structure
 */

public class QueueOfInts {
    
    /**
     * This is an "INNER CLASS". An inner class is when you need
     * a class that only one other class uses. Linked lists and
     * nodes are the classic example of this.
     */
    private class IntNode {
        public int value; //value stored in node
        public IntNode next; //pointer to next node
        
        //constructor
        public IntNode(int x) {
            value = x;
            next = null;
        }
    }
    
    private IntNode head; //first node in list
    private IntNode tail; //last node in list
    
    //Constructor for queue
    public QueueOfInts() {
        head = null;
        tail = null;
    }
    
    /**
     * Returns true of list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return head == null && tail == null;
    }
    
    /**
     * Returns current size of the queue, that is, number
     * of integers inside the queue
     */
    public int size() {
        int size = 0;
        for (IntNode t = head; t != null; t = t.next) {
            size++;
        }
        return size;
    }
    /**
     * Returns the sum of integers in the queue
     */
    public int sum() {
        int sum = 0;
        for (IntNode t = head; t != null; t = t.next)  {
            sum += t.value;
        }
        return sum;
    }
    
    /**
     * Inserts at the end of the queue
     */
    public void enqueue(int x) {
        IntNode newNode = new IntNode(x);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    /**
     * Removes from the front of the queue and returns
     * the removed number
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("ERROR: dequeue from empty queue");
        }
        int out = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return out;
    }
    
    public static void main(String[] args) {
        QueueOfInts q = new QueueOfInts();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.size() + " - should be 3");
        System.out.println(q.sum() + " - should be 6");
        q.dequeue();
        q.dequeue();
        q.dequeue();
        System.out.println(q.isEmpty() + " - should be true");
    }
}