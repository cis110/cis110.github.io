---
layout: default
title: CIS 110 Fall 2020 — Introduction to Computer Programming
active_tab: caesar
---

## Hail, Caesar!

---

### Goals

The goals of this part of the assignment are to practice using functions, arrays, and strings in Java, as well as to learn about the field of cryptography. The specific goals are:

- To write and use functions, and understand the use of helper functions
use and manipulate arrays
- Learn about String manipulation and ASCII encoding
- To become acquainted with cryptography

At the end of the assignment, you will have a program that can encrypt, decrypt, and crack the Caesar cipher!

---

### Background

Cryptography is the study of secure communications and secret codes. It helps you, say, send a secret message across enemy lines, knowing that even if the message is intercepted, it could not be read. People have been using ciphers (encrypted messages) for thousands of years, but only in the last century have computers come into the field. One of the oldest ways to hide a message is to use a substitution cipher. One classic example of a substitution cipher is the Caesar cipher, named after the first recorded (and most famous) user, Julius Caesar. If you'd like to learn more about the Caesar cipher, you can check out the [wikipedia page](https://en.wikipedia.org/wiki/Caesar_cipher) to read about its history and usage.

![caesar_img](hw03_base/caesar.jpg)

*Julius Caesar*

---

### Understanding the Problem

The Caesar cipher is a basic encryption technique where all letters in a message are shifted down the alphabet by a certain number (determined by the key). In order to encrypt or decrypt a message, you will need a secret key that should, in practice, be hard to find if you don’t already know it. In the Caesar cipher, the key is the number of places to shift each character. This number could be specified numerically (e.g., 4) or it could be specified as a character (e.g., 'E' -- which is 4 places over from 'A').  For simplicity, we typically convert the entire message to uppercase, and may omit punctuation.

For instance, consider the message (and famous Julius Caesar quote): "CAESAR’S WIFE MUST BE ABOVE SUSPICION" and the key "E", which says to change each letter in the message to the letter four places to the right in the alphabet. For example, 'C' becomes 'G', 'A' becomes 'E', etc. Note the letter 'W' in "WIFE", when shifted four down, goes beyond 'Z'. This is handled by wrapping back to the front of the alphabet, and so 'W' becomes 'A'.

In total, the message becomes:
GEIWEV'W AMJI QYWX FI EFSZI WYWTMGMSR

---

### Program Requirements

By the end of this assignment, you will have a `Caesar.java` program which takes in command line arguments that will tell it whether to:

- Encrypt a message using a particular key
- Decrypt a message using a particular key, or
- Crack an encrypted message, giving us back the secret key

The message will be stored in a file, which will be read by the program.
To encrypt the message stored in `plaintext.txt` with a key of 'G', you would call
`java Caesar encrypt plaintext.txt G`
To decrypt the message stored in `cipher.txt` with a key of 'G', you would call
`java Caesar decrypt cipher.txt G`
To crack the message stored in `cipher.txt`, you would call
`java Caesar crack cipher.txt english.txt`
`cipher.txt` and `plaintext.txt` are not files that we provide. You must construct them on your own. `plaintext.txt` can be any message whereas cipher.txt should be the output of a `plaintext.txt` once it has been encrypted.

---

### Getting Started

Codio should contain `Caesar.java`, which is the file you will be writing all of your code in. It also contains three text files: `english.txt`, `encrypted_message.txt`, and `readme_caesar.txt`. If you need the originals again, download the [base folder](hw03_base/base.zip).

---

### Helpful Tips
- If you want to print out an array, you won't be able to print the array itself. You need to create a loop and print each element of the array.
- Printing and returning are **NOT** the same thing. Printing is a side effect of your program, whereas a return statement allows your output to propagate back to where you originally called the function, at which point you can save and use that value for whatever you’re doing. 
`return null;` is just a dummy return statement to make the starter files compile. You should replace them when you implement the functions.

---

### Low-level Functions

#### Understanding the Representation

Before we begin encrypting messages, we first need to decide how to represent a message in our program. The obvious choice would be to store them as a String. This would certainly work, but may not be the easiest approach.

Instead, we will represent the message as an array of integers, where each integer is a symbol in the message. All English letters will be represented by their place in the alphabet. For instance, "C" is the third letter in the alphabet, and so would be represented by a 2. Remember, computer science loves zero-indexing, so the first letter, "A", would be 0. The word "CONSUL" would be represented as [ 2, 14, 13, 18, 20, 11 ].

