/**
 * PLEASE DON'T SUBMIT THIS FILE!
 */

// public class BouncingBallObjectDemo {
//     public static void main(String[] args) {
//         int n = Integer.parseInt(args[0]);
//         Ball[] balls = new Ball[n];
//         setup(balls);
//         while (true) { // time loop
//             PennDraw.clear(PennDraw.WHITE);
//             for (int i = 0; i < balls.length; i++) { // physics calculation loop
//                 // draw the ball
//                 balls[i].draw();

//                 // update position of the ball
//                 balls[i].move();
//             }
//             PennDraw.advance();
//         }
//     }

//     // instantiates a Ball for every slot in the array,
//     // turns on animation.
//     public static void setup(Ball[] balls) {
//         PennDraw.setCanvasSize(500, 500);
//         for (int i = 0; i < balls.length; i++) {
//             balls[i] = new Ball();
//         }
//         PennDraw.enableAnimation(30);
//     }
// }
