public class LinkNodesActivity {

    public static void printLinkNodes(Link head) {
        if (head == null) {
            System.out.println("null head");
        } else {
            Link curr = head;
            while (curr != null) {
                System.out.println(curr.data);
                curr = curr.next;
            }
        }

    }

    /**
     * Remove the node at the beginning of the list and put it at the end of the
     * list using only a reference to the head node.
     * 
     * Returns the new head of the list.
     */
    public static Link solveProblemOne(Link head) {
        head.next.next.next = head;
        head = head.next;
        head.next.next.next = null;
        return head;
    }

    public static void main(String[] args) {
        // problem 1
        Link pOne = new Link('A', null);
        pOne.next = new Link('B', null);
        pOne.next.next = new Link('C', null);

        // do the modifications required for Problem 1
        Link solutionOne = solveProblemOne(pOne);

        // should print 'B', 'C', 'A'
        printLinkNodes(solutionOne);
    }
}