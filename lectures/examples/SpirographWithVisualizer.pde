/**
Bryn Mawr College, Department of Computer Science <br>
Click to randomly choose a new color, inner circle size and innser offset. <br>
History plus mathematical basis of Spirograph: http://en.wikipedia.org/wiki/Spirograph <br>
This runs really slowly in Javascript because it uses pixel manipulation. Try the java version instead.
*/

float smallerRadius;        // radius of the circle rotating inside of the larger one
float largerRadius;         // radius of the other circle
float innerOffset = 100;    // offset of the pen from center of the smaller circle
float outerAngle = 0;       // current angle of rotation about the center of the larger cirlce
float dOuterAngle = .01;    // stepsize of the angle of the outer circle
float innerAngle = 0;       // current angle of rotation about the center of the smaller circle
color penColor = color(255, 0, 0);  // color of the pentip

int iterCount = 0;          // the number of times we have gone through the draw loop
PImage savedDrawingWindow;  // used to save the contens of the drawing window so they can be restored at the next iteration
boolean changedPen = false;


void setup() {
  size(500, 500);

  // create the saved drawing window with the same dimensions as the processing window
  savedDrawingWindow = createImage(width, height, ARGB);

  smooth();
  background(255);
  //set to some initial values (these will be randomized whenever we click the mouse
  largerRadius = width/2.0;
  smallerRadius = width*7.0/25.0;

  frameRate(1000);  // go super fast!
}

void mouseClicked() {
  // choose a new random pen color, inner circle size, and inner offset
  penColor = color(random(0, 255), random(0, 255), random(0, 255));
  smallerRadius = random(0, largerRadius);
  innerOffset = random(0, smallerRadius);
  // record that a new pen (plus smaller circle and offset) has been recorded
  changedPen = true;
}

void draw() {
  // restore the saved drawing window
  image(savedDrawingWindow, 0, 0);

  // draw the outer circle
  noFill();
  stroke(0);
  strokeWeight(5);
  ellipse(width/2.0, height/2.0, largerRadius*2, largerRadius*2);

  /* Control where to start the loop for drawing the spirograph.
   * If we haven't changed the pen, then there is no need to regenerate all previously drawn points since they are already on the screen.*/
  int startAt;
  if (changedPen) {
     startAt = 0; 
  } else {
     startAt = iterCount; 
  }

  for (int i = startAt; i <= iterCount; i++) {
    pushMatrix();
    // advance the outer angle by the stepsize
    outerAngle = i*dOuterAngle;
    // set the inner angle using the following formula (derived from the geometry of the spirograph)
    innerAngle = -outerAngle * largerRadius/smallerRadius;

    // move coordinate system to be relative to the center of the larger circle
    translate(width/2.0, height/2.0);

    // rotate about the center of the outer circle
    rotate(outerAngle);

    // move the center of the coordinate system to the smaller circle
    translate(largerRadius-smallerRadius, 0);
    // rotate about the center of the smaller circle
    rotate(innerAngle);

    // apply the pen color to the appropriate point
    fill(penColor);
    stroke(penColor);
    strokeWeight(3);
    point(innerOffset, 0);

    // if we are on the last iteration save the window state and draw the visualization (inner circle plus pen tip)
    if (i == iterCount) {
      // save the pixels on the screen currently so we can restore at the next iteration
      loadPixels();
      savedDrawingWindow.loadPixels();
      // assign all of the pixels currently in the draw window into the image savedDrawingWindow so it can be restored later
      for (int k = 0; k < savedDrawingWindow.pixels.length; k++) {
        savedDrawingWindow.pixels[k] = color(red(pixels[k]), green(pixels[k]), blue(pixels[k]));
      }
      savedDrawingWindow.updatePixels();

      // draw the smaller circle
      noFill();
      for (int j = 0; j < 10; j++) {
        if (j % 2 == 0) {
          stroke(0);
        } 
        else {
          stroke(192);
        }
        arc(0, 0, 2*smallerRadius, 2*smallerRadius, j*2.0*PI/10.0, (j+1)*2*PI/10.0);
      }

      // draw the hole where the pen current is
      stroke(0);
      ellipse(innerOffset, 0, 6, 6);
    }
    popMatrix();
  }

  // advance one iteration
  iterCount++;
  
  // make the pen as not having changed
  changedPen = false;
}