---

Recall that Java already encodes characters as integers using ASCII:

![ascii_table](hw03_base/ascii_table.png)

---

There is no need to memorize the table above, since we can easily uncover the integer encoding via casting. For instance, take a look at this code snippet:

```java
char letter = 'A';

// cast letter to an integer as encoded by ASCII
int asciiRepresentation = (int) letter;

// will print out 65
System.out.println(asciiRepresentation);
```

We could certainly use the innate ASCII values of characters to encode characters as integers in this program, but the math is a bit easier if we instead represent 'A' as 0 instead of 65. We can perform one operation to convert from ASCII encoding to our method of symbol encoding in which ‘A’ is represented as 0 instead of 65. We can simply subtract or add the character 'A':

```java
char letter = 'C';

// cast letter to an integer as encoded by our representation
int ourSymbolRepresentation = (int) letter - 'A';

// will print out 2
System.out.println(ourSymbolRepresentation);
```

We can easily recover the original character simply by adding 'A' to it:

```java
int ourSymbolRepresentation = 2;

// will become 'C'
char letter = (char) (ourSymbolRepresentation + 'A');
```

Make sure you fully understand this operation and why we use it before moving on to the next section.

---

### Program Structure Outline

Recall that functions allow us to intelligently break up our program into a collection of logical units that we can develop and test independently. We can often identify these major units by considering the high level structure of our program and what we will need to do.

Recall that your Caesar program must take in command line arguments that will tell it whether to

- Encrypt a message using a particular key
- Decrypt a message using a particular key, or
- Crack an encrypted message, giving us back the secret key

The message will be stored in a text file, which will be read by the program.
Based solely on this description, we can see that we will need at least three functions:
`encrypt()`, `decrypt()`, and `crack()`.

The `main()` will then serve as the overall control for our program. (As always), the  `main()` will run before any other part of the program is executed.  `main()` is where we will handle reading command line arguments, reading in the text from the file, and calling the appropriate functions (to encrypt, decrypt, crack, etc) located elsewhere in the program.

We can also see that many of these functions will need to convert between text (characters) and the integer symbol encoding, and handle the shifting (see section 0.C to review what we mean by shifting). In fact, these procedures are likely to be so common that we should make helper functions, additional functions that complete a smaller task, which can be used by other functions.

For example, our basic encryption/decryption process will need to:

- take in text as a String and convert each character in the string into our symbol encoding
- shift those encoded characters either right (to encrypt) or left (to decrypt)
- convert the encoded characters back into text for output (String)

Our task will then be to write functions for each of these major tasks (which we can do and test independently), and then combine those functions together into a working program.

---

### Converting To and From Symbol Arrays

We will first tackle the lowest-level functions to handle encoding/decoding of strings by writing two functions: one to convert from a `String` to our symbol representation (an array of integers), and one to convert from our symbol representation (an array of integers) back to a `String`:

```java
/*
 * Description: converts a string to a symbol array,
 *              where each element of the array is an
 *              integer encoding of the corresponding
 *              element of the string.
 * Input:  the message text to be converted
 * Output: integer encoding of the message
 */
public static int[] stringToSymbolArray(String str) { ... }

/*
 * Description: converts an array of symbols to a string,
 *              where each element of the array is an
 *              integer encoding of the corresponding
 *              element of the string.
 * Input:  integer encoding of the message
 * Output: the message text
 */
public static String symbolArrayToString(int[] symbols) { ... }
```

Note: you need to use `str.toUpperCase()` before converting to a symbol array. This will simply make all alphabet characters become uppercase. This returns a new `String`, so you must say `str = str.toUpperCase()`.

`stringToSymbolArray()` should initialize an integer array of the correct length, iterate through each character in `str` to fill in the compartments of the array with the encoded integer value corresponding to each character in the string. Recall that you can use `str.charAt(i)` to find the `i`th character in `str` and your knowledge of ASCII to make the conversion from char to the corresponding encoded integer.

Test this first function by writing a bit of test code in your `main()` function to call `stringToSymbolArray("CONSUL")` and check that the function call returns the array `[2, 14, 13, 18, 20, 11]`. Try a few other test cases. Once you're convinced the function is working, move on to write `symbolArrayToString()`.
`symbolArrayToString()` should take an `int[]` (integer array) where each element is the encoded integer value for the corresponding letter. The structure of this function is similar to `stringToSymbolArray()`, except it reverses the process.

