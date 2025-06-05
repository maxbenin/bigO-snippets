import dev.maxbenin.ExponentialComplexity;
import dev.maxbenin.FactorialComplexity;
import dev.maxbenin.LogNComplexity;
import dev.maxbenin.N2Complexity;
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
		N2Complexity n2Ops = new N2Complexity();
		ExponentialComplexity expOps = new ExponentialComplexity();
		FactorialComplexity factOps = new FactorialComplexity();

		// Input sizes for testing (increasing exponentially)
		int[] sizes = {1000, 10000, 100000, 1000000, 10000000};

		// Header for results table
		System.out.println("=======================================================================");
		System.out.println("          DEMONSTRATION OF ALGORITHMIC COMPLEXITY (BIG O)            ");
		System.out.println("=======================================================================");
		System.out.println("This test compares the execution time of algorithms with different");
		System.out.println("complexities as input size increases.");
		System.out.println();
		System.out.printf("%-10s | %-15s | %-20s | %-15s | %-15s %n",
				"Size", "O(1) Access", "O(log n) BinSearch", "O(n) Sum", "O(n log n) Sort");
		System.out.println(new String(new char[85]).replace('\0', '-'));

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

		// Separate section for expensive algorithms with variable inputs
		System.out.println("\n\n=======================================================================");
		System.out.println("          EXPENSIVE ALGORITHMS WITH VARIABLE INPUTS                   ");
		System.out.println("=======================================================================");
		System.out.println("These algorithms are tested with different input sizes to show their");
		System.out.println("exponential/factorial growth patterns.");
		System.out.println();

		testExpensiveAlgorithms(n2Ops, expOps, factOps);

		// Explanatory notes on result interpretation
		System.out.println("\nIMPORTANT NOTES:");
		System.out.println("1. Timings are illustrative and can vary based on system load, JVM, etc.");
		System.out.println("2. The key is to observe the TREND of how time changes with increasing 'n'.");
		System.out.println("3. Theoretical expectations:");
		System.out.println("   - O(1): constant time, independent of input size");
		System.out.println("   - O(log n): grows very slowly as input increases");
		System.out.println("   - O(n): grows linearly with input size");
		System.out.println("   - O(n log n): grows faster than linear but slower than quadratic");
		System.out.println("   - O(n²): time grows quadratically — avoid on large datasets");
        System.out.println("   - O(2^n): exponential growth — becomes impractical quickly");
        System.out.println("   - O(n!): factorial growth — feasible only for very small n");
	}

	/**
	 * Tests expensive algorithms (O(n²), O(2^n), O(n!)) with variable inputs
	 * to demonstrate their growth patterns
	 */
	private static void testExpensiveAlgorithms(N2Complexity n2Ops, ExponentialComplexity expOps, FactorialComplexity factOps) {
		// Test O(n²) - Bubble Sort with increasing array sizes
		System.out.println("O(n²) - Bubble Sort Performance:");
		System.out.printf("%-10s | %-15s%n", "Array Size", "Time (ms)");
		System.out.println(new String(new char[30]).replace('\0', '-'));
		
		int[] bubbleSortSizes = {100, 500, 1000, 2000, 3000};
		for (int size : bubbleSortSizes) {
			int[] testArray = createArray(size);
			double duration = measureExecutionTime(() -> 
				n2Ops.bubbleSort(Arrays.copyOf(testArray, testArray.length)));
			System.out.printf("%-10d | %-15.6f%n", size, duration);
		}

		// Test O(2^n) - Fibonacci with increasing n values
		System.out.println("\nO(2^n) - Fibonacci Performance:");
		System.out.printf("%-10s | %-15s%n", "n", "Time (ms)");
		System.out.println(new String(new char[30]).replace('\0', '-'));
		
		int[] fibonacciSizes = {30, 35, 38, 40, 42};
		for (int n : fibonacciSizes) {
			double duration = measureExecutionTime(() -> expOps.fibonacci(n));
			System.out.printf("%-10d | %-15.6f%n", n, duration);
		}

		// Test O(n!) - Permutations with increasing array sizes
		System.out.println("\nO(n!) - Permutations Performance:");
		System.out.printf("%-10s | %-15s | %-15s%n", "Elements", "Permutations", "Time (ms)");
		System.out.println(new String(new char[45]).replace('\0', '-'));
		
		int[] permutationSizes = {3, 4, 5, 6, 7, 8};
		for (int size : permutationSizes) {
			int[] testArray = new int[size];
			for (int i = 0; i < size; i++) {
				testArray[i] = i + 1; // Array [1, 2, 3, ..., size]
			}
			
			long permutationCount = factorial(size);
			double duration = measureExecutionTime(() -> 
				factOps.generatePermutations(testArray));
			System.out.printf("%-10d | %-15d | %-15.6f%n", size, permutationCount, duration);
			
			// Safety break for very large factorial times
			if (duration > 5000) { // More than 5 seconds
				System.out.println("Stopping permutation tests - time limit exceeded");
				break;
			}
		}
	}

	/**
	 * Calculates factorial for display purposes
	 */
	private static long factorial(int n) {
		long result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}
