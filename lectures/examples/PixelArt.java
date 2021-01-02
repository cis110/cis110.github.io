
/**
 * Author: Harry Smith
 *
 * PennKey: sharry
 *
 * Description: Loads a file containing a binary representation of an image and
 * draws it to the screen using PennDraw.
 *
 * Usage: PixelArt <image_file> draws the image_file contents and lets you edit
 * it PixelArt <file1> <file2> ... <fileN> animates through file1 up to fileN
 * for a fun animation
 */
public class PixelArt {
    public static void main(String[] args) {
        if (args.length == 0) {
            animateFrames(args);
        } else if (args.length == 1) {
            showCanvas(args[0]);
        } else {
            animateFrames(args);
        }
    }

    public static void showCanvas(String filename) {
        PennDraw.enableAnimation(30);
        boolean running = true;
        int[][] img = readFile(filename);

        // this is not safe for jagged arrays, but we assume that this one isn't jagged.
        int numRows = img.length;
        int numCols = img[0].length;

        // the 0.5 buffers allow us to have a border on screen.
        // for a 2D array, row 0 is the top array, but for a PennDraw canvas, usually
        // y=0 is the bottom. The setYScale with the first argument > second flips the y
        // coordinates
        // so that 0 is the top and numRows is the bottom.
        PennDraw.setXscale(-0.5, numCols + 0.5);
        PennDraw.setYscale(numRows + 0.5, -0.5);
        while (running) {
            // this draws the background. I don't use PennDraw.clear() because of a bug in
            // the
            // PennDraw implementation.
            PennDraw.setPenColor(100, 100, 100);
            PennDraw.filledRectangle(numCols / 2.0, numRows / 2.0, numCols, numRows);

            draw(img);

            // optional animation steps.
            if (PennDraw.hasNextKeyTyped()) {
                char c = PennDraw.nextKeyTyped();

                // you can save the result by pressing s and printing the contents to the
                // console.
                if (c == 's') {
                    printImg(img);
                } else if (c == 'x') { // pressing x stops the interactivity.
                    running = false;
                } else { // pressing any other key flips the color of the square you're hovering over
                         // right now.
                    int xToFlip = (int) (PennDraw.mouseX());
                    int yToFlip = (int) (PennDraw.mouseY());

                    // out of bounds checking
                    if (xToFlip < 0 || xToFlip > numCols - 1 || yToFlip < 0 || yToFlip > numRows - 1) {
                        continue;
                    }

                    // -(x - 1) is a simple little formula to take x from 0 -> 1 and 1 -> 0.
                    // This would not be the only way to implement a flip.
                    img[yToFlip][xToFlip] = (img[yToFlip][xToFlip] - 1) * -1;
                }
            }
            PennDraw.advance();
        }
    }

    public static void printImg(int[][] img) {
        System.out.println(img.length + " " + img[0].length);
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                System.out.print(img[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] readFile(String filename) {
        In inStream = new In(filename);
        int numRows = inStream.readInt();
        int numCols = inStream.readInt();
        int[][] img = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                img[i][j] = inStream.readInt();
            }
        }
        return img;
    }

    public static void draw(int[][] img) {
        int numRows = img.length;
        int numCols = img[0].length;
        int cValue;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                cValue = 255 * img[i][j];
                PennDraw.setPenColor(cValue, cValue, cValue); // (0, 0, 0) is black and (255, 255, 255) is white

                /*
                 * j is the column index, which is the x position i is the row index, which is
                 * the y position 0.5 is the half-width of the square based on the coordinate
                 * system i defined j+0.5 then puts centers the square, e.g. filledSquare(0.5,
                 * 0.5, 0.5) fills in a square from 0 to 1 in the x and the y direction, which
                 * is fitting for the pixel at position (0, 0).
                 */
                PennDraw.filledSquare(j + 0.5, i + 0.5, 0.5);
            }
        }
    }

    public static void animateFrames(String[] filenames) {
        // oooh, a 3D array...
        int[][][] imgs = new int[filenames.length][][];

        for (int i = 0; i < filenames.length; i++) {
            imgs[i] = readFile(filenames[i]);
        }

        boolean running = true;
        int currentFrame = 0;
        PennDraw.enableAnimation(8);
        while (running) {
            int numRows = imgs[0].length;
            int numCols = imgs[0][0].length;
            PennDraw.setXscale(-0.5, numCols + 0.5);
            PennDraw.setYscale(numRows + 0.5, -0.5);

            PennDraw.setPenColor(100, 100, 100);
            PennDraw.filledRectangle(numCols / 2.0, numRows / 2.0, numCols, numRows);
            draw(imgs[currentFrame]);
            if (PennDraw.hasNextKeyTyped()) {
                PennDraw.nextKeyTyped();
                running = false;
            }
            currentFrame = (currentFrame + 1) % filenames.length;
            PennDraw.advance();
        }

    }
}