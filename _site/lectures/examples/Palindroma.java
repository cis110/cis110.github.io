/* EXTRA
 * This example is only if you are curious
 * ReverseSentence already contains a function
 * How do you use it in a different class?
 * This shows you how.
 * For this to work, ReverseSentence would have to be in same folder
 */
public class Palindroma {
    public static void main(String[] args) {
        //compare the single argument to the reverse of that
        System.out.println(args[0].equals(ReverseSentence.reverse(args[0])));
    }
}