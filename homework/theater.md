---
layout: default
title: CIS 110 Fall 2020 — Introduction to Computer Programming
active_tab: theater
---

# Lights, Cameras, Objects!

### Goals of Assignment

- Reinforce principles of object oriented design.
  - Modularity
  - Encapsulation
  - Interactions between objects
  - State
- Learn to throw and handle exceptions
- Learn to do effective JUnit testing.

___

### Design

In this homework, you will be writing the functionality for your favorite local movie theater. All movie theaters have Movies, Customers, and Reviews for their movies, so we'll be making objects for each of these things.

___

### Testing

#### Motivation

While we've been using println statements in main in previous homeworks, for this homework we're going to use JUnit, which is a industry-grade framework used by companies like Amazon and Google to test their Java code. JUnit is valuable because it lets us maintain enormous test suites that can run automatically and let us know if changes to our code breaks any of our functionality - this becomes super crucial as the projects you'll be making in your CIS career will grow in size and complexity.

#### JUnit Reminders

As a review, JUnit works by comparing expected output to actual output on your functions and object state. Here's an example:

```java
public class ExampleTest {

    @Test
    public void testSumFunction() {
        assertEquals("5 + 6 should be 11", 11, Example.sum(5, 6));
    }

}
```

We can also test to make sure an exception is thrown properly. Using the same setup as above:

```java
   @Test(expected = IllegalArgumentException.class)
    public void testException() {
        SomeClass.readNonnullFile(null);
    }
```

You'll find the following functions from the JUnit library useful:

```java
assertTrue(someConditon);
assertFalse(someCondition);
assertEquals(expectedValue, actualValue);
assertEquals(expectedDouble, actualDouble, deltaValue);
assertArrayEquals(expectedArray, actualArray);
```

#### Running Junit on Codio

In order to run your tests, go to Tools -> JUnit and click the blue "Execute All" button. After you've run them once, you can also click the blue "Re-execute" button. Each test will either say passed or failed - passed means your test worked, and failed means it does not. You can click on a failed test to see more information about the failure.

___

### Disclaimer

There are many different methods to write in this assignment, but each should be solved with a no more than a few lines of code, with a few exceptions. If you find yourself stuck trying to write very long methods, that's a good sign that you should take a break and get some clarification on Piazza or in Office Hours.

___

### Part 1: Review.java

We're going to take a bottom-up approach to making this movie theater. First, we're going to implement the most basic object, which is the Review object. A Review has three properties: a `Movie` object, a `score`, and a `description`. Score is an int that must be in the range of `[0, 100]` inclusive - if it is not, then you should throw an `IllegalArgumentException` with an appropriate error message. This class is what we refer to as a **POJO**, or plain old Java object - it just holds variables and can return their values.

Implement the constructor to store the given values in these fields. Note that there is no `isPositive` parameter - you should say that `isPositive` is true if the score given is at least `70`. Next, implement each of the four getters: `getMovie()`, `isPositive()`, `getScore()`, and `getDescription()`.

Here’s an example of how you would instantiate a Review object.

```java
Review review = new Review(someMovieObject, 80, "Really amazing movie!");
```

*Quick check-in: How does this method fit into our concept of 'Immutability'? Are there any fields that are not fully immutable?*

___

### Part 2: Movie.java

In `Movie.java`, you will be implementing the following methods:

- Constructor
- seen()
- leaveReview(Review review)
- rottenTomatoes()
- hasTicketsLeft()
- getters for the fields

Note: We have implemented two functions for you that you do not need to change or test: `equals()` and `toString()`. These are methods that every object either implicitly or explicitly implements.

Let's break down each part.

#### Constructor

For the constructor, you should be storing the parameters to the instance fields, which are `String name`, `String genre`, `String rating`, `int tickets`, `Review[] reviews`, and `int reviewIndex`. You should initialize the length of `reviews` to be `maxReviews`. These fields respectively represent the name of the movie, what genre the movie is, the rating of the movie (like G, PG, R), the number of tickets left for the movie before it's sold out, an array of reviews that customers have left, and an index variable to help you track where you are in the reviews array.

