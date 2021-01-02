public class DoublyLinkedQueue{
    public DLLNode head;
    public DLLNode tail;
    
    public DoublyLinkedQueue(){
        head = null;
        tail = null;
    }
    
    public boolean isEmpty(){
        return (head == null);
    }
    
    public void enqueue(int x) {
        //create the enqueue node
        DLLNode newNode = new DLLNode(x);
        
        if (isEmpty()){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    
    public int dequeue() {
        if (isEmpty()){
            throw new RuntimeException("ERROR: Dequeue from empty queue");
        }
        int output = head.item;        
        head = head.next;
        if (head == null) { //list is size 1
            tail = null;
        }
        else { //other
            head.prev = null;
        }
        
        return output;
    }
    
    public static void main(String[] args) {
        DoublyLinkedQueue q = new DoublyLinkedQueue();
        q.enqueue(1);
        q.enqueue(4);
        System.out.println(q.dequeue()); //should print 1
        System.out.println(q.dequeue()); //should print 4
        q.dequeue();
    }
}