Again, write code in `main()` to test `symbolArrayToString()`. Since you know that `stringToSymbolArray()` is working, your test code can use this function to encode a simple string, and then use `symbolArrayToString()` to decode it. If it works correctly, you should get back the same simple string you encoded. Test your code until you're convinced both functions work.

---

#### Shifting Symbols

The next step is to write a function to handle the shifting required to encrypt messages. This is the method in the base file with the method header of:

```java
public static int shift(int symbol, int offset)
```

If symbol is an English letter (with an encoded integer value between 0 and 25), then it should be shifted down the alphabet by `offset` amount (an integer between 0 and 25). Remember to wrap symbols that go off the alphabet (‘W’ shifted by ‘E’ should return 0 representing ‘A’)! If you are confused and think it should return 'B', keep in mind that we zero-index our offsets. 'A' is a shift of 0, so 'E' is a shift of 4.

If `symbol` is not between 0 and 25, meaning it is some sort of whitespace or punctuation, then it should just be returned as is. (In our implementation, punctuation is not encoded and does not change during the encryption/decryption process.) We do this so all whitespace and punctuation is simply ignored in our encryption and decryption process. *Hint: Modulo (%) will be helpful here!*

Remember to write an appropriate header comment for your `shift()` function (as well as your other functions going forward).

---

#### Unshifting Symbols

We also must handle the unshifting (i.e., left shifting) of characters when we need to decrypt an already encrypted message. This function has the following method header in your `Caesar.java` file:

```java
public static int unshift(int symbol, int offset)
```

This should simply undo the shifts done by `shift()`. Try thinking about how you will do this and do some examples before writing any code! Also, try to think how you can very easily do this by building on code you've already written.

You should now take some time to test `shift()` and `unshift()`.
A great way to do so is to run the output of `shift()` as input to `unshift()` - for example, `unshift(shift(3, 5), 5)` should be 3.

---

### High-Level Functions

Now that we've created functions to handle the encoding/decoding and shifting/unshifting of our messages, we can focus on the three high-level functions in our program outline:
`encrypt()`, `decrypt()`, and `crack()`.

Once we write these functions, the `main()` will then serve as the overall control for our program, calling one of the three functions above as indicated by the given command-line argument.

We will start by defining encrypt()...

---

#### Encrypt

Using the functions you have already written, you should implement the function with the method header in your code of

```java
public static String encrypt(String message, int key)
```

The basic operations carried out in the function should be:

- Convert the message to an array of encoded symbols (which we represent as ints)
- For each symbol in the array, shift it by the given offset
- Return a String version of the encrypted symbol array

**Note: It is VERY important that your program take in the numerical representation of the key, and NOT a character. If you do not do this, you will fail most of the tests we provide.**

From the above description, we can see that a message is considered “encrypted” once it has been encoded into integer symbols, shifted, and converted back to a String representation. Once this is done, you should be able to test `encrypt()` in `main()` and be able to encrypt the string, "ET TU, BRUTE?" using 6 (letter G) as the offset to get "KZ ZA, HXAZK?". Be sure to write comprehensive header comments for the function, and test it thoroughly (try encrypting other strings with various offsets and analyze the output) before proceeding to the next part.

---

#### Decrypt

Now that you can encrypt your message, you need to be sure you can decrypt it. Write the decrypt function, which has this method header in your file:

```java
public static String decrypt(String cipher, int key)
```

The structure of this function is very similar to `encrypt()`, but instead of using `shift()`, you should be using `unshift()` and then you must decode the unshifted symbols before converting back to a string.

Once this is done, you should be able to use `decrypt()` in `main()` with "KZ ZA, HXAZK?" and 6 (letter G) as the key to obtain "ET TU, BRUTE?"

You should add some code in `main()` to test it. At this point, if you run a String through `encrypt()` and then `decrypt()`, the output should be the same as the input String.

Here is a sample test that you can use for reference. Please write your own test.

```java
String message = "I AM CONSTANT AS THE NORTHERN STAR";
String cipher = encrypt(message, 6);
String decrypted = decrypt(cipher, 6);
System.out.println(decrypted); // should be the original message (in upper case)
```

