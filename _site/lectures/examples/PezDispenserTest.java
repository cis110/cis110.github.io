public class PezDispenserTest {
    public static void main(String[] args) {
        PezDispenser pumpkin = new PezDispenser("Pumpkin", "Green", 12);
        PezDispenser donald = new PezDispenser("Donald Duck", "Blue", 12);
        
        pumpkin.load();
        pumpkin.dispense();
        
        donald.dispense();
        
        System.out.println(pumpkin.getCurrent() + " should be 11");
        System.out.println(donald.getCurrent() + " should be 0");
        
        donald = pumpkin;
        
        System.out.println(donald.getCurrent() + " should be 11");
        
        pumpkin.dispense();
        
        System.out.println(donald.getCurrent() + " should be 10");
        
    }
}