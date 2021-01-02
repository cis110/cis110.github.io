---
layout: default
title: CIS 110 Fall 2020 — Introduction to Computer Programming
active_tab: runtime-errors-walkthrough
---

- [General Example 1: Reading the stack trace of a runtime error](#general-example-1-reading-the-stack-trace-of-a-runtime-error)
  - [Compile the code](#compile-the-code)
  - [Run the code](#run-the-code)
  - [Understanding the Error Message](#understanding-the-error-message)
    - [1. We start by examining the STACK TRACE.](#1-we-start-by-examining-the-stack-trace)
    - [2. Next, we look to the name of the exception to tell us what actually went wrong.](#2-next-we-look-to-the-name-of-the-exception-to-tell-us-what-actually-went-wrong)
    - [3. Finally, let's look at the Exception Description Java gives us.](#3-finally-lets-look-at-the-exception-description-java-gives-us)
    - [4. Let's summarize what we've learned just from the Exception.](#4-lets-summarize-what-weve-learned-just-from-the-exception)
  - [Fixing the problem.](#fixing-the-problem)
- [General Example 2: Squash one bug, and you find another.](#general-example-2-squash-one-bug-and-you-find-another)
  - [Reading the Exception](#reading-the-exception)
    - [1. We start by examining the STACK TRACE.](#1-we-start-by-examining-the-stack-trace-1)
    - [2. Follow with a look at the EXCEPTION NAME.](#2-follow-with-a-look-at-the-exception-name)
    - [3. EXCEPTION DESCRIPTION](#3-exception-description)
  - [Using Print Statements to Debug](#using-print-statements-to-debug)
- [A Pause to Collect Your Thoughts](#a-pause-to-collect-your-thoughts)
- [Null Pointer Exceptions](#null-pointer-exceptions)
  - [Short and Sweet: NPE by Not Assigning a Value to a Variable.](#short-and-sweet-npe-by-not-assigning-a-value-to-a-variable)
  - [An NPE One Layer Deeper](#an-npe-one-layer-deeper)
  - [NPEs Can Come From Poor Design Choices](#npes-can-come-from-poor-design-choices)

# General Example 1: Reading the stack trace of a runtime error

Here's `Palindromes.java`. It's a file that contains a `main` function for testing & printing, and an `isPalindrome` function that returns `true` when its input String is a palindrome.

Unfortunately, this program is buggy. Let's try to find out what happens when we run it.

```java
public class Palindromes {

    public static void main(String[] args) {
        String input = "hannah";
        if (isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is NOT a palindrome.");
        }
    }

    public static boolean isPalindrome(String word) {
        // base case - can't repeat the step of "peeling off first and last letters"
        // when there's only one letter, e.g.:
        // r a c e c a r
        // X X X ! X X X

        if (word.length() == 1) {
            return true;
        }

        // check if first and last are the same
        char firstChar = word.charAt(0);
        char lastChar = word.charAt(word.length());
        boolean firstAndLastMatch = firstChar == lastChar;

        //if they match, recurse on the string without the first and last letters
        return firstAndLastMatch && isPalindrome(word.substring(1, word.length() - 1));
    }
}
```

---

## Compile the code

The code does compile. That's a good sign, but it doesn't mean that our code _works_, just that it will run.

---

## Run the code

Here's where the error pops up. Before we think too hard about solving it, we should make sure to note that this is a **runtime error**, or a bug in our code that causes an error sometime after the program is compiled and started.

> Runtime errors usually happen when you try to perform some operation on some data that is outside of an acceptable range of values. An example would be trying to call `Math.sqrt(-1)`, since we can't represent the square root of a negative number as an `int`.
> This looks similar to a Type Error, but a Type Error would lead to a compilation error. You have the right data type in general, but the specific value that you're using is invalid.

Our first step on seeing a runtime error like this should be to break apart the message that's printed.

---

## Understanding the Error Message

Here's our error message.

```
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 6
        at java.lang.String.charAt(String.java:658)
        at Palindromes.isPalindrome(Palindromes.java:24)
        at Palindromes.main(Palindromes.java:5)
```

How do we read it?

### 1. We start by examining the STACK TRACE.

> The stack trace is the series of "at statements" printed at the bottom of your exception. It shows the sequence of functions that were called leading up to your error.

We start at the bottom, as this is the first function called. Here that's `main`, which makes sense: `main` is always the entry point to Java programs. We see at the end of the line `(Palindromes.java:5)`, meaning that `main` called another function on line 5. To see what that function is, we look to the next line up.

> The stack trace has the first (outermost) function call at the bottom. Each line number in a line of the stack trace refers to the line where the next function was called. The next function is directly on top of the previous, and the last function to be called before the error crashed the program is at the top of the trace.

The next line up indicates that `main` calls `isPalindrome`. Following the same pattern, we find that `isPalindrome` calls another function on line 24. That function (from the next line up!) is `charAt`. This brings us to the top of the stack trace, and it means that we've found the function call that crashed the program: `charAt`. Moreover, we know that the specific call to `charAt` that crashed the program lives on line `24`.

### 2. Next, we look to the name of the exception to tell us what actually went wrong.

> Exceptions are how Java tells us that we hit a runtime error. We say that exceptions are "thrown" by Java when the underlying bug causes the program to crash.

The name of this exception is `StringIndexOutOfBoundsException`. Let's break it apart to get some insight as to why this exception was thrown.

- `String` indicates that we used a String in a way that led to our error. Something about the way we tried to use or treat the String was a problem.
- `IndexOutOfBounds` is a type of exception thrown when we attempt to index into a sequence (like an array or a String) with an index that's somehow invalid.
- `Exception` confirms what we already know: our program has a bug that causes it to crash.

`StringIndexOutOfBoundsException`, like its array counterpart, is a remarkably common error. Recall that a String is essentially a sequence of `chars` (characters), and that we can index it with `charAt` to ask for the character at a particular position. Like all indexing in Java, indices start at `0`, meaning that `"Harry".charAt(0) == 'H'`, `"Harry".charAt(4) == 'y'`, and trying to ask for an index smaller than `0` or larger than `4` would throw a `StringIndexOutOfBoundsException`.

> If a String `s` has a length of `n`, `i` is a valid index for `s.charAt(i)` if `0 <= i < n`.

### 3. Finally, let's look at the Exception Description Java gives us.

After the name of the exception, Java prints the message: `String index out of range: 6`. There are two especially important components to this message.

- `String index out of range` is a slightly more descriptive way of stating the name of the Exception itself. This confirms that whatever index we gave `charAt` is either too small (`<0`) or too big (`>= length of the string`).
- `6`: This is the index that we tried to pass `charAt`. This narrows down the problem, since `6` could never be too _small_ of an index for `charAt` to accept, only too _big_.

### 4. Let's summarize what we've learned just from the Exception.

We get a `StringIndexOutOfBoundsException` when we attempt to call `charAt` on line 24 inside `isPalindrome`. The index that causes this problem is `6`, which suggests that the String we're calling `charAt` on probably has a length of 6 or less.

## Fixing the problem.

You might already have a sense of how to fix this problem having looked at the code, but it's good to check your assumptions. To do this, we can use Print Statement Debugging carefully placed around the lines where the error occurs.

> Print Statement Debugging: adding print statement(s) to your code to check the values of your data before the program crashes.

We've already narrowed it down that `6` is somehow too large of an index for the String it's called on. Looking at line 24, where the exception occurs, we see:

```java
char lastChar = word.charAt(word.length());
```

Why is `6` too large here? We can add a print statement on the line above to check what the String `word` actually contains, and check how long it is.

```java
System.out.println(word + " has a length of " + word.length());
char lastChar = word.charAt(word.length());
```

This print statement shows us the value of `word` as well as its length. Now, running our program results in the following:

```
hannah has a length of 6
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 6
        at java.lang.String.charAt(String.java:658)
        at Palindromes.isPalindrome(Palindromes.java:25)
        at Palindromes.main(Palindromes.java:5)
```

We still have our same exception printed, but the first line shows the result of our print statement too. It turns out that right before the program crashes, `word` has the value `"hannah"`, which is a String six characters long. Of course, then, `word.charAt(6)` would result in an error, since the index of the last character is `5` instead. Taking a close look at line 24 reveals that ask for `word.charAt(word.length())`, and indexing using the length of the same String will always be a problem. What I should have written instead is:

```java
char lastChar = word.charAt(word.length() - 1);
```

This, of course, is the proper way to get the last character from a String. That character will always live at index word.length() - 1`. Now we can compile the code again and see what happens...

# General Example 2: Squash one bug, and you find another.

This should now be the state of our code.

```java
public static void main(String[] args) {
        String input = "hannah";
        if (isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is NOT a palindrome.");
        }
    }

    public static boolean isPalindrome(String word) {
        // base case - can't repeat the step where there's only one letter
        // r a c e c a r
        // ^ ^ ^   ^ ^ ^
        if (word.length() == 1) {
            return true;
        }

        // check if first and last are the same
        char firstChar = word.charAt(0);
        char lastChar = word.charAt(word.length() - 1);
        boolean firstAndLastMatch = firstChar == lastChar;

        // if they match, recurse on the string without the first and last letters
        return firstAndLastMatch && isPalindrome(word.substring(1, word.length() - 1));
    }
```

Fortunately, this code still compiles. But since we hope that we've solved a bug, we'd also like it to _run_ without crashing. When we run it now, we get the following:

```
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 0
      at java.lang.String.charAt(String.java:658)
      at Palindromes.isPalindrome(Palindromes.java:23)
      at Palindromes.isPalindrome(Palindromes.java:28)
      at Palindromes.isPalindrome(Palindromes.java:28)
      at Palindromes.isPalindrome(Palindromes.java:28)
      at Palindromes.main(Palindromes.java:5)
```

It still crashes! But with a different message than before. We don't have a correct program yet, but at least we have a new kind of problem. This is progress.

> When you discover that your code has a bug, it's usually the case that your code has several bugs hiding on top of each other. You will often solve one problem successfully, like we did, only to discover another underlying issue. Such is programming.

Let's get to work.

## Reading the Exception

### 1. We start by examining the STACK TRACE.

Like before, start with the stack trace from the bottom. Again we see that the first function call is from `main` on line 5. This call goes to `isPalindrome`, which calls the next function on line 28. **Note that before our program crashed at line 24 of `isPalindrome` so we have even more evidence that we fixed the previous bug.** The next function that `isPalindrome` calls is itself, `isPalindrome`. This is a signature sign of a recursive function: a call stack where a function appears repeatedly on top of calls to itself. This pattern repeats until one last call to `isPalindrome`, which then calls `charAt` on line 23. We have two main takeaways from this stack trace: first, we know that the error occurs when the fourth call to `isPalindrome` calls `charAt`; second, we take note that the error occurs only when we're working with a String smaller than the original input `"hannah"` since each recursive call to `isPalindrome` operates on a shorter and shorter String.

### 2. Follow with a look at the EXCEPTION NAME.

The name is `StringIndexOutOfBoundsException` like before. The same conclusions apply:

- `String` tells us that our error is related to using a String wrong.
- `IndexOutOfBounds` tells us that the error is because we tried to use an index outside of the range of the String's length (0 and str.length() - 1)
- `Exception` is a reminder that this is a runtime error.

### 3. EXCEPTION DESCRIPTION

The message that Java prints for us is `String index out of range: 0`. Like before, `String index out of range` means that we used an index that's too small or too big. We used an index that was too big last time, but using a negative number is another obvious way to fail. That being said, Java reports that the bad index value is `0` here. This may strike you as strange, since indices for Strings start at `0`. Thus, `0` should simply be the index of the first character of a String.

## Using Print Statements to Debug

It might not be immediately clear why `0` could ever be an invalid index for a String. Let's try using Print Statement Debugging to get a grasp of what's happening. The statement that we used before should be a good template for this type of problem:

```java
System.out.println(word + " has a length of " + word.length());
```

One issue that we need to address, though, is that we can't simply put the statement in the same place as before. We remember from the stack trace that the error occurs at the line number 23, and our previous spot to test was just after this at line 24. This would mean that anything that gets printed would not reflect the state of the data right before the moment the bug occurs. So, we write the following:

```java
System.out.println(word + " has a length of " + word.length());
char firstChar = word.charAt(0);
```

Compiling and running this program now gives us the following output:

```
hannah has a length of 6
anna has a length of 4
nn has a length of 2
 has a length of 0
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 0
        at java.lang.String.charAt(String.java:658)
        at Palindromes.isPalindrome(Palindromes.java:24)
        at Palindromes.isPalindrome(Palindromes.java:29)
        at Palindromes.isPalindrome(Palindromes.java:29)
        at Palindromes.isPalindrome(Palindromes.java:29)
        at Palindromes.main(Palindromes.java:5)
```

Like before, we have a bunch of printed lines before our program just ends up crashing anyway. This time, we see that this print statement gets called a total of four times, and this matches up quite well with our understanding of the program execution from the stack trace. We saw there four calls to `isPalindrome`, and this output shows us that each call ends up printing the input `isPalindrome` recieves along with its length in characters.

Now, looking at the list of printed outputs before the Exception message is printed: that last line looks weird. Why didn't anything print before `"has a length of 0"`? Looking at the last recursion step, we had `nn` as our input. The recursive step takes the first and last characters off the String and compares them. Since they were the same, the program checks to see if what's left is a palindrome. So what's left... an empty String! It looks like this: `""`. There are no characters inside it, so the index 0 refers to the first character, but there is no first character because an empty string is empty! Aha!

We're trying to use charAt() on an empty string, which just doesn't work. So what do we do? Change our index math so that we don't ask for something invalid? No, we update our base case. Here it is written currently:

```java
if (word.length() == 1) {
    return true;
}
```

Looking at it, it becomes obvious that this is an inadequate base case. When we have an original input String that's even in length, then none of the recursive steps will ever have a length of `1`. Yet, an empty string with a length of `0` is vacuously a palindrome. There's nothing there, and nothing backwards is still nothing. So we fix our base case to handle this type of input and move on!

```java
if (word.length() <= 1) {
    return true;
}
```

# A Pause to Collect Your Thoughts

We had a program with two similar bugs. We used the Exception messages from the crashes, along with cleverly placed print statements, to solve both bugs. The first was a simple mistake of index math, and the second revealed that our choice of base case was clearly not covering all possible outcomes. In both cases, we used information that Java provided us to quickly fix our errors.

# Null Pointer Exceptions
`NullPointerException`, or `NPE` for short, is a runtime error that occurs when a program attempts to dereference a variable that contains the value `null`. It sounds simple enough, and indeed these errors are often easy enough to spot and fix. It's worth noting, though, that `null` has been called a ["billion-dollar mistake" by its designer Tony Hoare](https://en.wikipedia.org/wiki/Tony_Hoare#Apologies_and_retractions) due to the decades of crashes and vulnerabilities it's led to since its implementation. As we begin to work with objects, and therefore references, it will be important to understand the `NPE` when it occurs and how to fix it.

Let's build our defenses against `NPE`s with a few quick examples. Anywhere we use an object or method that we haven't explicitly defined in code, you can assume that it has been reasonably and correctly implemented behind the scenes *without any bugs*.

## Short and Sweet: NPE by Not Assigning a Value to a Variable.
```java
SodaCan pepsi;
pepsi.shakeCan();
```
This first example is a simple look at what happens when you attempt to deference `null`. We declared the variable `pepsi`, but since we didn't assign it a value, it is not a reference to any particular `SodaCan` and therefore we run into trouble when we append the `.shakeCan()` method call to the end of it. Recall that the `.` is the syntax for dereferencing a variable, meaning that `pepsi.shakeCan()` attempts to:
   1. find a variable named `pepsi`, 
   2. follow the reference it contains (i.e. dereference it), 
   3. and then call the method `shakeCan()` that should be available from the `SodaCan` object hopefully found in memory.

This process breaks down at step 2: `pepsi` stores `null`, which means that it can't be dereferenced! You'll get an error like this:
```
Exception in thread "main" java.lang.NullPointerException
        at SodaCan.main(SodaCan.java:2)
```
As annoying as NPEs are, they're usually quite easy to fix. The idea here is that `pepsi` contained a null reference, so let's just replace it with a reference to an actual `SodaCan` using the constructor:
```java
SodaCan pepsi = new SodaCan();
pepsi.shakeCan();
```
The program compiles and runs, now.

## An NPE One Layer Deeper
We have the following two simple classes for a `Course` that's comprised of several `Students`:

```java
public class Student {
    public String name;
    public double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class Course {
    public Student[] roster;
    public int enrollment = 0;

    public Course(int classSize) {
        this.roster = new String[classSize]; 
    }

    public void addStudent(Student s) {
        if (enrollment < roster.length) {
            this.roster[enrollment] = s;
            enrollment++;
        }
    }
}
```

Simple enough. A `Course` is basically just an array of `Student`s with some added functionality on top. We run the following code and get an NPE:
```java
Course cis110 = new Course(350);
System.out.println(cis110.roster[10].grade);
```
```
Exception in thread "main" java.lang.NullPointerException
        at CourseTester.main(CourseTester.java:2)
```
We see that the error comes from line 2. On this line, we're attempting to look at the 11th `Student` in our `Course` and print out their grade. Let's try to see where it breaks down by finding out what was actually `null` when we tried to dereference it.
1. `cis110` is definitely not a `null` variable. We just initialized on the previous line using a constructor that should work just fine.
2. `cis110.roster` is also fine: in the constructor for a `Course`, we will always initialize the `roster` field of the `Course` object we're creating. After line 1, `cis110.roster` is definitely a reference to an array and it itself should not be `null`.
3. `cis110.roster[10]` should refer to the `Student` in position `10` of the `roster` array. That means we're referring to the 11th student, but that should be fine here given that our array was initialized to have a length of 350. 

Step 3 here should give us some pause: sure, it's fine to ask for the value at position `10` in this array, but it's not immediately obvious what that value should be. Recall, now, that when initializing an array how we did in the constructor (`roster = new Student[classSize]`), all of the entries in the array will take some default value that depends on the type of the data. Our data type? `Student`, which like all other objects, defaults to `null` when not initialized.

This means that `cis110.roster[10]` is indeed `null`, and the attempted dereference with `.grade` is what leads to our NPE. Notice that we got several layers deep here, with a null value hiding in a reference from a reference.

> When an NPE appears on a line with several nested dereferences (`this.that.theOther.etc()`), start from the left and work your way through to figure out where the null reference lives.

While an array itself might not be `null`, if the array has been implicitly initialized and has a reference data type, it will be filled with many `null` reference data types to begin with. This distinction will help you reason about NPEs when they appear.

## NPEs Can Come From Poor Design Choices
Our next example relates to a common bug. Imagine that you've spent a lot of time and effort writing your `LinkedList` class, including a `deleteLink(Link l)` method:
```java
public class LinkedList {
    private int size;
    private Link head;
    // methods, and constructors omitted above

    /**
    * deleteLink is a function from the LinkedList class that 
    * deletes a specific Link from a LinkedList and returns 
    * the head of the list with one small bug.
    */
    public Link deleteLink(Link l) {
        if (size != 0) {
            Link tmp = head;
            if (tmp.equals(l)) {
                head = tmp.next;
                return head;
            }
            while (tmp.next != null) {
                if (tmp.next.equals(l)) {
                    tmp.next = tmp.next.next;
                    size--;
                    return head; 
                }
                tmp = tmp.next;
            }  
        }
        return head;
    }

    // fields, methods, and constructors omitted above

}
```
This method implicitly handles four cases:
1. When the `LinkedList` itself is empty, we'll automatically `return head`
2. When the `LinkedList` is not empty and the first `Link` is the one to be deleted, we handle this in the second `if` block and quickly return.
3. When the `LinkedList` is not empty and the first `Link` is not the one to be deleted, we'll keep looking until we find and delete it.
4. If the `LinkedList` never contained the `Link` we're looking to delete, we'll `return head` anyway. Nothing changed.

Let's run the following:
```java
LinkedList list = new LinkedList();
list.addLink(new Link("cat"));
Link result = list.deleteLink(new Link("cat"));
result.printEntries();
```
Oh no! We get another NPE:
```
Exception in thread "main" java.lang.NullPointerException
        at LinkedList.main(LinkedList.java:4)
```
As you may have guessed given the larger amount of code coming before this, we've encountered an NPE that's a little harder to root out. We can start by reading the error message, which tells us that the issue is on line 4. That's the line where we call `result.printEntries()`. We're getting the NPE when we dereference some variable, like always. "But wait!" you may be thinking to yourself, "this time we definitely assigned `result` to have some value." Very astute!

Unlike last time, we've set the `Link result` to be equal to... something. That thing is the result of deleting the `"cat" Link` from our `LinkedList` using the method we already talked about, which should be the `head` link of the `LinkedList`. Perhaps now the error is coming into focus.

Our `LinkedList` only had one `Link` in it, and we just deleted it! That means that the `head` that we return is just `null`. So `list.deleteLink(new Link("cat"))` evaluates to `null`, and we store `null` in the variable `result`. Then, on the next line, we attempt to dereference `result`, leading to the NPE.

The purpose of this last NPE example was to show you that an NPE is often a sign of a bug that lives potentially quite far away from the line that results in the NPE. And furthermore, we didn't write code that's technically _wrong_. Sometimes you'll write methods that can unexpectedly return `null` or modify some object's state so that one of its fields is `null`. 

An interesting corrolary of this example is that there's no one best way to fix this NPE. It's possible to avoid throwing more NPEs like this by checking before an attempted dereference if the value of some variable is `null`: this is quite safe but results in a lot of extra code. Another solution is to modify the method that can return `null`. Perhaps `deleteLink()` should have a `void` return type, which makes a good deal of sense given that its job is to modify state rather than compute a specific value. These are design choices that you can make that help to avoid NPEs.





