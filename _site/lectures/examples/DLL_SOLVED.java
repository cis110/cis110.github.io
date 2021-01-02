public class DoublyLinkedList implements List {
    //declare head node, tail node and size
    private Node first;
    private Node last;
    private int size;
    
    //node inner class
    private static class Node {
        private double item;
        private Node next;
        private Node prev;
        
        public Node(double item) {
            this.item = item;
            next = null;
            prev = null;
        }
    }
    //constructs empty list
    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }
    
    //appends specified element to the end of this list
    public void insertAtHead(double x) {
        if (size == 0) {
            insertIntoEmptyList(x);
        } else {
            Node
                newNode = new Node
                (x);
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
            size++;
        }
    }
    
    //appends specified element to the end of this list
    public void add(double x) {
        if (size == 0) {
            insertIntoEmptyList(x);
        } else {
            Node
                newNode = new Node
                (x);
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
            size++;
        } 
    }
    
    public void add(int index, double item) {
        if (index == 0) {
            insertAtHead(item);
            return;
        }
        if (index == size) {
            add(item);
            return;
        }
        Node
            temp = first;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        //temp is now the node BEFORE where we insert.
        Node
            tempNext = temp.next;
        Node
            newNode = new Node
            (item);
        tempNext.prev = newNode;
        newNode.next = tempNext;
        temp.next = newNode;
        newNode.prev = temp;
    }
    
    private void insertIntoEmptyList(double x) {
        first = new Node (x);
        last = first;
        size = 1;
    }
    
    public void removeFirst() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        } else if (size == 1) {
            clear();
        } else {
            Node second = first.next;
            first.next = null;
            second.prev = null;
            first = second;
        } 
    }
    
    public void removeLast() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        } else if (size == 1) {
            clear();
        } else {
            Node
                lastPrev = last.prev;
            lastPrev.next = null;
            last.prev = null;
            last = lastPrev;
        } 
    }
    
    //removes all of the elements from the list
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }
    
    //returns true if this list contains d
    public boolean contains(double d) {
        for (Node temp = first; temp != null; temp = temp.next) {
            if (temp.item == d) {
                return true;
            }
        }
        return false;
    }
    
    //returns the element at the specified position in the list
    public double get(int index) {
        checkIndex(index);
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.item;
    }
    
    //returns the index of the first occurrence of the specified element in the list or -1 if the list does not contain
    //the element
    public int indexOf(double d) {
        Node temp = first;
        for (int i = 0; i < size; i++) {
            if (temp.item == d) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }
    
    //returns true if this list contains no elements
    public boolean isEmpty() {
        return size == 0;
    }
    
    //removes the element at the specified position in the list
    public void remove(int index) {
        //assume this is in the middle
        checkIndex(index);
        if (size == 1) {
            clear();
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            //temp is the node to be removed.
            Node tempPrev = temp.prev;
            Node tempNext = temp.next;
            temp.next = null;
            temp.prev = null;
            tempPrev.next = tempNext;
            tempNext.prev = tempPrev;
        }
    }
    
    //removes the first occurrence of the specified element from the list
    public boolean remove(double d) {
        Node temp = first;
        for (int i = 0; i < size; i++) {
            if (temp.item == d) {
                remove(i);
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    //replaces the element at the specified location
    public double set(int index, double d) {
        checkIndex(index);
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        double oldItem = temp.item;
        temp.item = d;
        return oldItem;
    }
    
    //returns the number of elements in the list
    public int size() {
        return size;
    }
    
    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new java.lang.IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        }
    }
    
    public String toString() {
        String out = "Size: " + size + "\n";
        for (Node temp = first; temp != null; temp = temp.next) {
            out += temp.item + " ";
        }
        return out;
    }
    
    public static void main(String[] args) {
        //LinkedList for testing
        DoublyLinkedList l = new DoublyLinkedList();
    }
}