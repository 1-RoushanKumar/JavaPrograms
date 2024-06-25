package com.roushan._19_DynamicProgramming;

public class _54_PalindromePartitioningTabulation {
    public static void main(String[] args) {
        String str = "geek"; // Example string
        int n = str.length();
        int[][] dp = new int[n][n]; // DP table to store the minimum cuts needed

        // Base case: Single character substrings are palindromes and need 0 cuts
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        // Fill the DP table
        for (int gap = 1; gap < n; gap++) { // gap represents the length of the substring minus 1
            for (int i = 0; i + gap < n; i++) { // i is the starting index of the substring
                int j = i + gap; // j is the ending index of the substring
                if (isPalindrome(str, i, j)) {
                    dp[i][j] = 0; // No cuts needed if the substring is a palindrome
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) { // Try all possible cuts from i to j
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }

        System.out.println(dp[0][n - 1]); // Output the minimum cuts needed for the whole string
    }

    // Helper function to check if a substring is a palindrome
    public static boolean isPalindrome(String str, int s, int e) {
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}

/*
Explanation:
1. The `main` function initializes the string `str` and its length `n`.
2. It initializes a DP table `dp` to store the minimum cuts needed for each substring.
3. The base case is that single character substrings are palindromes and need 0 cuts.
4. The outer loop `gap` represents the length of the substring minus 1.
5. The inner loop iterates over the starting index `i` and calculates the ending index `j`.
6. If the substring from `i` to `j` is a palindrome, no cuts are needed.
7. Otherwise, it calculates the minimum cuts needed by trying all possible cuts from `i` to `j`.
8. The result is stored in the DP table and the minimum cuts for the whole string are printed.

Time Complexity:
- The time complexity is \(O(n^3)\) due to the three nested loops: one for the gap, one for the starting index, and one for the possible cuts.

Space Complexity:
- The space complexity is \(O(n^2)\) because of the DP table that stores the results of subproblems.
*/
