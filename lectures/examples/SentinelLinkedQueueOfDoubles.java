/* SentinelLinkedQueueOfDoubles
 * 
 * This class implements a queue with a linked list.
 * It uses recursion to navigate the list, and 
 * uses a sentinel node at the head of the list
 * to eliminate some checks for null references.
 * (Compare enqueue() to the enqueue() implementation
 * in LinkedQueueOfDoubles to see effect of a sentinel node.)
 *
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

public class SentinelLinkedQueueOfDoubles implements QueueOfDoublesInterface {
    private class Node {
        Node next;
        double val;
    }
    
    // the head of the linked list
    // it is initialized to a "sentinel" or "dummy" node
    private Node head;
    
    // add a value to the end of the list
    public void enqueue(double head) {  
        // find the last node in the list
        // head is never null, so there is no special case to worry about
        Node n = this.head;
        while (n.next != null) n = n.next;
        
        // add the value to the end
        n.next = new Node();
        n.next.val = d;
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
        if (head.next == null) return "";
        String s = "" + head.next.val;
        for (Node n = head.next.next; n != null; n = n.next)
            s += " -> " + n.val;
        return s;
    }
    
    public SentinelLinkedQueueOfDoubles() {
        head = new Node();
    }
    
    public static void main(String[] args) {
        SentinelLinkedQueueOfDoubles q = new SentinelLinkedQueueOfDoubles();
        q.enqueue(42);
        q.enqueue(Math.PI);
        q.enqueue(Double.POSITIVE_INFINITY);
        q.enqueue(3);
        q.dequeue();
        
        System.out.println(q);
    }
}
