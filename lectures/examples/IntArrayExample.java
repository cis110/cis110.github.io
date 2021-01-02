public class IntArrayExample{
    public static void main(String[] args){
        int[] myIntArray = new int[10];//creates an array of size 10
        for(int i=0; i<myIntArray.length; i++){
            myIntArray[i] = -1;
        }
        myIntArray[0] = 10;
        myIntArray[1] = 20;
        myIntArray[2] = 30;
        myIntArray[3] = 40;
        myIntArray[4] = 50;
        myIntArray[5] = 60;
        myIntArray[6] = 70;
        myIntArray[7] = 80;
        myIntArray[8] = 90;
        //myIntArray[9] = 100;
        for(int i=0; i<myIntArray.length; i++){
            System.out.println("Value at index " + i + " is " + myIntArray[i]);
        }
    }
}