package com.roushan._19_DynamicProgramming;

public class _40_CountBSTUsingTabulation {
    public static void main(String[] args) {
        int n = 4; // Number of nodes

        int ans = countBSTUsingTabulation(n);

        System.out.println(ans); // Output the result: Number of unique BSTs with `n` nodes
    }

    /**
     * Function to count the number of unique Binary Search Trees (BSTs) that can be
     * formed with 'n' distinct nodes using tabulation.
     *
     * @param n Number of nodes
     * @return Number of unique BSTs

     * Time Complexity: O(n^2)
     * - The time complexity is O(n^2) because we have a nested loop where the outer loop runs `n` times,
     *   and the inner loop also runs up to `n` times for each iteration of the outer loop.

     * Space Complexity: O(n)
     * - The space complexity is O(n) due to the DP array of size `n+1` used to store the number of unique BSTs
     *   for each number of nodes from 0 to `n`.
     */
    public static int countBSTUsingTabulation(int n) {
        int[] dp = new int[n + 1]; // DP array to store the count of unique BSTs for each number of nodes
        dp[0] = 1; // Base case: An empty tree has exactly one unique BST

        // Fill the dp array using a bottom-up approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // For each root `j` (from 1 to i), count the number of unique BSTs
                // by multiplying the count of unique BSTs in the left subtree (j-1 nodes)
                // and the right subtree (i-j nodes) and summing up for all possible roots
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n]; // Return the result: Number of unique BSTs with `n` nodes
    }
}
