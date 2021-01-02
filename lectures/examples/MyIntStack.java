public class MyIntStack {
    private int[] contents;
    private int capacity;
    private int size;
    
    public MyIntStack(int capacity) {
        this.capacity = capacity;
        contents = new int[capacity];
        size = 0;
    }
    
    public void push(int x) {
        //check if stack is full
        if (size == capacity) {
            throw new RuntimeException("ERROR: Tried to push to a full stack.");
        }
        contents[size] = x;
        size++;
    }
    
    public int pop() {
        if (size == 0) {
            throw new RuntimeException("ERROR: Tried to pop from empty stack");
        }
        size--;
        return contents[size];
    }
    
    public int peek() {
        if (size == 0) {
            throw new RuntimeException("ERROR: Tried to peek at empty stack");
        }
        return contents[size-1];
    }
    
    public String toString() {
        String out = "Capacity: " + capacity + "\n";
        out += "Size: " + size + "\n";
        out += "Contents: ";
        for (int i = 0; i < size; i++) {
            out += contents[i] + ",";
        }
        return out;
    }
    
    public static void main(String[] args) {
        MyIntStack stack = new MyIntStack(4);
        stack.push(4);
        stack.push(3);
        stack.push(5);
        stack.pop();
        stack.push(7);
        System.out.println(stack);
    }
}