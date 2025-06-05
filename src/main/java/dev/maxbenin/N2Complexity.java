package dev.maxbenin;
/**
 * Demonstration of O(n^2) Quadratic Time Complexity
 *
 * O(n^2) algorithms have nested loops where each loop iterates over the input size.
 * Common examples include:
 * - Bubble sort
 * - Selection sort
 * - Insertion sort
 */
public class N2Complexity {
    public void bubbleSort(int[] array) {
        if (array == null) return;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}