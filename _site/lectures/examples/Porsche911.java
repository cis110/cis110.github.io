public class Porsche911 {
    private String color;
    private String seatType;
    private int hp;
    private boolean autoTrans;
    private double fuel;
    
    private double posX, posY;
    
    public void drive(double x, double y) {
        double d2 = (x - posX) * (x - posX) +
            (y - posY) * (y - posY);
        double d  = Math.sqrt(d2);
        double gas = d * mpg();
        if (gas > fuel) {
            throw new RuntimeException("Not enough gas.");
        }
        posX = x;
        posY = y;
        fuel -= gas;
    }
    
    public float mpg() {
        if (autoTrans)
            return 5000.0f / hp;
        else
            return 10000.0f / hp;
    }
    
    public void refuel() {
        fuel = 8;
    }
    
    public Porsche911(String color, String seatType, 
                      int hp, boolean isManual) {
        this.color = color;
        this.seatType = seatType;
        this.hp = hp;
        
        autoTrans = !isManual;
        
        refuel();
    }


    public static void main(String[] args) {
        // create a Porsche
        Porsche911 porsche = new Porsche911("BROWN", "STOCK", 330, true);
    }
}