import java.awt.*;

public class PezDispenserVF14_12 {
    // fields
    private Color color;
    private String name;
    private boolean isFemale;
    private int capacity; // max possible
    private int currentCount;
    private double weight;
    
    // methods

    // constructor
    public PezDispenserVF14_12(
                        Color c,
                        String n,
                        boolean f,
                        int capacity,
                        int currentCount,
                        double weight
                        
    ) {
        color = c;
        name = n;
        isFemale = f;
        this.capacity = capacity;
        this.currentCount = currentCount;
        this.weight = weight;
    }

    // returns the current number of pez 
    private int load(int n) {
        currentCount += n;
        return currentCount;
    }

    public boolean fill() {
        if (currentCount == 0) {
            load(capacity);
            return true;
        } else {
            return false;
        }
    }

    public void dispense() {
        currentCount--;
    }

    public static void main(String[] args) {
        PezDispenserVF14_12 p = 
            new PezDispenserVF14_12(Color.GREEN,
                                    "Woody",
                                    false,
                                    12,
                                    0,
                                    3
                                   );
        System.out.println(p.capacity);
        p.load(3);
        System.out.println(p.currentCount);
    }
}
