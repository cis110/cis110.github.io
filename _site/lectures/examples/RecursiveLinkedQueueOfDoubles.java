/* RecursiveLinkedQueueOfDoubles
 * 
 * This class implements a queue with a linked list.
 * It uses recursion to navigate the list, and 
 * uses a sentinel node at the head of the list
 * to eliminate some checks for null references.
 * (Compare enqueue() to the enqueue() implementation
 * in LinkedQueueOfDoubles to see effect of a sentinel node.)
 *
 * The only methods implemented are enqueue, dequeue,
 * isEmpty(), and toString, because that is enough to
 * illustrate the structure and functioning of a linked list.
 *
 * A more useful queue class would also be able to return
 * the value at the head of the list (peek), and report
 * its size.
 *
 * Dependiencies: QueueOfDoublesInterface.java
 */
public class RecursiveLinkedQueueOfDoubles implements QueueOfDoublesInterface {
    private class Node {
        Node next;
        double val;
        
        // string representation of current
        // value followed by all subsequent values
        public String toString() {
            String s = "" + val;
            if (next != null)
                s += " -> " + next;
            return s;
        }
        
        // add a value to the end of the list
        public void enqueue(double d) {
            if (next == null) {
                // this node is the end of the list
                // so append the value
                next = new Node();
                next.val = d;
            } else {
                // this node is not the end of the list
                // so tell the next node in the list to add it
                next.enqueue(d);
            }
        }
    }
    
    // the head of the list, with a sentinel node for convenience
    private Node head = new Node();
    
    // add a value to the end of the list
    public void enqueue(double d) {
        head.enqueue(d); // the node class does the real work
    }
    
    // remove node at the front/head of the list
    // do nothing if the list is empty
    public void dequeue() {
        if (head.next != null) // head.next is the real head of the list
            head.next = head.next.next;
    }
    
    // return whether or not the queue is empty
    public boolean isEmpty() { return head.next == null; }
    
    // produce a string representation of a
    // node and all following nodes in the list
    public String toString() {
        // print nothing if the list is empty
        if (head.next == null) return "";
        return "" + head.next; // the node class does the real work
    }
    
    
    // testing
    public static void main(String[] args) {
        RecursiveLinkedQueueOfDoubles q = new RecursiveLinkedQueueOfDoubles();
        q.enqueue(42);
        q.enqueue(Math.PI);
        q.enqueue(Double.POSITIVE_INFINITY);
        q.enqueue(3);
        q.dequeue();
        
        System.out.println(q);
    }
}
