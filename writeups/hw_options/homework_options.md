---
layout: default
title: CIS 110 Internal
active_tab: hw_options
---


# CIS 110 TA Homework Instructions

As a CIS 110 TA, you are expected to complete each of the homeworks one week ahead of the students. However, you won't have access to the nice Codio environments that the students have access to. Outlined here are the many different ways we see to complete the homeworks (and to write Java code in general). You are, of course, welcome to write it in any way you want - all that matters is you end up with working Java files.

## Using an IDE
There are many IDEs out there that are built to work with Java, and have built in features such as compiling, running, JUnit, debugging, etc. 

---

### Dr. Java
This is what we used to use in CIS 110, pre-Codio. If you're old enough to have used this as a student, it's nice and simple to use for this purpose as well. If you're not old enough to have used this a student, we don't recommend you bother setting it up now. It has been discontinued and the setup is annoying.

### Eclipse
Eclipse is annoying and confusing and hard to set up, and I don't recommend using it for anything (110 or other purposes). However, Eclipse is the accepted solution for Java code in the majority of classes at Penn, so you'll likely be encouraged to set this up for CIS 120 or CIS 121, or may already have it set up from taking those courses. If you'd like to set it up from scratch, you can follow the [CIS 120 instructions](https://www.seas.upenn.edu/~cis120/21sp/eclipse_setup/).

