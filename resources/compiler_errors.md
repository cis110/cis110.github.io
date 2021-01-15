---
layout: default
title: CIS 110 Fall 2020 — Introduction to Computer Programming
active_tab: compiler-errors-walkthrough
---

**Note: This will be overwhelming to read at the beginning (and even the middle) of the semester. We leave it as is so that it may be of use to you later in the semester, or a sneak peak into debugging.**

# Compiler Errors

Compiler errors happen when you write Java that's syntactically invalid or features a mismatch in acceptable types. In these cases, Java fails to compile your code and you can't run the most recent version of the program you've written. Let's explore four examples of common sorts of compiler errors and how to solve them.


  - [Example 1: Comparison between an invalid pair of types](#example-1)
  - [Example 2: Case of the missing token](#example-2)
  - [Example 3: A little faster now](#example-3)
  - [Example 4: This one is mysterious](#example-4)
  - [Bonus: What is a compiler error?](#bonus-what-is-a-compiler-error)

## Example 1

### Comparison between an invalid pair of types

```java
public class Palindrome {

    public static void main(String[] args) {
        String input = "hannah";
        if (isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is NOT a palindrome.");
        }
    }

    public static boolean isPalindrome(String word) {
        if (word <= 1) {
            return true;
        }
        // check if first and last are the same
        char firstChar = word.charAt(0);
        char lastChar = word.charAt(word.length() - 1);
        boolean firstAndLastMatch = firstChar == lastChar;

        // if they match, recurse on the string without the first and last letters
        return firstAndLastMatch && isPalindrome(word.substring(1, word.length() - 1));
    }
}
```

Here's our error:

```
Palindrome.java:13: error: bad operand types for binary operator '<='
        if (word <= 1) {
                 ^
  first type:  String
  second type: int
```
We always need to start by reading the error message. Unlike for runtime errors, compiler errors will not feature a stack trace. This is because the code cannot be run as written, and the stack trace is the tool used to help you keep track of which functions were called during the execution of the program. As a result, compilation errors are usually quite brief. 

Let's break the error message down. 
1. First, take note of the line number where the error lives. In this case, it's line 13 of Palindrome.java.
2. We have `error: bad operand types for binary operator '<='` as the general description of the error.
    1. An **operator** is a piece of syntax that represents some mathematical or relational operation. We've seen several examples of these already: `+, -, /, >, <, ==, !=, %`, and so on.
    2. An **operand**, like the argument(s) to a function, is the data that goes into performing the operator's operation. Thus, in the expression `4 + 2`, `+` is the `operator` and `4` and `2` are the `operands`.
    3. Putting this together, `bad operand types for binary operator '<='` is a message telling us that we've tried to use the `<=` operator to compare two values that are of inappropriate types. 
3. The remaining snippet of the error message is an annotation that Java provides to give you some more details about what it thinks went wrong. The most important part to pay attention to here is the print-out of the two types that Java has accused you of trying to compare. Specifically, `first type: String` tells us that the left-hand side of the operand is of type `String` and `second type: int` tells us that the right-hand side of the operand is of type `int`.


To summarize: just from the error message, we know where the error lives in the code, we know that the error is one of bad types for the `<=` operator, and we know that Java thinks we're trying to ask if a `String` is less than or equal to an `int`. Now the failure to compile makes some more sense! It's not valid to compare `"Happy Birthday"` to `38904803`.
 
Now we turn to the code itself. Navigating to line 13, we find the following use of the operand in question:
```java
if (word <= 1) {
```

Indeed, it's easy to see that the value on the right-hand side is an `int`, and a variable named `word` certainly sounds like a `String`. We can go to `word`'s definition to verify that it is a `String`.
  ```java
  line 12:
      public static boolean isPalindrome(String word) {
  ```
`word` is defined as an input argument to the function isPalindrome, and it has type `String`, so we're definitely comparing a `String` to an `int` like Java accused us of doing. 

How do we fix it? We have to think about what we're trying to do on this line. Line 13 is actually the base case to our recursive function, which should be checking to see if the length of the input `word` is at most `1`. If so, `word` is automatically a palindrome. Writing it out here and reiterating to ourselves what the intended purpose of the code was in the first place makes our error plain. The base case depends on the length of the word, so clearly we made a mistake and forgot to use `word.length()` A quick sanity check: `word.length()` returns an `int`, which lets us compare an `int` with... an `int`! Problem solved.

```java
if (word.length() <= 1) {
```
Replace line 13 with the above and verify that the program compiles. Then, you can run it to your heart's delight.

## Example 2

### Case of the missing token
```java
public class Palindrome {

    public static void main(String[] args) {
        String input = "hannah";
        if (isPalindrome(input) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is NOT a palindrome.");
        }
    }

    public static boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }
        // check if first and last are the same
        char firstChar = word.charAt(0);
        char lastChar = word.charAt(word.length() - 1);
        boolean firstAndLastMatch = firstChar == lastChar;

        // if they match, recurse on the string without the first and last letters
        return firstAndLastMatch && isPalindrome(word.substring(1, word.length() - 1));
    }
}
```


Here's our error. Let's read it:

```
Palindrome.java:5: error: ')' expected
        if (isPalindrome(input) {
                               ^
1 error
```
1. `Palindrome.java:5` indicates that the error in question lives on line 5 of `Palindrome.java`. It's important to note that this doesn't necessarily mean that the solution will be on this line itself. This is just as far as the Java compiler gets before it crashes.
2. `error: ')' expected` tells us that Java was looking for a `)` character somewhere in the code that it couldn't find. This is a fairly common type of error, and it should immediately suggest to you that there's some `(` character in your file that doesn't have a matching `)` character. Whenever you use an open parenthesis, Java will expect there to be a corresponding close parenthesis later on.
3. The rest of the message is a printed version of the line in question, with a helpful marker for where Java thinks the missing `)` might have belonged. 

There are two reasons that this error might occur. The first is that the `)` character is indeed missing, and that there's some `(` that belongs in the code that's missing its corresponding close. The second reason might be that you have accidentally included a `(` that never belonged in the first place. In this case, the solution would be to delete the `(` and **not** to add another `)`. In this second case, we are more likely to solve the error by changing a line other than line 5 itself.

Let's start thinking about the problem on line 5
- If statements require an open and a close paren around the condition they're testing
- Calling `isPalindrome` requires an open and a close paren around the input argument
- Counting parentheses, we have...
    - two open parens (good!)
    - one closed paren! (bad)

Looking at the line, it looks like the the if statement is the one that's missing a close parenthesis before the if block starts with the `{` character. So let's try adding the `)` there on Line 5 (which, in this case, is exactly where Java pointed out the error).
```java
if (isPalindrome(input)) {
```
Compile and verify that this fixed the problem.

## Example 3

### A little faster now

```java
public class Palindrome {

    public static void main(String[] args) {
        String input = "hannah";
        if (isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is NOT a palindrome.");
        }
    }

    public static boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }
        // check if first and last are the same
        char firstChar = word.charAt(0);
        char lastChar = word.charAt(word.length() - 1);
        boolean firstAndLastMatch = firstChar == lastChar;

        // if they match, recurse on the string without the first and last letters
        return firstAndLastMatch && isPalindrome(word.substring(1; word.length() - 1));
    }
}
```

The error:

```
Palindrome.java:22: error: ')' expected
        return firstAndLastMatch && isPalindrome(word.substring(1; word.length() - 1));
                                                                 ^
Palindrome.java:22: error: ';' expected
        return firstAndLastMatch && isPalindrome(word.substring(1; word.length() - 1));
                                                                  ^
Palindrome.java:22: error: illegal start of expression
        return firstAndLastMatch && isPalindrome(word.substring(1; word.length() - 1));
                                                                       ^
Palindrome.java:22: error: ';' expected
        return firstAndLastMatch && isPalindrome(word.substring(1; word.length() - 1));
                                                                              ^
4 errors
```
This time we have 4 whole error messages! This might seem like cause to panic, but let's stay calm while we make some observations. First, note that all of these errors actually live on line 22. Second, reading the error messages, we can see that our errors are based on bad syntax (a misplaced character here or there) rather than on bad use of types. Recall from [Example 1](#example-1) that a type error is likely to complain using the word "type" as well as a report of which type(s) you used improperly. 

Having so many *syntax* errors on the same line is often a sign that your problem is a misplaced or incorrect token placed somewhere in that line where it doesn't belong. In other words, the four separate errors might make you think you've made four different mistakes, but this isn't necessarily the case. Let's see why.

Instead of diving in too deeply to all of the error messags, let's make note of the fact that the top error listed marks is also the one that places its "look here for the error" carat farthest to the left in the line. This is usually a good place to start. That carat points to the first semicolon of the line that separates two arguments to the `substring` function:
```java
return firstAndLastMatch && isPalindrome(word.substring(1; word.length() - 1));
```
Wait a minute! Did I just write "the first semicolon of the line"? That's not a good sign, given that semicolons are what we use to terminate lines, and that *commas* are used to separate arguments inside function calls. That should give you an idea of how to fix the error:
```java
return firstAndLastMatch && isPalindrome(word.substring(1, word.length() - 1));
```
Compile and verify.
## Example 4

### This one is mysterious
This last one is perhaps the trickiest to parse from the error message. That also means that it will stick in your head, and you will learn to interpret the mistake from the least information!

Try to compile the following code:

```java
public class Palindrome {

    public static void main(String[] args) {
        String input = "hannah";
        if (isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is NOT a palindrome.");
        }
    }

    public static boolean isPalindrome(String word) {
        if (word.length() <= 1) {
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

The error:

```
Palindrome.java:24: error: reached end of file while parsing
}
 ^
1 error
```
Like I said: this one is mysterious. You kind of just have to know it. The only real hint is that the error hits on line 24, the end of the file.
Claiming that the compiler "reached the end of the file while parsing" is an indication that the compiler thought there should be more code. Java knows when to stop expecting new code by following code blocks, which are delimited with `{` and `}`. This suggests that we didn't end some code block with a `}` character, since Java is trying to parse more code when it hits the end of the file.

To solve this one, go through and click on any open bracket character `{` in your text editor. Codio (or any text editor worth its salt) will highlight its corresponding close bracket. If the text editor can't find the corresponding close, then usually it will mark the open bracket in an "error color" (often red). Make sure that each open bracket has a matching close bracket and that it's the one you expect. It is impossible to understate: **having your code properly indented makes this much easier to do**.

Clicking around in the file reveals that the very first `{` is unmatched, and that all of our other `{` characters seem to have sensible `}` to match them. That means that we can end the file with another `}` to close that first `{` from line 1. Do this, compile, verify, and smile. You've done some good debugging.

## Bonus: What is a compiler error?
Compiler errors happen when Java fails to compile the code that you've written. Recall that the code we write (all of our `.java` files) must be translated into a set of instructions that a computer can execute. This process is called **compilation**, and it must be performed every time you write new code before you can test & run that code. 

Here's a tiny program I can write called `Small.java`. What it does is not important.
```java
public class Small {
    public static void main(String[] args) {
        if (args.length > 2) {
            System.out.println("not small!");
        } else {
            System.out.println("small!");
        }
    }
}
```

When I compile `Small.java`, I get a resulting `Small.class` file. Here's what the contents of that file actually looks like to the computer:

```
CA FE BA BE 00 00 00 34 00 20 0A 00 07 00 11 09 00 12 00 13 08 00 14 0A 00 15 00 16 08 00 17 07 00 18 07 00 19 01 00 06 3C 69 6E 69 74 3E 01 00 03 28 29 56 01 00 04 43 6F 64 65 01 00 0F 4C 69 6E 65 4E 75 6D 62 65 72 54 61 62 6C 65 01 00 04 6D 61 69 6E 01 00 16 28 5B 4C 6A 61 76 61 2F 6C 61 6E 67 2F 53 74 72 69 6E 67 3B 29 56 01 00 0D 53 74 61 63 6B 4D 61 70 54 61 62 6C 65 01 00 0A 53 6F 75 72 63 65 46 69 6C 65 01 00 0A 53 6D 61 6C 6C 2E 6A 61 76 61 0C 00 08 00 09 07 00 1A 0C 00 1B 00 1C 01 00 10 4E 6F 20 73 6D 61 6C 6C 20 6D 61 74 74 65 72 2E 07 00 1D 0C 00 1E 00 1F 01 00 10 54 68 69 73 20 69 73 20 6E 6F 74 68 69 6E 67 2E 01 00 05 53 6D 61 6C 6C 01 00 10 6A 61 76 61 2F 6C 61 6E 67 2F 4F 62 6A 65 63 74 01 00 10 6A 61 76 61 2F 6C 61 6E 67 2F 53 79 73 74 65 6D 01 00 03 6F 75 74 01 00 15 4C 6A 61 76 61 2F 69 6F 2F 50 72 69 6E 74 53 74 72 65 61 6D 3B 01 00 13 6A 61 76 61 2F 69 6F 2F 50 72 69 6E 74 53 74 72 65 61 6D 01 00 07 70 72 69 6E 74 6C 6E 01 00 15 28 4C 6A 61 76 61 2F 6C 61 6E 67 2F 53 74 72 69 6E 67 3B 29 56 00 21 00 06 00 07 00 00 00 00 00 02 00 01 00 08 00 09 00 01 00 0A 00 00 00 1D 00 01 00 01 00 00 00 05 2A B7 00 01 B1 00 00 00 01 00 0B 00 00 00 06 00 01 00 00 00 01 00 09 00 0C 00 0D 00 01 00 0A 00 00 00 48 00 02 00 01 00 00 00 1A 2A BE 05 A4 00 0E B2 00 02 12 03 B6 00 04 A7 00 0B B2 00 02 12 05 B6 00 04 B1 00 00 00 02 00 0B 00 00 00 12 00 04 00 00 00 03 00 06 00 04 00 11 00 06 00 19 00 08 00 0E 00 00 00 04 00 02 11 07 00 01 00 0F 00 00 00 02 00 10
```

It's not legible to a human, but the important part is that it's easy for the computer to read and execute. In order for the compilation step to succeed, the syntax of my `.java` file must be valid and the types that I use must always match up. Think of this like writing valid English, or any human language: in order to have your words be legible to another person, they must be spelled correctly.
