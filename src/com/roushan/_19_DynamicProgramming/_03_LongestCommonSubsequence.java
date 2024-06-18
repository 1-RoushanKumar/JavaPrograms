package com.roushan._19_DynamicProgramming;

public class _03_LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "AXYZ";
        String s2 = "BAZ";
        int m = s1.length();
        int n = s2.length();

        //1st approach using recursion which will take time = O(2^n)
        System.out.println(lcs1(s1, s2, m, n));

        //2nd approach using memoization which will take time = O(m*n) = O(n^2)
        // Initialize memoization table with -1
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        // Print the length of the longest common subsequence
        System.out.println(lcs(s1, s2, m, n, memo));

        //3rd approach using tabulation which also take O(m*n).
        System.out.println(lcs2(s1, s2, m, n));
    }

    //1st approach
    public static int lcs1(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcs1(s1.substring(0, m - 1), s2.substring(0, n - 1), m - 1, n - 1);
        } else {
            return Math.max(lcs1(s1, s2, m - 1, n), lcs1(s1, s2, m, n - 1));
        }
    }

    //2nd approach
    private static int lcs(String s1, String s2, int m, int n, int[][] memo) {
        // Check if the value is already computed
        if (memo[m][n] == -1) {
            // Base case: if either string is empty, LCS length is 0
            if (m == 0 || n == 0) {
                memo[m][n] = 0;
            } else if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, memo);
            } else {
                memo[m][n] = Math.max(lcs(s1, s2, m - 1, n, memo), lcs(s1, s2, m, n - 1, memo));
            }
        }
        return memo[m][n];
    }

    //3rd approach
    public static int lcs2(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
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