You will also have to make sure that the movie has a valid `genre` - if the provided `genre` isn't in the static array of valid genres, you will throw an `IllegalArgumentException` with an appropriate error message.

There are some instance fields that are not provided in the constructor - you should initialize these using your best judgment.

Here’s an example of how you would instantiate a Movie object.

```java
Movie movie = new Movie("Memento", "Thriller", "R", 100, 50);
```

#### `hasTicketsLeft()`

Customers can't see a movie if it's sold out. Return `true` if there are still tickets for the movie and `false` otherwise.

#### `seen()`

Every time a `Customer` sees this movie, they will call this function. You should decrement the `tickets`. However, if there are no tickets left, you should throw an `IllegalStateException`.

*Quick check-in: How does this method fit into our concept of 'State'? How about 'Encapsulation'?*

#### `leaveReview(Review review)`

Each `Movie` object should track the reviews that customers leave for it. if the input is `null`, throw an `IllegalArgumentException` - otherwise, add the review to your array `reviews`. The instance field `reviewIndex` will be really useful to you here - you should use that to track where you should put the next review in the array. Note that if there is no space left in your reviews array, you should just return without doing anything.

#### `rottenTomatoes()`

Customers don't want to have to read every review for a movie before deciding if they want to see it. Instead, they should just be able to see the **percentage** of people that liked it when they saw it! To this end, we will be implementing the Rotten Tomatoes approach - we return the number of positive reviews times 100 divided by the number of total reviews. If there are no reviews yet, just return `50`.

Example: Say that there are five reviews for our movie so far, with scores of 25, 50, 60, 80, and 90. In this case, we have 2 positive reviews and 3 negative reviews. In this case, we will return 40, because 2/5 reviews are positive and we want to return the percent of positive reviews.

#### Getters

You should implement getters for the three private variables `name`, `genre`, `ticketsLeft`, and `rating`. We have started these for you.

___

### Part 3: ReviewTest.java

This is going to be our simplest class to test, because it contains fields but has no methods that change its state or interact with other objects. Complete the tests we have started for you in `ReviewTest.java`. You need to implement the `assert` statements in each test.

___

### Part 4: MovieTest.java

For this file, you should test the following:
Make sure your constructor properly initializes your fields. Use your getter methods to help you test this. You should follow the same logic and structure that you used for your `ReviewTest.java` file.

- For any function that returns void (`seen()` and `leaveReview()`), you need to test for **side effects**. That means that you need to make sure that the intended side effects changed your object's state properly, and that it did not improperly change any other fields.
  - **Note: Because no getters were provided for `reviews`, you should ONLY test that there are no unintended side effects. Please do not add any additional getters to the `Movie` class.**
- For any function that has a return value, try to test with at least one edge case as well as a 'normal' case. An edge case is an input or state that might be at the limits of acceptable ranges. For example, testing `rottenTomatoes()` on a movie with no reviews would be an edge case.
- For any function that can throw an error (in this case, the constructor, `seen()` and `leaveReview()`), you must write a test that causes that error to be thrown.

Reminder: If you are using junit to test equality with doubles, you will need to add an additional parameter for a `delta` which represents how far apart the two values can be for the test to pass. For example, if you are expecting 100, you could set the delta to be 0.01 and say `assertEquals(100, function(x, y), 0.01)`.

___

### Part 5: Customer.java

We're now ready to implement our `Customer` object. A `Customer` has a `name` and a minimum Rotten Tomatoes score that a movie has to achieve before they'll be willing to see it, which we call `preferredMinScore`. A `Customer` can also track what movies they've seen using `moviesSeen` and what reviews they've left using `reviews`. You will be implementing the following methods:

- Constructor
- `goodEnough(Movie movie)`
- `seeMovie(Movie movie)`
- `leaveReview(Movie movie, int score, String description)`
- Getters for fields `name`, `reviews`, and `preferredMinScore`

#### Constructor

Initialize your instance fields.

- When initializing your `reviews` and `moviesSeen` array, you should make them both of length `100`.
- If the name parameter is `null` or the empty String, throw an `IllegalArgumentException`.
- Note that there are more instance fields than there are parameters in the constructor. Make sure to initialize all of the fields.

Here’s an example of how you would instantiate a Customer object.

