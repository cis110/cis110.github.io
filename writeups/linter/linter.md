---
layout: default
title: CIS 110 Internal
active_tab: linter
---

# CIS 110 Linter

Download our linter [here](linter.py).

## Usage:

In a terminal window, run with `python3 linter.py fileone.java filetwo.java ...`, or just `python3 linter.py *.java`

## Output:

Script will overwrite existing java files with a formatted version of the file.

## What the cis 110 linter does:

- Corrects all indentation in a file using the standardized four spaces per indent level (not tabs).
- Removes excess spacing which detracts from readability.
- Appends a class header to the top of the file if it does not have one.

## What the cis 110 linter does not:

- Rename variables to camelCase
- Correct or point out other style errors that the style checker catches, including but not limited to:
	- spacing issues within lines, such as saying `i=i+2;` instead of `i = i + 2;` or not having a space between a `)` and a `{`

## Example:

Here is a sample file prior to linting:
```java
import java.awt.Color;

public class MySketch {

private static void setColor(int red, int green, int blue) {
PennDraw.setPenColor(red, green, blue);
}

private static void setColor(Color color) {
setColor(color.getRed(), color.getGreen(), color.getBlue());
}


    private static void drawBackground() {
            setColor(Color.PINK);
            PennDraw.filledSquare(0, 0, 1, 1);
    }

    private static void drawMrPotato() {


        setColor(Color.BLACK);
        PennDraw.setPenRadius(0.05);
        PennDraw.ellipse(0.5, 0.65, 0.3, 0.25);
        PennDraw.ellipse(0.5, 0.40, 0.35, 0.25);
        setColor(249, 212, 144);
        PennDraw.setPenRadius();
        PennDraw.filledEllipse(0.5, 0.65, 0.3, 0.25);
        PennDraw.filledEllipse(0.5, 0.40, 0.35, 0.25);
        


        drawMrPotatoFeature(0.01, 0.27, 0.2, 0.05, 0.07);
        drawMrPotatoFeature(0.01, 1 - 0.27, 0.2, 0.05, 0.07);
        


        drawMrPotatoFeature(0.01, 0.195, 0.55, 0.04, 0.03);
        drawMrPotatoFeature(0.01, 1 - 0.195, 0.55, 0.04, 0.03);
        


        setColor(Color.PINK);
        PennDraw.filledEllipse(0.37, 0.695, 0.04, 0.02);
        PennDraw.filledEllipse(1 - 0.37, 0.695, 0.04, 0.02);
        setColor(Color.BLACK);
        PennDraw.filledCircle(0.4, 0.72, 0.025);
        PennDraw.filledCircle(1 - 0.4, 0.72, 0.025);
        PennDraw.arc(0.5, 0.6, 0.1, 75, 105);
        


        PennDraw.setPenRadius(0.005);
        PennDraw.ellipse(0.28, 0.34, 0.008, 0.005);
        PennDraw.ellipse(1 - 0.28, 0.34, 0.008, 0.005);
        PennDraw.ellipse(0.32, 0.5, 0.01, 0.006);
        PennDraw.ellipse(1 - 0.32, 0.5, 0.01, 0.006);
        PennDraw.ellipse(0.32, 0.8, 0.01, 0.006);
        PennDraw.ellipse(1 - 0.32, 0.8, 0.01, 0.006);
    }

    private static void drawMrPotatoFeature(double outlineRadius, double xCenter, double yCenter, double halfWidth, double halfHeight) {
        
        
        PennDraw.setPenRadius();
        setColor(249, 212, 144);
        PennDraw.filledEllipse(xCenter, yCenter, halfWidth, halfHeight);
        setColor(Color.BLACK);
        PennDraw.setPenRadius(outlineRadius);
        PennDraw.ellipse(xCenter, yCenter, halfWidth, halfHeight);
    }
    
    // main method calls draw functions
    public static void main(String[] args) {
        drawBackground();
        drawMrPotato();
    }
}
```

Here is the file after linting:

```java
/**
 * Name: TODO
 * Pennkey: TODO
 * Execution: TODO
 *
 * Description: TODO
**/
import java.awt.Color;

public class MySketch {
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    private static void setColor(int red, int green, int blue) {
        PennDraw.setPenColor(red, green, blue);
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    private static void setColor(Color color) {
        setColor(color.getRed(), color.getGreen(), color.getBlue());
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    private static void drawBackground() {
        setColor(Color.PINK);
        PennDraw.filledSquare(0, 0, 1, 1);
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    private static void drawMrPotato() {
        setColor(Color.BLACK);
        PennDraw.setPenRadius(0.05);
        PennDraw.ellipse(0.5, 0.65, 0.3, 0.25);
        PennDraw.ellipse(0.5, 0.40, 0.35, 0.25);
        setColor(249, 212, 144);
        PennDraw.setPenRadius();
        PennDraw.filledEllipse(0.5, 0.65, 0.3, 0.25);
        PennDraw.filledEllipse(0.5, 0.40, 0.35, 0.25);
        
        drawMrPotatoFeature(0.01, 0.27, 0.2, 0.05, 0.07);
        drawMrPotatoFeature(0.01, 1 - 0.27, 0.2, 0.05, 0.07);
        
        drawMrPotatoFeature(0.01, 0.195, 0.55, 0.04, 0.03);
        drawMrPotatoFeature(0.01, 1 - 0.195, 0.55, 0.04, 0.03);
        
        setColor(Color.PINK);
        PennDraw.filledEllipse(0.37, 0.695, 0.04, 0.02);
        PennDraw.filledEllipse(1 - 0.37, 0.695, 0.04, 0.02);
        setColor(Color.BLACK);
        PennDraw.filledCircle(0.4, 0.72, 0.025);
        PennDraw.filledCircle(1 - 0.4, 0.72, 0.025);
        PennDraw.arc(0.5, 0.6, 0.1, 75, 105);
        
        PennDraw.setPenRadius(0.005);
        PennDraw.ellipse(0.28, 0.34, 0.008, 0.005);
        PennDraw.ellipse(1 - 0.28, 0.34, 0.008, 0.005);
        PennDraw.ellipse(0.32, 0.5, 0.01, 0.006);
        PennDraw.ellipse(1 - 0.32, 0.5, 0.01, 0.006);
        PennDraw.ellipse(0.32, 0.8, 0.01, 0.006);
        PennDraw.ellipse(1 - 0.32, 0.8, 0.01, 0.006);
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    private static void drawMrPotatoFeature(double outlineRadius, double xCenter, double yCenter, double halfWidth, double halfHeight) {
        PennDraw.setPenRadius();
        setColor(249, 212, 144);
        PennDraw.filledEllipse(xCenter, yCenter, halfWidth, halfHeight);
        setColor(Color.BLACK);
        PennDraw.setPenRadius(outlineRadius);
        PennDraw.ellipse(xCenter, yCenter, halfWidth, halfHeight);
    }
    
    // main method calls draw functions
    public static void main(String[] args) {
        drawBackground();
        drawMrPotato();
    }
}

```