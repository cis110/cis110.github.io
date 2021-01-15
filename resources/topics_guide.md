---
layout: default
title: CIS 110 Fall 2020 — Introduction to Computer Programming
active_tab: course-topic-guide
---

# Introduction
This resource is presented as list of topics, functions, and patterns that we've encountered so far in CIS 110. It is reference material, and not a definitive textbook.

Please note that this resource is **not**...
- a comprehensive list of all information that might be tested on an exam
- a replacement for having viewed the live & recorded material that covered these topics
- an indication that something **not** covered here is not an important concept in learning programming & Java.
- an example of exactly the level of detail at which you need to understand a concept.

Here are a handful of good ways to use this document:
- As a **starting point** for preparing for an exam.
- As a way to check your understanding of a recent topic.
- As a reference for completing homeworks, especially when you recall that we've covered something similar to the problem at hand before in the class.
- As a way to double check why the code you're writing isn't compiling, or to remind you of some syntax rules that just won't stick in your head.

> You might notice that some text looks like this. When something is written in this way, it's information that you might be interested to learn but that you're not required to know. 

**Note: We leave the table of contents in full, but will not fill in the relevant information until it has been taught in lecture.**

Table of Contents:
- [Introduction](#introduction)
- [Incomplete List of Functions & Operations We Have Used](#incomplete-list-of-functions--operations-we-have-used)
- [Basics of a Java Program](#basics-of-a-java-program)
  - [Writing & Running Code](#writing--running-code)
  - [The `main` Method & `args`](#the-main-method--args)
  - [Code Blocks](#code-blocks)
- [Drawing](#drawing)
- [Variables](#variables)
  - [What A Variable Is](#what-a-variable-is)
  - [Declaring a Variable](#declaring-a-variable)
  - [Assigning a Value to a Variable](#assigning-a-value-to-a-variable)
  - [Variable Scopes](#variable-scopes)
- [Data Types](#data-types)
  - [What a Data Type Is](#what-a-data-type-is)
  - [Primitive Data Types in Java](#primitive-data-types-in-java)
    - [Table of Primitives](#table-of-primitives)
    - [Strings](#strings)
  - [Some Important Operators & Tools](#some-important-operators--tools)
    - [Relational Operators](#relational-operators)
    - [The multifaceted `+`](#the-multifaceted-)
    - [Mod (`%`)](#mod-)
    - [Casting](#casting)
    - [Parsing](#parsing)
    - [Math](#math)
- [Conditionals](#conditionals)
  - [When to use a Conditional](#when-to-use-a-conditional)
  - [`if`, `else if`, and `else`](#if-else-if-and-else)
  - [Switch Statements](#switch-statements)
- [Loops](#loops)
  - [Rules of Iteration in Java](#rules-of-iteration-in-java)
  - [The While Loop](#the-while-loop)
  - [The For Loop](#the-for-loop)
  - [Your Loop of Choice](#your-loop-of-choice)
  - [Break and Continue](#break-and-continue)
- [Arrays](#arrays)
  - [What is an Array?](#what-is-an-array)
    - [Arrays Are Fixed-Length](#arrays-are-fixed-length)
    - [Arrays Are Indexed](#arrays-are-indexed)
    - [Arrays Contain Values Of One Type Only](#arrays-contain-values-of-one-type-only)
  - [Manipulating Arrays](#manipulating-arrays)
    - [Initializing entries of an array to random values](#initializing-entries-of-an-array-to-random-values)
    - [Printing the values of an array](#printing-the-values-of-an-array)
    - [Finding the maximum value in an array](#finding-the-maximum-value-in-an-array)
    - [Finding the sum & mean of an array of doubles](#finding-the-sum--mean-of-an-array-of-doubles)
- [Functions](#functions)
  - [Anatomy of a Function](#anatomy-of-a-function)
  - [Functions and Control Flow](#functions-and-control-flow)
  - [Functions and Variable Scope](#functions-and-variable-scope)
- [Recursion](#recursion)
- [Object Oriented Programming](#object-oriented-programming)
  - [Objects vs Classes](#objects-vs-classes)
  - [Writing Classes to Define Object State & Behavior](#writing-classes-to-define-object-state--behavior)
    - [Fields](#fields)
    - [Methods](#methods)
    - [Constructor](#constructor)
  - [Principles of Object Oriented Programming](#principles-of-object-oriented-programming)
    - [Encapsulation](#encapsulation)
      - [Getters and Setters](#getters-and-setters)
    - [Abstraction](#abstraction)
    - [State](#state)
    - [Mutability and Immutability](#mutability-and-immutability)
  - [Abstract Data Types](#abstract-data-types)
- [References in Java](#references-in-java)
- [LinkNodes, Linked Lists, & Array Lists](#linknodes-linked-lists--array-lists)
  - [Typical List Interface](#typical-list-interface)
- [Number Systems](#number-systems)
  - [Decimal vs. Binary](#decimal-vs-binary)
  - [Converting from Binary to Decimal](#converting-from-binary-to-decimal)
  - [Converting from Decimal to Binary](#converting-from-decimal-to-binary)
  - [Encryption & XOR](#encryption--xor)
- [2D Arrays](#2d-arrays)
  - [Declaring and Initializing](#declaring-and-initializing)
  - [Indexing](#indexing)
  - [Iteration through 2D Arrays](#iteration-through-2d-arrays)
- [Comparing Objects](#comparing-objects)

---
<!-- 
# Incomplete List of Functions & Operations We Have Used
- Basic operations:
  - Arithmetic
    - `+, -, *, /` on numeric types
    - `%`, the [mod operator](#mod-) for numeric types
  - Logical
    - `&&`, `||` for booleans
  - Relational
    - `==, !=` for all primitive data types
    - `<, >, <=, =>` for numeric primitive types
- `Math` operations
  - `Math.pow` for exponentiation (don't use for squaring, though!)
  - `Math.sqrt` for square roots
  - `Math.abs` for absolute values
  - `Math.min`, `Math.max` for finding the smaller/larger of two values
- `PennDraw` functions
  - These are numerous, so review [our PennDraw guide](https://www.cis.upenn.edu/~cis110/current/resources/penndraw.html) for the full listing
  - `PennDraw.setPenColor`, `PennDraw.setPenRadius` for changing drawing properties
  - `PennDraw.clear` to clear the screen, draw backgrounds
  - `PennDraw.setScale`, `PennDraw.setXScale`, `PennDraw.setYScale` for changing drawing scales.
  - Shapes range from simple (`PennDraw.point`) to complex (`PennDraw.polygon`)
  - `PennDraw.enableAnimation` and `PennDraw.advance` are essential for animation
  - Interactivity:
    - `PennDraw.mousePressed`, `PennDraw.mouseX`, and `PennDraw.mouseY` for mouse inputs
    - `PennDraw.hasNextKeyTyped` and `PennDraw.nextKeyTyped` for keyboard inputs
- Reading inputs with `In`
  - `isEmpty` for checking if there is anything left to read in the file
  - `readInt, readDouble, readBoolean, readString, readLine` all read & parse the next single value in the file as the desired data type. These all read one value at a time.
  - `readAll` consumes the rest of the text in the file and returns it to you as a (potentially very long) `String`.
- Printing
  - `System.out.println` prints its input, followed by a line break (an `'\n'` character).
  - `System.out.print` prints its input exactly, with no space add afterwards.
- Arrays
  - `arr.length` evaluates to the length of the array `arr` as an `int`.
  - `arr[i]` evaluates to the value stored at index `i` within array `arr`.
- `String`s
  - `+` is used for _concatenating_ a value with a `String`. More on this [here.](#the-multifaceted-)
  - `s.length()` returns the length of the `String` as an `int`.
  - `s.charAt(i)` returns the `char` at index `i` in `String s`.
  - `s.toUpperCase()` and `s.toLowerCase()` return a new `String` with all alphabetic `char`s in `s` converted to uppercase and lowercase, respectively.  

---
# Basics of a Java Program

## Writing & Running Code
- Java code is written in `.java` files.
- Code must be compiled before it can be run.
  - To compile your code, press the "Compile" button on the top bar in Codio.
  - Every time you change your code, you must re-compile your code before running it so that the changes are executed.
- To run a Java program that has been compiled, you must meet several important criteria. If the program is `ExampleFile.java`, then the layout of the program must match the following:
  ```java
  // This file is named ExampleFile.java
  public class ExampleFile {
      // Other code & functions can come before or after main, too
      public static void main(String[] args) {
          ...
      }
      // Other code & functions can come before or after main, too
  }
  ```
  - Specifically, the name of the file and the top-level class name must match.
  - Additionally, the program needs a main function to be run directly.
- A program, once compiled, can be run with `java ExampleFile` from the Codio terminal, optionally passing in command line arguments as well.

## The `main` Method & `args`
This is the entry point to a program. That is, when you run `java Apples fuji macintosh pink-lady`, you're doing the following:
- Java finds the method defined as `public static void main(String[] args)` from `Apples.java`
- The execution of the program starts at the beginning of the `main` method, and continues until `main` returns, including any potential method calls in `main`.
- The input argument to `main` called `args` is an array of Strings representing the list of arguments passed in from the run command. In this case, `args` would be equal to `{"fuji", "macintosh", "pink-lady"}`
  - `args` is always an array of `String`s. If you intend to interpret the input as numbers, you'll need to use _parsing_ on the relevant members of `args` (`Integer.parseInt(s)`, `Double.parseDouble(s)`).

## Code Blocks
Java programs are essentially sequences of nested code blocks. Code blocks are groups of lines of code that live between an open brace (this character: `{` ) and its corresponding close brace (this character: `}`). Note that a block of code does not necessarily end at the first `}` character following a `{` character in the case of nested code.  
An illustration follows, with each comment specifying which code block that line would belong to. Note the fact that code blocks can nest, and how this is represented here with the decimal notation (block 1.2.1 is the first block inside the second block inside the first block, for example).
```java
public class CodeBlockExample {
  // BLOCK 1
  public static void main(String[] args) {
    // BLOCK 1.1
    for (...) {
      // BLOCK 1.1.1
    }
    // BLOCK 1.1
    while (...) {
      // BLOCK 1.1.2
    }
    // BLOCK 1.1
  }
  // BLOCK 1

  public static int tester() {
    // BLOCK 1.2
    for (...) {
      // BLOCK 1.2.1
    }
    return 0; // BLOCK 1.2
    // BLOCK 1.2
  }
}
```

# Drawing
A complete reference to drawing with PennDraw is [already available on the course site.](https://www.cis.upenn.edu/~cis110/current/resources/penndraw.html) Some key points:
- The default coordinate system for PennDraw canvases has `(0, 0)` in the bottom left corner and `(1, 1)` at the top right corner. You can use `PennDraw.setScale()` to change this as makes sense to your program.
- All shapes (from points to polygons) are drawn to the color specified by the PennDraw `penColor`. To change the color of a shape, you must add a call to `PennDraw.setPenColor()` at some point before the line where you draw the shape.
- Animation is disabled by default.
  - A call to `PennDraw.enableAnimation(frameRate)` turns on animation at the specified framerate. 
  - If animations are enabled, nothing will be actually drawn to the screen until `PennDraw.advance()` is called. When this function is called, any shape or text drawing commands run since the last call to `advance()` will have their outputs drawn to the screen.
- PennDraw also allows you to capture user input through mouse clicks and key presses. The protocols for these steps are listed [here](https://www.cis.upenn.edu/~cis110/current/resources/penndraw.html#keyboard-and-mouse) and you should take care to familiarize yourself with them.
  - Mouse presses are simple to read: calling `mousePressed()` works regardless of the previous user inputs and represents the state of the mouse at the current frame.
  - PennDraw tracks all key presses and saves them for you until you ask for them. Following the examples of how to use `hasNextKeyTyped()` and `nextKeyTyped()` are important for understanding how to read sequences of user input, which stores the state from previous frames.

# Variables

## What A Variable Is
Variables are just names for individual pieces of data in Java. You provide the name and type of a variable to Java, and Java will keep track of that name for you. You can then assign (and reassign) data to the variable for later use. Variables in Java are mutable, meaning that you are able to change the values that the variables contain. This is the big reason why they are so useful!

## Declaring a Variable
The syntax for declaring a variable is a two part statement: `type name`, where `type` is the data type of the variable and `name` is the name of the variable. When a variable is declared without having a value assigned to it, the variable will have a default value. The default value depends on the data type that variable, but the result is that whenever you reference the variable after it is declared, it will have some (potentially `null` value). Once a variable has been declared, it is not possible to declare a variable of the same name in the same scope.  
Some examples:
```java
int x;
double y;
String lastName;
char middleInitial;
boolean isFinished;
```

## Assigning a Value to a Variable
This is done with the use of the assignment operator, `=`. The syntax for assigning a value to a variable is: providing the name of the variable, followed by the assignment operator, followed by an expression that will be the new value of the variable (examples to follow). It is possible to assign a value to a variable at the moment it is declared, although this is not required. This means that it is possible to assign to a variable when or after it is declared, but it is not possible to assign a value to a name of a variable that has never been declared. Variables can also be assigned in terms of themselves, and this is a powerful asset in the case of trying to count or store intermediate results of computation.  
Some examples:
```java
int age = 53;
double y;
y = age * 2.5;
String lastName;
lastName = "Fouh";
middleInitial = (char) (middleInitial + 2);
boolean isFinished;
isFinished = !isFinished;
```

## Variable Scopes
The scope of a variable is the set of lines in the Java program where Java will recognize the name of that variable. A variable is generally in scope for the entire code block in which it is defined following its definition, and it is also in scope for all code blocks nested inside after its definition.  
```java
public static void main(String[] args) {
  // x is not in scope
  System.out.println("not yet");
  boolean x = true; // x begins scope here
  while (x) {
    // this is a nested code block within the previous one
    x = false; // x is in scope here
    System.out.println("Just once.");
  }
  // we're back in the original block; x is in scope
  System.out.println(x);
} // x's original code block ends.
// x is not in scope here

public static int tester() {
  // x is not in scope here
}
```

# Data Types

## What a Data Type Is
In Java, **every expression that stores or calculates to a value has a data type**. A data type is a formal classification for how Java represents and handles any piece of information. This is a broad and almost philosophical definition. A more practical one looks like this: a data type in Java is a definition of the range that a particular value can belong to, and what operations are valid to perform on that value. Operators and functions in Java specify what data types they can work with. If you are not careful with tracking the data types of the inputs to different functions and operators, you can end up with code that won't compile.

## Primitive Data Types in Java
There are a number of primitive Data Types available in Java. To say that a data type is primitive means that the type is predefined by Java to be included in the language. In this class we focus on studying four primitive data types: `boolean`, `char`, `int`, and `double`. In addition, we are also heavily interested in the `String` Data Type which, while not technically a primitive one, can be used in many similar ways to the primitive data types.

### Table of Primitives

|Data Type|Range|Default|Usage|Key Operations (not exhaustive)|
|---------|-----|-------|-----|-------------------------------|
|`int`|[-32,768, 32,767]|0|integers|+,-,*,/,%,>,<,<=,=>,==,!=|
|`double`|a very negative number up to a very positive number|0.0|numbers, including fractional parts|+,-,*,/,%,>,<,<=,=>,==,!=|
|`boolean`|{`true`, `false`}|`false`|truth values|==, !=, !, && , \|\||
|`char`|[0, 65535]|0, or `'\u0000'`|single characters of text (letters, numbers, punctuation, spaces) represented as small integers|similar to `int`|

### Strings
`String`s are effectively sequences of `char`s. The default value of a `String` is `null` (more on this later). `String`s are how we represent text and language in Java. The operations defined on `String`s are numerous, but an important basic one is the `+` operator, which represents concatenation when applied to one or more `String`s. 

`String`s are immutable in Java, meaning that when you perform some operation on a `String`, an entirely new `String` will be returned. 
```java
String first = "Maya";
String second = first.toUpperCase(); // Capitalize all letters in string

System.out.println("first is still " + first);
System.out.println("second is " + second);
```
Running the above code demonstrates that `String first` was unchanged after the call to `toUpperCase()`:
```bash
> first is still Maya
> second is MAYA
```

## Some Important Operators & Tools
Many of the operators available for each data type will prove useful at some point. This section represents a brief overview of some of these, as well as other function tools. For a more complete overview of the behaviors of operations among different types, make sure to look at the exercises at the end of [this presentation](https://www.cis.upenn.edu/~cis110/current/lectures/1VariablesDataTypes.pdf).

### Relational Operators
All of `>,<,<=,=>,==,!=` are operators that accept two values of primitive data types and return a `boolean` result. These comparison tools are often essential for defining the control flow of your programs in `if` statements and in loops.

### The multifaceted `+`
- When `+` is used between two numeric types (`int` and `double`), the resulting operation _addition_. If a `double` is in the mix, then the resulting type will be `double`; otherwise, `int`.
- When `+` is used between one `String` and any other primitive type, the result is *concatenation*.
  Concatenation converts the other data type in the operation to a `String` representation and then appends that to the other `String`.  
  ```java
  boolean b = false;
  String str = "hoods";
  System.out.println(b + str);
  // Output: "falsehoods"
  ```
 - `+` can be used as addition between a `char` and another `char` or an `int`. This uses the underlying integer representation of the `char` to do the arithmetic. Using an `int` in this operation gives the output type `int`

### Mod (`%`)
Another name for mod would be "remainder after division". Major uses for this operation include constraining `int`s to wrap around within a certain range, testing for whether a number is even or odd, or checking to see if a number is a multiple of another. Remember that `%` with one negative argument leads to a negative result.

### Casting
_Casting_ is the process of interpreting a value of some data type as a different data type. In this course, when we refer to casting we are referring to the manual process of converting from a type with a wider range of values into a type with a smaller range of values.
```java
int justTheInt = (int) 51.564;
char asLetter = (char) justTheInt;
```
> Although we usually refer to it as "type promotion" in CIS 110, some sources will refer to conversions going in the other direction as casting, too. This is the automatic process of converting a `char` into an `int` or an `int` into a `double` that Java will do for you. This works automatically when the original type is "smaller" than the new, "larger" type.

### Parsing
_Parsing_ is the process of interpreting the value of a `String` as a representation of a value in some other data type. The primary ways that we use parsing with respect to data types are with the following two examples:  
```java
int fromString42 = Integer.parseInt("42");
double fromStringThreePointOneFour = Double.parseDouble("3.14159265");
```

### Math
The basic arithmetic operators represent only a small fraction of the math that you can do in Java. Using the `Math` library, operations like `abs`, `min`, `max`, trigonometric functions, exponentiation, `round`, and `random` are available. There's a good listing of these at the end of [this presentation](https://www.cis.upenn.edu/~cis110/current/lectures/1VariablesDataTypes.pdf).

# Conditionals
Conditionals are the simplest means we have to influence control flow in our programs. By default, Java programs execute sequentially, with each line being run in the order it's written. When you add conditionals to your program, you decide among several options for which lines of code to be run next based on the state of some specified values.

## When to use a Conditional
- To match some value to one out of several possible values
- To make a choice about what to do based on user input
- To make a decision about whether to break out of a loop
- To check to see if you've hit some special state, perhaps 

## `if`, `else if`, and `else`
Control flow can be influenced using if, else if, and else statements. 

- An if statement consists of the `if` keyword, a condition, and a body. The condition is an expression, possibly containing several values and variables, that evaluates to a boolean. 
  - If the condition evaluates to `true`, then the code in the body of the if statement is executed. - If not, then the code is skipped entirely.  
- An else if statement is exactly like an if statement in syntax (it requires a condition and a body), with the only difference being that the required keyword is `else if` (rather than `if` alone). 
  - An else if statement can only be used directly following an if statement or another else if statement. 
  - When the condition of the else if statement evaluated to `true` **and all previous if and else if statements were not executed**, the body of the statement will be executed. 
- An else statement is slightly different. Only the `else` keyword is required, along with a body. 
  - An else statement can only be used *once* directly following an if statement or an else if statement
  - The body of an else statement will be executed only if all previous if and else if statements failed to execute.

```java
if (x > y || a == c) {
  System.out.println("Hello");
} else if (x == y) {
  System.out.println("Goodbye");
} else if (x < y) {
  System.out.println("So long");
} else {
  System.out.println("Farewell");
}

// These next if statements are unrelated to the first chain and to each other.
// Either of them will be run when their conditions are true, independent of prior conditionals.
if (u && i) {
  return 10;
}
if (me && u) {
  return 20;
}
```

## Switch Statements
Switch statements are conditionals designed for the purpose of checking the value of some variable or expression against several enumerated outcomes. We do not require you to use a switch statement in this class, although you are certainly welcome to. An example that demonstrates the complete syntax of a switch statement is presented here.

```java
switch (name) {
  case "Harry": case "Eric":
    title = "Professor";
    break;
  case "Jules": case "Michael": case "Gian": case "Ben":
    title = "Head TA";
    break;
  default:
    System.out.println("Name not matched, default case used");
    title = "TA";
    break;
}
```
This example checks to see if `name` is the name of a professor, a head TA, or a TA.

# Loops
Loops are the way that we implement iteration in Java. They are the tools by which we are able to write programs that perform one task many, many times. It is from this ability to write in repetition (with controlled variation) that the power of computation emerges.  

## Rules of Iteration in Java

Any loop that we use in Java is controlled by three components:
1. **An initialization** of a loop control variable (or perhaps several variables).
2. **A termination condition** defined over the control variable(s). When the loop control variable reaches a particular value or state, the termination condition will evaluate to `false` and the iteration of the `loop` will stop. 
3. **A modification** of the loop control variable(s). By modifying the control variable(s), we can eventually reach the state outlined in the termination condition, indicating that the loop should cease repeating.

## The While Loop
As outlined in the previous section, a while loop must include an initialization component, a termination condition, and a modification step.  
```java
int i = 40; // initialization (i is the loop control variable)
while (i > 0) { // termination condition
  System.out.println(i);
  i--; // modification step
}

boolean hasPressed = false; // initialization (hasPressed is the loop control variable)
while (!hasPressed) { // termination condition
  PennDraw.filledRectangle(...);
  if (PennDraw.mousePressed()) {
    hasPressed = true; // modification
  }
}
```
Some takeaways from these two examples:
- You will usually need to perform the initialization step outside of the body of the loop. Otherwise, loop control variable will have its value reset every iteration of the loop, leading to bugs.
- The termination condition is the only essential component of iteration that's actually required by the syntax of the while loop.
- The loop control variable need not be modified every iteration of the while loop, although sometimes it makes sense to. Compare how many times `hasPressed` would be changed with how many times `i` would be changed.

The termination condition is checked before every iteration of the loop, including before the (potential) first iteration.
## The For Loop
A for loop must again include an initialization step, a termination condition, and a modification. Unlike a while loop, though, a for loop has space for these steps built into its very syntax.
```java
//  |INITIALIZATION   | TERMINATION COND. | MODIFICATION|
for (String line = "."; line.length() < 10; line += '.') {
  System.out.println(line);
}

//  |INIT.         | TERM. |  MODIF.|
for (double k = 100; k == 1; k /= 10) {
  System.out.println(k);
}

//  |INIT.    | TERM.          | MOD|
for (int i = 0; i < args.length; i++) {
  System.out.println(args[i]);
}
```

A variable initialized during the intialization step is in scope only in the body of the loop. The termination condition is checked before every iteration of the loop, including before the (potential) first iteration. The modification step is performed after each iteration. 
## Your Loop of Choice
It is possible to convert a loop of one variety into an equivalent loop of the other variety. This is always true, although it usually is somewhat more natural to use one type in certain circumstances.

It's often more natural to write a **while loop** when:
- You're doing animation
- You're waiting indefinitely for user input
- The purpose of your iteration is not to traverse over some data of fixed length, or you're traversing over some data that has an unknown length
- You will perform different modification steps over the course of the loop execution based on different states

It's often more natural to write a **for loop** when:
- You're looping over the indices of data of some fixed length
- You need to generate a range of numbers
- You have a specific number of times that you want your loop to execute.

Perhaps the most salient point here: if your problem can be phrased as "examine every x in y" or "for every element of this array/this string, do something", this is a good sign that a for loop would fit nicely. These are just general guidelines, and you should keep in mind that you can always make either loop work. 

## Break and Continue
_break_ is a statement that, when executed in the body of a loop, causes that loop to immediately stop executing. The current iteration is halted, and no further iterations are executed. The control of the program resumes immediately after the body of the loop.

_continue_ is a statement that, when executed in the body of a loop, causes that iteration of the loop to immediately cease. In the case of the for loop, this causes the modification step to be applied. As long as the termination condition has not been met, the next iteration of the loop will commence.

`break` exits a loop entirely, `continue` skips to the next iteration.

# Arrays

## What is an Array?
In Java, an array is an fixed-length, indexed sequence of values that are all of the same type. Each value in this sequence can be modified and overwritten. An array is a data type of its own, and the type of an array is different from the type of the elements it contains. In particular, `int x = 4;` defines a variable of type `int`, whereas `int[] xs = {3, 4, 5};` defines a variable of type `int[]` (note the difference in brackets). 

```java
int[] ages = new int[320]; // an array of 320 ints
ages = new int[60]; // a new array of 60 ints. It is valid to store a new array in ages.

double[] xPositions = new double[10];

String[] suits = {"spades", "hearts", "diamonds", "clubs"};
```

### Arrays Are Fixed-Length
When you create an array, you must also specify its length. This can be done with implicit initialization (e.g. `new char[4]`) or explicit (e.g. `{4, 3, 2, 1}`). In both of these example cases, the arrays have a length of 4. It is not possible to add another element to this array without first creating a new, larger array.

### Arrays Are Indexed
Arrays in Java are 0-indexed, meaning that we refer to the first element of an array as being at index 0. Using `.length` on the end of the array, we have an expression for the length of an array. If we have some array `arr`, and we say that `n` is equal to `arr.length`, then each integer between `0` and `n` (but not including `n`) is a valid index for that array. 

The syntax for indexing into arrays in Java is to append `[index]` to the end of a variable containing an array. Taking our example from above with `suits`:

```java
String[] suits = {"spades", "hearts", "diamonds", "clubs"};
```

Then the following table represents the indices of `suits`:

|Index|Value|
|-----|-----|
|`suits[0]`|`"spades"`|
|`suits[1]`|`"hearts"`|
|`suits[2]`|`"diamonds"`|
|`suits[3]`|`"clubs"`|
|`suits[4]`, `suits[5]`, ... |Leads to `ArrayIndexOutOfBoundsException`|
|`suits[-1]`, `suits[-2]`, ... |Leads to `ArrayIndexOutOfBoundsException`|

### Arrays Contain Values Of One Type Only
When an array is initialized without explicit values, we use the syntax `new type[length]`, where `type` represents some valid data type (`String`, `boolean`, etc). The array that is created thus has the data type `type[]`, which reads in English as "an array of `type`s" or a "`type` array". This new array can only contain values of data type `type` from now on.  
This also means that when initializing arrays with explicit values, those explicit values must all be of the same type.  
When declaring a variable that will contain an array, you must declare the variable of the correct type. Refer the previous examples under "What is an Array?".

## Manipulating Arrays
Presented here are a few examples of how to manipulate arrays. These are taken directly from the website of the course's textbook. All credit to Sedgewick and Wayne. Refer to the [booksite's section on arrays](https://introcs.cs.princeton.edu/java/14array/) for a fuller listing of patterns related to using arrays.

### Initializing entries of an array to random values
```java
int n = 5;
double[] a = new double[n];
for (int i = 0; i < n; i++) {
    a[i] = Math.random();
}
```

### Printing the values of an array
Assumes the existence of some array `a`, like the one from the first example.
```java
System.out.println("a[]");
System.out.println("-------------------");
for (int i = 0; i < n; i++) {
    System.out.println(a[i]);
}
System.out.println();
System.out.println("a = " + a);
System.out.println();
```

### Finding the maximum value in an array
Assumes the existence of some array `a`, like the one from the first example.
```java
double max = Double.NEGATIVE_INFINITY;
for (int i = 0; i < n; i++) {
    if (a[i] > max) max = a[i];
}
System.out.println("max = " + max);
```

### Finding the sum & mean of an array of doubles
Assumes the existence of some array `a`, like the one from the first example.
```java
double sum = 0.0;
for (int i = 0; i < n; i++) {
    sum += a[i];
}
System.out.println("average = " + sum / n);
```

# Functions
Functions (or methods) are the basic building blocks of Java programs. `main` is a function, `Math.abs` is a function, `PennDraw.filledRectangle` is a function, and you can write your own functions. In CIS 110, we use the terms "function" and "method" to refer to the same thing. Both the term "function" and the term "method" have broader and diverging meanings outside of the scope of the course, but in CIS 110 we can use them interchangably. 

> In JavaScript, it's not the case that every function is a method although the reverse is basically true. Going by the definitions outlined in, say, [Cornell's CS1130 Course](http://www.cs.cornell.edu/courses/cs1130/2012sp/1130selfpaced/module2/module2part1/methodHeaders.html), Java has it so that not every method is a function even though every function is indeed a method. This is vague notation.

Functions in Java are similar to functions in mathematics. Fundamentally, functions are tools that take some inputs, do some work based on the inputs, and produce some output. 

## Anatomy of a Function
A function has...
1. a header. A header consists of several pieces:
   1. One or more optional modifiers, like `public` and `static`. You should continue to include these words at the beginning of your functions, even though we haven't covered their meanings yet.
   2. A return type. This specifies the data type that the function is guaranteed to output. 
      1. If a function has a return type of `int`, for example, the function is guaranteed to return an `int`.
      2. It is possible for a function to have a return type of `void`, which is a guarantee that the function will not return any data at all.
   3. A name. This specifies how you can refer to this function and use it later.
   4. A list of arguments type & name pairs
      1. Each argument must have its type specified first
      2. The name of the argument in the header puts variables with these names in scope in the body of the function.
2. a body. The body of a function is a just another block of code where execution starts at the top.
3. one or more `return` statements.
   1. `return` is a keyword in Java that indicates that the function should stop executing.
   2. `return` is coupled with a value. For example, a full `return` statement might look like `return true;`, `return x + 4;`, or `return str.toUpperCase()`. In each case, the type of the value being returned must match the return type of the function.
   3. A function with a non-void return type must end with a `return`. Reaching the end of a function without hitting `return` will result in an error.
   4. The only exception to these rules are in the case of a function with return type `void`. In this case, `return` cannot be paired with a value, since `void` indicates that no data is returned. In functions with return type `void`, it is possible to use no `return` statements at all, and when Java reaches the end of the function body, Java will `return` implicitly.

To illustrate these rules, we examine a searching function:
```java
/**
 * indexOfValue attempts to find value in an array of chars
 * called list. If we find value, return its index. If we
 * don't find value, return -1 to indicate that value is 
 * not in list.
 */
public static int indexOfValue(char value, char[] list) {
  for (int i = 0; i < list.length; i++) {
    if (list[i] == value) {
      return i;
    }
  }
  return -1
}
```
- The header is `public static int indexOfValue(char value, char[] list)`
  - The return type of this function is `int`
  - The name of the function is `indexOfValue`
  - The input argument consists of a `char` named `value` and an array of chars (a `char[]`) named `list`.
- The body of the function lives between the first open brace and the last close brace. `list` and `value`, the input arguments, are in scope in the body.
- This function has two `return` statements, and both of them return some `int` value. No matter the inputs, one of these `return`s will be reached.

## Functions and Control Flow
Java programs start executing at `main` when run from the command line, as we do in CIS 110. Control is passed between functions with _function calls_, which happen where we write the name of the function followed by a list of input argument values in parentheses. 

Considering the example below, we have a function `public static int addTwo(int x)`. We can call `addTwo` like so: `addTwo(4)`. In this case, `4` is the value that will be bound to the variable `x` at the start of `addTwo`'s body.

The execution of the most recent function call must be completed before control is passed back to the point where that call was made. This results in a _call stack_.

```java
public class Functions {
    public static void main(String[] args) {
        System.out.println("Starting main.");
        int six = addTwo(4);
        System.out.println("four plus two is " + six);
        int eight = addThree(5);
        System.out.println("five plus three is " + eight);
        System.out.println("Leaving main");
    }

    public static int addTwo(int x) {
        System.out.println("Starting addTwo with input " + x);
        System.out.println("Leaving addTwo");
        return x + 2;
    }

    public static int addThree(int x) {
        System.out.println("Starting addThree with input " + x);
        int temp = addTwo(x);
        System.out.println("Leaving addThree");
        return temp + 1;
    }
}

```
The output:
```bash
$ java Functions
Starting main.
Starting addTwo with input 4
Leaving addTwo
four plus two is 6
Starting addThree with input 5
Starting addTwo with input 5
Leaving addTwo
Leaving addThree
five plus three is 8
Leaving main
```
Observe how this output illustrates the call stack. `main` is called first. From `main`, we call `addTwo`, which returns `6` without calling another function. Then from `main`, we call `addThree`, which in turn calls `addTwo`. `addThree`'s call to `addTwo` is resolved before `addThree` returns the result back to `main`. Then, `main` finishes execution without a return statement, which is acceptable because `main` always has return type `void`.

## Functions and Variable Scope
When a function is called and its body is executed, Java creates a new scope. Generally speaking, the only variables that will be in scope at the start of the function execution will be the input arguments to that function. 

```java
public class Scope {
  public static void main(String[] args) {
        int a = 50;
        int b = 100;
        int c = 200;
        System.out.println("before newScope, main's c = " + c);
        newScope(a, b);
        // the variable c declared in newScope is out of scope
        // back here in main.
        System.out.println("after newScope, main's c = " + c);
    }

    public static void newScope(int x, int y) {
        System.out.println("STARTING newScope");
        // x and y are in scope
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        // a, b, and c are not in scope here.
        // we can declare a variable c here
        int c = 40;
        System.out.println("newScope's c = " + c);
        System.out.println("ENDING newScope");
    }
}
```
Output:
```
$ java Scope
before newScope, main's c = 200
STARTING newScope
x = 50
y = 100
newScope's c = 40
ENDING newScope
after newScope, main's c = 200
```

# Recursion
The Codio lecture notes for this topic are very detailed, and they're even interactive! You should refresh yourself on rules about recursion there.

# Object Oriented Programming
Object Oriented Programming is a paradigm that views programs as collections of entities called objects that are comprised of and interact with each other.

> Contrast this with our previous notion of programming, which is called procedural programming. This just views programs as lines of code to be run, one after the other, with functions representing procedures that implement a specific task. Procedural programming is actually an effective way of thinking about drawing as we did it in the early parts of the semester: it’s not not necessary to view a program that sketches a scene as one made of many objects interacting with each other. Sometimes code is, after all, just a list of instructions.

## Objects vs Classes
Objects in Java are representations of real-world entities. Objects have state and behavior, and these are defined by classes. We say that objects are individual instances of a class. Therefore, a class is a blueprint for how to create objects of that underlying type.

Here we have a class called `Soda`.

```java
public class Soda {
  private String container;
  private String flavor;

  public Soda(String container, String flavor) {
    this.container = container;
    this.flavor = flavor;
  }

  // rest of class omitted for space
}
```
In another program, `SodaFountain.java`, we might have the following lines:

```java
Soda sprite = new Soda("glass bottle", "lemon-lime");
Soda coke = new Soda("can", "hard to describe");
```
In this case, we say that `sprite` and `coke` are objects, and that `Soda` is the class from which they have been instantiated.

## Writing Classes to Define Object State & Behavior
Now that we have the difference between a class and an object, it’s time to think about how classes are written. Classes are made up of fields, methods, and (optionally) constructors.

### Fields
A class’ fields represent the data that an instance of the class can store. These are effectively variables that belong to instances (objects) of this class. To that end, we sometimes refer to them as instance variables. Fields belong at the top of a class by convention.

```java
public class Tree {
  public int age;
  private String species;
  private double height;
  private double width;

  // rest of class omitted for space
}
```
In this class `Tree`, we have four fields. These are: `age`, `species`, `height`, and `width`. Observe that they have a type associated with them just like any other variable. Additionally, they have a privacy modifier (in this case, all but age are `private`). By convention, fields will normally be `private`, and this is explained further in the section on Encapsulation.

A field can be accessed inside of a class definition using its name alone, or with this as a way to specify that you’re referring to the field in the case that multiple variables in the same scope share the same name (this is called shadowing).

```java 
age = age + 34;
// if the RHS variable height shadows the field named 
// height, this example stores the value of the local
// variable height in the field called height.
this.height = height 
```
Outside of the object’s class, only its fields are directly accessible without the use of getter methods. Imagining we have some function `generateTree` that returns some `Tree` object, consider the following:

```java
Tree t = generateTree();
System.out.println(t.age); // this compiles
System.out.println(t.width); // this does not
```
### Methods
Methods are the functions of a class and they represent what the object can do and how it can change. These follow the rules of functions as we have discussed before.
When viewing methods from the object oriented approach, it’s important to recall that the methods in a class have access to that class’ fields. Continuing our `Tree` example from before:

```java
public class Tree {
  // ... same field definitions from above

  // estimate volume of trunk using cylinder formula.
  public double estimateTrunkVolume() {
    return Math.PI * (width / 2) * (width / 2) * height;
  }
}
```
Observe that the `estimateTrunkVolume` method of a `Tree` has access to the `width` and `height` fields of the `Tree` class. These variables are accessible in the body of the method without being passed in as input arguments.

Methods will be, in the context of this class, either `public` or `private`. Like with fields, `private` methods are only accessible inside the class itself whereas `public` methods are available from any instance of the class in another file.

If a method is `public`, it can be called from any instance of the class:

```java
Tree narrow = generateTree();
double volume = narrow.estimateTrunkVolume();
```
Methods with private designation are generally helper methods. For better understanding of `public` vs. `private` in methods, refer to notes on Encapsulation.


### Constructor
Constructors are the tools that we use to actually instantiate an object from a class. Constructors are essentially special methods that take the name of the class itself. When a constructor is called with the `new` keyword, Java will provide the space in memory to create a new instance of the desired class and it will use the constructor to set up the new instance in the specified manner.

Let’s return once more to our `Tree` example:

```java
public class Tree {
  public int age;
  private String species;
  private double height;
  private double width;

  public Tree(int age, String species, double height, double width) {
    this.age = age;
    this.species = species;
    this.height = height;
    this.width = width;
  }
}
```

Our constuctor is written right beneath the class’ fields (this is conventional). Note that it looks like a method named `Tree` without a specified return type. This is what indicates to Java that this thing is a constructor: no return type and sharing its name with the class itself. Notice how the input arguments to the constructor match the fields of the class: this is a typical pattern, where we have a constructor that assigns each of its inputs to the corresponding fields of the new object. A constructor can take fewer input arguments than fields in the class or vice versa. A constructor does not need a return statement.

## Principles of Object Oriented Programming
### Encapsulation
Encapsulation is the principle that an object should hide the details of how they work by providing a barrier between the interface of the object (what it can do) and its implementation (how it does what it does). The concept of separating implementation from interface is central to the notion of Abstraction as well, but Encapsulation focuses primarily on the tools that we use to hide the machinery of an object from the client that uses it.

Encapsulation is achieved in Java by use of Access Control, which itself is defined with visibility modifiers `public` and `private`. When a field or method is tagged with `private`, that field or method will only be accessible from within the file where it is defined. `public` fields and methods are, by contrast, available in any other file.

The public interface of a class is therefore the set of fields and methods available in the class that are defined as `public`. These are the methods that a user can call at will. If any fields are part of the public interface, then a user can access & modify these directly.

```java
public class Person {
  public int age;

  public Person(int age) {
    this.age = age;
  }
}
```
In this class `Person`, the field `age` would be considered part of the public interface. This is concerning, though, because a client using `Person` objects could do the following:

```java
Person harry = new Person(24);
harry.age = -20;
```

It doesn’t make sense for a `Person` to have a negative age, so a `Person` object shouldn’t be able to have their age be 0 or less. Leaving `age` as `public` allows anyone with access to a `Person` object to put that object into a nonsensical state. Thus, it makes better sense to do the following:


```java
public class Person {
  private int age;

  public Person(int age) {
    this.age = Math.max(0, age);
  }

  public int getAge() {
    return this.age;
  }

  public void ageOneYear() {
    this.age += 1;
  }
}
```
By keeping age `private`, modifying the constructor, and adding methods `getAge` and `ageOneYear` to the public interface, we keep `age` as a field that’s just part of the implementation. If a user wants to see a `Person`’s `age`, they can use the `getAge` method (a getter) to see it. If they want to change it, we are specifying with `ageOneYear` that a `Person` can only age one year at a time, and our constructor makes it so that making a `Person` with a negative `age` is impossible.

#### Getters and Setters
Getters and setters are special types of methods that help implement Encapsulation in a class. A getter is a method that returns the value of some data stored by an instance of the class. Note that this could be returning a field directly, or it could return some piece of data stored implicitly by an instance.

```java
public class Circle {
  private double radius;

  // Constructor omitted for space...

  public double getRadius() {
    return this.radius;
  }

  public double getDiameter() {
    return this.radius * 2;
  }

  public double getArea() {
    return Math.PI * this.radius * this.radius;
  }
}
```
In this Circle example, we have defined three getters: `getRadius`, `getDiameter`, and `getArea`. Notice that the only field of the class, `radius`, is `private`. The only way to access this data is therefore using `getRadius`. There are no fields for the diameter or the area of the shape, but we might also call `getDiameter` and `getArea` getters for their corresponding data anyway.

Setters work similarly, but they provide controlled means of updating the values of data stored in an object.

```java
public class Circle {
  private double radius;

  // Constructor & getters omitted for space...

  public void setRadius(double radius) {
    radius = Math.abs(radius);
    this.radius = radius;
  }
}
```
In this example, `setRadius` is a setter for the `radius` field that allows us to update that piece of data without risking the client filling the field with a negative (nonsensical) value.

Careful choices for `public` and `private` on the fields and methods of a class combined with getters and setters for `private` fields allow you to define an interface that hides and protects the implementation that you’ve chosen.

### Abstraction
_Abstraction_ is the process of representing real-world entities with properties relevant to the client that will be using it. The properties that we choose to represent an entity become the fields of the object. These chosen properties, along with our view of the stakeholder's desired use of the object, then help to define the interface that will be available to users of the object.

Abstraction is fundamental to solving interesting problems with Computer Science: it is not possible to directly manipulate a Movie, a Movie Ticket, or a Movie Theater with Java code, but we can keep track of abstract instances of these things to solve problems about them (selling and tracking tickets for film screenings, for example).

When designing a class, we use abstraction to make conscientious choices about how a class will represent an entity.

### State
Classes are defined with fields. When we talk about fields in the context of instantiated objects, we often refer to them as instance variables. These instance variables, like all variables we've been working with so far, store values and can change through time (unless they're _constants_). Looking at the values of all of the instance variables in a particular object at a particular time defines its _state_. In most cases, classes are written so that the objects defined from them can change through time, representing different states of the entities that the objects are designed to represent.

```java
public class Person {
  private String name;
  private String address;

  // constructors, getters, setters, & more omitted
}
```
A `Person` class might have fields for a name and an address. The state of any particular instance of `Person`, perhaps `harry`, would then be that `Person`'s name and address. At the time of this writing, `harry`'s address would be in Philadelphia, but when `harry` moves in a couple of years, we could call some method `harry.moveTo("New York City")`. Then, we've updated `harry`'s state to reflect his new location.

### Mutability and Immutability
Variables (and thus fields) are mutable, or changeable, by default in Java. This means that any user with access to an object's fields will generally have the ability to change the state of that object. We have already addressed this to a limited extent in our discussion of [encapsulation](#encapsulation): using privacy modifiers and carefully chosen getters, setters, and other methods, we can limit the access that a user has to the state of an object. But limited access is not the same thing as immutability; indeed, the presence of any setter or other `public` method that modifies the instance variables of an object implies that the object is mutable from the perspective of the end user.

Consider, then, the example of the `String` data type in Java. `String`s are objects, and we consider them to be immutable. Now we can understand that this is because users of the `String` class have no ability to change the fields of any `String` object: there are no getters and setters for the class, and all of the methods that manipulate a `String` return a new version of the `String`.

```java
String bookTitle = "In The Dream House"
System.out.println(bookTitle.toUpperCase());
System.out.println(bookTitle);
```
This results in:
```
"IN THE DREAM HOUSE"
"In The Dream House"
```
Even the methods available in `String` that manipulate some instance of a `String` do not modify the original `String`: calling `.toUpperCase()` left `bookTitle` the same for when we printed it out again afterwards. In this way, the `String` class achieves *immutability*.

```java
public class Receipt {
  private String recipient;
  private double[] amounts;
  private String[] items;

  public Receipt(String recipient, double[] amounts, String []) {...}

  public double computeSubtotal() {...}

  public double computeGrandTotal(double taxRate) {...}

  public void printReceipt() {...}
}
```
The above class for `Receipt` (with method implementations left implied for space) describes another immutable object. A `Receipt` object, once instantiated, cannot be modified. A user can only tally up the `Receipt` or print a nice, readable version of it, but neither of these actions change the state of the `Receipt`.

## Abstract Data Types
In many cases, it's not very important how some object works, as long as it does what we expect it to do. This is true in real life: when it comes to a car, you know that it can accelerate, brake, park, get in and out without worrying too much about what's under the hood (literally). _Abstract Data Types_ (ADTs) are ways that we can employ this principle in programming.

In Java, we write ADTs using _interfaces_. If a class _implements_ an interface, we say that the class is a subtype of the ADT's interface or that the ADT is a supertype of the class. 

Interfaces look like classes, but instead of fields and methods, interfaces are comprised of:
1. **abstract methods**, or method signatures without bodies
2. **constants**, or variables declared with keywords `static` and `final` that cannot be changed after they are declared.

The abstract methods are doing the heavy lifting here. These method signatures without bodies to the functions define exactly what an object of this ADT must be able to do, but they don't specify how it happens.

```java
public interface Car {
  public static final KM_PER_MILE = 1.609;

  void enter(String passenger);
  void accelerateTo(double targetSpeed);
  void brake(double targetSpeed);
}
```
Here's a basic example of a `Car` ADT. This tells us that any object of type `Car` can do these things: you can enter a car, you can speed upp, and you can slow down. Any object of type `Car` will also have access to the constant `KM_PER_MILE`, which might be useful in dealing with speeds for cars in different parts of the world.

It's important to recognize that we can't instantiate a `Car` directly: there's no constructor in this interface, and we couldn't write one even if we wanted to. Instead, we can only instantiate objects of types that implement the `Car` interface. The following snippet is the beginning of a `StationWagon` interface. 

> A note from Harry: A station wagon is not a particularly stylish variety of car. It has a boxy shape, a sluggish disposition, and plenty of trunk space. I note all of this with pride and nostalgia: my first car was a '98 Volvo station wagon.

```java
public class StationWagon implements Car {
  private String manufacturer;
  private double topSpeedMPH;
  private double currentSpeedMPH = 0;
  private int numDoors;
  private int numPassengers = 0;
  private String[] passengers = new String[6];

  public StationWagon(String manufacturer, double topSpeed, int numDoors) {
    // implemented but omitted for length
  }

  @Override
  public void enter(String passenger) {
    if (numPassengers < passengers.length) {
      passengers[numPassengers] = [passenger];
      numPassengers++;
    } else {
      System.out.println("Car's full!");
    }
  }

  @Override
  public void accelerateTo(double targetSpeed) {
    // implemented but omitted for length
  }

  @Override
  public void brake(double targetSpeed) {
    // implemented but omitted for length
  }

  public double getSpeedMPH() {
    return currentSpeedMPH;
  }
  
  public double getSpeedKMPH() {
    return currentSpeedMPH * KM_PER_MILE;
  }
}
```
Some important things to highlight here about how `StationWagon` implements `Car`. 
- Note that the class definition on line 1 includes the statement that `StationWagon implements Car`: this tells Java that `Car` is the interface that `StationWagon` should implement. 
- We were able to add our own fields to `StationWagon`.
- `StationWagon` contains a constructor. This lets us instantiate `StationWagon`s that are also `Car`s. This is the only way we have written to instantiate a `Car` object of any kind.
- All of the methods in `Car` are implemented in `StationWagon`. These are annotated with the `@Override` decorator, which is an optional feature that tells Java to double check that the method you're writing corresponds to a signature from the interface. 
- There are methods in `StationWagon` that were not outlined in `Car`, and that's OK! `getSpeedMPH` and `getSpeedKMPH` are getters that are not present in the `Car` interface, but there's no problem with including them in `StationWagon` as long as we don't add the `@Override` tag above them. 

Thus, the `StationWagon` class can instantiate any number of different `StationWagon` objects that represent different vehicles. Importantly, all `StationWagon`s are *also* all `Car`s—this is an example of the subtype-supertype relationship.

```java
Car harrysVolvo = new StationWagon("Volvo", 85, 4);
StationWagon otherCar = new StationWagon("Volkswagen", 99, 4);
```
In the above snippet, we instantiate two new objects. In both lines, we call the `StationWagon` constructor. For `harrysVolvo`, we store the resulting object we create in a variable of type `Car`. This works because a `StationWagon` is indeed a `Car`. For `otherCar`, we store the `StationWagon` in a variable of type `StationWagon`. This is also acceptable, and it means that `otherCar` can be used as a `StationWagon` more specifically than as a `Car`.

# References in Java
Like for recursion, our Codio course has excellent and interactive notes on how to think about references in Java. Please refer to those notes for a better understanding of the material. Just a few definitions to leave here for reference, then:
- _reference variables_ are variables for data types that are not primitive. Reference variables store as their values a reference to the location in memory where a particular object lives.
- _references_ are locations where a particular object lives in memory.
- _pointees_ are the objects that are being referred to by references.
- Variables are _sharing_ or are _aliases_ when they contain references to the same pointee.
- Two variables are _deep copies_ of each other when
  - they contain two separate references to two different pointees
  - their two pointees are _structurally_ equal objects that represent the same entity.

**Java is a pass-by-value language**. When you call a function in Java and give it an argument, the value of that argument is copied and handed along to the body of the function that's being called. When dealing with reference variables in Java, or variables that themselves contain a reference to some object's location in memory, a _copy_ of this reference is passed into the function being called. Thus, the input parameter to the function call and the local variable available in the body of the function are _aliases_ for each other. 

# LinkNodes, Linked Lists, & Array Lists
Lists in Java are covered quite thoroughly in our interactive Codio course. Please explore them there!

## Typical List Interface
A brief overview of a typical List interface, defined over some arbitrary example object called Item:  

1. `add`, which can be implemented in multiple ways:
   1. `void add(Item i, int index)` adds `Item i` to the list at position `index`.
   2. `boolean add(Item i)` simply adds `Item i` to the end of the list and returns `true`, or returns `false` if there is no room.
2. `boolean remove(Item i)` removes `Item i` from the list and returns `true`, or returns `false` if there is no such item. If there are duplicates of `i` in the list, the behavior may vary. Typically this results in removing the first matching `Item`, although this depends on the specifications.
3. `boolean contains(Item i)` returns `true` if `Item i` appears in the list, and `false` otherwise.
4. `boolean isEmpty()` returns `true` if the list is empty and `false` otherwise.
5. `int size()` returns the number of items in the list as an `int`.
6. `int get(Item i)` returns the index of `Item i` in the list. If there are duplicates of `i` in the list, the behavior may vary. Typically this results in finding the index of the first matching `Item`, although this depends on the specifications.

# Number Systems
Some quick definitions:

- a _digit_ is a single numerical symbol. We're most typically familiar with digits `0, 1, 2, 3, 4, 5, 6, 7, 8, 9`. 
- In a number, the _most significant digit_ is the leftmost non-zero digit. The _least significant digit_ is the rightmost digit. In the number `1234`, `1` is the most significant digit and `4` is the least significant digit.

## Decimal vs. Binary
_Decimal_, also referred to as base-10, is our typical way of dealing with numbers. The decimal number system consists of digits `0-9`. For an integer (we won't handle fractional numbers in other systems in CIS 110), we might call the position of the least significant digit (the right-most digit) the "ones place", then moving to the left we get the "tens place" and the "hundreds place" and so on. This reflects how we read numbers in decimal: `5,839` is equivalent `5*1000 + 8*100 + 3*10 + 9*1`.

_Binary_ is the base-2 number system, where our only digits are `0` and `1`. These "**b**inary dig**its**" are also called _bits_. Counting in binary proceeds as follows: `0, 1, 10, 11, 100, 101, 110, 111, 1000`, and so on. Instead of a "tens place" and a "hundreds place" as in decimal numbers, we have a "twos place" and a "fours place". That is, if we want to convert the binary number `1011` into a decimal interpretation, we view it in the following way: `1101` in binary is `1*8 + 1*4 + 0*2 + 1*1 = 13` in decimal.

## Converting from Binary to Decimal
As discussed right above, it's simple to convert from binary to decimal by considering the binary number to be a sum of powers of two. 

The algorithm for converting is as follows:
- Start at position `p = 0` (the rightmost position) and initialize an accumulator variable `sum = 0`.
- Take the bit `b` at the current position. Multiply `b * 2^p` and add the result to `sum`.
- increment `p` and move one position to the left, continuing until you perform the multiplication and addition step on the most sigificant bit.

`110101` becomes, then `1*2^0 + 0*2^1 + 1*2^2 + 0*2^3 + 1*2^4 + 1*2^5`, which is `1 + 4 + 16 + 32 = 53`.

## Converting from Decimal to Binary
Going in this direction, we recommend the following algorithm: starting with the decimal number to convert, and while the quotient is greater than 0, perform integer division, keeping track of the remainder. This is perhaps better explained through example (see the slides for an image version):

1. Start at 157. Divide this by 2 to get 78 remainder 1. 
2. Divide 78 by 2 to get 39 remainder 0.
3. Divide 39 by 2 to get 19 remainder 1.
4. Divide 19 by 2 to get 9 remainder 1.
5. Divide 9 by 2 to get 4 remainder 1.
6. Divide 4 by 2 to get 2 remainder 0.
7. Divide 2 by 2 to get 1 remainder 0.
8. Divide 1 by 2 to get 0 remainder 1, and we're done dividing.
9. Read the remainders in reverse: `10011101`.

We can verify that this is correct:
`10011101 (binary) = 1 + 4 + 8 + 16 + 128 = 157 (decimal)`.

## Encryption & XOR
We can interpret any piece of data as a sequence of bits. Thus, data of all types (ints, doubles, Strings, images, text files, videos, PDFs, etc) are interpretable as binary numbers! We can leverage this interpretation to carefully encrypt the data.

Supposing we have some message `m` that is the binary representation of some String. We can use the bitwise XOR operation, written in Java as `^`, to encrypt `m` using some secret key `k` of the same length as `m`. 

Here is the truth table for XOR:

|x|y|x^y (result)|
|----|----|----|
|0|0|0|
|0|1|1|
|1|0|1|
|1|1|0|

Say that `m = 10111010`, and `k` is a randomly generated bit String of the same length `11011010`:

|String name|||||||||
|----|----|----|----|----|----|----|----|----|
|m (message)|1|0|1|1|1|0|1|0|
|k (random key)|1|1|0|1|1|0|1|0|
|m ^ k|0|1|1|0|0|0|0|0|

Crucially, this process is reversible using the same key for encryption and decryption: 

|String name|||||||||
|----|----|----|----|----|----|----|----|----|
|m ^ k|0|1|1|0|0|0|0|0|
|k (random key)|1|1|0|1|1|0|1|0|
|m ^ k ^ k = m (message)|1|0|1|1|1|0|1|0|


# 2D Arrays

## Declaring and Initializing
Put simply, 2D arrays are arrays of arrays. The syntax for declaring a variable for a 2D array of ints is as follows:

```java
int[][] ages;
```

2D arrays can be initialized implicitly or explicitly, just like how we've used arrays previously:
```java
int[][] ages = new int[3][5];
```
This is implicit initialization, and it results in `ages` being an array containing `3` other arrays, each of which has `5` elements. The result is a 2D array that looks like this:

||||||
|----|----|----|----|----|
|0|0|0|0|0|
|0|0|0|0|0|
|0|0|0|0|0|  


We can use explicit initialization instead:
```java
int[][] ages = { 
                 {3, 4, 6},
                 {1, 2},
                 {0},
                 {5, 6, 7}
                };
```
This results in a _jagged_ array, where not all rows are of the same length. This works perfectly well!

||||
|----|----|----|
|3|4|6|
|1|2||
|0|
|5|6|7|

## Indexing
 By convention in this class, we refer to 2D arrays in _row-major order_, where the first index of the array refers to the "row" number and the second index to the "column". Further, the first row is the top one in the visualizations we've given before. For example, let's visualize the following 2D array:

 ```java
 String[][] seatingChart = {
                              {"Harry", "Eric", "Jules"}, 
                              {"Gian", "Ben", "Michael"}
                           };
 ```

 For the purposes of this class, we'll view `seatingChart` like this:

 ||||
 |----|----|----|----|
 |"Harry"|"Eric"|"Jules"|
 |"Gian"|"Ben"|"Michael"|


Independent of how we view the 2D array in text, we have that `seatingChart[0][0]` evaluates to `"Harry"` and `seatingChart[1][2]` evaluates to `"Michael"`. 

If you are working in a context where the 2D space analogy of rows and columns is not useful, or if this notation is confusion, recall that 2D arrays are just arrays of arrays, and so the following table holds for `double[][] prices`:

|expression|expression data type|data type interpretation|2D analogy interpretation|
|----------|----|-----------------|--------|
|`prices`|`double[][]`|array with elements of type `double[]`|2D array / matrix|
|`prices[i]`|`double[]`|array with elements of type `double`|row `i`|
|`prices[i][j]`|`double`|a single `double`|a single entry at row `i`, column `j`|

## Iteration through 2D Arrays
2D arrays are (I'll write it again!) arrays of arrays, so it makes sense to use nested loops to iterate through them. Presented below is a snippet that's safe to use on both jagged and rectangular 2D arrays. The purpose of the snippet is to go through and print out every entry of the 2D array, although it can easily be adapted for other purposes:

```java
Item[][] itemArr = generateItemArray();

for (int i = 0; i < itemArr.length; i++) {
  for (int j = 0; j < itemArr[i].length; j++) {
    System.out.println(itemArr[i][j]);
  }
}
```

Observe that the inner loop iterates from `0` up to the length of the current row, so jagged arrays are handled automatically without throwing `ArrayIndexOutOfBoundsException`.

# Comparing Objects
When you write a class for a data type, it's possible that the instances of that class can be compared to one another in some reasonable way. One `Student` might be compared to another `Student` based on their first names: `Student ruth` comes alphabetically after `Student prabh` but before `Student xianHan`.

To make it so an object is automatically comparable for the purposes of several built-in Java methods, you must first specify that the class implements `Comparable`.

Specifically, you must have:

```java
public ClassName implements Comparable<ClassName>
```
as the first line of the class definition. Note that because `Comparable` is a generic type, you need to append the `<ClassName>` to the end of it. The reasons why are beyond the scope of the course, you just need to remember that you have to include it for now.

Secondly, now that you've committed to implementing the `Comparable` interface, you need to make sure that your class implements the methods included in `Comparable`. Fortunately, there's only one: `int compareTo(ClassName other)`.

`compareTo` should return:
- a negative int (`-1` by convention) when `this` comes before `other`,
- a positive int (`1` by convention) when `this` comes after `other`,
- `0` when `this` and `other` are equal.

Now you can use the `.sort` methods of `Arrays` or `Lists` of `ClassName` objects to have Java automatically handle the sorting of those collections! -->