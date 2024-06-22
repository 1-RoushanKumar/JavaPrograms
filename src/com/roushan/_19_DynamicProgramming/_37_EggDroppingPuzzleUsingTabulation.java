package com.roushan._19_DynamicProgramming;

public class _37_EggDroppingPuzzleUsingTabulation {
    public static void main(String[] args) {
        int f = 36; // Number of floors
        int e = 2;  // Number of eggs
        int[][] dp = new int[f + 1][e + 1]; // DP table to store minimum trials

        // Initialize the DP table for base cases
        // If there are 0 floors, 0 trials are needed; if there is 1 floor, 1 trial is needed
        for (int i = 1; i <= e; i++) {
            dp[1][i] = 1; // 1 floor with any number of eggs requires 1 trial
            dp[0][i] = 0; // 0 floors with any number of eggs requires 0 trials
        }
        // If there is 1 egg, we need to try each floor one by one
        for (int j = 1; j <= f; j++) {
            dp[j][1] = j; // j floors with 1 egg requires j trials
        }

        // Fill the rest of the table using the optimal substructure property
        for (int i = 2; i <= f; i++) { // For each floor count from 2 to f
            for (int j = 2; j <= e; j++) { // For each egg count from 2 to e
                dp[i][j] = Integer.MAX_VALUE; // Initialize current cell to a large value

                // Calculate minimum trials for current cell by trying each floor from 1 to i
                for (int x = 1; x <= i; x++) {
                    // If the egg breaks at floor x, we check floors below (x-1) with one less egg (j-1)
                    // If the egg doesn't break, we check floors above (i-x) with the same number of eggs (j)
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x - 1][j - 1], dp[i - x][j]));
                }
            }
        }

        // Output the minimum number of trials needed for f floors and e eggs
        System.out.println(dp[f][e]);
    }
}

/*
 * Time Complexity: O(f^2 * e)
 * - The worst case is that for each cell (i, j) in the DP table, we iterate through all floors (from 1 to i),
 *   and there are f * e cells in the DP table.
 * - Thus, the time complexity is O(f^2 * e).
 *
 * Space Complexity: O(f * e)
 * - We use a DP table to store results of subproblems, which requires O(f * e) space.
 */
