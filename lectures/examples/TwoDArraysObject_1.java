public class TwoDArrays {
    public static void main(String[] args) {
		/**
		 * Example of Object Orientation. Two file readers
		 * Reading the same file but acting independently of one another
		 */
        In instreamFile0 = new In("temp0.txt");
        In instreamFile1 = new In("temp0.txt");
        
        System.out.println(instreamFile0.readLine());
        System.out.println(instreamFile1.readLine());
        System.out.println(instreamFile0.readLine());
        System.out.println(instreamFile1.readLine());
        
		
		/**
		 * 2D Array that is 3 "rows" by 4 "columns"
		 */
        int[][] grid = new int[3][4];
        
        grid[0][0] = 5;
        grid[2][3] = 7;
        grid[1][2] = 4;
        
        print2DArray(grid);
        
        int[][] t = transpose(grid);
        
        System.out.println();
        print2DArray(t);
        
        /**
         * A non-rectangular 2D Array
		 */
		System.out.println();
		int[][]notAGrid = new int[3][];
        notAGrid[0] = new int[4];
        notAGrid[1] = new int[2];
        notAGrid[2] = new int[10];
        
        System.out.println();
        print2DArray(notAGrid); */
        
    }
    /**
	 * This function prints a 2D Array
	 */
    public static void print2DArray (int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
	
	/**
	 * The function below transposes a 2D Matrix (must be rectangular)
	 */
    /// 1 2 3
    /// 4 5 6
    /// convert
    /// 1 4
    /// 2 5
    /// 3 6
    
    public static int[][] transpose (int[][] arr) {
        if (arr == null) { //if the array is null, we can't transpose it
            return null;
        }
		
		//check if any row of the array is null        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                System.out.println("Row " + i + " is a null array");
                return null;
            }
        }
        
		//check if array is empty
        if (arr.length == 0) {
            return new int[0][0]; //return an empty matrix
        }
		
        //make sure all rows have the same length
        int targetLength = arr[0].length;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length != targetLength) {
                System.out.println("This is not a matrix");
                return null; //can't transpose a non-rectangular matrix
            }
        }
        
		//perform the actual transpose
        int[][] out = new int[targetLength][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                out[j][i] = arr[i][j];
            }
        }
        return out;
    }
}