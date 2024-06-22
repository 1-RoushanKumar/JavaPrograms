package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _39_CountBSTUsingMemoization {
    public static void main(String[] args) {
        int n = 4; // Number of nodes
        int[] memo = new int[n + 1]; // Array for memoization
        Arrays.fill(memo, -1); // Initialize memoization array with -1
        int ans = count(n, memo); // Call the function with memoization
        System.out.println(Arrays.toString(memo)); // Print the memo array
        System.out.println(ans); // Output the result
    }

    /**
     * Function to count the number of unique Binary Search Trees (BSTs) that can be
     * formed with 'n' distinct nodes using memoization.
     *
     * @param n    Number of nodes
     * @param memo Memoization array to store results of subproblems
     * @return Number of unique BSTs
     *
     * Time Complexity: O(n^2)
     * - The time complexity is O(n^2) because for each value of `n`, we perform
     *   `n` recursive calls. However, each subproblem is solved only once and stored
     *   in the memo array, resulting in a quadratic time complexity.
     *
     * Space Complexity: O(n)
     * - The space complexity is O(n) due to the memoization array of size `n+1` and
     *   the maximum depth of the recursion stack being `n`.
     */
    public static int count(int n, int[] memo) {
        // Base case: An empty tree or a single-node tree has exactly one unique BST
        if (n == 1 || n == 0) {
            return 1;
        }

        // If the result for this subproblem is already computed, return it
        if (memo[n] != -1) {
            return memo[n];
        }

        int res = 0; // Initialize result to 0

        // Iterate through all possible root positions (1 to n)
        for (int i = 1; i <= n; i++) {
            // Count the number of unique BSTs with `i` as the root
            // The left subtree contains `i-1` nodes, and the right subtree contains `n-i` nodes
            int leftTrees = count(i - 1, memo);
            int rightTrees = count(n - i, memo);

            // The total number of unique BSTs with `i` as the root is the product of
            // the number of unique BSTs in the left and right subtrees
            res += leftTrees * rightTrees;
        }

        // Store the computed result in the memo array
        memo[n] = res;

        return res; // Return the total count of unique BSTs
    }
}
