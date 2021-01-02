/**
 * Name : PennKey :
 *
 * Execution: java ArgsCalculator [number] [number] ... [number]
 *
 * $ java ArgsCalculator 1 2 3 5 Sum: 11 Average: 2.75
 * 
 *
 * This program takes in a list of numbers as command line arguments and
 * calculates the sum and the average of these numbers.
 */

public class ArgsCalculator {
  public static void main(String[] args) {

    // args and our new array will have the same length
    int inputLength = args.length;

    // Parsing the contents of args as doubles for our new array
    double[] inputs = new double[inputLength];
    for (int i = 0; i < inputLength; i++) {
      inputs[i] = Double.parseDouble(args[i]);
    }

    // The sum of no numbers is 0, so we start our sum here
    double sum = 0.0;

    // For every number we see, add it to our running sum of numbers we get.
    for (int i = 0; i < inputLength; i++) {
      sum += inputs[i];
    }

    // The average is defined as the sum of all numbers divided by total count
    double mean = sum / inputLength;

    // Print out our results.
    System.out.println("Sum: " + sum + " Average: " + mean);
  }
}