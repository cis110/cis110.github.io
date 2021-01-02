/**
 * CIS 110
 * Author: Paul "Will" McBurney
 * Tests whether two strings are equal
 *
 * Excution: java StringTest [firstString] [secondString]
 */

public class StringTest {
    public static void main(String[] args) {
        String s1 = args[0];
        String s2 = args[1];
        System.out.println(s1.equals(s2));
    }
}
