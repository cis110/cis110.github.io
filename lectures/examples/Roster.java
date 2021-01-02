/**
 * Recitation July 27: Roster class describes a roster of Person objects, with
 * maximum size "capacity."
 */
public class Roster {
    private Person[] roster;
    private int currentSize;
    
    public Roster(int capacity) {
        roster = new Person[capacity];
        currentSize = 0;
    }
    
    /**
     * Checks to see if roster is full.
     * If full, return true. Return false otherwise.
     */
    public boolean isFull() {
        return (currentSize - 1) == roster.length;
    }
    
    /**
     * Checks to see if roster is empty.
     * If empty,return true. Return false otherwise.
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    /**
     * Returns current size (number of Person) of roster.
     */
    public int currentSize() {
        return currentSize;
    }
    
    /**
     * Get person at index in Roster.
     */
    public Person getPerson(int index) {
        if (index >= currentSize) {
            throw new RuntimeException("ERROR: Attempting to get Person at " + 
                                       "impossible index.");
        }
        return roster[index];
    }
    /**
     * Takes in a Person objet and adds it to the end of the roster, if the
     * roster is not already full.
     */
    public void add(Person p) {
        // only add a person if roster is not full
        if (!isFull()) {
            roster[currentSize] = p;
            // update currentSize
            currentSize++;
        }
    }
    
    /**
     * Remove element at the end of the list.
     */
    public void remove() {
        if (currentSize > 0) {
            roster[currentSize - 1] = null;
            currentSize--;
        }
    }
    
    /**
     * Sort by last name using mergesort algorithm.
     * Note that "roster" is not necessarily full.
     * We make use of the fact that the Person class alredy has a sort method.
     */
    public static void sort(Roster roster) {
        // copy Roster contents into appropriately sized array
        Person[] arr = new Person[roster.currentSize()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = roster.getPerson(i);
        }
        // vacate roster completely
        while (!roster.isEmpty()) {
            roster.remove();
        }
        Person.sort(arr);
        // occupy roster with sorted array content
        for (int i = 0; i < arr.length; i++) {
            roster.add(arr[i]);
        }
    }
    
    /**
     * Prints roster. Used for testing.
     */
    private static void printRoster(Roster r) {
        for (int i = 0; i < r.currentSize(); i++) {
            Person p = r.getPerson(i);
            System.out.println(p.getLastName() + ", " + p.getFirstName() + ": " + p.getAge());
        }
    }
    
    public static void main(String[] args) {
        Roster roster = new Roster(9);
        System.out.println("current size expected 0, actual " + roster.currentSize());
        roster.add(new Person("Samuel", "Clemens", 74));
        roster.add(new Person("Ernest", "Hemingway", 61));
        roster.add(new Person("Emily", "Bronte", 30));
        roster.add(new Person("Identical", "Name", 52));
        roster.add(new Person("Virginia", "Woolf", 59));
        roster.add(new Person("Jane", "Austen", 41));
        roster.add(new Person("Identical", "Name", 27));
        roster.add(new Person("Francis", "Fitzgerald", 44));
        roster.add(new Person("Charlotte", "Bronte", 38));
        System.out.println("current size expected 9, actual " + roster.currentSize());
        
        System.out.println("Roster printed in order added:");
        printRoster(roster);
        
        System.out.println('\n' + "Roster organized by last name:");
        sort(roster);
        printRoster(roster);
    }
}