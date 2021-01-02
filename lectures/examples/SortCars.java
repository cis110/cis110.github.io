/**
 * Set of functions that sort an array of cars either by insertion sort
 * or by selection sort. Main is used for demonstration only, and randomly
 * generates an array of Cars of varyign speeds and then sorts that array using
 * the two different algorithms.
 * 
 * Finished version.
 */
public class SortCars {

    /* Swaps cars[i] and cars[j] */
    private static void swapIndices(int i, int j, Car[] cars) {
        Car temp = cars[i];
        cars[i] = cars[j];
        cars[j] = temp;
    }
    
    /* Sorts the cars by speed with Selection Sort */
    public static void sortCarsSelection(Car[] cars) {
        // iterate through each space in the to-be-sorted array
        for (int i = 0; i < cars.length - 1; i++) {
            // find the smallest unsorted value and swap it in
            int minIndex = i;
            for (int j = i + 1; j < cars.length; j++) {
                if (cars[j].getSpeed() < cars[minIndex].getSpeed()) {
                    minIndex = j;
                }
            }
            swapIndices(i, minIndex, cars);
        }
    }
    
    /* Sorts the cars by speed with Insertion Sort */
    public static void sortCarsInsertion(Car[] cars) {
        // iterate through each unsorted index
        for (int i = 1; i < cars.length; i++) {
            // find where it should go in the sorted portion
            for (int j = i; j > 0 && 
                 cars[j].getSpeed() < cars[j - 1].getSpeed(); j--) {
                    swapIndices(j, j - 1, cars);
            }
        }
    }
    
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
