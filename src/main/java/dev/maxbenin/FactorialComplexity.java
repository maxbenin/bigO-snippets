package dev.maxbenin;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstration of O(n!) Factorial Time Complexity
 *
 * O(n!) algorithms grow extremely fast and are typically impractical for large inputs.
 * Common examples include:
 * - Generating all permutations of a set
 * - Certain combinatorial problems
 */
public class FactorialComplexity {
    public List<List<Integer>> generatePermutations(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(array, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] array, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == array.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < array.length; i++) {
                if (tempList.contains(array[i])) continue;
                tempList.add(array[i]);
                backtrack(array, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}