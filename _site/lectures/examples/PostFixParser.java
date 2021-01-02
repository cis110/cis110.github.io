public class PostFixParser {
    static MyIntStack stack;
        
    public static int evaluate(String input) {
        String[] inputSplit = input.split(" ");
        stack = new MyIntStack(inputSplit.length);
        for (int i = 0; i < inputSplit.length; i++) {
            if (isOperator(inputSplit[i])) {
                processOperator(inputSplit[i]);
            } else {
                int x = Integer.parseInt(inputSplit[i]);
                stack.push(x);
            }
        }
        return stack.pop();
    }
    
    private static boolean isOperator(String str) {
        if ((str.equals("+")) || (str.equals("-")) ||
            (str.equals("*")) || (str.equals("/"))) {
            return true;
        } else {
            return false;
        }
    }
    
    private static void processOperator(String operator) {
        int val1 = stack.pop();
        int val2 = stack.pop();
        if (operator.equals("+")) {
            stack.push(val1 + val2);
        } else if (operator.equals("-")) {
            stack.push(val1 - val2);
        } else if (operator.equals("*")) {
            stack.push(val1 * val2);
        } else if (operator.equals("/")) {
            stack.push(val1 / val2);
        }
    }
    
    public static void main(String[] args) {
        int answer = PostFixParser.evaluate("2 3 + 7 *");
        System.out.println(answer + " should be 35");
    }
}