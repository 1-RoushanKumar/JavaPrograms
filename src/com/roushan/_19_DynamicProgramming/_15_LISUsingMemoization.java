package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _15_LISUsingMemoization {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 8, 10}; // Array for which we want to find the longest increasing subsequence
        int n = arr.length; // Length of the array

        // Initialize a memoization array with -1
        int[][] memo = new int[n][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Initial call to the recursive function
        int ans = lis(arr, 0, -1, n, memo);
        System.out.println(ans); // Output the result
    }

    /**
     * Recursive function to find the length of the longest increasing subsequence using memoization.
     *
     * @param arr  The input array.
     * @param i    The current index in the array.
     * @param prev The index of the previous element in the subsequence.
     * @param n    The length of the array.
     * @param memo The memoization array to store intermediate results.
     * @return The length of the longest increasing subsequence from index i to the end of the array.
     */
    private static int lis(int[] arr, int i, int prev, int n, int[][] memo) {
        // Base case: If we've reached the end of the array
        if (i == n) {
            return 0;
        }

        // Adjust prev for memoization array indexing
        int adjustedPrev = prev + 1;

        // If the result is already computed, return it
        if (memo[i][adjustedPrev] != -1) {
            return memo[i][adjustedPrev];
        }

        // Case 1: Do not include the current element in the subsequence
        int NotTake = lis(arr, i + 1, prev, n, memo);

        // Case 2: Include the current element in the subsequence if it forms an increasing sequence
        int Take = 0;
        if (prev == -1 || arr[i] > arr[prev]) {
            Take = 1 + lis(arr, i + 1, i, n, memo);
        }

        // Store the result in memoization array and return the maximum length
        memo[i][adjustedPrev] = Math.max(NotTake, Take);
        return memo[i][adjustedPrev];
    }
}

/*
 * Time Complexity:
 * The time complexity of this solution is O(n^2) because we are storing results
 * for each pair of (i, prev) indices and there are O(n) indices and O(n) possible
 * previous elements, resulting in O(n^2) total problems.
 *
 * Space Complexity:
 * The space complexity is O(n^2) due to the memoization array used to store intermediate results.
 * Additionally, the recursion stack depth will be O(n), but this is dominated by the memoization array.
 */
