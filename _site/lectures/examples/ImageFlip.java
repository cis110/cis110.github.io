public class ImageFlip {
    public static void main(String[] args) {
        //get input file        
        String inputFilename = args[0];
        
        //load image into a 2D array using ImageData.java
        int[][] img = ImageData.load(inputFilename);
        
        //to flip the image over, we are going to create a new 2D array
        //of the same size
        
        
        int height = img.length;
        int width = img[0].length;
        
        int[][] outputImg = new int[height][width];
        
        //approach using a nested for loop:
        /**
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                int outputRow = height - 1 - row;
                int outputColumn = width - 1 - column;
                outputImg[outputRow][outputColumn] = img[row][column];
            }
        }*/
        
        
        //approach using single for loop:
        for (int i = 0; i < width * height; i++) {
            int row = i / width;
            int column = i % width;
            int outputRow = height - 1 - row;
            int outputColumn = width - 1 - column;
            outputImg[outputRow][outputColumn] = img[row][column];
        }
        
        outputImg[0][0]= 255; //blue
        outputImg[0][1]= 256; //black
        outputImg[0][2]= 257;
        
        //Show the image
        ImageData.show(outputImg);
    }
}