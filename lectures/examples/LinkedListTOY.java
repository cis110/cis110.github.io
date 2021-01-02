/* LinkedListTOY.java
 * Benedict Brown
 *
 * Inserts number into a linked list in sorted order
 * then prints them out.
 *
 * Written in a style that is easy to translate to TOY
 * for illustrating how linked lists work in TOY.
 *
 * Input: a file with a list of integers (unordered)
 *        The first integer is the numer of values to read (a la N-Body)
 *   Example: 5
 *            3
 *            4
 *            2
 *            0
 *            1
 *   Is a file containing 5 numbers to sort: 3, 4, 2, 0, and 1
 *
 * Ouput: Numbers in sorted order.  The above example prints
 *            0
 *            1
 *            2
 *            3
 *            4
 */

public class LinkedListTOY {
    // private node class
    private static class Node {
        int val;
        Node next;
    }

    public static void main(String[] args) {
        // pre-allocate the nodes we might need
        // so the java program behaves like TOY
        //
        // this loop is not needed in TOY
        Node[] mem = new Node[128];
        for (int i = 0; i < mem.length; i++)
            mem[i] = new Node();

        // open the file and read valsLeftToRead
        In inStream = new In(args[0]);
        int valsLeftToRead = inStream.readInt();

        // initialize the head node to null and
        // nextMemIndex to index 0 of the mem array
        //
        // note that TOY keeps track of the *address*
        // of mem[nextMemIndex], not of the *index* nextMemIndex
        // i.e. if the mem array starts at memory address 0x80,
        // TOY will keep track of 0x80 + 2 * nextMemIndex since
        // every node takes 2 words of memory
        Node head = null;
        int nextMemIndex = 0;

        // create list
        while (valsLeftToRead > 0) {
            int newVal = inStream.readInt(); // read in a value
            mem[nextMemIndex].val = newVal;  // set val of next available node

            if (head == null) { // set head if this is the first element
                head = mem[nextMemIndex];
                mem[nextMemIndex].next = null;
            } else {
                // insert new value at the beginning if it is smallest we've seen
                if (newVal <= head.val) { 
                    mem[nextMemIndex].next = head;
                    head = mem[nextMemIndex];
                } else {
                    // find first node in list whose next is larger than new value
                    Node node = head;
                    while (node.next != null) {
                        if (node.next.val > newVal)
                            break;

                        node = node.next;
                    }

                    // insert value after this node
                    mem[nextMemIndex].next = node.next;
                    node.next = mem[nextMemIndex];
                }
            }

            valsLeftToRead--; // update valsLeftToRead
            nextMemIndex++;   // update nextMemIndex to point to next unused node
        }

        // print out values
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
