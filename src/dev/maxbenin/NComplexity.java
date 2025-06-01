package dev.maxbenin;

/**
 * Demonstration of O(n) Linear Time Complexity
 *
 * O(n) algorithms have runtime directly proportional to the input size.
 * For each increase in input size, the time increases by a proportional amount.
 * Common examples include:
 * - Simple iterations through arrays/collections
 * - Linear search
 * - Finding min/max in unsorted arrays
 */
public class NComplexity {
    /**
     * Calculates the sum of all elements in an array - O(n) operation
     *
     * This method demonstrates linear time complexity because it needs to
     * visit each element in the array exactly once to compute the sum.
     * Regardless of the values inside, the method must process all n elements,
     * making its time complexity directly proportional to the array's size.
     *
     * @param array the array whose elements will be summed
     * @return the sum of all elements in the array
     */
    public long sumArray(int[] array) {
        if (array == null) return 0;
        long sum = 0;

        // O(n) operation - we must visit each element exactly once
        // The time grows linearly with the size of the input array
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
}

