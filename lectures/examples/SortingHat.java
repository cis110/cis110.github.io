/*
 * Name: Gabee Ayres
 * Pennkey: ayresg
 * Recitation: Towne 313
 * 
 * Execution: java SortingHat name
 * 
 * Sorts the given name into one of the four Hogwarts houses.
 * 
 * Good test cases:
 *   empty string ("") - good test case in general, and length is even and < 8
 *   Sal - length is odd and < 8
 *   Mark - length is even and < 8
 *   Hannah - length is divisible by 6 but < 8
 *   Maureen - length is exactly 8
 *   Marcella - length is odd and > 8
 *   Mozzarella - length is even and > 8
 *   Rumplestiltskin - is Rumplestiltskin, length > 8
 *   rumplestiltskin - isn't Rumplestiltskin, length > 8
 * 
 */

public class SortingHat {

    public static void main(String[] args) {
        String name = args[0];
        int length = name.length();
        
        if (name.equals("Rumplestiltskin")) {
            System.out.println("Slytherin");
        } else if (name.length() > 8 || name.length() % 6 == 0) {
            System.out.println("Ravenclaw");
        } else if (name.length() < 8) {
            if (name.length() % 2 == 0) {
                System.out.println("Gryffindor");
            } else {
                System.out.println("Slytherin");
            }
        } else {
            System.out.println("Hufflepuff");
        }
    }
}
