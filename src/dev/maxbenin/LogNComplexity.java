package dev.maxbenin;

import java.util.Arrays;

/**
 * Demonstration of O(log n) Logarithmic Time Complexity
 *
 * O(log n) algorithms reduce the problem size by half in each step.
 * Common examples include:
 * - Binary search
 * - Binary tree operations
 * - Certain divide and conquer algorithms
 */
public class LogNComplexity {
    /**
     * Performs binary search on a sorted array - O(log n) operation
     *
     * Binary search works by repeatedly dividing the search interval in half.
     * With each comparison, the algorithm eliminates half of the remaining elements.
     * This division in half is what gives us the logarithmic time complexity.
     *
     * Note: The array MUST be sorted before calling this method.
     * Sorting an unsorted array first would add O(n log n) complexity.
     *
     * @param sortedArray the pre-sorted array to search within
     * @param key the value to search for
     * @return index of the key if found, otherwise a negative value
     */
    public int binarySearch(int[] sortedArray, int key) {
        if (sortedArray == null) return -1;

        // Using Java's built-in binary search for simplicity
        // This is an O(log n) operation because it halves the search space with each comparison
        return Arrays.binarySearch(sortedArray, key);
    }
}

