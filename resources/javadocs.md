---
layout: default
title: CIS 110 Fall 2020 — Introduction to Computer Programming
active_tab: javadocs
---

## CIS110 JavaDocs

---

Welcome to CIS110’s JavaDocs!  This will serve as a means to document what functions are fair game for student usage to better assist with homework and exam prep.  As always, please direct all questions to Piazza and/or Office Hours!

Notes before reading the docs:

- Functions are the ones that end with parenthesis (), while static values such as `Integer.MAX_VALUE`, `Math.PI` etc. are constants with some value.
- All headers have a JavaDocs reference link if anyone wants to explore more. They will have more functions and values, but we have this doc to highlight the most common ones used in this class.
- Files `In.java` and `PennDraw.java` have their own reference pages linked in the headers.
- Each function call / value has a description with some examples of usage and common errors. They are not exhaustive but just highlight commonly usecases.

---

### [Double](https://docs.oracle.com/javase/8/docs/api/java/lang/Double.html)

---

```java
public static double MAX_VALUE;
```

**Definition:** Maximum value a double can store

**Use Case:**

```java
double x = Double.MAX_VALUE;
double y = Double.max_value; // Error (it’s case sensitive)
```

---

```java
public static double MIN_VALUE;
```

**Definition:** Minimum value a double can store

**Use Case:**

```java
double x = Double.MIN_VALUE;
double y = Double.min_value; // Error (it’s case sensitive)
```

---

```java
public static double NEGATIVE_INFINITY;
```

**Definition:** Representation on negative infinity ($$-\infty$$) in Java

**Use Case:**

```java
double x = Double.NEGATIVE_INFINITY;
double y = Double.negative_infinity; // Error (case sensitive)
```

---

```java
public double parseDouble() {...}
```

**Definition:** `parseDouble()` reads a string and returns a number if it contains one, else throws a `NumberFormatException` if string has no number, or `NullPointerException` if the string is null

**Use Case:**

```java
double x = Double.parseDouble("110"); // returns 110.0
double y = Double.parseDouble("cis110"); // NumberFormatException
String s; // s is null
double z = Double.parseDouble(s); // NullPointerException
```

---

```java
public static double POSITIVE_INFINITY;
```

**Definition:** Representation on positive infinity ($$\infty$$) in Java

**Use Case:**

```java
double x = Double.POSITIVE_INFINITY;
double y = Double.positive_infinity; // Error (case sensitive)
```

---

### [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)

---

```java
public int parseInt() {...}
```

**Definition:** `parseInt()` reads a `String` and returns a number if it contains one, else throws a `NumberFormatException`

**Use Case:**

```java
int x = Integer.parseInt("-110"); // returns -110
int y = Integer.parseInt("cis110"); // NumberFormatException
String s; // s is null
int y = Integer.parseInt(s); // NumberFormatException 
// (NOT a NullPointerException as seen in Double.parseDouble()
// with a null string)
```

---

```java
public static int MAX_VALUE;
```

**Definition:** Maximum value an int can store ($$2^{31} - 1$$)

**Use Case:**

```java
int x = Integer.MAX_VALUE;
int y = Integer.max_value; // Error (it’s case sensitive)
```

---

```java
public static int MIN_VALUE;
```

**Definiton:** Minimum value an int can store ($$-2^{31}$$)

**Use Case:**

```java
int x = Integer.MIN_VALUE;
int y = Integer.min_value; // Error (it’s case sensitive)
```

---

### [Math](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html)

---

```java
public static double abs(double/int a) {...}
```

**Definition:** Takes in a `double` or `int` as argument, and returns absolute value of respective type

**Use Case:**

```java
double x = Math.abs(-3); // returns 3
double y = Math.abs(-245.34); // returns 245.34
int x = Math.abs(-2.3); // Error (type mismatch)
```

---

```java
public static double ceil(double a) {...}
```

**Definition:** Returns the smallest `double` value $$\geq a$$ which is an integer

**Use Case:**

```java
double x = Math.ceil(-5.5); // returns -5.0
double y = Math.ceil(3.2); // returns 4.0
double z = Math.ceil(2); // returns 2.0
int p = Math.ceil(2.4); // Error (assigning double to int)
```

---

```java
public static double floor(double a) {...}
```

**Definition:** Returns the largest `double` value $$\leq a$$ which is an integer

**Use Case:**

```java
double x = Math.floor(-5.5); // returns -6.0
double y = Math.floor(3.2); // returns 3.0
double z = Math.floor(2); // returns 2.0
int p = Math.floor(2.4); // Error (assigning double to int)
```

---

```java
public static double max(double/int a, double/int b) {...}
```

**Definition:** Returns the larger of 2 values. (In case of doubles, +0 > -0)

**Use Case:**

```java
double a = 7;
double b = 3;
double maxVal = Math.max(a, b); // returns 7
```

---

```java
public static double min(double/int a, double/int b) {...}
```

**Definition:** Returns the smaller of 2 values. (In case of doubles, -0 < +0)

**Use Case:**

