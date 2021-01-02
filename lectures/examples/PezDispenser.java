/**
 * Pez Dispenser
 * Authors: Paul "Will" McBurney, Benedict Brown
 * 
 * Description: This class models a PezDispenser
 * You can load and dispense candy with it.
 */

public class PezDispenser {
    public String character; //character name, such as "Mario"
    public String color; //color of sleeve
    public int count; //number of candies in the sleeve
    public int capacity; //max possible candies in the sleeve
    
    /**
     * Constructor - takes in a character name, sleeve color,
     * and maximum capacity and makes a Pez Dispenser instance.
     * 
     * Count is initially set to zero since when you open a 
     * Pez Dispenser the first time, it's empty.
     */
    public PezDispenser(String ch, String col, int cap) {
        character = ch;
        color = col;
        capacity = cap;
        count = 0;
    }
    
    /**
     * This method loads the Pez Dispenser to capacity
     */
    public void load() {
        count = capacity;
    }
    
    /**
     * This method dispenses a candy from the Pez Dispenser.
     * If a candy is dispensed, this returns true. Otherwise,
     * it returns false.
     */
    public boolean dispense() {
        if (count > 0) {
            count--;
            return true;
        } else {
            return false;
        }
    }
    
    public String toString() {
        String out = "Character: " + character + "\n";
        out += "\tColor: " + color + "\n";
        out += "\tHolding " + count + " of " + capacity;
        return out;
    }
}