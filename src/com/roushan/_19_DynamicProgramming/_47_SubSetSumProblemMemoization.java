package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _47_SubSetSumProblemMemoization {
    public static void main(String[] args) {
        int[] arr = {1,2,3}; // Example array
        int sum = 3; // Target sum
        int n = arr.length; // Length of the array
        // Initialize memoization table with -1 (indicating un-computed states)
        int[][] memo = new int[sum + 1][n + 1];
        for (int i = 0; i <= sum; i++) {
            Arrays.fill(memo[i], -1);
        }
        int ans = count(arr, sum, n, memo); // Call the memoized function
        for (int i = 0; i <= sum; i++) {
            System.out.println(Arrays.toString(memo[i]));
        }
        System.out.println(ans); // Output the result
    }

    // Memoized function to count the number of subsets with a given sum
    public static int count(int[] arr, int sum, int n, int[][] memo) {
        // Base case: If both sum and n are 0, there's exactly one subset (the empty subset)
        if (n == 0 && sum == 0) {
            return 1;
        }
        // Base case: If sum is 0, there's exactly one subset (the empty subset)
        if (sum == 0) {
            return 1;
        }
        // Base case: If n is 0 and sum is not 0, there's no subset that adds up to sum
        if (n == 0) {
            return 0;
        }

        // Check if the result is already computed in the memo table
        if (memo[sum][n] != -1) {
            return memo[sum][n];
        }

        // Recursive case:
        // If the last element is greater than sum, it cannot be included in the subset
        if (arr[n - 1] > sum) {
            memo[sum][n] = count(arr, sum, n - 1, memo);
        } else {
            // Return the count of subsets including the last element and excluding the last element
            memo[sum][n] = count(arr, sum - arr[n - 1], n - 1, memo) + count(arr, sum, n - 1, memo);
        }

        // Store the result in the memo table before returning it
        return memo[sum][n];
    }

    /*
     * Time Complexity: O(n * sum)
     * The function computes the result for each state (sum, n) only once and stores it in the memoization table.
     * There are (n + 1) * (sum + 1) possible states.
     *
     * Space Complexity: O(n * sum)
     * The space complexity is proportional to the size of the memoization table.
     * Additionally, the recursion stack can go up to n levels deep in the worst case.
     */
}
