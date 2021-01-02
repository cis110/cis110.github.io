---
layout: default
title: CIS 110 Style Guide
active_tab: style

---
## CIS 110 Style Guide

Just like human languages, programming languages have a particular syntax and grammar. If you make a mistake, you end up with a program that is invalid, or "gibberish." And just as publishers and periodicals have "house styles" that govern how to indent paragraphs, how many spaces to put after a period, which abbreviations to use or avoid, etc., companies and programming projects also adopt style guidelines.

imaginereadingatextwherenothingwascapitalized,therewasnospacebetweenwordsandaroundpunctuationmarks,andparagraphswereseparatedbyonlyatinyblankspace. The text would preserve its meaning, but be nearly impossible to read. Furthermore, if every article (or every paragraph) in a magazine adhered to a completely different style, it would be almost as confusing. Programming is no different, except that it is far easier to make a syntactically correct program unreadable by using poor or inconsistent style. Good style is essential to programming, and a substantial portion of your homework grade will be based on style.

Programming style generally encompasses how you indent your code, when you put spaces around operators, how you name variables, functions, and classes, and how you document your code. There are many opinions about what constitutes the best style, and most companies and projects adopt their own guidelines to ensure consistency. In CIS 110, we generally follow the textbook's style guidelines. These are typical of the rules you are likely to encounter elsewhere, but represent a particular set of choice among many possibilities. Here are some of the highlights (where these highlights differ from the booksite's style guide, follow the highlights):

---

### Checkstyle Errors

We run an automated style checker on your homework submissions that identifies up some (but not all!) style errors such as missing commas or spaces, extra long lines (over 85 characters), and unnecessary parenthesis.

Here is an example of a checkstyle error

```java
HelloWorld.java:12:14: '(' is preceded by whitespace 
```
This error says that in the HelloWorld.java file, there is an error on line 12 at character 14. Specifically the parenthesis is preceded by whitespace and should not be.

There is no excuse for having checkstyle errors in your code. If you submit code with checkstyle errors, you will receive a large point deduction. Note that there are style conventions that are not identified by the automated checker. It your responsibility to ensure your code does not contain these errors.

---

### Blocks of Code

A block is any section of code enclosed between curly braces ({}). We accept either of the following styles of curcle brace placement wherever they're required (loops, conditionals, functions and so on). You may use either option 1 or option 2, but you need to be consistent - i.e. you can't use option 1 in some places and option 2 in others.

```java
      // EXPECTED
      // 1. Curly Braces on the same line
      public static void main(String[] args) {
        // do something
      }

      // ALSO ACCEPTABLE
      // 2. Curly Braces on the following line
      public static void main(String[] args) 
      {
        // do something
      }
```                

Every block of code must contain curly braces, even if they could be ommitted. This includes loops and conditionals

```java
        // Allowed
        if (s.equals("hackett1")) { 
          // do something 
        }

        // NOT allowed
        if (s.equals("jupierce"))  
          // do something 


        // NOT allowed
        if (s.equals("rabaum")) // do something 
```                  

We DO NOT ACCEPT blocks of code where both curly braces are on the same line.

```java
        // NOT allowed
        if (s.equals("sierram")) { // do something }
```
---

### Indentation

Each block of code must be indented 4 spaces to the right of its parent block. A block is any section of code enclosed between curly braces ({}). Codio should be set up to do this automatically. You can re-indent the current line by pressing TAB. You can reindent a whole section by selecting it and pressing TAB. Do not indent your code manually with spaces, let Codio do it.

There is no excuse for improperly indented code. Ever. Whenever you start typing a new line of code, press TAB to make sure your cursor is in the right place. Badly indented code is impossible for humans to read, and impossible to debug. If Codio automatically indents your code in a way you don't expect, you have a bug. Usually you are missing a semi-colon or curly brace.
    
If your code is not properly indented in office hours, we may refuse to help you.

---

### Variable and Class Names

Variable names and function/method names should follow the camelCase convention. Names should start with a lower-case letter. If the name is a composite of multiple words, each subsequent word starts with a capital letter. For example, "var" is an acceptable name for a variable, and "thisIsAVariableName" is also an acceptable name for a variable. The names "ThisNameBeginsWithACapitalLetter" and "this_name_contains_underscores" are not acceptable for variables in CIS 110.

As an exception to the above rule, constant variable names should be all upper-case. Constant variables are variables whose value never changes. Alternatively, think of these as symbolic names for particular values. The canonical example is a variable whose value is 3.14159... This variable would be named "PI" rather than "pi". This convention is also widely accepted.

Variable and function names should be descriptive. Try to name your variables and functions in a way that reflects what they do. Here is an example of both good and bad variable naming.

```java
        // Good 
        String className = "cis";
        int classNumber = 110;
        boolean isProgrammingFun = true;

        // Bad
        String s = "cis";
        int x = 110;
        boolean y = true; 
```
Class names should begin with a capital letter. If the name is made up of multiple words, each word should begin with a capital letter. It is often difficult to tell from context whether a name refers to a variable or a class. By following the capitalization conventions your code becomes much easier to read and understand.

---

### Spacing

Use a single space on either side of mathematical operators (+, -, *, /). *For example, write "x + y", not "x+y".*
    
Do not put a space before the square brackets for an array. For example, write "String[] args" and "args[0]", not "String [] args" or "args [0]".

