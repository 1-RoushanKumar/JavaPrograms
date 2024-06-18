package com.roushan._19_DynamicProgramming;

public class _06_ShortestCommonSuperSequence {
    public static String shortestSuperSequence(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Fill the dp array with LCS lengths
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Initialize variables to trace back the solution
        int i = n, j = m;
        StringBuilder ans = new StringBuilder();

        // Trace back through the dp array to construct the SCS
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(s1.charAt(i - 1));
                i--;
            } else {
                ans.append(s2.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters of s1
        while (i > 0) {
            ans.append(s1.charAt(i - 1));
            i--;
        }

        // Add remaining characters of s2
        while (j > 0) {
            ans.append(s2.charAt(j - 1));
            j--;
        }

        // Reverse the constructed sequence to get the correct result
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";

        System.out.println("The Shortest Common Super sequence is: " + shortestSuperSequence(s1, s2));
    }
}
