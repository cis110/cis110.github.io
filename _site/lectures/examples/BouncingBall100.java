/*********************************************
 * Bouncing Ball
 * Author:  Eric Eaton, Benedict Brown
 * 
 * Description:
 * Simulates a ball bouncing off the walls
 * and floor with acceleration due to gravity
 * 
 * Compilation:  javac BouncingBall.java
 * Execution:    java BouncingBall
 * 
 * Program Arguments:  none
 * 
 *********************************************/

public class BouncingBall100 {
    public static void main(String[] args) {
        // setup the window
        PennDraw.setXscale(0, 100);
        PennDraw.setYscale(0, 100);
      
        // set up the balls' initial parameters
        double x0 = 100 * Math.random();          // random x from 0 to 100
        double x1 = 100 * Math.random();          // random x from 0 to 100
        double x2 = 100 * Math.random();          // random x from 0 to 100
        double x3 = 100 * Math.random();          // random x from 0 to 100
        double x4 = 100 * Math.random();          // random x from 0 to 100
        double x5 = 100 * Math.random();          // random x from 0 to 100
        double x6 = 100 * Math.random();          // random x from 0 to 100
        double x7 = 100 * Math.random();          // random x from 0 to 100
        double x8 = 100 * Math.random();          // random x from 0 to 100
        double x9 = 100 * Math.random();          // random x from 0 to 100
        double x10 = 100 * Math.random();          // random x from 0 to 100
        double x11 = 100 * Math.random();          // random x from 0 to 100
        double x12 = 100 * Math.random();          // random x from 0 to 100
        double x13 = 100 * Math.random();          // random x from 0 to 100
        double x14 = 100 * Math.random();          // random x from 0 to 100
        double x15 = 100 * Math.random();          // random x from 0 to 100
        double x16 = 100 * Math.random();          // random x from 0 to 100
        double x17 = 100 * Math.random();          // random x from 0 to 100
        double x18 = 100 * Math.random();          // random x from 0 to 100
        double x19 = 100 * Math.random();          // random x from 0 to 100
        double x20 = 100 * Math.random();          // random x from 0 to 100
        double x21 = 100 * Math.random();          // random x from 0 to 100
        double x22 = 100 * Math.random();          // random x from 0 to 100
        double x23 = 100 * Math.random();          // random x from 0 to 100
        double x24 = 100 * Math.random();          // random x from 0 to 100
        double x25 = 100 * Math.random();          // random x from 0 to 100
        double x26 = 100 * Math.random();          // random x from 0 to 100
        double x27 = 100 * Math.random();          // random x from 0 to 100
        double x28 = 100 * Math.random();          // random x from 0 to 100
        double x29 = 100 * Math.random();          // random x from 0 to 100
        double x30 = 100 * Math.random();          // random x from 0 to 100
        double x31 = 100 * Math.random();          // random x from 0 to 100
        double x32 = 100 * Math.random();          // random x from 0 to 100
        double x33 = 100 * Math.random();          // random x from 0 to 100
        double x34 = 100 * Math.random();          // random x from 0 to 100
        double x35 = 100 * Math.random();          // random x from 0 to 100
        double x36 = 100 * Math.random();          // random x from 0 to 100
        double x37 = 100 * Math.random();          // random x from 0 to 100
        double x38 = 100 * Math.random();          // random x from 0 to 100
        double x39 = 100 * Math.random();          // random x from 0 to 100
        double x40 = 100 * Math.random();          // random x from 0 to 100
        double x41 = 100 * Math.random();          // random x from 0 to 100
        double x42 = 100 * Math.random();          // random x from 0 to 100
        double x43 = 100 * Math.random();          // random x from 0 to 100
        double x44 = 100 * Math.random();          // random x from 0 to 100
        double x45 = 100 * Math.random();          // random x from 0 to 100
        double x46 = 100 * Math.random();          // random x from 0 to 100
        double x47 = 100 * Math.random();          // random x from 0 to 100
        double x48 = 100 * Math.random();          // random x from 0 to 100
        double x49 = 100 * Math.random();          // random x from 0 to 100
        double x50 = 100 * Math.random();          // random x from 0 to 100
        double x51 = 100 * Math.random();          // random x from 0 to 100
        double x52 = 100 * Math.random();          // random x from 0 to 100
        double x53 = 100 * Math.random();          // random x from 0 to 100
        double x54 = 100 * Math.random();          // random x from 0 to 100
        double x55 = 100 * Math.random();          // random x from 0 to 100
        double x56 = 100 * Math.random();          // random x from 0 to 100
        double x57 = 100 * Math.random();          // random x from 0 to 100
        double x58 = 100 * Math.random();          // random x from 0 to 100
        double x59 = 100 * Math.random();          // random x from 0 to 100
        double x60 = 100 * Math.random();          // random x from 0 to 100
        double x61 = 100 * Math.random();          // random x from 0 to 100
        double x62 = 100 * Math.random();          // random x from 0 to 100
        double x63 = 100 * Math.random();          // random x from 0 to 100
        double x64 = 100 * Math.random();          // random x from 0 to 100
        double x65 = 100 * Math.random();          // random x from 0 to 100
        double x66 = 100 * Math.random();          // random x from 0 to 100
        double x67 = 100 * Math.random();          // random x from 0 to 100
        double x68 = 100 * Math.random();          // random x from 0 to 100
        double x69 = 100 * Math.random();          // random x from 0 to 100
        double x70 = 100 * Math.random();          // random x from 0 to 100
        double x71 = 100 * Math.random();          // random x from 0 to 100
        double x72 = 100 * Math.random();          // random x from 0 to 100
        double x73 = 100 * Math.random();          // random x from 0 to 100
        double x74 = 100 * Math.random();          // random x from 0 to 100
        double x75 = 100 * Math.random();          // random x from 0 to 100
        double x76 = 100 * Math.random();          // random x from 0 to 100
        double x77 = 100 * Math.random();          // random x from 0 to 100
        double x78 = 100 * Math.random();          // random x from 0 to 100
        double x79 = 100 * Math.random();          // random x from 0 to 100
        double x80 = 100 * Math.random();          // random x from 0 to 100
        double x81 = 100 * Math.random();          // random x from 0 to 100
        double x82 = 100 * Math.random();          // random x from 0 to 100
        double x83 = 100 * Math.random();          // random x from 0 to 100
        double x84 = 100 * Math.random();          // random x from 0 to 100
        double x85 = 100 * Math.random();          // random x from 0 to 100
        double x86 = 100 * Math.random();          // random x from 0 to 100
        double x87 = 100 * Math.random();          // random x from 0 to 100
        double x88 = 100 * Math.random();          // random x from 0 to 100
        double x89 = 100 * Math.random();          // random x from 0 to 100
        double x90 = 100 * Math.random();          // random x from 0 to 100
        double x91 = 100 * Math.random();          // random x from 0 to 100
        double x92 = 100 * Math.random();          // random x from 0 to 100
        double x93 = 100 * Math.random();          // random x from 0 to 100
        double x94 = 100 * Math.random();          // random x from 0 to 100
        double x95 = 100 * Math.random();          // random x from 0 to 100
        double x96 = 100 * Math.random();          // random x from 0 to 100
        double x97 = 100 * Math.random();          // random x from 0 to 100
        double x98 = 100 * Math.random();          // random x from 0 to 100
        double x99 = 100 * Math.random();          // random x from 0 to 100
        double y0 = 50 + 50 * Math.random();      // y from 50 to 100
        double y1 = 50 + 50 * Math.random();      // y from 50 to 100
        double y2 = 50 + 50 * Math.random();      // y from 50 to 100
        double y3 = 50 + 50 * Math.random();      // y from 50 to 100
        double y4 = 50 + 50 * Math.random();      // y from 50 to 100
        double y5 = 50 + 50 * Math.random();      // y from 50 to 100
        double y6 = 50 + 50 * Math.random();      // y from 50 to 100
        double y7 = 50 + 50 * Math.random();      // y from 50 to 100
        double y8 = 50 + 50 * Math.random();      // y from 50 to 100
        double y9 = 50 + 50 * Math.random();      // y from 50 to 100
        double y10 = 50 + 50 * Math.random();      // y from 50 to 100
        double y11 = 50 + 50 * Math.random();      // y from 50 to 100
        double y12 = 50 + 50 * Math.random();      // y from 50 to 100
        double y13 = 50 + 50 * Math.random();      // y from 50 to 100
        double y14 = 50 + 50 * Math.random();      // y from 50 to 100
        double y15 = 50 + 50 * Math.random();      // y from 50 to 100
        double y16 = 50 + 50 * Math.random();      // y from 50 to 100
        double y17 = 50 + 50 * Math.random();      // y from 50 to 100
        double y18 = 50 + 50 * Math.random();      // y from 50 to 100
        double y19 = 50 + 50 * Math.random();      // y from 50 to 100
        double y20 = 50 + 50 * Math.random();      // y from 50 to 100
        double y21 = 50 + 50 * Math.random();      // y from 50 to 100
        double y22 = 50 + 50 * Math.random();      // y from 50 to 100
        double y23 = 50 + 50 * Math.random();      // y from 50 to 100
        double y24 = 50 + 50 * Math.random();      // y from 50 to 100
        double y25 = 50 + 50 * Math.random();      // y from 50 to 100
        double y26 = 50 + 50 * Math.random();      // y from 50 to 100
        double y27 = 50 + 50 * Math.random();      // y from 50 to 100
        double y28 = 50 + 50 * Math.random();      // y from 50 to 100
        double y29 = 50 + 50 * Math.random();      // y from 50 to 100
        double y30 = 50 + 50 * Math.random();      // y from 50 to 100
        double y31 = 50 + 50 * Math.random();      // y from 50 to 100
        double y32 = 50 + 50 * Math.random();      // y from 50 to 100
        double y33 = 50 + 50 * Math.random();      // y from 50 to 100
        double y34 = 50 + 50 * Math.random();      // y from 50 to 100
        double y35 = 50 + 50 * Math.random();      // y from 50 to 100
        double y36 = 50 + 50 * Math.random();      // y from 50 to 100
        double y37 = 50 + 50 * Math.random();      // y from 50 to 100
        double y38 = 50 + 50 * Math.random();      // y from 50 to 100
        double y39 = 50 + 50 * Math.random();      // y from 50 to 100
        double y40 = 50 + 50 * Math.random();      // y from 50 to 100
        double y41 = 50 + 50 * Math.random();      // y from 50 to 100
        double y42 = 50 + 50 * Math.random();      // y from 50 to 100
        double y43 = 50 + 50 * Math.random();      // y from 50 to 100
        double y44 = 50 + 50 * Math.random();      // y from 50 to 100
        double y45 = 50 + 50 * Math.random();      // y from 50 to 100
        double y46 = 50 + 50 * Math.random();      // y from 50 to 100
        double y47 = 50 + 50 * Math.random();      // y from 50 to 100
        double y48 = 50 + 50 * Math.random();      // y from 50 to 100
        double y49 = 50 + 50 * Math.random();      // y from 50 to 100
        double y50 = 50 + 50 * Math.random();      // y from 50 to 100
        double y51 = 50 + 50 * Math.random();      // y from 50 to 100
        double y52 = 50 + 50 * Math.random();      // y from 50 to 100
        double y53 = 50 + 50 * Math.random();      // y from 50 to 100
        double y54 = 50 + 50 * Math.random();      // y from 50 to 100
        double y55 = 50 + 50 * Math.random();      // y from 50 to 100
        double y56 = 50 + 50 * Math.random();      // y from 50 to 100
        double y57 = 50 + 50 * Math.random();      // y from 50 to 100
        double y58 = 50 + 50 * Math.random();      // y from 50 to 100
        double y59 = 50 + 50 * Math.random();      // y from 50 to 100
        double y60 = 50 + 50 * Math.random();      // y from 50 to 100
        double y61 = 50 + 50 * Math.random();      // y from 50 to 100
        double y62 = 50 + 50 * Math.random();      // y from 50 to 100
        double y63 = 50 + 50 * Math.random();      // y from 50 to 100
        double y64 = 50 + 50 * Math.random();      // y from 50 to 100
        double y65 = 50 + 50 * Math.random();      // y from 50 to 100
        double y66 = 50 + 50 * Math.random();      // y from 50 to 100
        double y67 = 50 + 50 * Math.random();      // y from 50 to 100
        double y68 = 50 + 50 * Math.random();      // y from 50 to 100
        double y69 = 50 + 50 * Math.random();      // y from 50 to 100
        double y70 = 50 + 50 * Math.random();      // y from 50 to 100
        double y71 = 50 + 50 * Math.random();      // y from 50 to 100
        double y72 = 50 + 50 * Math.random();      // y from 50 to 100
        double y73 = 50 + 50 * Math.random();      // y from 50 to 100
        double y74 = 50 + 50 * Math.random();      // y from 50 to 100
        double y75 = 50 + 50 * Math.random();      // y from 50 to 100
        double y76 = 50 + 50 * Math.random();      // y from 50 to 100
        double y77 = 50 + 50 * Math.random();      // y from 50 to 100
        double y78 = 50 + 50 * Math.random();      // y from 50 to 100
        double y79 = 50 + 50 * Math.random();      // y from 50 to 100
        double y80 = 50 + 50 * Math.random();      // y from 50 to 100
        double y81 = 50 + 50 * Math.random();      // y from 50 to 100
        double y82 = 50 + 50 * Math.random();      // y from 50 to 100
        double y83 = 50 + 50 * Math.random();      // y from 50 to 100
        double y84 = 50 + 50 * Math.random();      // y from 50 to 100
        double y85 = 50 + 50 * Math.random();      // y from 50 to 100
        double y86 = 50 + 50 * Math.random();      // y from 50 to 100
        double y87 = 50 + 50 * Math.random();      // y from 50 to 100
        double y88 = 50 + 50 * Math.random();      // y from 50 to 100
        double y89 = 50 + 50 * Math.random();      // y from 50 to 100
        double y90 = 50 + 50 * Math.random();      // y from 50 to 100
        double y91 = 50 + 50 * Math.random();      // y from 50 to 100
        double y92 = 50 + 50 * Math.random();      // y from 50 to 100
        double y93 = 50 + 50 * Math.random();      // y from 50 to 100
        double y94 = 50 + 50 * Math.random();      // y from 50 to 100
        double y95 = 50 + 50 * Math.random();      // y from 50 to 100
        double y96 = 50 + 50 * Math.random();      // y from 50 to 100
        double y97 = 50 + 50 * Math.random();      // y from 50 to 100
        double y98 = 50 + 50 * Math.random();      // y from 50 to 100
        double y99 = 50 + 50 * Math.random();      // y from 50 to 100
        double ballRadius = 2;
        double dx0 = Math.random();               // dx from 0 and 1
        double dx1 = Math.random();               // dx from 0 and 1
        double dx2 = Math.random();               // dx from 0 and 1
        double dx3 = Math.random();               // dx from 0 and 1
        double dx4 = Math.random();               // dx from 0 and 1
        double dx5 = Math.random();               // dx from 0 and 1
        double dx6 = Math.random();               // dx from 0 and 1
        double dx7 = Math.random();               // dx from 0 and 1
        double dx8 = Math.random();               // dx from 0 and 1
        double dx9 = Math.random();               // dx from 0 and 1
        double dx10 = Math.random();               // dx from 0 and 1
        double dx11 = Math.random();               // dx from 0 and 1
        double dx12 = Math.random();               // dx from 0 and 1
        double dx13 = Math.random();               // dx from 0 and 1
        double dx14 = Math.random();               // dx from 0 and 1
        double dx15 = Math.random();               // dx from 0 and 1
        double dx16 = Math.random();               // dx from 0 and 1
        double dx17 = Math.random();               // dx from 0 and 1
        double dx18 = Math.random();               // dx from 0 and 1
        double dx19 = Math.random();               // dx from 0 and 1
        double dx20 = Math.random();               // dx from 0 and 1
        double dx21 = Math.random();               // dx from 0 and 1
        double dx22 = Math.random();               // dx from 0 and 1
        double dx23 = Math.random();               // dx from 0 and 1
        double dx24 = Math.random();               // dx from 0 and 1
        double dx25 = Math.random();               // dx from 0 and 1
        double dx26 = Math.random();               // dx from 0 and 1
        double dx27 = Math.random();               // dx from 0 and 1
        double dx28 = Math.random();               // dx from 0 and 1
        double dx29 = Math.random();               // dx from 0 and 1
        double dx30 = Math.random();               // dx from 0 and 1
        double dx31 = Math.random();               // dx from 0 and 1
        double dx32 = Math.random();               // dx from 0 and 1
        double dx33 = Math.random();               // dx from 0 and 1
        double dx34 = Math.random();               // dx from 0 and 1
        double dx35 = Math.random();               // dx from 0 and 1
        double dx36 = Math.random();               // dx from 0 and 1
        double dx37 = Math.random();               // dx from 0 and 1
        double dx38 = Math.random();               // dx from 0 and 1
        double dx39 = Math.random();               // dx from 0 and 1
        double dx40 = Math.random();               // dx from 0 and 1
        double dx41 = Math.random();               // dx from 0 and 1
        double dx42 = Math.random();               // dx from 0 and 1
        double dx43 = Math.random();               // dx from 0 and 1
        double dx44 = Math.random();               // dx from 0 and 1
        double dx45 = Math.random();               // dx from 0 and 1
        double dx46 = Math.random();               // dx from 0 and 1
        double dx47 = Math.random();               // dx from 0 and 1
        double dx48 = Math.random();               // dx from 0 and 1
        double dx49 = Math.random();               // dx from 0 and 1
        double dx50 = Math.random();               // dx from 0 and 1
        double dx51 = Math.random();               // dx from 0 and 1
        double dx52 = Math.random();               // dx from 0 and 1
        double dx53 = Math.random();               // dx from 0 and 1
        double dx54 = Math.random();               // dx from 0 and 1
        double dx55 = Math.random();               // dx from 0 and 1
        double dx56 = Math.random();               // dx from 0 and 1
        double dx57 = Math.random();               // dx from 0 and 1
        double dx58 = Math.random();               // dx from 0 and 1
        double dx59 = Math.random();               // dx from 0 and 1
        double dx60 = Math.random();               // dx from 0 and 1
        double dx61 = Math.random();               // dx from 0 and 1
        double dx62 = Math.random();               // dx from 0 and 1
        double dx63 = Math.random();               // dx from 0 and 1
        double dx64 = Math.random();               // dx from 0 and 1
        double dx65 = Math.random();               // dx from 0 and 1
        double dx66 = Math.random();               // dx from 0 and 1
        double dx67 = Math.random();               // dx from 0 and 1
        double dx68 = Math.random();               // dx from 0 and 1
        double dx69 = Math.random();               // dx from 0 and 1
        double dx70 = Math.random();               // dx from 0 and 1
        double dx71 = Math.random();               // dx from 0 and 1
        double dx72 = Math.random();               // dx from 0 and 1
        double dx73 = Math.random();               // dx from 0 and 1
        double dx74 = Math.random();               // dx from 0 and 1
        double dx75 = Math.random();               // dx from 0 and 1
        double dx76 = Math.random();               // dx from 0 and 1
        double dx77 = Math.random();               // dx from 0 and 1
        double dx78 = Math.random();               // dx from 0 and 1
        double dx79 = Math.random();               // dx from 0 and 1
        double dx80 = Math.random();               // dx from 0 and 1
        double dx81 = Math.random();               // dx from 0 and 1
        double dx82 = Math.random();               // dx from 0 and 1
        double dx83 = Math.random();               // dx from 0 and 1
        double dx84 = Math.random();               // dx from 0 and 1
        double dx85 = Math.random();               // dx from 0 and 1
        double dx86 = Math.random();               // dx from 0 and 1
        double dx87 = Math.random();               // dx from 0 and 1
        double dx88 = Math.random();               // dx from 0 and 1
        double dx89 = Math.random();               // dx from 0 and 1
        double dx90 = Math.random();               // dx from 0 and 1
        double dx91 = Math.random();               // dx from 0 and 1
        double dx92 = Math.random();               // dx from 0 and 1
        double dx93 = Math.random();               // dx from 0 and 1
        double dx94 = Math.random();               // dx from 0 and 1
        double dx95 = Math.random();               // dx from 0 and 1
        double dx96 = Math.random();               // dx from 0 and 1
        double dx97 = Math.random();               // dx from 0 and 1
        double dx98 = Math.random();               // dx from 0 and 1
        double dx99 = Math.random();               // dx from 0 and 1
        double dy0 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy1 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy2 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy3 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy4 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy5 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy6 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy7 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy8 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy9 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy10 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy11 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy12 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy13 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy14 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy15 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy16 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy17 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy18 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy19 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy20 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy21 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy22 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy23 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy24 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy25 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy26 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy27 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy28 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy29 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy30 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy31 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy32 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy33 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy34 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy35 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy36 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy37 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy38 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy39 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy40 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy41 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy42 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy43 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy44 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy45 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy46 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy47 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy48 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy49 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy50 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy51 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy52 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy53 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy54 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy55 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy56 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy57 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy58 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy59 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy60 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy61 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy62 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy63 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy64 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy65 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy66 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy67 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy68 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy69 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy70 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy71 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy72 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy73 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy74 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy75 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy76 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy77 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy78 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy79 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy80 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy81 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy82 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy83 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy84 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy85 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy86 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy87 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy88 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy89 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy90 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy91 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy92 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy93 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy94 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy95 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy96 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy97 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy98 = .5 + .5 * Math.random();     // dy from .5 and 1
        double dy99 = .5 + .5 * Math.random();     // dy from .5 and 1
        double accel0 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel1 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel2 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel3 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel4 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel5 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel6 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel7 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel8 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel9 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel10 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel11 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel12 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel13 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel14 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel15 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel16 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel17 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel18 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel19 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel20 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel21 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel22 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel23 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel24 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel25 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel26 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel27 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel28 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel29 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel30 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel31 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel32 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel33 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel34 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel35 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel36 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel37 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel38 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel39 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel40 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel41 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel42 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel43 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel44 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel45 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel46 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel47 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel48 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel49 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel50 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel51 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel52 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel53 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel54 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel55 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel56 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel57 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel58 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel59 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel60 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel61 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel62 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel63 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel64 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel65 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel66 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel67 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel68 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel69 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel70 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel71 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel72 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel73 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel74 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel75 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel76 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel77 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel78 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel79 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel80 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel81 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel82 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel83 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel84 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel85 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel86 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel87 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel88 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel89 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel90 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel91 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel92 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel93 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel94 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel95 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel96 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel97 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel98 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
        double accel99 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
      
        PennDraw.enableAnimation(30);
        while (true) {
            PennDraw.clear(PennDraw.WHITE);
            PennDraw.setPenColor(PennDraw.RED);
            PennDraw.filledCircle(x0, y0, ballRadius);
            PennDraw.filledCircle(x1, y1, ballRadius);
            PennDraw.filledCircle(x2, y2, ballRadius);
            PennDraw.filledCircle(x3, y3, ballRadius);
            PennDraw.filledCircle(x4, y4, ballRadius);
            PennDraw.filledCircle(x5, y5, ballRadius);
            PennDraw.filledCircle(x6, y6, ballRadius);
            PennDraw.filledCircle(x7, y7, ballRadius);
            PennDraw.filledCircle(x8, y8, ballRadius);
            PennDraw.filledCircle(x9, y9, ballRadius);
            PennDraw.filledCircle(x10, y10, ballRadius);
            PennDraw.filledCircle(x11, y11, ballRadius);
            PennDraw.filledCircle(x12, y12, ballRadius);
            PennDraw.filledCircle(x13, y13, ballRadius);
            PennDraw.filledCircle(x14, y14, ballRadius);
            PennDraw.filledCircle(x15, y15, ballRadius);
            PennDraw.filledCircle(x16, y16, ballRadius);
            PennDraw.filledCircle(x17, y17, ballRadius);
            PennDraw.filledCircle(x18, y18, ballRadius);
            PennDraw.filledCircle(x19, y19, ballRadius);
            PennDraw.filledCircle(x20, y20, ballRadius);
            PennDraw.filledCircle(x21, y21, ballRadius);
            PennDraw.filledCircle(x22, y22, ballRadius);
            PennDraw.filledCircle(x23, y23, ballRadius);
            PennDraw.filledCircle(x24, y24, ballRadius);
            PennDraw.filledCircle(x25, y25, ballRadius);
            PennDraw.filledCircle(x26, y26, ballRadius);
            PennDraw.filledCircle(x27, y27, ballRadius);
            PennDraw.filledCircle(x28, y28, ballRadius);
            PennDraw.filledCircle(x29, y29, ballRadius);
            PennDraw.filledCircle(x30, y30, ballRadius);
            PennDraw.filledCircle(x31, y31, ballRadius);
            PennDraw.filledCircle(x32, y32, ballRadius);
            PennDraw.filledCircle(x33, y33, ballRadius);
            PennDraw.filledCircle(x34, y34, ballRadius);
            PennDraw.filledCircle(x35, y35, ballRadius);
            PennDraw.filledCircle(x36, y36, ballRadius);
            PennDraw.filledCircle(x37, y37, ballRadius);
            PennDraw.filledCircle(x38, y38, ballRadius);
            PennDraw.filledCircle(x39, y39, ballRadius);
            PennDraw.filledCircle(x40, y40, ballRadius);
            PennDraw.filledCircle(x41, y41, ballRadius);
            PennDraw.filledCircle(x42, y42, ballRadius);
            PennDraw.filledCircle(x43, y43, ballRadius);
            PennDraw.filledCircle(x44, y44, ballRadius);
            PennDraw.filledCircle(x45, y45, ballRadius);
            PennDraw.filledCircle(x46, y46, ballRadius);
            PennDraw.filledCircle(x47, y47, ballRadius);
            PennDraw.filledCircle(x48, y48, ballRadius);
            PennDraw.filledCircle(x49, y49, ballRadius);
            PennDraw.filledCircle(x50, y50, ballRadius);
            PennDraw.filledCircle(x51, y51, ballRadius);
            PennDraw.filledCircle(x52, y52, ballRadius);
            PennDraw.filledCircle(x53, y53, ballRadius);
            PennDraw.filledCircle(x54, y54, ballRadius);
            PennDraw.filledCircle(x55, y55, ballRadius);
            PennDraw.filledCircle(x56, y56, ballRadius);
            PennDraw.filledCircle(x57, y57, ballRadius);
            PennDraw.filledCircle(x58, y58, ballRadius);
            PennDraw.filledCircle(x59, y59, ballRadius);
            PennDraw.filledCircle(x60, y60, ballRadius);
            PennDraw.filledCircle(x61, y61, ballRadius);
            PennDraw.filledCircle(x62, y62, ballRadius);
            PennDraw.filledCircle(x63, y63, ballRadius);
            PennDraw.filledCircle(x64, y64, ballRadius);
            PennDraw.filledCircle(x65, y65, ballRadius);
            PennDraw.filledCircle(x66, y66, ballRadius);
            PennDraw.filledCircle(x67, y67, ballRadius);
            PennDraw.filledCircle(x68, y68, ballRadius);
            PennDraw.filledCircle(x69, y69, ballRadius);
            PennDraw.filledCircle(x70, y70, ballRadius);
            PennDraw.filledCircle(x71, y71, ballRadius);
            PennDraw.filledCircle(x72, y72, ballRadius);
            PennDraw.filledCircle(x73, y73, ballRadius);
            PennDraw.filledCircle(x74, y74, ballRadius);
            PennDraw.filledCircle(x75, y75, ballRadius);
            PennDraw.filledCircle(x76, y76, ballRadius);
            PennDraw.filledCircle(x77, y77, ballRadius);
            PennDraw.filledCircle(x78, y78, ballRadius);
            PennDraw.filledCircle(x79, y79, ballRadius);
            PennDraw.filledCircle(x80, y80, ballRadius);
            PennDraw.filledCircle(x81, y81, ballRadius);
            PennDraw.filledCircle(x82, y82, ballRadius);
            PennDraw.filledCircle(x83, y83, ballRadius);
            PennDraw.filledCircle(x84, y84, ballRadius);
            PennDraw.filledCircle(x85, y85, ballRadius);
            PennDraw.filledCircle(x86, y86, ballRadius);
            PennDraw.filledCircle(x87, y87, ballRadius);
            PennDraw.filledCircle(x88, y88, ballRadius);
            PennDraw.filledCircle(x89, y89, ballRadius);
            PennDraw.filledCircle(x90, y90, ballRadius);
            PennDraw.filledCircle(x91, y91, ballRadius);
            PennDraw.filledCircle(x92, y92, ballRadius);
            PennDraw.filledCircle(x93, y93, ballRadius);
            PennDraw.filledCircle(x94, y94, ballRadius);
            PennDraw.filledCircle(x95, y95, ballRadius);
            PennDraw.filledCircle(x96, y96, ballRadius);
            PennDraw.filledCircle(x97, y97, ballRadius);
            PennDraw.filledCircle(x98, y98, ballRadius);
            PennDraw.filledCircle(x99, y99, ballRadius);
            PennDraw.setPenColor(PennDraw.BLACK);
            PennDraw.square(50,50,50);
          
            // simulate motion
            x0 = x0 + dx0;
            x1 = x1 + dx1;
            x2 = x2 + dx2;
            x3 = x3 + dx3;
            x4 = x4 + dx4;
            x5 = x5 + dx5;
            x6 = x6 + dx6;
            x7 = x7 + dx7;
            x8 = x8 + dx8;
            x9 = x9 + dx9;
            x10 = x10 + dx10;
            x11 = x11 + dx11;
            x12 = x12 + dx12;
            x13 = x13 + dx13;
            x14 = x14 + dx14;
            x15 = x15 + dx15;
            x16 = x16 + dx16;
            x17 = x17 + dx17;
            x18 = x18 + dx18;
            x19 = x19 + dx19;
            x20 = x20 + dx20;
            x21 = x21 + dx21;
            x22 = x22 + dx22;
            x23 = x23 + dx23;
            x24 = x24 + dx24;
            x25 = x25 + dx25;
            x26 = x26 + dx26;
            x27 = x27 + dx27;
            x28 = x28 + dx28;
            x29 = x29 + dx29;
            x30 = x30 + dx30;
            x31 = x31 + dx31;
            x32 = x32 + dx32;
            x33 = x33 + dx33;
            x34 = x34 + dx34;
            x35 = x35 + dx35;
            x36 = x36 + dx36;
            x37 = x37 + dx37;
            x38 = x38 + dx38;
            x39 = x39 + dx39;
            x40 = x40 + dx40;
            x41 = x41 + dx41;
            x42 = x42 + dx42;
            x43 = x43 + dx43;
            x44 = x44 + dx44;
            x45 = x45 + dx45;
            x46 = x46 + dx46;
            x47 = x47 + dx47;
            x48 = x48 + dx48;
            x49 = x49 + dx49;
            x50 = x50 + dx50;
            x51 = x51 + dx51;
            x52 = x52 + dx52;
            x53 = x53 + dx53;
            x54 = x54 + dx54;
            x55 = x55 + dx55;
            x56 = x56 + dx56;
            x57 = x57 + dx57;
            x58 = x58 + dx58;
            x59 = x59 + dx59;
            x60 = x60 + dx60;
            x61 = x61 + dx61;
            x62 = x62 + dx62;
            x63 = x63 + dx63;
            x64 = x64 + dx64;
            x65 = x65 + dx65;
            x66 = x66 + dx66;
            x67 = x67 + dx67;
            x68 = x68 + dx68;
            x69 = x69 + dx69;
            x70 = x70 + dx70;
            x71 = x71 + dx71;
            x72 = x72 + dx72;
            x73 = x73 + dx73;
            x74 = x74 + dx74;
            x75 = x75 + dx75;
            x76 = x76 + dx76;
            x77 = x77 + dx77;
            x78 = x78 + dx78;
            x79 = x79 + dx79;
            x80 = x80 + dx80;
            x81 = x81 + dx81;
            x82 = x82 + dx82;
            x83 = x83 + dx83;
            x84 = x84 + dx84;
            x85 = x85 + dx85;
            x86 = x86 + dx86;
            x87 = x87 + dx87;
            x88 = x88 + dx88;
            x89 = x89 + dx89;
            x90 = x90 + dx90;
            x91 = x91 + dx91;
            x92 = x92 + dx92;
            x93 = x93 + dx93;
            x94 = x94 + dx94;
            x95 = x95 + dx95;
            x96 = x96 + dx96;
            x97 = x97 + dx97;
            x98 = x98 + dx98;
            x99 = x99 + dx99;
            y0 = y0 - dy0;
            y1 = y1 - dy1;
            y2 = y2 - dy2;
            y3 = y3 - dy3;
            y4 = y4 - dy4;
            y5 = y5 - dy5;
            y6 = y6 - dy6;
            y7 = y7 - dy7;
            y8 = y8 - dy8;
            y9 = y9 - dy9;
            y10 = y10 - dy10;
            y11 = y11 - dy11;
            y12 = y12 - dy12;
            y13 = y13 - dy13;
            y14 = y14 - dy14;
            y15 = y15 - dy15;
            y16 = y16 - dy16;
            y17 = y17 - dy17;
            y18 = y18 - dy18;
            y19 = y19 - dy19;
            y20 = y20 - dy20;
            y21 = y21 - dy21;
            y22 = y22 - dy22;
            y23 = y23 - dy23;
            y24 = y24 - dy24;
            y25 = y25 - dy25;
            y26 = y26 - dy26;
            y27 = y27 - dy27;
            y28 = y28 - dy28;
            y29 = y29 - dy29;
            y30 = y30 - dy30;
            y31 = y31 - dy31;
            y32 = y32 - dy32;
            y33 = y33 - dy33;
            y34 = y34 - dy34;
            y35 = y35 - dy35;
            y36 = y36 - dy36;
            y37 = y37 - dy37;
            y38 = y38 - dy38;
            y39 = y39 - dy39;
            y40 = y40 - dy40;
            y41 = y41 - dy41;
            y42 = y42 - dy42;
            y43 = y43 - dy43;
            y44 = y44 - dy44;
            y45 = y45 - dy45;
            y46 = y46 - dy46;
            y47 = y47 - dy47;
            y48 = y48 - dy48;
            y49 = y49 - dy49;
            y50 = y50 - dy50;
            y51 = y51 - dy51;
            y52 = y52 - dy52;
            y53 = y53 - dy53;
            y54 = y54 - dy54;
            y55 = y55 - dy55;
            y56 = y56 - dy56;
            y57 = y57 - dy57;
            y58 = y58 - dy58;
            y59 = y59 - dy59;
            y60 = y60 - dy60;
            y61 = y61 - dy61;
            y62 = y62 - dy62;
            y63 = y63 - dy63;
            y64 = y64 - dy64;
            y65 = y65 - dy65;
            y66 = y66 - dy66;
            y67 = y67 - dy67;
            y68 = y68 - dy68;
            y69 = y69 - dy69;
            y70 = y70 - dy70;
            y71 = y71 - dy71;
            y72 = y72 - dy72;
            y73 = y73 - dy73;
            y74 = y74 - dy74;
            y75 = y75 - dy75;
            y76 = y76 - dy76;
            y77 = y77 - dy77;
            y78 = y78 - dy78;
            y79 = y79 - dy79;
            y80 = y80 - dy80;
            y81 = y81 - dy81;
            y82 = y82 - dy82;
            y83 = y83 - dy83;
            y84 = y84 - dy84;
            y85 = y85 - dy85;
            y86 = y86 - dy86;
            y87 = y87 - dy87;
            y88 = y88 - dy88;
            y89 = y89 - dy89;
            y90 = y90 - dy90;
            y91 = y91 - dy91;
            y92 = y92 - dy92;
            y93 = y93 - dy93;
            y94 = y94 - dy94;
            y95 = y95 - dy95;
            y96 = y96 - dy96;
            y97 = y97 - dy97;
            y98 = y98 - dy98;
            y99 = y99 - dy99;
            dy0 = dy0 + accel0;
            dy1 = dy1 + accel1;
            dy2 = dy2 + accel2;
            dy3 = dy3 + accel3;
            dy4 = dy4 + accel4;
            dy5 = dy5 + accel5;
            dy6 = dy6 + accel6;
            dy7 = dy7 + accel7;
            dy8 = dy8 + accel8;
            dy9 = dy9 + accel9;
            dy10 = dy10 + accel10;
            dy11 = dy11 + accel11;
            dy12 = dy12 + accel12;
            dy13 = dy13 + accel13;
            dy14 = dy14 + accel14;
            dy15 = dy15 + accel15;
            dy16 = dy16 + accel16;
            dy17 = dy17 + accel17;
            dy18 = dy18 + accel18;
            dy19 = dy19 + accel19;
            dy20 = dy20 + accel20;
            dy21 = dy21 + accel21;
            dy22 = dy22 + accel22;
            dy23 = dy23 + accel23;
            dy24 = dy24 + accel24;
            dy25 = dy25 + accel25;
            dy26 = dy26 + accel26;
            dy27 = dy27 + accel27;
            dy28 = dy28 + accel28;
            dy29 = dy29 + accel29;
            dy30 = dy30 + accel30;
            dy31 = dy31 + accel31;
            dy32 = dy32 + accel32;
            dy33 = dy33 + accel33;
            dy34 = dy34 + accel34;
            dy35 = dy35 + accel35;
            dy36 = dy36 + accel36;
            dy37 = dy37 + accel37;
            dy38 = dy38 + accel38;
            dy39 = dy39 + accel39;
            dy40 = dy40 + accel40;
            dy41 = dy41 + accel41;
            dy42 = dy42 + accel42;
            dy43 = dy43 + accel43;
            dy44 = dy44 + accel44;
            dy45 = dy45 + accel45;
            dy46 = dy46 + accel46;
            dy47 = dy47 + accel47;
            dy48 = dy48 + accel48;
            dy49 = dy49 + accel49;
            dy50 = dy50 + accel50;
            dy51 = dy51 + accel51;
            dy52 = dy52 + accel52;
            dy53 = dy53 + accel53;
            dy54 = dy54 + accel54;
            dy55 = dy55 + accel55;
            dy56 = dy56 + accel56;
            dy57 = dy57 + accel57;
            dy58 = dy58 + accel58;
            dy59 = dy59 + accel59;
            dy60 = dy60 + accel60;
            dy61 = dy61 + accel61;
            dy62 = dy62 + accel62;
            dy63 = dy63 + accel63;
            dy64 = dy64 + accel64;
            dy65 = dy65 + accel65;
            dy66 = dy66 + accel66;
            dy67 = dy67 + accel67;
            dy68 = dy68 + accel68;
            dy69 = dy69 + accel69;
            dy70 = dy70 + accel70;
            dy71 = dy71 + accel71;
            dy72 = dy72 + accel72;
            dy73 = dy73 + accel73;
            dy74 = dy74 + accel74;
            dy75 = dy75 + accel75;
            dy76 = dy76 + accel76;
            dy77 = dy77 + accel77;
            dy78 = dy78 + accel78;
            dy79 = dy79 + accel79;
            dy80 = dy80 + accel80;
            dy81 = dy81 + accel81;
            dy82 = dy82 + accel82;
            dy83 = dy83 + accel83;
            dy84 = dy84 + accel84;
            dy85 = dy85 + accel85;
            dy86 = dy86 + accel86;
            dy87 = dy87 + accel87;
            dy88 = dy88 + accel88;
            dy89 = dy89 + accel89;
            dy90 = dy90 + accel90;
            dy91 = dy91 + accel91;
            dy92 = dy92 + accel92;
            dy93 = dy93 + accel93;
            dy94 = dy94 + accel94;
            dy95 = dy95 + accel95;
            dy96 = dy96 + accel96;
            dy97 = dy97 + accel97;
            dy98 = dy98 + accel98;
            dy99 = dy99 + accel99;

            // bounce off floor
            if (y0 <= ballRadius) { dy0 = -0.9 * dy0; }
            if (y1 <= ballRadius) { dy1 = -0.9 * dy1; }
            if (y2 <= ballRadius) { dy2 = -0.9 * dy2; }
            if (y3 <= ballRadius) { dy3 = -0.9 * dy3; }
            if (y4 <= ballRadius) { dy4 = -0.9 * dy4; }
            if (y5 <= ballRadius) { dy5 = -0.9 * dy5; }
            if (y6 <= ballRadius) { dy6 = -0.9 * dy6; }
            if (y7 <= ballRadius) { dy7 = -0.9 * dy7; }
            if (y8 <= ballRadius) { dy8 = -0.9 * dy8; }
            if (y9 <= ballRadius) { dy9 = -0.9 * dy9; }
            if (y10 <= ballRadius) { dy10 = -0.9 * dy10; }
            if (y11 <= ballRadius) { dy11 = -0.9 * dy11; }
            if (y12 <= ballRadius) { dy12 = -0.9 * dy12; }
            if (y13 <= ballRadius) { dy13 = -0.9 * dy13; }
            if (y14 <= ballRadius) { dy14 = -0.9 * dy14; }
            if (y15 <= ballRadius) { dy15 = -0.9 * dy15; }
            if (y16 <= ballRadius) { dy16 = -0.9 * dy16; }
            if (y17 <= ballRadius) { dy17 = -0.9 * dy17; }
            if (y18 <= ballRadius) { dy18 = -0.9 * dy18; }
            if (y19 <= ballRadius) { dy19 = -0.9 * dy19; }
            if (y20 <= ballRadius) { dy20 = -0.9 * dy20; }
            if (y21 <= ballRadius) { dy21 = -0.9 * dy21; }
            if (y22 <= ballRadius) { dy22 = -0.9 * dy22; }
            if (y23 <= ballRadius) { dy23 = -0.9 * dy23; }
            if (y24 <= ballRadius) { dy24 = -0.9 * dy24; }
            if (y25 <= ballRadius) { dy25 = -0.9 * dy25; }
            if (y26 <= ballRadius) { dy26 = -0.9 * dy26; }
            if (y27 <= ballRadius) { dy27 = -0.9 * dy27; }
            if (y28 <= ballRadius) { dy28 = -0.9 * dy28; }
            if (y29 <= ballRadius) { dy29 = -0.9 * dy29; }
            if (y30 <= ballRadius) { dy30 = -0.9 * dy30; }
            if (y31 <= ballRadius) { dy31 = -0.9 * dy31; }
            if (y32 <= ballRadius) { dy32 = -0.9 * dy32; }
            if (y33 <= ballRadius) { dy33 = -0.9 * dy33; }
            if (y34 <= ballRadius) { dy34 = -0.9 * dy34; }
            if (y35 <= ballRadius) { dy35 = -0.9 * dy35; }
            if (y36 <= ballRadius) { dy36 = -0.9 * dy36; }
            if (y37 <= ballRadius) { dy37 = -0.9 * dy37; }
            if (y38 <= ballRadius) { dy38 = -0.9 * dy38; }
            if (y39 <= ballRadius) { dy39 = -0.9 * dy39; }
            if (y40 <= ballRadius) { dy40 = -0.9 * dy40; }
            if (y41 <= ballRadius) { dy41 = -0.9 * dy41; }
            if (y42 <= ballRadius) { dy42 = -0.9 * dy42; }
            if (y43 <= ballRadius) { dy43 = -0.9 * dy43; }
            if (y44 <= ballRadius) { dy44 = -0.9 * dy44; }
            if (y45 <= ballRadius) { dy45 = -0.9 * dy45; }
            if (y46 <= ballRadius) { dy46 = -0.9 * dy46; }
            if (y47 <= ballRadius) { dy47 = -0.9 * dy47; }
            if (y48 <= ballRadius) { dy48 = -0.9 * dy48; }
            if (y49 <= ballRadius) { dy49 = -0.9 * dy49; }
            if (y50 <= ballRadius) { dy50 = -0.9 * dy50; }
            if (y51 <= ballRadius) { dy51 = -0.9 * dy51; }
            if (y52 <= ballRadius) { dy52 = -0.9 * dy52; }
            if (y53 <= ballRadius) { dy53 = -0.9 * dy53; }
            if (y54 <= ballRadius) { dy54 = -0.9 * dy54; }
            if (y55 <= ballRadius) { dy55 = -0.9 * dy55; }
            if (y56 <= ballRadius) { dy56 = -0.9 * dy56; }
            if (y57 <= ballRadius) { dy57 = -0.9 * dy57; }
            if (y58 <= ballRadius) { dy58 = -0.9 * dy58; }
            if (y59 <= ballRadius) { dy59 = -0.9 * dy59; }
            if (y60 <= ballRadius) { dy60 = -0.9 * dy60; }
            if (y61 <= ballRadius) { dy61 = -0.9 * dy61; }
            if (y62 <= ballRadius) { dy62 = -0.9 * dy62; }
            if (y63 <= ballRadius) { dy63 = -0.9 * dy63; }
            if (y64 <= ballRadius) { dy64 = -0.9 * dy64; }
            if (y65 <= ballRadius) { dy65 = -0.9 * dy65; }
            if (y66 <= ballRadius) { dy66 = -0.9 * dy66; }
            if (y67 <= ballRadius) { dy67 = -0.9 * dy67; }
            if (y68 <= ballRadius) { dy68 = -0.9 * dy68; }
            if (y69 <= ballRadius) { dy69 = -0.9 * dy69; }
            if (y70 <= ballRadius) { dy70 = -0.9 * dy70; }
            if (y71 <= ballRadius) { dy71 = -0.9 * dy71; }
            if (y72 <= ballRadius) { dy72 = -0.9 * dy72; }
            if (y73 <= ballRadius) { dy73 = -0.9 * dy73; }
            if (y74 <= ballRadius) { dy74 = -0.9 * dy74; }
            if (y75 <= ballRadius) { dy75 = -0.9 * dy75; }
            if (y76 <= ballRadius) { dy76 = -0.9 * dy76; }
            if (y77 <= ballRadius) { dy77 = -0.9 * dy77; }
            if (y78 <= ballRadius) { dy78 = -0.9 * dy78; }
            if (y79 <= ballRadius) { dy79 = -0.9 * dy79; }
            if (y80 <= ballRadius) { dy80 = -0.9 * dy80; }
            if (y81 <= ballRadius) { dy81 = -0.9 * dy81; }
            if (y82 <= ballRadius) { dy82 = -0.9 * dy82; }
            if (y83 <= ballRadius) { dy83 = -0.9 * dy83; }
            if (y84 <= ballRadius) { dy84 = -0.9 * dy84; }
            if (y85 <= ballRadius) { dy85 = -0.9 * dy85; }
            if (y86 <= ballRadius) { dy86 = -0.9 * dy86; }
            if (y87 <= ballRadius) { dy87 = -0.9 * dy87; }
            if (y88 <= ballRadius) { dy88 = -0.9 * dy88; }
            if (y89 <= ballRadius) { dy89 = -0.9 * dy89; }
            if (y90 <= ballRadius) { dy90 = -0.9 * dy90; }
            if (y91 <= ballRadius) { dy91 = -0.9 * dy91; }
            if (y92 <= ballRadius) { dy92 = -0.9 * dy92; }
            if (y93 <= ballRadius) { dy93 = -0.9 * dy93; }
            if (y94 <= ballRadius) { dy94 = -0.9 * dy94; }
            if (y95 <= ballRadius) { dy95 = -0.9 * dy95; }
            if (y96 <= ballRadius) { dy96 = -0.9 * dy96; }
            if (y97 <= ballRadius) { dy97 = -0.9 * dy97; }
            if (y98 <= ballRadius) { dy98 = -0.9 * dy98; }
            if (y99 <= ballRadius) { dy99 = -0.9 * dy99; }

            // bounce off walls
            if (x0 <= ballRadius || x0 >= (100 - ballRadius) ) { dx0 = -dx0; }
            if (x1 <= ballRadius || x1 >= (100 - ballRadius) ) { dx1 = -dx1; }
            if (x2 <= ballRadius || x2 >= (100 - ballRadius) ) { dx2 = -dx2; }
            if (x3 <= ballRadius || x3 >= (100 - ballRadius) ) { dx3 = -dx3; }
            if (x4 <= ballRadius || x4 >= (100 - ballRadius) ) { dx4 = -dx4; }
            if (x5 <= ballRadius || x5 >= (100 - ballRadius) ) { dx5 = -dx5; }
            if (x6 <= ballRadius || x6 >= (100 - ballRadius) ) { dx6 = -dx6; }
            if (x7 <= ballRadius || x7 >= (100 - ballRadius) ) { dx7 = -dx7; }
            if (x8 <= ballRadius || x8 >= (100 - ballRadius) ) { dx8 = -dx8; }
            if (x9 <= ballRadius || x9 >= (100 - ballRadius) ) { dx9 = -dx9; }
            if (x10 <= ballRadius || x10 >= (100 - ballRadius) ) { dx10 = -dx10; }
            if (x11 <= ballRadius || x11 >= (100 - ballRadius) ) { dx11 = -dx11; }
            if (x12 <= ballRadius || x12 >= (100 - ballRadius) ) { dx12 = -dx12; }
            if (x13 <= ballRadius || x13 >= (100 - ballRadius) ) { dx13 = -dx13; }
            if (x14 <= ballRadius || x14 >= (100 - ballRadius) ) { dx14 = -dx14; }
            if (x15 <= ballRadius || x15 >= (100 - ballRadius) ) { dx15 = -dx15; }
            if (x16 <= ballRadius || x16 >= (100 - ballRadius) ) { dx16 = -dx16; }
            if (x17 <= ballRadius || x17 >= (100 - ballRadius) ) { dx17 = -dx17; }
            if (x18 <= ballRadius || x18 >= (100 - ballRadius) ) { dx18 = -dx18; }
            if (x19 <= ballRadius || x19 >= (100 - ballRadius) ) { dx19 = -dx19; }
            if (x20 <= ballRadius || x20 >= (100 - ballRadius) ) { dx20 = -dx20; }
            if (x21 <= ballRadius || x21 >= (100 - ballRadius) ) { dx21 = -dx21; }
            if (x22 <= ballRadius || x22 >= (100 - ballRadius) ) { dx22 = -dx22; }
            if (x23 <= ballRadius || x23 >= (100 - ballRadius) ) { dx23 = -dx23; }
            if (x24 <= ballRadius || x24 >= (100 - ballRadius) ) { dx24 = -dx24; }
            if (x25 <= ballRadius || x25 >= (100 - ballRadius) ) { dx25 = -dx25; }
            if (x26 <= ballRadius || x26 >= (100 - ballRadius) ) { dx26 = -dx26; }
            if (x27 <= ballRadius || x27 >= (100 - ballRadius) ) { dx27 = -dx27; }
            if (x28 <= ballRadius || x28 >= (100 - ballRadius) ) { dx28 = -dx28; }
            if (x29 <= ballRadius || x29 >= (100 - ballRadius) ) { dx29 = -dx29; }
            if (x30 <= ballRadius || x30 >= (100 - ballRadius) ) { dx30 = -dx30; }
            if (x31 <= ballRadius || x31 >= (100 - ballRadius) ) { dx31 = -dx31; }
            if (x32 <= ballRadius || x32 >= (100 - ballRadius) ) { dx32 = -dx32; }
            if (x33 <= ballRadius || x33 >= (100 - ballRadius) ) { dx33 = -dx33; }
            if (x34 <= ballRadius || x34 >= (100 - ballRadius) ) { dx34 = -dx34; }
            if (x35 <= ballRadius || x35 >= (100 - ballRadius) ) { dx35 = -dx35; }
            if (x36 <= ballRadius || x36 >= (100 - ballRadius) ) { dx36 = -dx36; }
            if (x37 <= ballRadius || x37 >= (100 - ballRadius) ) { dx37 = -dx37; }
            if (x38 <= ballRadius || x38 >= (100 - ballRadius) ) { dx38 = -dx38; }
            if (x39 <= ballRadius || x39 >= (100 - ballRadius) ) { dx39 = -dx39; }
            if (x40 <= ballRadius || x40 >= (100 - ballRadius) ) { dx40 = -dx40; }
            if (x41 <= ballRadius || x41 >= (100 - ballRadius) ) { dx41 = -dx41; }
            if (x42 <= ballRadius || x42 >= (100 - ballRadius) ) { dx42 = -dx42; }
            if (x43 <= ballRadius || x43 >= (100 - ballRadius) ) { dx43 = -dx43; }
            if (x44 <= ballRadius || x44 >= (100 - ballRadius) ) { dx44 = -dx44; }
            if (x45 <= ballRadius || x45 >= (100 - ballRadius) ) { dx45 = -dx45; }
            if (x46 <= ballRadius || x46 >= (100 - ballRadius) ) { dx46 = -dx46; }
            if (x47 <= ballRadius || x47 >= (100 - ballRadius) ) { dx47 = -dx47; }
            if (x48 <= ballRadius || x48 >= (100 - ballRadius) ) { dx48 = -dx48; }
            if (x49 <= ballRadius || x49 >= (100 - ballRadius) ) { dx49 = -dx49; }
            if (x50 <= ballRadius || x50 >= (100 - ballRadius) ) { dx50 = -dx50; }
            if (x51 <= ballRadius || x51 >= (100 - ballRadius) ) { dx51 = -dx51; }
            if (x52 <= ballRadius || x52 >= (100 - ballRadius) ) { dx52 = -dx52; }
            if (x53 <= ballRadius || x53 >= (100 - ballRadius) ) { dx53 = -dx53; }
            if (x54 <= ballRadius || x54 >= (100 - ballRadius) ) { dx54 = -dx54; }
            if (x55 <= ballRadius || x55 >= (100 - ballRadius) ) { dx55 = -dx55; }
            if (x56 <= ballRadius || x56 >= (100 - ballRadius) ) { dx56 = -dx56; }
            if (x57 <= ballRadius || x57 >= (100 - ballRadius) ) { dx57 = -dx57; }
            if (x58 <= ballRadius || x58 >= (100 - ballRadius) ) { dx58 = -dx58; }
            if (x59 <= ballRadius || x59 >= (100 - ballRadius) ) { dx59 = -dx59; }
            if (x60 <= ballRadius || x60 >= (100 - ballRadius) ) { dx60 = -dx60; }
            if (x61 <= ballRadius || x61 >= (100 - ballRadius) ) { dx61 = -dx61; }
            if (x62 <= ballRadius || x62 >= (100 - ballRadius) ) { dx62 = -dx62; }
            if (x63 <= ballRadius || x63 >= (100 - ballRadius) ) { dx63 = -dx63; }
            if (x64 <= ballRadius || x64 >= (100 - ballRadius) ) { dx64 = -dx64; }
            if (x65 <= ballRadius || x65 >= (100 - ballRadius) ) { dx65 = -dx65; }
            if (x66 <= ballRadius || x66 >= (100 - ballRadius) ) { dx66 = -dx66; }
            if (x67 <= ballRadius || x67 >= (100 - ballRadius) ) { dx67 = -dx67; }
            if (x68 <= ballRadius || x68 >= (100 - ballRadius) ) { dx68 = -dx68; }
            if (x69 <= ballRadius || x69 >= (100 - ballRadius) ) { dx69 = -dx69; }
            if (x70 <= ballRadius || x70 >= (100 - ballRadius) ) { dx70 = -dx70; }
            if (x71 <= ballRadius || x71 >= (100 - ballRadius) ) { dx71 = -dx71; }
            if (x72 <= ballRadius || x72 >= (100 - ballRadius) ) { dx72 = -dx72; }
            if (x73 <= ballRadius || x73 >= (100 - ballRadius) ) { dx73 = -dx73; }
            if (x74 <= ballRadius || x74 >= (100 - ballRadius) ) { dx74 = -dx74; }
            if (x75 <= ballRadius || x75 >= (100 - ballRadius) ) { dx75 = -dx75; }
            if (x76 <= ballRadius || x76 >= (100 - ballRadius) ) { dx76 = -dx76; }
            if (x77 <= ballRadius || x77 >= (100 - ballRadius) ) { dx77 = -dx77; }
            if (x78 <= ballRadius || x78 >= (100 - ballRadius) ) { dx78 = -dx78; }
            if (x79 <= ballRadius || x79 >= (100 - ballRadius) ) { dx79 = -dx79; }
            if (x80 <= ballRadius || x80 >= (100 - ballRadius) ) { dx80 = -dx80; }
            if (x81 <= ballRadius || x81 >= (100 - ballRadius) ) { dx81 = -dx81; }
            if (x82 <= ballRadius || x82 >= (100 - ballRadius) ) { dx82 = -dx82; }
            if (x83 <= ballRadius || x83 >= (100 - ballRadius) ) { dx83 = -dx83; }
            if (x84 <= ballRadius || x84 >= (100 - ballRadius) ) { dx84 = -dx84; }
            if (x85 <= ballRadius || x85 >= (100 - ballRadius) ) { dx85 = -dx85; }
            if (x86 <= ballRadius || x86 >= (100 - ballRadius) ) { dx86 = -dx86; }
            if (x87 <= ballRadius || x87 >= (100 - ballRadius) ) { dx87 = -dx87; }
            if (x88 <= ballRadius || x88 >= (100 - ballRadius) ) { dx88 = -dx88; }
            if (x89 <= ballRadius || x89 >= (100 - ballRadius) ) { dx89 = -dx89; }
            if (x90 <= ballRadius || x90 >= (100 - ballRadius) ) { dx90 = -dx90; }
            if (x91 <= ballRadius || x91 >= (100 - ballRadius) ) { dx91 = -dx91; }
            if (x92 <= ballRadius || x92 >= (100 - ballRadius) ) { dx92 = -dx92; }
            if (x93 <= ballRadius || x93 >= (100 - ballRadius) ) { dx93 = -dx93; }
            if (x94 <= ballRadius || x94 >= (100 - ballRadius) ) { dx94 = -dx94; }
            if (x95 <= ballRadius || x95 >= (100 - ballRadius) ) { dx95 = -dx95; }
            if (x96 <= ballRadius || x96 >= (100 - ballRadius) ) { dx96 = -dx96; }
            if (x97 <= ballRadius || x97 >= (100 - ballRadius) ) { dx97 = -dx97; }
            if (x98 <= ballRadius || x98 >= (100 - ballRadius) ) { dx98 = -dx98; }
            if (x99 <= ballRadius || x99 >= (100 - ballRadius) ) { dx99 = -dx99; }

            // animate
            PennDraw.advance();
        }
    }
}
