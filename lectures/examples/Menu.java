
/**
 * Class implementing a food menu
 *
 */
public class Menu
    implements FoodMenu
{
    private Link head;
    private Link current;
    private int size;
    
    public Menu() {
        this.current = this.head = null;
        this.size = 0;
    }

    @Override
    public int addMenuItem(MenuItem dish)
    {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public int removeMenuItem(MenuItem dish)
    {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public MenuItem findMenuItem(String dishName)
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public FoodMenu vegetarianMenu()
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public FoodMenu dessertMenu()
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public FoodMenu valueMenu(double maxPrice)
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public String displayMenu()
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * internal Link node class
     *
     */
    public class Link {
        public MenuItem data;
        public Link next;

        /**
         * @param data the MenuItem object stored in this Link
         * @param next the follower of this Link
         */
        public Link(MenuItem data, Link next) {
            this.data = data;
            this.next = next;
        }
    }

}
