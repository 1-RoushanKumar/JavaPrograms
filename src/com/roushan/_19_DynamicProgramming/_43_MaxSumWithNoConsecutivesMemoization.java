package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _43_MaxSumWithNoConsecutivesMemoization {
    public static void main(String[] args) {
        int[] arr = {10, 5, 15, 20};
        int n = arr.length;
        int[] memo = new int[n + 1]; // Memoization array to store computed results
        Arrays.fill(memo, -1); // Initialize a memoization array with -1 to indicate values not computed
        int ans = maxSum(arr, n, memo); // Compute maximum sum using memoization
        System.out.println(Arrays.toString(memo)); // Print memoization array for reference
        System.out.println(ans); // Output the maximum sum of non-consecutive elements
    }

    /**
     * Function to calculate the maximum sum of elements in an array such that no two elements are adjacent,
     * using memoization to optimize recursive approach.
     *
     * @param arr  The input array of integers.
     * @param n    The number of elements in the current subarray being considered.
     * @param memo Memoization array to store computed results.
     * @return The maximum sum possible with non-consecutive elements up to index 'n' in the array 'arr'.
     * Time Complexity: O(n)
     * - Each sub-problem is solved only once and stored in a memoization array, so subsequent calls are O(1).
     * Space Complexity: O(n)
     * - The space complexity is O(n) due to the memoization array used for storing results of subproblems.
     */
    public static int maxSum(int[] arr, int n, int[] memo) {
        if (memo[n] == -1) { // Check if result is not already computed
            if (n == 1) {
                memo[n] = arr[0]; // Base case: If there is only one element, return that element as the maximum sum.
            } else if (n == 2) {
                memo[n] = Math.max(arr[0], arr[1]); // Base case: If there are two elements, return the maximum of the two.
            } else {
                // Recursive case: Calculate the maximum sum by choosing between excluding the current element arr[n-1]
                // and taking the maximum sum up to arr[n-1] (n-1 elements), or including arr[n-1] and adding it to
                // the maximum sum up to arr[n-2] (n-2 elements).
                memo[n] = Math.max(maxSum(arr, n - 1, memo), maxSum(arr, n - 2, memo) + arr[n - 1]);
            }
        }
        return memo[n]; // Return the computed maximum sum for subarray of size 'n'
    }
}
