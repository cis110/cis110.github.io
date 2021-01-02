void setup() {
  size(400, 400);
  smooth();
  noLoop();
  //ellipseMode(CORNERS);
}

void draw() {
  int w = 2 * (int) sqrt(width/4 * width/4 + height/4 * height/4);
  noStroke();
  fill(255, 0, 0, 255);
  ellipse(width/4, height/4, w, w);
  fill(0, 255, 0, 127);
  ellipse(3 * width/4, 3 * height/4, w, w);
  fill(0, 0, 255, 127);
  ellipse(3 * width/4, height/4, w, w);
  fill(255, 255, 0, 127);
  ellipse(width/4, 3 * height/4, w, w);
}
