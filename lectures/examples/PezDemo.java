/**
 * Author: Paul "Will" McBurney
 * 
 * This file creates some PezDispensers and uses them.
 */

public class PezDemo {
    public static void main(String[] args) {
        //create a Yoshi Pez Dispenser
        PezDispenser yoshi = new PezDispenser("Yoshi", "White", 12);
        //create a Mickey Mouse Pez Dispenser
        PezDispenser mickey = new PezDispenser("Mickey Mouse", "Red", 12);
        //create a Halloween Pumpkin Pez Dispenser
        PezDispenser pumpkin = new PezDispenser("Jack\'o\'latern", "Green", 12);
        //print all 3 PezDispensers
        System.out.println(yoshi); //calls the class's toString() function
        System.out.println(mickey);
        System.out.println(pumpkin);

        
        //load yoshi
        System.out.println("\nLoading Yoshi");
        yoshi.load();
        //print yoshi to show it's loaded, but none of the others are
        System.out.println(yoshi);
        System.out.println(mickey);
        System.out.println(pumpkin);
        
        //load mickey
        System.out.println("\nLoading Mickey");
        mickey.load();
        //print yoshi to show it's loaded, but none of the others are
        System.out.println(yoshi);
        System.out.println(mickey);
        System.out.println(pumpkin);
        
        //dispense from yoshi
        System.out.println("\nDispensing from Yoshi");
        yoshi.dispense();
        //print yoshi to show it's loaded, but none of the others are
        System.out.println(yoshi);
        System.out.println(mickey);
        System.out.println(pumpkin);
        
        //dispense from pumpkin, which is empty
        System.out.println("\nDispensing from Pumpkin");
        pumpkin.dispense();
        //print yoshi to show it's loaded, but none of the others are
        System.out.println(yoshi);
        System.out.println(mickey);
        System.out.println(pumpkin);
    }
}