```java
double a = 7;
double b = 3;
double minVal = Math.min(a, b); // returns 3
```

---

```java
public static double random() {...}
```

**Definition:** Generates a pseudo-random `double` [0, 1) (1 isn’t possible result, 0 is).

#### Change Possible Values

Let’s say we wanted to generate $$[3,\ldots,6]$$ inclusive, as integers, we would do the following:

```java
int x = (int) (3 + Math.random() * 4)
```

More generally for range $$[\texttt{low},\ldots,\texttt{high}]$$:

```java
int range = low + (int) (Math.random() * (high - low + 1))
```

**Other Use Cases:**

```java
double x = Math.random(); // can store in variable
if (Math.random() > 0.5) { ... } // or, can call it directly

boolean b = Math.random() < 1; // ALWAYS true
```

---

```java
public static double PI;
```

**Definition:** Stores the value of $$\pi$$

**Use Case:**

```java
double pi = Math.PI;
double x = Math.pi; // Error (case sensitive)
```

---

```java
public static double pow(double base, double exponent) {...}
```

**Definition:** Returns $$\texttt{base}^{\texttt{exponent}}$$.

*Note Inefficiency* - squaring and cubing should instead be $$x * x$$ and $$x * x * x$$, as `Math.pow()` is inefficient for low powers.

**Use Case:**

```java
double x = Math.pow(-3, 3); // returns -27.0
double y = Math.pow(2, 2); // returns 4.0
double z = Math.pow(4, -1); // returns 0.25
```

---

```java
public static double sqrt(double a) {...}
```

**Definition:** Returns $$\sqrt a$$

*Note:* `Math.sqrt()` of a negative number just gives you `NaN` (Not a Number).

**Use Case:**

```java
double x = Math.sqrt(25); // returns 5.0
double y = Math.sqrt(2); // returns 1.4142135623730951
double z = Math.sqrt(-4); // returns NaN
```

---

### [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)

---

```java
public char charAt(int index) {...}
```

**Definition:** `charAt` returns the character at the specified index of the `String`variable.  Make sure the index is within the bounds of the String!

**Use Case:**

```java
String s = "CIS110";
s.charAt(0); // returns ‘C’
s.charAt(6); // throws IndexOutOfBoundsException
```

---

```java
public boolean equals(Object anObject) {...}
```

**Definition:** `equals` will compare the `String` with another `String` passed into the function and check for equality.  Make sure to use `.equals()` rather than comparing two strings with ==.

**Use Case:**

```java
String s = "CIS110";
s.equals("CIS110"); // returns true
s.equals("CIS120"); // returns false
```

---

```java
public int indexOf(int ch) {...}
```

**Definition:** `indexOf` will return the *first* index that the character (represented as an integer) `ch` appears at in the `String`.  If the character does not appear in the `String`, then `indexOf` returns -1.

**Use Case:**

```java
String s = "CIS110";
s.indexOf('C'); // returns 0
s.indexOf('2'); // returns -1
```

---

```java
public int length() {...}
```

**Definition:** length returns the length of this `String`.

**Use Case:**

```java
String s = "CIS110";
s.length(); // returns 6
```

---

```java
public String substring(int beginIndex) {...}
```

**Definition:** `substring(int beginIndex)` will return a substring of this `String` that begins at the index `beginIndex` and ends at the end of the `String`.  `substring()` is overloaded.

```java
public String substring(int beginIndex, int endIndex) {...}
```

**Definition:** `substring(int beginIndex, int endIndex)` returns a substring of this `String` that begins at the index `beginIndex` and ends at the index `endIndex - 1` inclusive (that is, `endIndex` is not included).

In both cases, if `beginIndex` or `endIndex` are out of bounds of the String’s length, or if `beginIndex` > `endIndex`, `substring()` will throw an `IndexOutOfBoundsException`.

**Use Case:**

```java
String s = "CIS110";
s.substring(3);     // returns “110”
s.substring(2, 5);  // returns “S11”
s.substring(-4);    // throws IndexOutOfBoundsException
s.substring(2, 10); // throws IndexOutOfBoundsException
s.substring(5, 2);  // throws IndexOutOfBoundsException
```

---

```java
public String toLowerCase() {...}
```

**Definition:** `toLowerCase()` converts all the characters in the `String` to lowercase characters.  Don’t worry about non-letter characters, such as numbers and punctuation.

**Use Case:**

```java
String s = "CIS110";
s.toLowerCase(); // returns “cis110”
System.out.println(s) // prints "CIS110" becuase strings are immutable
s = s.toLowerCase();
System.out.println(s); // now prints "cis110"
```

---

```java
public String toUpperCase() {...}
```

**Definition:** `toUpperCase()` converts all the characters in the `String` to uppercase characters.  Again, don’t worry about non-letter characters, such as numbers and punctuation.

**Use Case**:

```java
String s = "cis110";
s.toUpperCase(); // returns “CIS110”
System.out.println(s) // prints "cis110" becuase strings are immutable
s = s.toUpperCase();
System.out.println(s); // now prints "CIS110"
```
