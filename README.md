# 📊 bigO-snippets

**Java code snippets to visualize and understand Big O complexities in practice.**

This is a Maven-based Java project that provides practical examples to demonstrate the performance impact of different algorithmic complexities — from O(1) to O(n!), including sorting, recursion, and nested loops.

## 🚀 Why this repo?

Understanding **Big O notation** is essential to writing efficient code. This repo helps you:

- Visualize how algorithm complexity scales with input size.
- Identify and avoid performance bottlenecks.

## 📂 Examples Included

- `O1Access.java` – Constant time
- `OlogNBinarySearch.java` – Logarithmic time
- `ONLinearSum.java` – Linear time
- `ONLogNSort.java` – N log N complexity (sorting)
- `ON2NestedLoop.java` – Quadratic time
- `O2nExponential.java` – Exponential growth
- `ONFactorial.java` – Factorial complexity

## ▶️ How to Run

This project uses **Maven + Java 21**.

To compile and run:

```bash
mvn clean compile exec:java
````

Make sure the class `Main.java` is configured as the entry point (as per `exec-maven-plugin`).

## 🧪 Running Tests

```bash
mvn test
```

This repository supports the examples in the article:

**👉 [Java & Big O: Part 1 — From Theory to Milliseconds ⏱️](https://www.linkedin.com/pulse/java-big-o-from-theory-milliseconds-max-benin-stawf)**

**👉 [Java & Big O: Part 2 — The Painful Complexities You Should Avoid 😰](https://www.linkedin.com/pulse/java-big-o-from-theory-milliseconds-max-benin-stawf)**


---

🔗 My [LinkedIn](https://www.linkedin.com/in/maxbenin/) for more content on Java performance and software engineering.
