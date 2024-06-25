package com.roushan._19_DynamicProgramming;

public class _49_MatrixChainMultiplicationRecursion {
    public static void main(String[] args) {
        int[] arr = {20, 10, 30, 40}; // Example array representing matrix dimensions
        int n = arr.length; // Number of matrices is arr.length - 1
        int ans = minChain(arr, 1, n - 1); // Calculate minimum multiplications needed
        System.out.println("Minimum number of multiplications is: " + ans); // Output the result
    }

    // Recursive function to find the minimum number of multiplications
    public static int minChain(int[] arr, int i, int j) {
        // Base case: if there's only one matrix, no multiplication is needed
        if (i == j) {
            return 0;
        }

        // Initialize the result to a large number
        int res = Integer.MAX_VALUE;

        // Try every possible position to split the product
        for (int k = i; k < j; k++) {
            // Cost of multiplying matrices from i to k, k+1 to j, and then multiplying the results
            int cost = minChain(arr, i, k) + minChain(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];

            // Take the minimum of all possible costs
            res = Math.min(res, cost);
        }

        return res; // Return the minimum cost
    }
}

/*
Explanation:
1. The main function initializes the array `arr`, representing the dimensions of matrices.
   If the dimensions array is [20, 10, 30, 40], it represents matrices A1 (20x10), A2 (10x30), and A3 (30x40).
2. It computes the number of matrices as `n - 1` and calls the recursive function `minChain` with indices 1 and `n - 1`.
3. The `minChain` function calculates the minimum number of scalar multiplications needed to multiply the matrices from index `i` to `j`.

Base Case:
- If `i == j`, there is only one matrix, so no multiplication is needed.

Recursive Case:
- The function iterates through all possible positions to split the product (`k` from `i` to `j-1`).
- It recursively calculates the cost of multiplying the matrices from `i` to `k` and from `k+1` to `j`, and then adds the cost of multiplying the two resulting matrices.
- It updates the result with the minimum cost found.

Time Complexity:
- The time complexity is \(O(2^n)\) due to the exponential nature of the recursive solution, as it tries all possible splits, leading to overlapping subproblems.

Space Complexity:
- The space complexity is \(O(n)\) because of the recursion stack. The depth of the recursion tree is `n`.
*/
