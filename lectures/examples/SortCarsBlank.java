/**
 * Set of functions that sort an array of cars either by insertion sort
 * or by selection sort. Main is used for demonstration only, and randomly
 * generates an array of Cars of varyign speeds and then sorts that array using
 * the two different algorithms.
 * 
 * Unfinished version for livecoding.
 */
public class SortCarsBlank {
    
    /* Swaps cars[i] and cars[j] */
    private static void swapIndices(int i, int j, Car[] cars) {}
    
    /* Sorts the cars by speed with Selection Sort */
    public static void sortCarsSelection(Car[] cars) {}
    
    /* Sorts the cars by speed with Insertion Sort */
    public static void sortCarsInsertion(Car[] cars) {}
    
    public static void main(String[] args) {
        // set up the parking lot :)
        int numCars = 10;
        Car[] carsInsertion = new Car[numCars];
        Car[] carsSelection = new Car[numCars];
        
        // fill the two arrays with identical cars with random speeds
        for (int i = 0; i < numCars; i++) {
            carsInsertion[i] = 
                new Car("Vehicle", "" + i, (int) (Math.random() * 100));
            carsSelection[i] = carsInsertion[i];
        }
        
        // print out our original array for testing
        System.out.println("Starting array:");
        for (int i = 0; i < numCars; i++) {
            System.out.println(carsInsertion[i]);
        }
        System.out.println();
        
        // Sort each array using selection / insertion sort
        sortCarsInsertion(carsInsertion);
        sortCarsSelection(carsSelection);
        
        // print out the array sorted by insertion
        System.out.println("Array sorted by insertion sort:");
        for (int i = 0; i < numCars; i++) {
            System.out.println(carsInsertion[i]);
        }
        System.out.println();
        
        // print out the array sorted by selection
        System.out.println("Array sorted by selection sort:");
        for (int i = 0; i < numCars; i++) {
            System.out.println(carsSelection[i]);
        }
        System.out.println();
    }
}
