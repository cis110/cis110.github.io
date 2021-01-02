/* LinkedQueueOfDoubles
 * 
 * This class implements a queue with a linked list.
 * It uses loops to navigate the list, and an empty
 * list will have a null head node.
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
public class LinkedQueueOfDoubles implements QueueOfDoublesInterface {
    class Node {
        Node next;
        double val;
    }
    
    // the head of the list
    // this value is protected rather than private
    // so that sub-classes can access it
    protected Node head;
    
    // add a value to the end of the list
    public void enqueue(double d) {
        // special case: the list is empty
        if (head == null) {
            // create a new head node
            head = new Node();
            head.val = d;
            return;
        }
        
        // general case: the list exists
        // we need to find its end/tail
        // and add a node there
        Node n = head;
        while (n.next != null) n = n.next;
        n.next = new Node();
        n.next.val = d;
    }
    
    // remove node at the front/head of the list
    // do nothing if the list is empty
    public void dequeue() {
        if (head != null)
            head = head.next;
    }

    // return whether or not the queue is empty    
    public boolean isEmpty() { return head == null; }
    
    // produce a string representation of a
    // node and all following nodes in the list
    public String toString() {
        // print nothing if the list is empty
        if (head == null) return "";
        
        // print out the first value
        String s = "" + head.val;
        
        // add on the values of everything else
        for (Node n = head.next; n != null; n = n.next)
            s += " -> " + n.val;
        
        return s;
    }

    public LinkedQueueOfDouble() {
    }
    
    // testing
    public static void main(String[] args) {
        LinkedQueueOfDoubles q = new LinkedQueueOfDoubles();
        q.enqueue(42);
        q.enqueue(Math.PI);
        q.enqueue(Double.POSITIVE_INFINITY);
        q.enqueue(3);
        q.dequeue();
        
        System.out.println(q);
    }
}
