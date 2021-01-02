public class StringNode {
    public String item; //the value at this node
    public StringNode next; //a pointer to where I can find the next node
    
    //constructor - creates an initially empty stack of strings
    public StringNode(String item) {
        this.item = item;
        next = null;
    }
}