---
layout: default
title: CIS 110 Fall 2020 — Introduction to Computer Programming
active_tab: hello_world
---

## Hello World

---

### 1. Getting Started

---

#### Goals

The purpose of this assignment is to introduce you to coding in Java and familiarize you with the mechanics of preparing and submitting assignments. The specific goals are to:

- Familiarize yourself with the course website
- Sign up for Piazza (our class discussion board)
- Learn to use Codio for editing, compiling, and executing programs
- Edit, compile, and execute a simple Java program
- Learn your way around Gradescope (our online submission and grading site)

---

#### Piazza

The class discussion board is hosted on Piazza. If you are not enrolled in the Piazza course, you may sign up [here](piazza.com/upenn/fall2020/cis1102020c).

**Use Piazza to:**

- View all course announcements from instructors
- Ask all questions about course logistics, material
- You may post about errors in your code, but these issues are best addressed in office hours
- If your question is very specific to your code, post privately (just to TAs and instructors) to protect the privacy of your code
- Answer other students’ questions
- Follow questions asked by other students (this may help answer questions you have too)

---

#### Software Setup

We will be using [Codio](https://www.codio.com/) this semester - you should already be enrolled in the Codio course. Please contact the course staff if you are not. 

**Non-SEAS Students: Request your SEAS account [here](https://cets.seas.upenn.edu/answers/account-services.html)**. It usually takes at least 30 minutes for your account to be activated. Even if you do not plan on using the lab computers, you should request an account now. If your own laptop stops working for any reason, you will be relieved to have immediate access to the lab computers. (Per SEAS policy, SEAS accounts are available only to registered students (including P/F), but not to auditors.)

---

### 2. Hello, World!

#### Program Overview and Setup

This part of the homework walks you through completing your first program! Traditionally, the first program anyone writes in a new language just prints, "Hello, World!" to the interactions pane.

- Once you've logged in to Codio, click Courses on the left and navigate to this class. Go to the "My Classroom" tab and select the assignment with the name "Hello, World!"

- On the left, you should see a pane with a list of files. Open the `HelloWorld.java` file. You should update the name and PennKey at the top of the file. Type the following code, **do not copy and paste it** where you see the TO-DO comment, just for practice (it won't take long). If you omit even a semicolon, the program won't work.
  - As you type, Codio will do the indenting for you. 

    ```java
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
    ```

- Click the **Compile** button in Codio's dropdown (on the top) to translate your program into a form the machine (your computer) can execute. If you have any errors (like forgetting a semi-colon), you may get a “compiler” error. You will see the error message in the new terminal window that Codio opens for you. The message will likely be difficult to understand at this stage, but it will tell you exactly which line of code is giving you a problem and preventing compilation. Make sure you typed in exactly the program provided above.
- Once compiled, click **Run Hello World** in the dropdown to run your program. It should print out, "Hello, World!" in the terminal window.

---

### 3. Example Drawing

The cis110 jar file sets up tools to help you draw graphics and play sound (StdDraw and StdAudio) that are very simple to use. For CIS110, however, we will be using a drawing library that we have called `PennDraw`. Before you make your own drawing, you will study our example drawing of a house to understand how the `PennDraw` library works.

To do this part of your HW:

1. Click Compile in the Codio dropdown.
2. Click Run MyHouse in the Codio dropdown.
3. Click View Running Program next to Run MyHouse.
4. You should see a drawing appear in a new window. If so, close the window and continue with the assignment. If not, we'll be happy to help you.

We have provided you with example code in `MyHouse.java` to make sure that drawing is working on your computer. It also gives you some examples of what can be drawn using the PennDraw library. Read the [PennDraw wiki](../resources/penndraw.html) to see what you can draw (i.e. shapes, images, text…) using PennDraw. The wiki page lists all of the functions you can use and explains how to use them.

Open the file `MyHouse.java` in Codio. Ensure that the provided code compiles and runs on your computer. Pay attention to the comments in the code (the text that begins with “//” which appears in green) as they will help you understand what each line of code contributes to the drawing you see.

---

### 4. Your Own Drawing

You will now write your own program which will create a drawing (like the one you saw in `MyHouse.java`).

#### My Sketch Specifications

Create a new file in Codio (File -> New File) and name it `MySketch.java`. Use your HelloWorld and MyHouse programs to guide you in writing this new program. Design and create your own piece of digital art using Java and the `PennDraw` library. Think of yourself as a creative designer when choosing the topic of your design.

**This is your very first program, so here are some guidelines:**

- Make a header section with your name, pennkey etc similar to what you have done in `HelloWorld.java`.
- To begin writing actual code (rather than comments), refer to your `HelloWorld.java` and `MyHouse.java` programs
  - **HINT**: Notice how both files follow the format “public class [name of program]”... and have the statement “public static void main(String [] args)”
- Make sure that it is at least 500 pixels by 500 pixels. The dimensions can vary depending upon your design, but make sure that it is not "small".
- Make use of any of the drawing functions learned in class this week: `PennDraw.setCanvasSize()`, `PennDraw.rectangle()`, `PennDraw.filledRectangle()` etc.
- You are also allowed to (and strongly encouraged to!) use any of the drawing functions that you find on the [PennDraw wiki](../resources/penndraw.html).
- Your sketch should make use of several functions (as this is the point of this assignment! A really "abstract" sketch like a simple circle in the center of the screen will not suffice, as aesthetic as it may seem).
- Build your program up slowly, compiling and testing (making sure it draws what you think it should) frequently as you go.
- Start by adding a few simple shapes to your sketch. Then test your program. Then change the colors. Then test it. Then add some more, and test it. Repeat this process, building your program up step-by-step.
- At each point in time, you should have a completely working program. If you made a small change and broke something, then most likely the problem is in what you just changed. This makes debugging faster and easier.
- Trying to write a bunch of code and then debugging it all at once will result in frustration and a program that is difficult to get working.
- Be creative. Have fun and experiment!
  - (This is not an assessment of artistic ability so don’t worry if art is not your strong suit! Just give it your best effort)

Here are some ideas to get you started:

- A self-portrait
- An avatar or a cartoon of someone
- Your favorite cartoon TV Show character, or design your own...
- A city-scape
- Animal/object caricatures
- A selection from Sistine chapel (just kidding…)

---

### Readme

Every assignment will have an accompanying `readme` file that you will fill out and submit. This is a required part of the assignment and it usually takes only a few minutes. Among other things, the readme is where you can give any comments or feedback you have on the homework.

- In Codio, select `readme_hello.txt` on the left.
- Complete all questions in `readme_hello.txt` and save the file. You will submit it with everything else in the next step.
- **Warning:** Always edit the readme files in Codio.  **Never use Notepad, TextEdit, Word, or any other non-programming editor.** These programs will all corrupt the file, and we won't be able to read your submitted version, which makes it very hard to give points.

---

### Submission

All homework will be submitted to Gradescope. Some time this week, you should have received an email from Gradescope notifying you that you’ve been added to “CIS110 Fall 2020 on Gradescope”. The email contains a link to set up your password. Once you set your password, you will have an account linked to your Penn email (the one which received the email) and you’re all set up to submit. Complete the following steps to submit your HW00 assignment:

- On Codio, download `HelloWorld.java`, `MySketch.java`, and `readme_hello.txt` by right clicking on the file name and selecting Download.
- On Gradescope, under the “Assignments” tab for CIS110 (on the left of your window), select HW00
- Upload `HelloWorld.java`, `MySketch.java`, and `readme_hello.txt`
- Click "Submit" to submit your homework.
- **All program file names should match the required names exactly, including capitalization. Make sure you submit the .java files, NOT the .class files**. Java is extremely picky about file names and capitalization; if your file name doesn't match what we expect, your program will probably fail our automated tests. It may also be a sign that you submitted the wrong file (e.g. HelloWorld.**class** instead of HelloWorld.**java**). You can always re-submit to correct such errors.
- The confirmation page shows you the recorded submission time, which files have just been uploaded, which were previously uploaded, and which have not yet been submitted.
- Read the **Test Output** section carefully. We show you the results of a variety of automatic tests on every homework. Each homework will describe the tests it runs. Usually, we will show you the output of compiling your program (**if you program compiles correctly, there will be no warning or error messages**), a few simple tests, and the results of checkstyle.
- **The tests we run on your submission are not complete, and do not guarantee your program works perfectly.** On some homework, we only show you whether your code compiles and if you have style errors.
- Checkstyle automatically checks your program for conformity to many aspects of our coding style guidelines. It is not exhaustive, meaning that you could receive point deductions for style issues not caught by our style checker. See the "Coding Style" section of the policies for more information.
- **All homework must be submitted through Gradescope.** We cannot accept e-mailed submissions under any circumstances. If you are having issues using Gradescope, visit Office Hours or post on Piazza.
- If you used images in any of your programs, you'll need to submit those image files as well in order for your program to run correctly. For your submission it does not matter what your image files are named, however, the image names that you choose must match those found in your code (i.e. if you call `PennDraw.picture(0, 0, "cloud.png")`, you must include in your submission an image titled "cloud.png").
