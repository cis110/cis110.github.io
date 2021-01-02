/**
 * ADT modeling the behavior of a Food menu object
 */
public interface FoodMenu
{
    /**
     * @param dish the menu item to remove to the menu
     * @return the number of menu items
     * (11/9)
     */
    public int addMenuItem(MenuItem dish);
    /**
     * @param dish the menu item to remove to the menu
     * @return the number of menu items
     * (11/11)
     */
    public int removeMenuItem(MenuItem dish);
    
    /**
     * @param dishName the name of the menu item to be removed
     * @return The menu item removed or null if there is 
     * no menu item with that name
     * (11/9)
     */
    public MenuItem findMenuItem(String dishName);
    
    /**
     * @return a new list of all vegetarian options on this 
     * food menu  or null
     * (11/11)
     * 
     */
    public FoodMenu vegetarianMenu();
    
    /**
     * @return a new list of all dessert options on this 
     * food menu  or null
     * (11/11)
     */
    public FoodMenu dessertMenu();
    
    /**
     * @param maxPrice
     * @return a new list of all menu items with price 
     * (11/11)
     */
    public FoodMenu valueMenu(double maxPrice);
    
    /**
     * @return a string representation of this food menu in the format
     * [<menu item><menu item> ...]
     * (11/9)
     */
    public String displayMenu(); 

}
