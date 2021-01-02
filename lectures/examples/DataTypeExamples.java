public class DataTypeExamples{
    public static void main(String args[]){
        int x = 5;
        int y = 2;
        System.out.println("x + y = " + (x + y));
        System.out.println("x - y = " + (x - y));
        System.out.println("x * y = " + (x * y));
        System.out.println("x / y = " + (x / y));
        System.out.println("x % y = " + (x % y));
	
        double doubleX = 4.5;
        double doubleY = 3.2;
        System.out.println("-----doubles-------");
        System.out.println("x + y = " + (doubleX + doubleY));
        System.out.println("x - y = " + (doubleX - doubleY));
        System.out.println("x * y = " + (doubleX * doubleY));
        System.out.println("x / y = " + (doubleX / doubleY));
        System.out.println("x % y = " + (doubleX % doubleY));
	
        boolean alwaysTrue = (1==1);
        boolean alwaysFalse = (0>1);
        boolean alsoAlwaysTrue = true;
        boolean alsoAlwaysFalse = false;
        boolean xIsEven = ((x % 2)==0);
        boolean xIsOdd = ((x % 2)==1);
        System.out.println("The statement \"x is Even\" is " + xIsEven);
        System.out.println("The statement \"x is Odd\" is " + xIsOdd);
        System.out.println("True and True = " + (alwaysTrue && alwaysTrue));
        System.out.println("True and False = " + (alwaysTrue && alwaysFalse));
        System.out.println("False and False = " + (alwaysFalse && alwaysFalse));
        System.out.println("True or True = " + (alwaysTrue || alwaysTrue));
        System.out.println("True or False = " + (alwaysTrue || alwaysFalse));
        System.out.println("False or False = " + (alwaysFalse || alwaysFalse));
    }
}
