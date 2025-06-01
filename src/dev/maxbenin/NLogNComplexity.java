package dev.maxbenin;

import java.util.Arrays;

/**
 * Demonstration of O(n log n) Time Complexity
 *
 * O(n log n) is the time complexity of efficient comparison-based sorting algorithms.
 * This complexity often appears when an algorithm does O(log n) work for each of n elements.
 * Common examples include:
 * - Merge sort
 * - Heap sort
 * - Quick sort (average case)
 * - Most practical sorting algorithms
 */
public class NLogNComplexity {
    /**
     * Sorts an array of integers - O(n log n) operation
     *
     * This method uses Java's built-in Arrays.sort() which implements:
     * - Dual-Pivot Quicksort for primitive types (like int)
     * - TimSort (a hybrid of merge sort and insertion sort) for objects
     *
     * Why O(n log n)?
     * - The 'n' factor: we need to examine all n elements
     * - The 'log n' factor: the sorting algorithm makes approximately log n
     *   comparisons per element (think of it like building/traversing a tree)
     *
     * O(n log n) is mathematically proven to be the best possible time complexity
     * for any comparison-based sorting algorithm in the average case.
     *
     * @param array the array to be sorted
     */
    public void sortArray(int[] array) {
        if (array == null) return;

        // Using Java's built-in sort implementation
        // This is typically O(n log n) for sorting algorithms
        Arrays.sort(array);
    }
}

