import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Nov10 {
    public static void main(String[] args) {
        //create an array list adding the number 1 through 5 for it
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        System.out.println(sum(numbers));
        System.out.println(max(numbers));
        
        System.out.println(hexDigitToDecimal("0"));
        System.out.println(hexDigitToDecimal("A"));
        System.out.println(hexDigitToDecimal("F"));
        
        numbers.clear(); //empty the array list
        System.out.println(sum(numbers)); //sum is zero
        //System.out.println(max(numbers)); //this line would throw an exception
        
        Shape c = new Circle(0.5, 0.5, 0.33);
        Circle c2 = (Circle) c; //typecast a Shape to a Circle
        
        System.out.println(c2.equals("bird")); //returns fase since obviously a
                                               //circle is not the word "bird"
        c2.draw();
    }
    /**
     * Gets the sum of elements in an int arrya list
     */
    public static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int number : list) {
            sum += number;
        }
        return sum;
    }
    /**
     * Gets the max of elements in an int arrya list
     * Throws exception if list is empty
     */
    public static int max(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("ERROR: Cannot get the max from an empty list");
        }
        int max = list.get(0);
        for (int number : list) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
    
    
    /**
     * Convert a hex digit as a string to a number
     */
    public static int hexDigitToDecimal(String digit) {
        try {
            if (digit.length() != 1) { //this line could throw a NullPointerException
                throw new IllegalArgumentException("ERROR: input is not exactly 1 character in length.");
            }
            int number = Integer.parseInt(digit);//this line could throw a NumberFormatException
            return number;
        } catch (NumberFormatException e) {
            //this block of code runs if Integer.parseInt throws a NumberFormatException
            char ch = digit.charAt(0);
            if (ch < 'A' || ch > 'F') { //if illegal character
                throw new IllegalArgumentException("ERROR: invalid character digit");
            }
            return ch - 'A' + 10;
        } catch (NullPointerException e) {
            //this block of code runs if digit is a null string
            throw new IllegalArgumentException("ERROR: input was a null string");
        }
    }
}