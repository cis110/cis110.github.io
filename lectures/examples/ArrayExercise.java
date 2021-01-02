/**
 *  Author: Paul "Will" McBurney
 *
 *  Description: This file gives a basic introduction to some array functionalities
 *  such as creation, iterating through, printing, and increasing the size of an arry
 *
 *  Execution: java ArrayExercise 5 1 3 4 6 (as many integer numbers as you want)
 *
 *  This program will load those numbers into an array and print that array at the end
 *  To illustrate increasing the size of the array, the number 7 will be added to the end
 *  of the array befor printing.
 */

public class ArrayExercise {
  
  public static void main(String[] args) {
    
    int[] a = new int[args.length];
    // convert args to int array
    for (int i = 0; i < args.length; i++) {
      a[i] = Integer.parseInt(args[i]);
    }
    
    printArray(a);
    
    // initialize temp array to one entry larger than a
    int[] temp = new int[a.length + 1];
    
    // copy values from a into temp
    for (int i = 0; i < a.length; i++) {
        temp[i] = a[i];
    }
    
    // put 7 into last entry of temp array
    temp[temp.length - 1] = 7;
    
    // update the value of a
    a = temp;

    //print a
    for (int i = 0; i < a.length; i++) {
        if (i == a.length - 1) {
           System.out.println(a[i]);
        } else {
           System.out.print(a[i] + ", ");
        }
    }
  }
}






