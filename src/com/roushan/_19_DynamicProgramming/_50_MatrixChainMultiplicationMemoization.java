package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _50_MatrixChainMultiplicationMemoization {

    public static void main(String[] args) {
        int[] arr = {20, 10, 30, 40}; // Example array representing matrix dimensions
        int n = arr.length; // Number of matrices is arr.length - 1
        int[][] memo = new int[n][n]; // Memoization table to store results of subproblems

        // Initialize the memoization table with -1 (indicating uncomputed values)
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int ans = minChain(arr, 1, n - 1, memo); // Calculate minimum multiplications needed
        System.out.println("Minimum number of multiplications is: " + ans); // Output the result
    }

    // Recursive function with memoization to find the minimum number of multiplications
    public static int minChain(int[] arr, int i, int j, int[][] memo) {
        // Base case: if there's only one matrix, no multiplication is needed
        if (i == j) {
            return 0;
        }

        // If the result for this subproblem is already computed, return it
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // Initialize the result to a large number
        int res = Integer.MAX_VALUE;

        // Try every possible position to split the product
        for (int k = i; k < j; k++) {
            // Cost of multiplying matrices from i to k, k+1 to j, and then multiplying the results
            int cost = minChain(arr, i, k, memo) + minChain(arr, k + 1, j, memo) + arr[i - 1] * arr[k] * arr[j];

            // Take the minimum of all possible costs
            res = Math.min(res, cost);
        }

        // Store the result in the memoization table before returning
        memo[i][j] = res;

        return res; // Return the minimum cost
    }
}

/*
Explanation:
1. The main function initializes the array `arr`, representing the dimensions of matrices.
   If the dimensions array is [20, 10, 30, 40], it represents matrices A1 (20x10), A2 (10x30), and A3 (30x40).
2. It computes the number of matrices as `n - 1` and initializes the memoization table `memo` with -1 to indicate uncomputed values.
3. It calls the `minChain` function with indices 1 and `n - 1`, along with the memoization table.
4. The `minChain` function calculates the minimum number of scalar multiplications needed to multiply the matrices from index `i` to `j`.

Base Case:
- If `i == j`, there is only one matrix, so no multiplication is needed.

Memoization:
- The function checks if the result for the current subproblem `memo[i][j]` is already computed.
- If computed, it returns the stored result to avoid redundant calculations.

Recursive Case:
- The function iterates through all possible places to split the product (`k` from `i` to `j-1`).
- It recursively calculates the cost of multiplying the matrices from `i` to `k` and from `k+1` to `j`, and then adds the cost of multiplying the two resulting matrices.
- It updates the result with the minimum cost found and stores it in the memoization table.

Time Complexity:
- The time complexity is \(O(n^3)\) due to the three nested loops: two for the recursive calls and one for the iteration over `k`.

Space Complexity:
- The space complexity is \(O(n^2)\) for the memoization table and \(O(n)\) for the recursion stack. The memoization table stores results for all subproblems, and the recursion stack's depth is `n`.
*/