---

#### Reading From a File

Once you are confident that `encrypt()` and `decrypt()` are working, you should comment out anything you’ve written in your `main()`. In order to obtain the message you will be encrypting you will need to read in data (the message) from a file.

Look back at your `NBody.java` from last week and make use of `In inStream` to do this.

- HINT: The function that will be most helpful is `inStream.readAll()` which returns the entire text of the file as a String.

Write code in `main()` to:

- Handle the command line arguments
- Load the specified text file
- Call the appropriate function to encrypt/decrypt/crack the message
- Print out the result

Before you move on to the next part, you should be able to run the following operations. For this testing, you will need to create a text file with a message of your choice. Once you encrypt the message, add the encrypted output to the same text file or another. Call decrypt (see command line example below) with the text file containing the message you encrypted and see if you get the original message you created.

To encrypt a message in `filename.txt` using the symbol value of 6 (character G):

```java
java Caesar encrypt filename.txt G // (filename.txt is not a file we provide)
```

To decrypt the message in another file `filename_two.txt` using the symbol value of 6 (character G):

```java
java Caesar decrypt filename_two.txt G // (filename_two.txt is not a file we provide)
```

If you’d like a refresher on command-line arguments or reading from a file, you can look back to the [NBody writeup](nbody.html#2-command-line-arguments). You should test your functions before moving forward. You can test by creating a test file called `message.txt` and put some English sentences in it. Run `encrypt()` on this file through the command line, saving the output to a new file called `test_encryption.txt`, and then run `decrypt()` on that through the command line. If you get back the same original message, then you're probably in a good place to keep moving forward.

---

### Cracking the Cipher

#### Understanding the Process

The first recorded instance of a systematic breaking of the Caesar cipher came from Al-Kindi in Mesopotamia in the 9th Century: almost 1000 years after Caesar’s death!

Now that you have worked out encoding, decoding, encrypting, and decrypting messages, we will add one more step to reach the final goal of cracking the Caesar cipher. This final step involves letter frequency analysis. This simply means you will be taking a text or String and counting how often each letter in the alphabet appears throughout the text. English text will have lots of "E"s and "A"s, while an encrypted cipher may have an unusually high number of "X"s or "B"s.

---

#### Letter Frequency Analysis

Before you can analyze the Caesar cipher text to crack it, you will need the frequency with which the 26 letters in the alphabet appear in the English language. We have given these frequencies for each letter in `english.txt`. The first line will have the frequency of the letter ‘A’, the second ‘B’, and so on. You should take a look at the file, and note that it has **26** lines.

Implement the function `getDictionaryFrequencies()` that takes as input the name of the file containing frequencies to be read and returns a double array with the frequencies contained in that text file. The 0th element in the array should be the frequency of ‘A’, the 1st should be the frequency of ‘B’, and so on.

Once you have the frequencies of characters in English it is time to obtain the frequencies in the cipher text file. In order to do this, implement the function `findFrequencies()`. The input will be the int array representation of the cipher text and it should return a double array where the 0th element in the array is the frequency of ‘A’ in the ciphertext, and so on.

To find the frequency of each letter, first find the number of times each letter appears in the ciphertext. Then, divide all of these numbers by the total number of letters in the ciphertext. **Ignore any non-letter symbols.**

Write code in `main()` to test your functions. (Hint: Make a simple string with a known letter frequency, encode it, and make sure your `findFrequencies()` gives you back the appropriate frequency counts.)

---

#### Scoring the Frequency

The next step in cracking the cipher will be scoring the frequencies you found in the last step. This is done by finding the absolute value of the difference between each letter in the ciphertext frequencies and its corresponding letter in the English frequencies. To do this, find the absolute value of the difference between the frequency for each letter in the cipher text and for the corresponding English frequency for that letter.

For example, given an array for frequencies of A, B, and C in a message as [ 0.2, 0.1, 0.0 ] and the English language frequencies are [ 0.1, 0.1, 0.05 ]. The total score of the messsage's frequencies would be:

$Math.abs(0.2 - 0.1) + Math.abs(0.1 - 0.1) + Math.abs(0.0 - 0.05) = 0.15$

This score essentially tells us how well the letter frequency in the message matches what we would expect if the message were in English, rather than encrypted. The lower the score, the closer the message is to decrypted English. We can use this later to crack the Caesar cipher by trying different keys and picking the one that gives us the lowest score!
Implement the function `scoreFrequencies()` that takes in two frequencies arrays, `english` and `currentFreqs`, and returns the difference between each value pair in the arrays, as described above.

---

### Crack

Now for the fun part! You should be writing a function called `crack()` to perform these steps outlined below. **Note that this function header has not been provided for you in `Caesar.java` and is something you must write yourself**. We'd like you to think about what the inputs to this function should be, what it should return, and whether you'd like any other functions to help you out. There are several correct ways to do this, so really think about the benefits and drawbacks to your design!

The written decryption and encryption code allows us to be able to hide and decipher cool messages but what if we don’t know the key? In order to crack a cipher with an unknown key we can guess the key via brute force until we find the correct one. We will implement this in `crack()`.

One method to do this is to try to decrypt the cipher message with all possible keys (‘A’ through ‘Z’). At each decryption find the frequencies of the letters in our newly decrypted message and use this to determine the frequency score (using `scoreFrequencies()`). You want to find which key will give us a message that looks most similar to English, so its frequency score should be the lowest among all keys.

*Finding the minimum score key will be a similar process as finding the minimum value in an array, so looking back at that example from lecture and recitation may be helpful.*

Once you’ve tried decrypting with all possible keys, return the message found using the key with the lowest score. This should be the original message!

---

### Final Touches

Once you have written `crack()`, you should add code to your main so that you can run `Caesar.java` using:

```java
java Caesar crack cipher.txt english.txt
```

Note `cipher.txt` is not a file that we provide. It is an example of a generic cipher. See `encrypted_message.txt` below for a test case

This command will crack the cipher in `cipher.txt`, using the letter frequencies stored in `english.txt`, which your program must also load. **It should print out the cracked message.**

Once you have this working, and tested `crack()`, you have a program that can encrypt a message, decrypt it with the key, and break encryption. You've just cracked Caesar!

Try out your program by cracking the provided file, `encrypted_message.txt`. Put the answer to this in your `readme_caesar.txt`.

---

### Extra Credit

```
RSA XLEX CSY LEZI GSQTPIXIH XLI GEIWEV GMTLIV (ERH GER VIEH XLMW IBXVE GVIHMX HIWGVMTXMSR!), XVC E FMKKIV GLEPPIRKI!

EW IBXVE GVIHMX, MQTPIQIRX E TVSKVEQ XS IRGVCTX ERH HIGVCTX QIWWEKIW YWMRK XLI ZMKIRIVI GMTLIV.  XLI ZMKIRIVI GMTLIV YWIW E WIVMIW SJ HMJJIVIRX GEIWEV GMTLIVW XS IRGVCTX XIBX, FEWIH SR XLI PIXXIVW SJ E OICASVH.  PSSO MX YT SR AMOMTIHME JSV HIXEMPW EW XS LSA XLI ZMKIRIVI GMTLIV ASVOW. (WSVVC, FYX AI GSYPHR'X HMVIGXPC MRGPYHI XLI PMRO, WMRGI XLMW IBXVE GVIHMX XIBX MW IRGVCTXIH!)

AVMXI E TVSKVEQ XS IRGVCTX ERH HIGVCTX QIWWEKIW YWMRK XLI ZMKIRIVI GMTLIV.  CSYV TVSKVEQ WLSYPH FI REQIH "ZMKIRIVI" (FYX MR GEQIP GEWI, RSX EPP YTTIVGEWI) ERH MX WLSYPH JSPPSA E GSQQERH PMRI MRXIVJEGI WMQMPEV XS XLI GEIWEV TVSKVEQ.  XLI SRI HMJJIVIRGI MW XLEX MRWXIEH SJ XEOMRK MR E PIXXIV EW XLI OIC, MX AMPP EGGITX ER IRXMVI ASVH.  JSV ER IBXVE GLEPPIRKI, XVC GVEGOMRK XLI ZMKIRIVI GMTLIV.

KSSH PYGO!
```

---

### Submission

Submit `Caesar.java` and `readme_caesar.txt` on Gradescope.

Important: Your code will automatically be tested for correctness when you submit and display a score out of 35 points. This will account for 60% of your grade for the assignment. We don't display details on failing tests, but please use the title of the tests as a hint for how to correct your code. If you encounter any autograder-related issues, please make a private post on Piazza.
