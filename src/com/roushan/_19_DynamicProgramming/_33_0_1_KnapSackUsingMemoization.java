package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _33_0_1_KnapSackUsingMemoization {
    public static void main(String[] args) {
        int[] val = {10, 40, 30, 50}; // Values of the items
        int[] wt = {5, 4, 6, 3}; // Weights of the items
        int weight = 10; // Maximum weight capacity of the knapsack
        int n = val.length; // Number of items
        int[][] memo = new int[n + 1][weight + 1]; // Memoization array
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1); // Initialize memo array with -1
        }
        int ans = knapSack(wt, val, n, weight, memo); // Call the knapSack function
        for (int i = 0; i <= n; i++) {
            System.out.println(Arrays.toString(memo[i]));
        }
        System.out.println(ans); // Output the maximum value that can be obtained
    }

    // Function to solve the 0/1 Knapsack problem using memoization
    public static int knapSack(int[] wt, int[] val, int n, int w, int[][] memo) {
        // Base case: if no items are left or knapsack capacity is 0
        if (w == 0 || n == 0) {
            return 0;
        }
        // If result is already computed, return it from memo array
        if (memo[n][w] != -1) {
            return memo[n][w];
        }
        // If the weight of the nth item is more than the knapsack capacity w, it cannot be included
        if (wt[n - 1] > w) {
            memo[n][w] = knapSack(wt, val, n - 1, w, memo);
        } else {
            // Return the maximum of two cases:
            // 1. nth item included
            // 2. nth item not included
            memo[n][w] = Math.max(knapSack(wt, val, n - 1, w, memo), val[n - 1] + knapSack(wt, val, n - 1, w - wt[n - 1], memo));
        }
        return memo[n][w]; // Return the result
    }
}

/*
Time Complexity:
The time complexity of this solution is O(n * w), where n is the number of items and w is the weight capacity of the knapsack.
This is because we are solving each subproblem once and storing the results.

Space Complexity:
The space complexity is O(n * w) due to the memoization array used to store intermediate results.
*/
