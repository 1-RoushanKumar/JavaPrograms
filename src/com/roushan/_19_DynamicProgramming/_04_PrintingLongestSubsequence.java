package com.roushan._19_DynamicProgramming;

public class _04_PrintingLongestSubsequence {
    public static void main(String[] args) {
        String s1 = "AXYZ";
        String s2 = "BAZ";
        int m = s1.length();
        int n = s2.length();

        // Create a dp array to store lengths of the longest common subsequence
        int[][] dp = new int[m + 1][n + 1];

        // Find the length of LCS and fill the dp array
        int lengthOfLcs = lcs2(s1, s2, m, n, dp);

        // Create a character array to store the LCS
        char[] str = new char[lengthOfLcs];

        // Initialize indices for traversing the dp array
        int i = m, j = n;
        int k = lengthOfLcs - 1;

        // Trace back through the dp array to construct the LCS string
        while (i > 0 && j > 0) { // corrected condition (should be strictly greater than 0)
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                str[k] = s1.charAt(i - 1);
                i--;
                j--;
                k--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        // Convert the character array to a string and print it
        String ans = new String(str);
        System.out.println("Longest Common Subsequence: " + ans);
    }

    // Function to find the length of LCS and fill the dp array
    public static int lcs2(String s1, String s2, int m, int n, int[][] dp) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
