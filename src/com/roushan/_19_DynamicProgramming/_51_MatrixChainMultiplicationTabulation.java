package com.roushan._19_DynamicProgramming;

public class _51_MatrixChainMultiplicationTabulation {
    public static void main(String[] args) {
        int[] arr = {20, 10, 30, 40}; // Example array representing matrix dimensions
        int n = arr.length; // Number of matrices is arr.length - 1
        int[][] dp = new int[n][n]; // DP table to store the minimum cost of matrix chain multiplication

        // Initialize the table with 0 for single matrix chains
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // Length of the chain
        for (int length = 2; length < n; length++) { // length is the length of the subproblem we are solving
            for (int i = 1; i < n - length + 1; i++) { // i is the starting index of the chain
                int j = i + length - 1; // j is the ending index of the chain
                dp[i][j] = Integer.MAX_VALUE; // Initialize the cost to a large value

                for (int k = i; k < j; k++) { // k is the index where the chain is split
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j]; // Cost calculation
                    dp[i][j] = Math.min(dp[i][j], cost); // Find the minimum cost
                }
            }
        }

        System.out.println("Minimum number of multiplications is: " + dp[1][n - 1]); // Output the result
    }
}

/*
Explanation:
1. The main function initializes the array `arr`, representing the dimensions of matrices.
   For example, if the dimensions array is [10, 20, 30, 40, 50], it represents matrices A1 (10x20), A2 (20x30), A3 (30x40), and A4 (40x50).
2. The number of matrices is `n - 1`.
3. The dp table is initialized with 0 for single matrix chains because multiplying one matrix requires 0 multiplications.
4. The outer loop (length) iterates over the length of the subproblems being solved.
5. The inner loops iterate over the starting (i) and ending (j) indices of the subproblems.
6. The innermost loop (k) iterates over the possible split points of the chain, calculating the cost of multiplication and updating the dp table with the minimum cost.

Time Complexity:
- The time complexity is \(O(n^3)\) due to the three nested loops: one for the length of the subproblem, one for the starting index, and one for the possible split points.

Space Complexity:
- The space complexity is \(O(n^2)\) because of the dp table that stores the results of subproblems.
*/
