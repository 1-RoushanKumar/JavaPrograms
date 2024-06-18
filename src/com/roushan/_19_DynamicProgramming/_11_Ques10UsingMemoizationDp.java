package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _11_Ques10UsingMemoizationDp {
    public static void main(String[] args) {
        // Input strings
        String s1 = "CAT";
        String s2 = "CUT";

        // Lengths of the input strings
        int m = s1.length();
        int n = s2.length();

        // Initialize memoization table with -1 to indicate uncompleted values
        int[][] memo = new int[m + 1][n + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        // Calculate the minimum number of operations required to convert s1 to s2
        int ans = minOperation(s1, s2, m, n, memo);

        System.out.println("Printing Memo Matrix::");
        // Print the memoization table for reference
        for (int[] arr : memo) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("No. of operations::");
        // Print the result
        System.out.println(ans);
    }

    /**
     * This method calculates the minimum number of operations required to convert
     * string s1 to string s2 using recursion with memoization.
     *
     * @param s1 The first string
     * @param s2 The second string
     * @param m The current length of the first string being considered
     * @param n The current length of the second string being considered
     * @param memo Memoization table to store results of problems
     * @return The minimum number of operations required
     */
    public static int minOperation(String s1, String s2, int m, int n, int[][] memo) {
        // Check if the result for this problem is already computed
        if (memo[m][n] == -1) {
            // If the first string is empty, the only option is to insert all characters of the second string
            if (m == 0) {
                memo[m][n] = n;
                // If the second string is empty, the only option is to remove all characters of the first string
            } else if (n == 0) {
                memo[m][n] = m;
                // If the last characters of both strings are the same, ignore the last character
                // and recursively find the edit distance for the remaining strings
            } else if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                memo[m][n] = minOperation(s1, s2, m - 1, n - 1, memo);
            } else {
                // If the last characters are different, consider all three operations:
                // 1. Insert the last character of s2 into s1
                // 2. Remove the last character of s1
                // 3. Replace the last character of s1 with the last character of s2
                // Take the minimum of these three operations and add 1 (for the current operation)
                memo[m][n] = 1 + Math.min(minOperation(s1, s2, m - 1, n, memo), // Remove
                        Math.min(minOperation(s1, s2, m, n - 1, memo), // Insert
                                minOperation(s1, s2, m - 1, n - 1, memo))); // Replace
            }
        }
        // Return the result from the memoization table
        return memo[m][n];
    }
}

// Time Complexity Explanation:
// With memoization, the time complexity is reduced to O(m * n) where m and n are the lengths of the input strings.
// This is because each problem is solved once and stored in the memoization table, which has m * n entries.
// Space Complexity Explanation:
// The space complexity is O(m * n) due to the memoization table and the recursion stack, which can go up to O(max(m, n)).
