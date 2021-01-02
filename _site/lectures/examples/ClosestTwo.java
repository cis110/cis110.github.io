/**
 * input: 11 6 3 5
 * 
 * I want to find the two numbers that are closest to each
 * 
 * output 6 and 5
 */

public class ClosestTwo {
    //create our input array
    public static void main(String[] args) {
        int[] inputNumber = new int[args.length];
        
        //populate our input array
        for (int i = 0; i < args.length; i++) {
            inputNumber[i] = Integer.parseInt(args[i]);
        }
        
        int[] solution = {inputNumber[0], inputNumber[1]};
        int minDistance = Math.abs(inputNumber[0] - inputNumber[1]);
        
        for(int i = 0; i < inputNumber.length; i++) {
            for (int j = i + 1; j < inputNumber.length; j++) {
                if (minDistance > Math.abs(inputNumber[i] -
                                           inputNumber[j])) {
                    solution[0] = inputNumber[i];
                    solution[1] = inputNumber[j];
                    minDistance = Math.abs(inputNumber[i] -
                                           inputNumber[j]);
                }
            }
        }
        
        System.out.println("The closest numbers are " + solution[0] + "," +
                           solution[1]);
    }
}