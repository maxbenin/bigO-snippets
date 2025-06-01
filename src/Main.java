import dev.maxbenin.LogNComplexity;
import dev.maxbenin.NComplexity;
import dev.maxbenin.NLogNComplexity;
import dev.maxbenin.O1Complexity;

import java.util.Arrays;
import java.util.Random;

/**
 * Practical demonstration of algorithmic complexity analysis (Big O)
 *
 * This program illustrates the performance differences between algorithms
 * of different complexities: O(1), O(log n), O(n) and O(n log n).
 */
public class Main {
	private static final Random random = new Random();

	// Constants to improve readability
	private static final double NANO_TO_MILLI = 1_000_000.0;

	/**
	 * Creates an array of random integers
	 *
	 * @param size the size of the array to be created
	 * @return array of integers filled with random values
	 */
	public static int[] createArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt(size * 10); // Random values between 0 and (size * 10 - 1)
		}
		return array;
	}

	/**
	 * Generic function to measure the execution time of an operation
	 *
	 * @param operation the operation to be executed and measured
	 * @return execution time in milliseconds
	 */
	private static double measureExecutionTime(Runnable operation) {
		long startTime = System.nanoTime();
		operation.run();
		long endTime = System.nanoTime();
		return (endTime - startTime) / NANO_TO_MILLI;
	}

	public static void main(String[] args) {
		// Initialize classes that implement the different algorithms
		O1Complexity o1Ops = new O1Complexity();
		LogNComplexity logNOps = new LogNComplexity();
		NComplexity nOps = new NComplexity();
		NLogNComplexity nLogNOps = new NLogNComplexity();

		// Input sizes for testing (increasing exponentially)
		int[] sizes = {1000, 10000, 100000, 1000000, 10000000};

		// Header for results table
		System.out.println("=======================================================================");
		System.out.println("          DEMONSTRATION OF ALGORITHMIC COMPLEXITY (BIG O)            ");
		System.out.println("=======================================================================");
		System.out.println("This test compares the execution time of algorithms with different");
		System.out.println("complexities as input size increases.");
		System.out.println();
		System.out.printf("%-10s | %-15s | %-20s | %-15s | %-15s%n",
				"Size", "O(1) Access", "O(log n) BinSearch", "O(n) Sum", "O(n log n) Sort");
		System.out.println(new String(new char[80]).replace('\0', '-'));

		// Run tests for each input size
		for (int size : sizes) {
			// Create arrays for testing (one unsorted and one sorted)
			int[] testArray = createArray(size);
			int[] sortedTestArray = Arrays.copyOf(testArray, testArray.length);
			Arrays.sort(sortedTestArray); // Pre-sort for binary search demonstration

			int indexToAccess = size / 2; // Middle index of the array
			int keyToSearch = sortedTestArray[random.nextInt(size)]; // Existing value for search

			// Measure time of each operation using the generic function
			double durationO1 = measureExecutionTime(() ->
					o1Ops.getElement(testArray, indexToAccess));

			double durationLogN = measureExecutionTime(() ->
					logNOps.binarySearch(sortedTestArray, keyToSearch));

			double durationN = measureExecutionTime(() ->
					nOps.sumArray(testArray));

			// For sorting test, we need a fresh copy of the array
			double durationNLogN = measureExecutionTime(() -> {
				int[] arrayToSort = Arrays.copyOf(testArray, testArray.length);
				nLogNOps.sortArray(arrayToSort);
			});

			// Display results for this input size
			System.out.printf("%-10d | %-15.6f | %-20.6f | %-15.6f | %-15.6f%n",
					size, durationO1, durationLogN, durationN, durationNLogN);
		}

		// Explanatory notes on result interpretation
		System.out.println("\nIMPORTANT NOTES:");
		System.out.println("1. Timings are illustrative and can vary based on system load, JVM, etc.");
		System.out.println("2. The key is to observe the TREND of how time changes with increasing 'n'.");
		System.out.println("3. Theoretical expectations:");
		System.out.println("   - O(1): constant time, independent of input size");
		System.out.println("   - O(log n): grows very slowly as input increases");
		System.out.println("   - O(n): grows linearly with input size");
		System.out.println("   - O(n log n): grows faster than linear but slower than quadratic");
	}
}
