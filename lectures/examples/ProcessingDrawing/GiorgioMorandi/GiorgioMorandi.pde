/**
Bryn Mawr College, Department of Computer Science
Inspired by Giorgio Morandi
*/

PImage original;

void setup() {
  size(700, 600);
  smooth();
  noLoop();
  
  original = loadImage("natura-morta.jpg");
}

void draw() {
  // Walls
  fill(178, 195,202);
  quad(0, 0, 130, 0, 130, 370, 0, 599);
  
  fill(168, 178, 176);
  quad(130, 0, 699, 0, 699, 360, 130, 360);
  
  fill(157, 176, 183);
  quad(130, 360, 699, 360, 699, 599, 0, 599);
  
  // the original painting
  image(original, 250, 50, 200, 158);
  strokeWeight(5);
  noFill();
  rect(250, 50, 200, 158);
  
  // The table
  strokeWeight(1);
  
    // back legs
  fill(129, 143, 144);
    rect(255, 330, 40, 130);
  rect(550, 330, 40, 130);
  
  fill(166, 190, 170);
  quad(250, 330, 600, 330, 550, 430, 200, 430);
  

  fill(129, 143, 144);
  rect(200, 430, 350, 20);
  quad(550, 430, 600, 330, 600, 350, 550, 450);
  
  // legs
  rect(210, 450, 40, 120);
  rect(500, 450, 40, 120);
  
  
    // pitcher (brown in the back)
  fill(96, 82, 69);
  beginShape();
  curveVertex(330, 350);
  curveVertex(330, 350);
  curveVertex(345, 235);
  curveVertex(310, 180);
  curveVertex(350, 200);
  curveVertex(380, 200);
  curveVertex(375, 220);
  curveVertex(405, 290);
  curveVertex(405, 350);
  curveVertex(330, 350);
  endShape(CLOSE);
  // bottle1
  fill(203, 210, 216);
  beginShape();
  curveVertex(320, 390);
  curveVertex(310, 355);
  curveVertex(320, 210);
  curveVertex(327, 211);
  curveVertex(324, 250); 
  curveVertex(340, 280);
  curveVertex(350, 355);
  curveVertex(320, 360);
  curveVertex(310, 355);
  endShape(CLOSE);
  
  // bottle2
  
  fill(212, 213, 216);
  beginShape();
  curveVertex(355, 355);
  curveVertex(355, 355);
  curveVertex(350, 230);
  curveVertex(360, 195);
  curveVertex(368, 195);
  curveVertex(368, 220);
  curveVertex(390, 290);
  curveVertex(390, 355);
  curveVertex(360, 360);
  curveVertex(360, 355);
  endShape(CLOSE);

  // brown bottle in the back #2
  fill(82, 72, 68);
  rect(460, 220, 15, 125);
  ellipse(468, 217, 25, 6);
  
  // wide bottle
  fill(157, 167, 114);
  beginShape();
  vertex(400, 350);
  vertex(400, 290);
  curveVertex(400, 290);
  curveVertex(432, 310);
  curveVertex(465, 292);
  curveVertex(465, 292);
  vertex(465, 350);
  curveVertex(465, 350);
  curveVertex(465, 350);
  curveVertex(445, 355);
  curveVertex(400, 350);
  curveVertex(400, 300);
  endShape(CLOSE);
  
  // top of green bottle
  fill(148, 158, 150);
  beginShape();
  vertex(400, 290);
  vertex(430, 240);
  vertex(430, 220);
  vertex(438, 221);
  vertex(438, 242);
  vertex(465, 292);
  curveVertex(465, 292);
  curveVertex(465, 292);
  curveVertex(432, 302);
  curveVertex(400, 290);
  curveVertex(400, 290);
  

  endShape(CLOSE);
  
  // bottle#4
  fill(221, 227, 227);
  //noStroke();
  rect(470, 300, 40, 50);
  ellipse(490, 300, 40, 30);
  ellipse(490, 280, 20, 20);
  noStroke();
  ellipse(490, 290, 13, 13);
  stroke(0);
  rect(484, 211, 12, 62);
  stroke(221, 227, 227);
  line(484, 273, 497, 273);
  //fill(0);
  ellipse(490.5, 310, 39, 29);
  stroke(0);
  ellipse(490, 210, 16, 8);
}

