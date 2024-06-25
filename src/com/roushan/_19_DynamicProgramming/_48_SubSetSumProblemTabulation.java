package com.roushan._19_DynamicProgramming;

public class _48_SubSetSumProblemTabulation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3}; // Example array
        int sum = 3; // Target sum
        int n = arr.length; // Length of the array

        // Create a 2D array to store the counts of subsets
        // dp[i][j] will store the number of subsets of elements from arr[0] to arr[i-1] that sum up to j
        int[][] dp = new int[n + 1][sum + 1];

        // There is exactly one way (the empty subset) to make sum 0 with any subset
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // There are no subsets that can make any positive sum with an empty set
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = 0;
        }

        // Fill the dp table in bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                // Exclude the current element arr[i-1]
                dp[i][j] = dp[i - 1][j];
                // Include the current element arr[i-1] if it does not exceed the current sum
                if (arr[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        // The result is stored in dp[n][sum], which contains the number of subsets that sum up to 'sum'
        System.out.println(dp[n][sum]);
    }
}