The spacing around parentheses corresponds to how you would use them in English and math:
- Put spaces outside the parentheses, but not inside them, when they are used to group mathematical computations. For example, write "a + (b + c)", not "a +(b + c)" or "a + ( b + c )".
- Put spaces outside the parentheses, but not inside them, when they are part of a loop or conditional (if, for, or while). For example, write "if (x > 5) {", not "if(x > 5){" or "if ( x > 5 ) {".
- Do not put spaces around parentheses when they are part of a function call. For example, write "System.out.println("hello, world.")", not "System.out.println ("Hello, world.")" or "System.out.println( "Hello, world." )".
- Use blank lines to separate blocks of code that perform different functionality. There is no hard rule on how to do this; you can break it up as you please. Don't use uncessary blank space - 1 or 2 empty lines between blocks should suffice.
- Be consistent in your spacing. Don't use 1 blank line in some places and 3 in others.

---

### File Headers

Every .java file you submit must start with a file header comparable to the one below. Often times we will provide you a template, but you can also cut and paste from another file or from the example below. Your comment does not have to be formatted identically to this one, but it must start with your name, PennKey (not PennID!), and recitation, followed by instructions for how to run your program, and a description of what the program does.

```java
    /*  Name: Max Giancaterino
     *  PennKey: mgianc
     *  Recitation: 200
     *
     *  Execution: java HelloWorld
     *
     *  Prints "Hello, World". By tradition, this is everyone's first program.
     *
     */
```
---

### Commenting

Please document your code with comments. Comment should be used to quickly and concisely explain what your code is doing to an external reader. There is no real hard rule on how many comments should be included. In general you should comment blocks of code, explaining what each block does and also add comments explaining anything complex or confusing.

Please do not comment excessively. Do not put comments where comments are not required. A piece of code like System.out.println("cis110") does not require any explanation. Do not comment for the sake of commenting.

Comments should go above the code they reference. If it doesn't cause the line to be too long, short comments can go inline with the code they're referencing. Comments should never be below the code they reference.
    For comments that span more than a single line, please use a multi-line comment.

```java
        // This is a single line comment 

        /* This is a 
         * multi-line comment
         */
```               

Any TODO comments (including those provided in skeleton code) should be removed before submission.
    
Please provide function header comments for all of your functions (except main). This allows a reader to understand what the function is supposed to do. A function header comment should describe any inputs to or outputs of the function and provide a short description of what the function does. You can use the following template:

```java
        /* 
         * Description: 
         *
         * Input:
         *
         * Output: 
         */
```
---

### Code Efficiency

In general, we don't worry too much about how efficient your programs are in CIS 110. It's more important to have a correctly working program. That said, there are some style requirements related to efficiency.

When writing conditionals, never compare the value of a boolean variable or expression to true or false. You can just reference the boolean expression or it's negation directly. For example

```java
        boolean myBoolean = true;
        // GOOD STYLE
        if (myBoolean) {
          ....
        }

        if (!myBoolean) {
          ...
        }
        // BAD STYLE 
        if (myBoolean == true) {
          ....
        }

        if (myBoolean == false) {
          ...
        }
```                

Do not duplicate code. Instead, write a helper function that contains that code and call the helper function when necessary. If you ever find yourself copy-pastying blocks of code from one part of a program to another, chances are you should be writing a helper function.

Avoid writing redundant code, such as functions you never use.

Avoid obvious code inefficiencies. For example, if you need to look at every element in an array don't use a double nested loop.

Avoid overly complicated logic; aim to make your code as simple as possible. This includes simplifying boolean expressions and simplifying operations.

Where possible, aim to use a for loop instead of a while loop. This is because it's much easier accidentially introduce a bug when using a while loop.

Any print statements used to debug your code should be commented out or removed when you submit.

---

### Example Code

Below is an example of a short class written with good style.

```java
/* Name: Joe Smith
 * Pennkey: jsmith
 * 
 * Execution: java BouncingBall
 * 
 * Animate a ball bouncing within the boundaries of the PennDraw window.
 * 
 */

public class BouncingBall {
    public static void main(String[] args) {
        PennDraw.setCanvasSize(500, 500);

        // Position
        double ballPosX = 0.5;
        double ballPosY = 0.5;

        // Velocity
        double ballVelX = 0.01;
        double ballVelY = -0.01;
        double ballRadius = 0.1;
        PennDraw.enableAnimation(30); // 30 frames per second (FPS)
        
        while (true) {
            // Make the screen white
            PennDraw.clear();
            PennDraw.setPenColor(PennDraw.BLUE);
            PennDraw.filledRectangle(0.5, 0.25, 0.5, 0.25);
            PennDraw.setPenColor(PennDraw.RED);
            PennDraw.filledCircle(ballPosX, ballPosY, ballRadius);

            // Update position X and Y coords with velocity components
            ballPosX = ballPosX + ballVelX;
            ballPosY = ballPosY + ballVelY;

            /* Check the ball's position relative to the screen's bounds,
             * and if it's close enough to the bounds, flip the ball's X or Y
             * velocity depending on if it's by a vertical or horizontal wall
            */
            if ((ballPosY - ballRadius <= 0.0 && ballVelY < 0.0) ||
               (ballPosY + ballRadius >= 1.0 && ballVelY > 0.0)) {
                ballVelY = ballVelY * -1 + (Math.random() - 0.5) * 0.001;
            }
            if ((ballPosX - ballRadius <= 0.0 && ballVelX < 0.0) ||
               (ballPosX + ballRadius >= 1.0 && ballVelX > 0.0)) {
                ballVelX = ballVelX * -1 + (Math.random() - 0.5) * 0.001;
            }
            PennDraw.advance();
        }
    }
}
```


