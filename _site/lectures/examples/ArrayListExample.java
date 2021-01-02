import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
    public static void main(String[] args) {
        //creating your ArrayList
        ArrayList<String> words = new ArrayList<String>();
        //adding values
        words.add("cat");
        words.add("dog");
        words.add("bird");
        words.add("pig");
        
        //toString demonstration
        System.out.println(words);
        
        //accessing a specific value
        System.out.println(words.get(2));
        
        //iterating over indices
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }
        
        //another useful loop
        for (String word : words) {
            System.out.println(word);
        }
        
        //contains method
        System.out.println(words.contains("bird"));
        System.out.println(words.contains("steve"));
        System.out.println(words.indexOf("cat"));
        System.out.println(words.indexOf("steve"));
        
        //removing - two ways
        words.remove("bird"); //remove a specific element
        System.out.println(words);
        words.remove(0); //remove a specific index
        System.out.println(words);
        
        words.add("bird");
        words.add("cat");
        
        //sorting - more on this later
        Collections.sort(words);
        System.out.println(words);
    }
}