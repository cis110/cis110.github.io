public class FunctionExercisesSolution {

    public static int countInstancesOf(char c, String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
    
    
    
    public static void main(String[] args) {
        
        int totalCount = 0;
        char c = args[0].charAt(0);
        for (int i = 1; i < args.length; i++) {
            totalCount += countInstancesOf(c, args[i]);
        }
        System.out.println(totalCount);
    }
}