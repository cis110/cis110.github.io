---
layout: default
title: CIS 110 Fall 2020 — Introduction to Computer Programming
active_tab: in
---

### [In.java](../assets/example_programs/In.java)

---

#### Motivation

`In.java` lets us read information stored in different files. As long as we know the format of a file, we can parse its contents and programmatically interact with it. The first example we will see of `In.java` is with hw02, NBody, where you will simulate a universe based upon information stored in a separate file containing the radius, positions, velocities, and image files of each of the bodies in the solar system. Crucially, you do not need to know **any** other information other than the format of this file in order to simulate **infinitely many** solar systems with your program.

---

#### Downloading and Using In.java

To use `In.java`, save [In.java](../assets/example_programs/In.java) to the same folder as your program. Once you add it to your folder, you should open it up and compile it.

---

#### Setting up a File Reader

The standard library provides the class `In.java` to support accessing information from a file. Study `StudentsFileProcessor.java`, which is contained in the `nbody_data.zip` you downloaded in Part 0. This file provides an example of reading information from a file. Compile `StudentsFileProcessor.java`, and run it from the Codio Terminal with the argument `students.txt`:

`java StudentsFileProcessor students.txt`

In your program, declare and initialize a variable, `inStream`, as below:

```java
In inStream = new In(filename); // creates a variable inStream of type In to read from the file
```

`inStream` is just a variable name. You could name this variable anything, but for convenience we are giving you the name “inStream” for your file reader variable.

---

#### Reading values from a file

Now that `inStream` is initialized, you can access/read information from it using the following function calls. These functions behave identically to those in `StdIn`. Below, you will see that each value read from the file (accessed via inStream) is immediately stored in a variable (i.e. b, i, d, s).

```java
boolean b = inStream.isEmpty();     // boolean value that is true if there are no more values, false otherwise
int     i = inStream.readInt();     // reads in an int from inStream
double  d = inStream.readDouble();  // reads in a double from inStream
boolean b = inStream.readBoolean(); // reads in a boolean from inStream
String  s = inStream.readString();  // reads in a string from inStream
String  s = inStream.readLine();    // reads in an entire line from inStream
String  s = inStream.readAll();     // reads in the entire file from inStream
```

`inStream` will start reading from the beginning of the file (top left). Each time a function like `readDouble()` is called, `inStream` attempts to read the next (unread) number as a double (an error will occur if it cannot be parsed to a double). The next time a read function is called, `inStream` moves to the next item in the file.

For example, say that a file, `sample.txt`, is as follows:

    4 5

The code snippet

```java
In inStream = new In("sample.txt");
int x = inStream.readInt();
double y = inStream.readDouble();
```

will set variable `x` to 4 and variable `y` to 5.0.
