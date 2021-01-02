PImage img;

void setup() {
  size(500, 400);
  img = loadImage("MarioJumping.jpg");
}

void draw() {
  background(255);
  image(img, width/4, height/4);
}
