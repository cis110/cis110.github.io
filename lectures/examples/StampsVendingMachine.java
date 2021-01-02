/**
 * a program that simulates a vending machine 
 * that provides first class stamps
 */
public class StampsVendingMachine {
    public static void main(String[] args) {
        //read in dollar amount inserted
        int dollarAmount = Integer.parseInt(args[0]);
        //how many 49c stamps
        int firstClassStamps = dollarAmount * 100 / 49;
        //how much change(penny stamps)
        int change = dollarAmount * 100 % 49;
        //provide some output  to the user
        System.out.println("You get " + firstClassStamps + "FCS and " 
                               + change + "penny stamps");
    }
}