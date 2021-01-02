
public class IntNode {
    public int data;
    // next's type is "Reference to an IntNode"
    // this also means that the heap memory
    // allocated for the entire list of IntNodes
    // IS NOT GUARANTEED to be sequential,
    // unlike an array
    public IntNode next;
    
    public IntNode(int data, IntNode next) {
        this.data = data;
        this.next = next;
    }
    
    public IntNode(int data) {
        this.data = data;
        this.next = null;
    }
    
    public boolean hasNext() {
        return this.next != null;
    }
    
    public static void printList(IntNode start) {
        for(IntNode curr = start; curr != null; curr = curr.next) {
            System.out.print(curr.data + " ");
        }
    }
    
    // Inserts a node with the given value just after
    // the node invoking this function. If the invoker
    // currently has a next node, then its next becomes
    // the next of the newly-inserted node
    public void insertNext(int value) {
        IntNode newNode = new IntNode(value);
        
        if(this.next != null) {
            newNode.next = this.next;
        }
        this.next = newNode;
    }
    
    public void removeNext() {
        IntNode tempNext = this.next.next;
        this.next.next = null;
        this.next = tempNext;
    }
    
    // Given the beginning of the linked list, and
    // an int indicating the ith node in the list,
    // return the value stored at that node
    public static int valueAtIndex(IntNode start, int i) {
        int currentIndex = 0;
        // Before we do the loop, can we check if i is out of bounds of our list?
        // No, we cannot.
        for(IntNode curr = start; curr != null; curr = curr.next) {
            if(currentIndex == i) {
                return curr.data;
            }
            ++currentIndex;
        }
        // Do something if the index ended up being out of bounds
        throw new ArrayIndexOutOfBoundsException(i);
        // I throw an exception to indicate an index out of bounds
        // instead of returning some dummy value because there is no
        // value I could return that would indicate an error.
    }
    
    // Tell us how many nodes the linked list contains
    // given the start of the linked list
    // ASSUMES that the node passed into the function is the first node in the list
    public static int length(IntNode start) {
        int length = 0;
        // Do I need to specially handle the case in which start is null?
        for(IntNode curr = start; curr != null; curr = curr.next) {
            ++length;
        }
        return length;
    }
    
    public static void main(String[] args) {
        /*
        IntNode a = new IntNode(10);
        IntNode b = new IntNode(20);
        IntNode c = new IntNode(33);
        a.next = b;
        b.next = c;
        */
        // Build a linked list
        // Size is NOT fixed; can ADD or REMOVE elements at will
        IntNode c = new IntNode(33);
        IntNode b = new IntNode(20, c);
        IntNode a = new IntNode(10, b);
        a.insertNext(40);
        a.next.removeNext();
        printList(a);
        System.out.println();
        System.out.println(valueAtIndex(a, 0));
    }
}