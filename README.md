# Priority Queue Programming Assignment

**Course:** CSC130 - Algorithms and Data Structures  
**Semester:** Spring 2025  
**Instructor:** Dr. Abeer Abdel Khaleq  
**Student:** Farrukh Israilov  
**Points:** 100  
**Assignment:** Heaps and Priority Queues

## 📋 Overview

This Java project demonstrates the use of **heaps**, **priority queues**, and **comparators** by modeling a queue of `Movie` objects with custom priority logic. The user is able to select how the queue should prioritize movies:

- By **recommendation** score (default, using `Comparable<Movie>`)
- By **release date** (using a custom `MovieReleaseDate` comparator)
- By **genre** (using a custom `MovieGenre` comparator)

The program interacts with the user via console input, builds a `PriorityQueue` based on the selected criteria, and demonstrates queue behavior such as insertion, peek, polling, and display.

## 📦 Classes & Structure

### `Movie.java`
- Attributes: `title`, `genre`, `rating`, `releaseDate`, `recommendation`
- Uses `LocalDate` for date handling
- Implements `Comparable<Movie>` based on:
  - Primary: `recommendation`
  - Secondary: `rating`
  - Tertiary: `genre`

### `MovieReleaseDate.java`
- Implements `Comparator<Movie>`
- Compares movies chronologically using `releaseDate`

### `MovieGenre.java`
- Implements `Comparator<Movie>`
- Compares movies alphabetically by `genre`, then by `recommendation` if genre matches

### `Main.java`
- Asks the user to select the queue's priority rule
- Populates the queue with 10 real movie examples
- Demonstrates priority queue operations: `peek`, `poll`, and full display
- Displays movies in a formatted table view

## 📚 Requirements (From Assignment)

1. Use `LocalDate` for release dates — **do not use strings**
2. Implement custom comparison logic in `Movie`, `MovieReleaseDate`, and `MovieGenre`
3. Prompt the user for queue criteria and build accordingly
4. Insert, peek, poll, and display movies in the queue
5. Ensure proper documentation and class separation

## 🔗 Useful Resources

- [Working with Dates in Java 8](https://medium.com/javarevisited/working-with-dates-in-java-8-d04f4b04b4b9)
- [Java `LocalDate` API Docs](https://docs.oracle.com/javase/8/docs/api/index.html?java/time/LocalDate.html)

---

> This project was submitted as part of the course requirements and demonstrates practical use of data structures and sorting mechanisms using Java's built-in `PriorityQueue` and `Comparator` interfaces.