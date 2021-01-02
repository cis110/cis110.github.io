public class ReverseSentence {
    
      public static String reverse (String s) {
        String answer = "";
        for (int n = s.length() - 1; n >= 0; n--) {
            answer += s.charAt(n);
        }
        return answer;
    }
    
    public static void main(String[] args) {
        String input = args[0];
        if (reverse(input).equals(input)) {
            System.out.println ("good!");
        }
        else {
            System.out.println("boooooo!!!");
        }
    }
    
  
}