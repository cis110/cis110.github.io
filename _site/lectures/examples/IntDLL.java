/**
 * Integer doubly linked list
 */

public class IntDLL {
    int size;
    IntNode first;
    IntNode last;
    
    //inner class DLL Node
    class IntNode {
        int item;
        IntNode prev;
        IntNode next;
        
        public IntNode(int item) {
            this.item = item;
            prev = null;
            next = null;
        }
    }
    
    public IntDLL() {
        size = 0;
        first = null;
        last = null;
    }
    
    public void insertAtHead(int x) {
        if (size == 0) {
            insertIntoEmptyList(x);
        } else {
            IntNode newNode = new IntNode(x);
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
            size++;
        }
    }
    
    public void insertAtTail(int x) {
        if (size == 0) {
            insertIntoEmptyList(x);
        } else {
            IntNode newNode = new IntNode(x);
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
            size++;
        } 
    }
    
    public void insertAt(int item, int index) {
        if (index == 0) {
            insertAtHead(item);
            return;
        }
        if (index == size) {
            insertAtTail(item);
            return;
        }
        IntNode temp = first;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        //temp is now the node BEFORE where we insert.
        IntNode tempNext = temp.next;
        IntNode newNode = new IntNode(item);
        tempNext.prev = newNode;
        newNode.next = tempNext;
        temp.next = newNode;
        newNode.prev = temp;
    }
    
    private void insertIntoEmptyList(int x) {
        first = new IntNode(x);
        last = first;
        size = 1;
    }
    
    public void removeHead() {
        if (size == 0) {
            throw new RuntimeException("ERROR: cannot remove from empty list");
        } else if (size == 1) {
            removeOnlyElementFromList();
        } else {
            IntNode second = first.next;
            first.next = null;
            second.prev = null;
            first = second;
        } 
    }
    
    public void removeTail() {
        if (size == 0) {
            throw new RuntimeException("ERROR: cannot remove from empty list");
        } else if (size == 1) {
            removeOnlyElementFromList();
        } else {
            IntNode lastPrev = last.prev;
            lastPrev.next = null;
            last.prev = null;
            last = lastPrev;
        } 
    }
    
    public void remove(int index) {
        //assume this is in the middle
        if (size == 0) {
            throw new RuntimeException("ERROR: cannot remove from empty list");
        } else if (index >= size) {
            throw new RuntimeException("Cannot remove value of Index >= Size");
        } else if (size == 1) {
            removeOnlyElementFromList();
        } else if (index == 0) {
            removeHead();
        } else if (index == size-1) {
            removeTail();
        } else {
            IntNode temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            //temp is the node to be removed.
            IntNode tempPrev = temp.prev;
            IntNode tempNext = temp.next;
            temp.next = null;
            temp.prev = null;
            tempPrev.next = tempNext;
            tempNext.prev = tempPrev;
        }
    }
    
    private void removeOnlyElementFromList() {
        first = null;
        last = null;
        size = 0;
    }
    
    public String toString() {
        String out = "Size: " + size + "\n";
        for (IntNode temp = first; temp != null; temp = temp.next) {
            out += temp.item + ",";
        }
        return out;
    }
    
    public static void main(String[] args) {
        IntDLL list = new IntDLL();
        list.insertAtHead(1);
        System.out.println(list);
        list.insertAtHead(2);
        list.insertAtHead(3);
        System.out.println(list);
        list.insertAtTail(4);
        System.out.println(list);
        list.insertAt(5, 4);
        System.out.println(list);
        list.removeHead();
        list.removeTail();
        list.remove(1);
        System.out.println(list);
    }
}