```java
Customer harry = new Customer("Harry Smith", 85);
```

#### `goodEnough(Movie movie)`

A movie is good enough for a customer to see if the movie's rotten tomatoes score is at least their `preferredMinScore`. First, check if the movie is `null` - if it is, then throw an `IllegalArgumentException`. If not, then if the customer decides to see the movie, this method should return `true`, and if the customer doesn’t decide to see the movie, this method should return `false`.

#### `seeMovie(Movie movie)`

If the input movie is `null`, throw an `IllegalArgumentException`. Otherwise, do the following:

- If `moviesSeenIndex` is too large to put a new movie in the array, return `false`.
- If the movie still has tickets left and the customer decides the movie is good enough, then call the movie's `seen()` method, add the movie to the customer's array of seen movies, and return `true`. Otherwise, return `false`.

#### `leaveReview(Movie movie, int score, String description)`

- First, make sure the user has not reviewed this movie before (this is not the same thing as seeing the movie!) If they have or `movie` is null, then you should throw an `IllegalArgumentException`.
- If `reviewIndex` is too large to leave another review, return without doing anything. That means that you should not be adding a review to the reviews array and you should not be leaving a review on the movie object.
- If not, then you should leave a review on the movie object with the given parameters, and save the review in the Customer's array of `reviews`.
- You must make sure the review left on the movie object is the same review in the array of reviews - that is, they should share the same reference in memory. You can make sure that they share the same reference by saving the new Review in a variable called `newReview`. Then, you can add this `newReview` to the customer's review array and (without modifying `newReview`!) also call the Movie's `leaveReview` method with `newReview` as the input.

#### Getters

Now implement the four getters we have outlined for you.

___

### Part 6. CustomerTest.java

Follow the guidelines from part 4 to write CustomerTest.java. Again, be sure to test the constructor and all methods on both typical inputs and edge cases.

___

### Part 7. BoxOffice.java

We have now finished implementing all of our lower-level objects and are ready to tackle the `BoxOffice` class. Running a movie theater is all about marketing, so our `BoxOffice` object is going to be in charge of tracking the best movies based on their reviews. First, let's implement our constructor.

#### Constructor

The constructor for a `BoxOffice` object should save the theater name and initialize the `bestMovie` and `secondBestMovie` fields to be `null` for now.
We also want to track the total number of movie theaters that are created, so update the static `totalTheaters` field as well.

#### `marketing(Movie[] allMovies)`

This is where we will do the work to figure out what movies we're going to be advertising. Note that this is a `private` method. From the perspective of a user of the class, they will be calling either `bestNewRelease()` or `secondBestNewRelease()`. Both of those functions will use this function, but no user will ever call this function by itself. Because of that, we are going to hide it to keep things simpler for the user. This is an aspect of abstraction as well as encapsulation.

- First, make sure that `allMovies` isn't `null` and has at least `1` movie. If it doesn't, throw an `IllegalArgumentException`.
- Then, find the two movies with the two highest averages based on how we defined our scoring function in the `Movie` class (be sure to use functions we already wrote!) and update `bestMovie` and `secondBestMovie` accordingly.
  - Note that if there are ties, you should use the first movie with that score. That is, if the second best movie has a score of 90, and then you find another movie with a score of 90, you wouldn’t change your second best movie.
- Note: If `allMovies` only has one movie, you should not throw an exception - instead, you should store that value in `bestMovie` and `secondBestMovie` should be `null`.

#### `bestNewRelease(Movie[] allMovies)` and `secondBestNewRelease(Movie[] allMovies)`

First, make sure that `allMovies` isn't `null` and has at least 1 movie. If it doesn't, throw an `IllegalArgumentException`. Reviews for movies are always updating, and we don't want to get out of date on what movies we should be advertising. When someone calls `bestNewRelease` or `secondBestNewRelease`, you should re-do your marketing calculations on the provided movies. Then, you can return the best or second best movie, respectively.

___

### Part 8. BoxOfficeTest.java

Follow the same guidelines from part 4 to write this file. Again, you will be testing the constructor and all methods, and be sure to use both normal and edge cases.

___

### Submission

Please upload all of your `.java` files and your readme to Gradescope for submission.
