package dev.maxbenin;

/**
 * Demonstration of O(n!) Factorial Time Complexity
 *
 * O(n!) algorithms grow extremely fast and are typically impractical for large inputs.
 * Common examples include:
 * - Generating all permutations of a set
 * - Certain combinatorial problems
 */
public class ExponentialComplexity {
    public int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}