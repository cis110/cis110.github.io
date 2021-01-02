public class StackOfStrings {
    private StringNode first;
    private int size;
    
    //constructor
    public StackOfStrings() {
        first = null;
        size = 0;
    }
    
     /**
     * Return true if the stack if empty. Otherwise return false.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     *  Push a new String onto the stack
     */ 
    public void push(String str) {
        //create a new node an populates it with input String
        StringNode newNode = new StringNode(str);
        
        //Link newNode into list
        newNode.next = first;
        
        //increment size
        size++;
        
        //update first pointer
        first = newNode;
    }
    
    /**
     * Remove and return the first value on the stack 
     */
    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Error: Tried to pop from empty stack");
        }
        //Store value to be returned
        String output = first.item;
        
        //Update first pointer to next node
        first = first.next;
        
        //decrement size
        size--;
        
        //Return
        return output;
    }
    
    /**
     * Return the contents of the Stack of Strings as a single String
     */
    
    public String toString() {
        String out = "Size = " + size + "\n";
        for (StringNode temp = first; temp != null; temp = temp.next) {
            out = out + temp.item + ",";
        }
        return out;
    }
    
    public static void main(String[] args) {
        StackOfStrings stack = new StackOfStrings();
        stack.push("to");
        stack.push("be");
        stack.push("or");
        stack.push("not");
        stack.push("to");
        stack.push("be");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}