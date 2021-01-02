/*
 * Roll a die of a specified number of sides
 */

public class RollADie{
    public static void main(String[] args) {
        int numSides;
        int numArgs = args.length;
        if (numArgs < 1)
        {            
            numSides = 6;
            numArgs++;
        } else {
            System.out.println(args[0]);
            numSides = Integer.parseInt(args[0]);
        }
        int rolled = ((int) (Math.random() * numSides)) + 1;
        //Math.random() gives random value [0,1)
        System.out.println("You rolled " + rolled);
    }
}
