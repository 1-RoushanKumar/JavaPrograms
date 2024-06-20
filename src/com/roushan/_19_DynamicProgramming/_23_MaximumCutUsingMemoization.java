package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _23_MaximumCutUsingMemoization {
    public static void main(String[] args) {
        int n = 5; // Total length of the rope
        int a = 1, b = 2, c = 3; // Lengths of the cuts we can make
        // Create a memoization array to store results for different lengths
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -2); // Initialize with -2 to indicate uncompleted values
        int ans = maxCut(n, a, b, c, memo); // Calculate the maximum number of cuts
        System.out.println(ans); // Print the result
    }

    // Recursive function with memoization to find the maximum number of cuts
    private static int maxCut(int n, int a, int b, int c, int[] memo) {
        // Base case: if the length becomes negative, it's not possible to make further cuts
        if (n < 0) {
            return -1;
        }

        // Base case: if the length becomes zero, we've successfully made all possible cuts
        if (n == 0) {
            return 0;
        }

        // If the result for this length has already been computed, return it
        if (memo[n] != -2) {
            return memo[n];
        }

        // Recursively calculate the maximum cuts by considering each cut length
        int res = Math.max(
                maxCut(n - a, a, b, c, memo), // Max cuts by making a cut of length 'a'
                Math.max(
                        maxCut(n - b, a, b, c, memo), // Max cuts by making a cut of length 'b'
                        maxCut(n - c, a, b, c, memo) // Max cuts by making a cut of length 'c'
                )
        );

        // If no valid cuts can be made, store and return -1
        if (res == -1) {
            memo[n] = res;
        } else {
            // Otherwise, store and return the result incremented by 1 to include the current cut
            memo[n] = res + 1;
        }

        return memo[n];
    }
}

/*
 * Time Complexity Analysis:
 * With memoization, each problem is solved only once and stored in the memo array.
 * There are n problems (one for each length from 0 to n), and each problem involves a constant amount of work (checking and updating the memo array).
 * Therefore, the time complexity is O(n).
 *
 * Space Complexity Analysis:
 * The space complexity includes the space for the memo array and the recursion stack.
 * The memo array requires O(n) space, and the recursion stack requires O(n) space in the worst case.
 *
 * Therefore, the overall space complexity is O(n).
 */