### IntelliJ
If you want to use a Java specific editor, IntelliJ is the way to go. It has many of the same useful features as Eclipse, but has a cleaner look, is easier to use, and tends to work better. They have both a paid version and an open source version - the open source version is plenty for your purposes (plus it's open source, so that's fun!). They have great setup instructions on [their website](https://www.jetbrains.com/idea/download/#section=linux).

---

## Using Codio
If you'd like to use Codio because it's what you know, or you want to see what students see, there are a few options for you.

### Use the Live Coding Workspace
The Live Coding Workspace in the 110 course will be open from the beginning of the semester, so you're always welcome to do that. When you're looking at the list of assignments, click the 3 dots on the right > Preview to open your own copy.

I'm pretty sure Preview mode doesn't save your work in between sessions, so use this option at your own peril. **We don't really recommend this.**

### Set up your own Project
You can also set up your own Codio project to have the same config as our course ones. It can be a little annoying, so I would probably recommend setting up one project and using that for all 110 things. 

On the left, under "Build", select "My Projects." On the top, select New Project. You will be taken to a page that walks you through the settings.

1. Select your starting point: Below the options, click "Click here" to see more options. Select "browse" next to Empty Stack, and then select "CIS 110 Java Stack."

2. Add some details: You can make the name and description anything you want. We recommend naming this "110 HW Template".

3. Select the visibility: Select private.

4. Select gigabox: Select standard.

At this point, you have the functionality of a basic IDE. There are three more things to set up to have same functionality as our students.
- Upload the [cis110.jar](support_files/cis110.jar), [junit jar](support_files/junit.jar), and [linter.py](support_files/linter.py) files. 
- The config file should look like the below example, with the run buttons changed to be assignment specific.
- The settings file (Codio > Preferences > Project) should have the below lines in the editor section.

#### Config Example

{% raw %}
```
{
    "commands": {
        "Compile": "javac -cp .:junit-platform-console-standalone-1.3.2.jar:cis110.jar *.java",
        "Run LetterViewer": "java LetterViewer",
        "Run LineDrawingTool": "java LineDrawingTool",
        "Run Rivalry": "java Rivalry",
        "Autoformat Files": "python3 linter.py *.java"
    },
    "preview": {
        "View Running Program": "https://{{domain3000}}/"
    }
}
```
{% endraw %}

#### Settings File
Add to the left hand side of the file:
```
tab_size = 4
ruler = 85
```

#### JUnit
If you're doing a homework assignment that has JUnit testing, you'll have to configure the paths yourself. First, for the compile command in the config file, change it to be actual files instead of all java files - this command only works for non-JUnit files. For instance, if I wanted to compile `FingerExercises.java` and `Sierpinski.java`, the command would be `javac -cp .:cis110.jar FingerExercises.java Sierpinski.java`.

Now, for the actual JUnit configurations, navigate to the JUnit tool through Tools -> JUnit. In this pane you can switch between JUnit Settings and JUnit Executions at the top. Settings is where you'll change the settings, and executions is where you'll see the test output. 

On the JUnit Settings, type `cis110.jar` into Library path. In Add Test Case, type the name of one of your test files, click Add Test Case, and then continue that for any other test files. When you're done, click Execute All.

---

## Text Editor + Command Line
This is by far the best option, and has the added benefit that you'll become more comfortable with command line in the process.

### Text Editors

A text editor is a piece of software that lets you edit ascii, or text, files. They can range in complexity but are a different entity than an IDE (Integrated Development Environment) in that an IDE is built to handle all parts of the development process - coding, compiling, running, debugging, testing, etc. A text editor can add plugins to make some of these tasks possible, but their end goal is to be a comfortable place for you to develop.

Some of the most popular text editors today are [Sublime Text 3](https://www.sublimetext.com/3), and [VS Code](https://code.visualstudio.com/), which Jules and I like. Download whichever looks nicer to you.

### Incorporating the Command Line

Because text editors are meant for editing files, you will need to compile and execute your Java files through your terminal. This guide assumes you know how to open, navigate, and use basic terminal commands. If that is not the case, refer to our command line tutorial guide. The following commands will compile and execute a java file:
`javac JavaFile.java && java JavaFile`. The first part, `javac JavaFile.java` is the equivalent of hitting 'Compile' in an IDE - the 'c' means 'compiler'. The second part, `java JavaFile` is the same as hitting 'Run' in an IDE. By combining both commands with `&&` it tells your terminal to first compile, and if compilation succeeds, to execute the file.

### 110 Specific Setup

A lot of our homework depends upon `PennDraw.java` and `In.java`. Rather than figuring out the gross syntax for adding a jar to your compilation path, it's best to just copy those files into your working directory when you are coding for 110. For example, if you want to develop for 110 like I do, this is how you could set up NBody if you had those files in a folder called cis110/standard:

```Shell
Hackett @ cis110/21sp:
$ mkdir hw02 && cd hw02 && cp ../standard/PennDraw.java . && cp ../standard/In.java . && code .
```
Note that the `code .` is a command set up with VS Code that tells VS Code to open a new window in this directory. Just one reason why you shouldn't use Sublime 👀

If you would like to use the jar, you can compile with `javac -cp .:cis110.jar JavaFile.java` and run with `java -cp .:cis110.jar JavaFile`. I have them set up into aliases (c110 for compile 110 and r110 for run 110) so you don't have to remember the "gross" syntax and you also don't have to find the files every time. For these commands to work you will need the cis110 jar in the folder you're currently in (you can set up an alias for this too if you want.)

### JUnit Setup
A few of our homeworks use JUnit tests and you should at least be able to *say* you can run tests, even if you don't actually do it. You'll need the [junit jar](junit-4.12.jar) and the [hamcrest jar](hamcrest-core-1.3.jar) in the directory you're running JUnit from.

In order to compile a JUnit file, use the command `javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar Filename.java`, and to run it use the command `java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore Filename`.

You'll notice that these commands are not fun to remember. I use the following aliases to make life a little easier:

```Shell
alias setjunit='cp ~/Documents/jars/junit-4.12.jar junit-4.12.jar; cp ~/Documents/jars/hamcrest-core-1.3.jar hamcrest-core-1.3.jar'
alias junitc='javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar'
alias junit='java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore'
```

With these aliases, you run `setjunit` once in the folder you're using - note that this assumes the jars are located in `~/Documents/jars/` - and then use `junitc` everytime you want to compile and `junit` everytime you want to run.


### Putting it Together

Once you have downloaded your text editor of choice, your typical development flow will be making a new file in your cis110/homework folder (or similar), navigating there in a terminal and opening the file with your text editor, make changes to the file with the text editor, and regularly compile and run with your terminal commands.

Once you do this a few times (ie on hw01 and hw02 for cis110) you'll find that this is much faster than trying to make a new project environment in Intellij or Eclipse for each 110 hw.

### When NOT to Use Text Editor + Command Line

When you are working on larger projects, ie, larger than 110 homework, it becomes a bit unwieldy to use javac for your Java development. This will be a personal preference, but at some point you will want to swap from text editor + command line to an IDE (IntelliJ) when the components are adequately complex.