/*************************************************************************
 *  Compilation:  javac HtreeProcessing.java
 *  Execution:    java HtreeProcessing N
 *
 *  Plot an order N Htree.
 *
 *  % java Htree 5
 *
 *************************************************************************/

import processing.core.*;

public class HtreeProcessing extends PApplet {
    static int recursionDepth;

    // plot an H, centered on (x, y) of the given side length
    public void drawH(float x, float y, float size) {

        // compute the coordinates of the 4 tips of the H
        float x0 = x - size/2;
        float x1 = x + size/2;
        float y0 = y - size/2;
        float y1 = y + size/2;

        // draw the 3 line segments of the H
        line(x0, y0, x0, y1);    // left  vertical segment of the H
        line(x1, y0, x1, y1);    // right vertical segment of the H
        line(x0,  y, x1,  y);    // connect the two vertical segments of the H
    }

    // plot an order n H-tree, centered on (x, y) of the given side length
    public void drawHtree(int n, float x, float y, float size) {
        if (n == 0) return;
        drawH(x, y, size);

        // compute x- and y-coordinates of the 4 half-size H-trees
        float x0 = x - size/2;
        float x1 = x + size/2;
        float y0 = y - size/2;
        float y1 = y + size/2;

        // recursively draw 4 half-size H-trees of order n-1
        drawHtree(n-1, x0, y0, size/2);    // lower left  H-tree
        drawHtree(n-1, x0, y1, size/2);    // upper left  H-tree
        drawHtree(n-1, x1, y0, size/2);    // lower right H-tree
        drawHtree(n-1, x1, y1, size/2);    // upper right H-tree
    }


    public void setup() {
        size(450, 450);

        // set the window coordinates to (0, 0) in the lower left
        // up to (1, 1) in the upper-right
        setCoordinates();

        float x = 0.5f, y = 0.5f;   // center of H-tree
        float size = 0.5f;         // side length of H-tree
        drawHtree(recursionDepth, x, y, size);
    }

    // read in a command-line argument N and plot an order N H-tree
    public static void main(String[] args) {
        recursionDepth = Integer.parseInt(args[0]);
        PApplet.main((new Throwable()).getStackTrace()[0].getClassName());
    }

    /** set the coordinate system so (0, 0) is near the bottom-left
     *  corner, and (1, 1) is near the top-rightf
     */
    void setCoordinates() {
        resetMatrix();

        // flip and scale the canvas
        scale(width, -height);
        translate(0, -1);
        translate(0.1f, 0.1f);
        scale(0.8f, 0.8f);

        // make the stroke with 1 pixel
        // (stroke width is affected by the scale)
        strokeWeight(1.0f / width);
    }
}
