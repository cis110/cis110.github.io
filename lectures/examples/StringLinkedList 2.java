public class StringLinkedList implements StringList
{
    // insert, append, size, isEmpty, toString
    private Node head;
    private Node tail;
    private int  size;


    public StringLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    // Remove all contents from the list, so it is once again empty
    public void clear()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    // Insert "it" at the current location
    public boolean insert(int index, String it)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0)
        { // insert at head
            insertAtHead(it);
        }
        else if (index == size)
        {
            insertAtTail(it);
        }
        else
        { // insert after the head
            int i = 0;
            Node curr = head;
            while (i < index - 1)
            {
                curr = curr.next;
                i++;
            } // curr points to the node before where the new node will be
              // inserted
            Node newNode = new Node(it, curr.next);
            curr.next = newNode;
        }
        size++; // increment size
        return true;
    }


    private void insertAtHead(String it)
    {
        if (isEmpty())
        {
            insertIntoEmptyList(it);
        }
        else
        {
            Node newHead = new Node(it, head);
            head = newHead;
        }

    }


    private void insertAtTail(String it)
    {
        if (isEmpty())
        {
            insertIntoEmptyList(it);
        }
        else
        {
            tail.next = new Node(it, null);
            tail = tail.next;
        }

    }


    private void insertIntoEmptyList(String it)
    {
        Node newHead = new Node(it, null);
        head = newHead;
        tail = newHead;
    }


    // Append "it" at the end of the list
    public boolean append(String it)
    {
        if (isEmpty())
        {
            insertIntoEmptyList(it);
        }
        else
        {
            insertAtTail(it);
        }
        size++;
        return true;
    }


    // Removes and return the element at the specified position in this list
    public String remove(int index)
    {
        // TODO
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        String value = "";
        if (isEmpty())
        {
            return "";
        }
        else if (index == 0)
        { // remove at head
            value = head.data;
            if (size == 1)
            { // list will become empty
                clear();
                return value;
            }
            head = head.next;
        }
        else
        {
            // move to the correct position
            int i = 0;
            Node curr = head;
            while (i < index - 1)
            {
                curr = curr.next;
                i++;
            }
            if (curr.next == tail)
            {// remove at tail
                value = tail.data; // Remember value
                curr.next = null; //remove node from list
                tail = curr; //move tail
            }
            else
            {
                value = curr.next.data; // Remember value
                curr.next = curr.next.next; //remove node
            }
        }
        size--;
        return value;
    }


    // Returns the element at the specified position in this list
    public String get(int index)
    {
        // TODO
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0)
        {
            return head.data;
        }
        // move to the node at index
        int i = 0;
        Node curr = head;
        while (i < index)
        {
            curr = curr.next;
            i++;
        }
        return curr.data;
    }


    // Returns true if this list contains the specified element
    public boolean contains(String o)
    {
        // TODO
        if (isEmpty())
        {
            return false;
        }
        Node curr = head;
        while (curr != null)
        {
            if (curr.data.equals(o))
            {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }


    // Returns the length / number of elements in this list
    public int size()
    {
        return size;
    }


    // Returns true if this list is empty
    public boolean isEmpty()
    {
        return (head == null) && (tail == null);
    }


    public String toString()
    {
        if (isEmpty())
        {
            return "[]";
        }
        String result = "[";
        Node curr = head;
        while (curr != tail)
        {
            result = result + "<" + curr.data + ">";
            curr = curr.next;
        }
        result = result + "<" + curr.data + ">" + "]";
        return result;
    }


    private class Node
    {
        private String data;
        private Node   next;


        public Node(String data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }

}
