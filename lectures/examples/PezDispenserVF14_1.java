import java.awt.*;
public class PezDispenserVF14_1 {
    // fields
    private double size;
    private String character;
    private Color color;

    private int maxPez;        // capacity
    private int currentCount;  // how many pez do I currently have
    private boolean isLemon;   // different flavours

    // methods
    public String getCharacter() {
        return Character;
    }
    
    public void dispense()  {
        currentCount--; 
    }

    public int load(boolean lemon, int n ) {
        if (n <= maxPez - currentCount)  {
            currentCount += n;
        }
        
        return currentCount; 
    }

    public PezDispenserVF14_1(double size,
                              String character,
                              Color color
    ) {
        this.size = size;
        this.character = character;
        this.color = color;
        currentCount = 0;
        isLemon = false;
        maxPez = 10;
    }

    public static void main(String[] args) {
        PezDispenserVF14_1 p = new PezDispenserVF14_1(37, "Buzz", Color.GREEN);
        p.load(true, 3);
        System.out.println(p.currentCount);
        System.out.println(p.character);
    }
}

