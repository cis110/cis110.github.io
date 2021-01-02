/**
 * Immutable class modeling a menu item abstraction
 * 
 * Comparing (sorting) MenuItem objects:
 * - MenuItem objects are sorted by price ascending
 * - If two MenuItem items have the same price, then 
 * they are sorted by name ascending.
 * - Two MenuItem objects are equals if they have the same price 
 * and the same name
 * 
 *
 */
public class MenuItem{
    
    private String name;
    private double price;
    private boolean vegetarian;
    private boolean dessert;
    
    /**
     * @param name of the menu item
     * @param price of the menu item
     * @param vegetarian if the menu item is vegetarian
     * @param dessert if the menu item is a dessert
     */
    public MenuItem(String name, double price, boolean vegetarian, boolean dessert){
        if(price <= 0){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.price = price;
        this.vegetarian = vegetarian;
        this.dessert = dessert;     
    }
    
    /**
     * @return the name of the menu item
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * @return the price of the menu item
     */
    public double getPrice(){
        return this.price;
    }
    
    /**
     * @return true if the menu item is vegetarian
     */
    public boolean getVegetarian(){
        return this.vegetarian;
    }
    
    /**
     * @return true if the menu item is a dessert
     */
    public boolean getDessert(){
        return this.dessert;
    }
    
    /**
     * @return a string representation of a menu item
     */
    public String toString(){
        return "<"+ this.name + " | $" + this.price + " | v: " + this.vegetarian + " | d: " 
            + this.dessert +">";
    }
    
}
