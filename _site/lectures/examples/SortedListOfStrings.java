/* SortedListOfStrings
 * Benedict Brown
 * November 2016
 *
 * Maintains a linked list of strings in sorted order.
 * insert() adds a string to the list, 
 * contains() returns whether or not the string is in the list.
 *
 * Behavior is undefined if the string is null.
 */
public class SortedListOfStrings {
    // A simple node class for the linked list
    // str and next get initialized to null by default
    // because there is no constructor
    private class Node {
        public String str;
        public Node next;
    }
    
    // The head of the linked list is initialized with an empty
    // Node rather than with null.  This node is a "dummy"
    // node that doesn't contain an actual string.  It
    // allows us to avoid special cases where head == null
    // and for inserting a string at the head of the list
    private Node head = new Node();
    
    // Tnsert the string s into the list.
    // Throw a NullPointerException if s is null.
    public void insert(String s) {
        // Find the node n *after which* to insert s.
        // We don't have to worry about head == null
        // or s coming before all other strings in the list
        // because of the "dummy" node at the front of the list.
        Node n = head;
        while (n.next != null && s.compareTo(n.next.str) >= 0)
            n = n.next;
        
        // create a new node for the string s and insert it after n
        Node newNode = new Node();
        newNode.str = s;
        newNode.next = n.next;
        n.next = newNode;
    }
    
    // Return whether or not the list contains string s
    // Throw a NullPointerException if s is null
    public boolean contains(String s) {
        // Traverse the list, looking for s.
        // Start at head.next because head is the dummy node
        for (Node n = head.next; n != null; n = n.next) {
            if (s.compareTo(n.str) == 0) {
                // we found the s, so return true
                return true;
            } else if (s.compareTo(n.str) < 0) {
                // we've already gone too far, so
                // s isn't in the list
                return false;
            }
        }
        
        // we checked the entire list without finding s
        return false;
    }
}
