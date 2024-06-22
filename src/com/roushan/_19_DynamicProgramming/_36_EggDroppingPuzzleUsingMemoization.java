package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _36_EggDroppingPuzzleUsingMemoization {
    public static void main(String[] args) {
        int e = 2; // Number of eggs
        int f = 36; // Number of floors
        int[][] memo = new int[f + 1][e + 1]; // Memoization table to store intermediate results

        // Initialize memoization table with -1 (indicating un_computed states)
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }

        // Call the trial function to get the minimum number of trials
        int ans = trial(f, e, memo);

        // Print the memoization table for debugging (optional)
        for (int[] ints : memo) {
            System.out.println(Arrays.toString(ints));
        }

        // Output the minimum number of trials
        System.out.println(ans);
    }

    public static int trial(int f, int e, int[][] memo) {
        // Base case 1: If there is only one egg, we need to try each floor one by one
        if (e == 1) {
            return f;
        }

        // Base case 2: If there is only one floor, we need only one trial
        if (f == 1) {
            return 1;
        }

        // Base case 3: If there are no floors, no trials are needed
        if (f == 0) {
            return 0;
        }

        // Return the cached result if it exists
        if (memo[f][e] != -1) {
            return memo[f][e];
        }

        int res = Integer.MAX_VALUE; // Initialize the result to a large number

        // Consider dropping the egg from each floor and calculate the number of trials in the worst case
        for (int i = 1; i <= f; i++) {
            // If the egg breaks, we need to check the floors below (i-1) with one less egg (e-1)
            // If the egg doesn't break, we need to check the floors above (f-i) with the same number of eggs (e)
            int subRes = Math.max(trial(i - 1, e - 1, memo), trial(f - i, e, memo)) + 1;

            // Find the minimum of these trials
            res = Math.min(subRes, res);
        }

        // Store the result in the memoization table
        memo[f][e] = res;

        // Return the minimum number of trials needed
        return res;
    }
}

/*
 * Time Complexity: O(f^2 * e)
 * - The worst case is that for each state (f, e), we iterate through all floors (from 1 to f),
 *   and there are f * e possible states in the memoization table.
 * - Thus, the time complexity is O(f^2 * e).
 *
 * Space Complexity: O(f * e)
 * - We use a memoization table to store results of subproblems, which requires O(f * e) space.
 */
