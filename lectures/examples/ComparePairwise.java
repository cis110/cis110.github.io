public class ComparePairwise {
    public static void main(String[] args) {
        int[] inputNumber = new int[args.length];
        
        //populate our input array
        for (int i = 0; i < args.length; i++) {
            inputNumber[i] = Integer.parseInt(args[i]);
        }
        
        for (int i = 0; i < inputNumber.length; i++) {
            for (int j = 0; j < inputNumber.length; j++) {
                if (i == j) {
                    System.out.print(" ");
                } else if (inputNumber[i] == inputNumber[j]) {
                    System.out.print("=");
                } else if(inputNumber[i] > inputNumber[j]) {
                    System.out.print(">");
                } else {
                    System.out.print("<");
                }
            }
            
            System.out.println();
        }
    }
}