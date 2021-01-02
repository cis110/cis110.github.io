public class StringReverser {
    
    public static void main(String[] args) {
        String original = args[0];
        String result = "";
        int length = original.length();
        for (int i = length - 1; i >= 0; i--) {
            result += original.charAt(i);
        }
        System.out.println(result);
    }
    
}