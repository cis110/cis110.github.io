public class StackTest {
    public static void main(String[] args){
        StackOfStrings stack = new StackOfStrings();
        
        stack.push("Blue");
        stack.push("Green");
        System.out.println(stack.pop());//should print Green
        
        System.out.println(stack.isEmpty()); //prints false
        System.out.println(stack);//size = 1 , Blue
    }
}