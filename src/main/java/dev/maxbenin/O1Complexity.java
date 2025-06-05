package dev.maxbenin;

/**
 * Demonstration of O(1) Constant Time Complexity
 *
 * O(1) operations take the same amount of time regardless of input size.
 * Common examples include:
 * - Array access by index
 * - HashMap/HashSet lookups
 * - Stack/Queue push and pop operations
 */
public class O1Complexity {
    /**
     * Retrieves an element from an array at a specific index - O(1) operation
     *
     * @param array the array to access
     * @param index the position to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if index is invalid or array is null
     */
    public int getElement(int[] array, int index) {
        // Basic bounds check for robustness, doesn't change O(1) nature for valid access
        if (array == null || index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index " + index + " for array of size " + (array == null ? 0 : array.length));
        }

        // Core O(1) operation - accessing an array by index takes constant time
        // regardless of array size, the CPU can jump directly to that memory location
        return array[index];
    }
}
