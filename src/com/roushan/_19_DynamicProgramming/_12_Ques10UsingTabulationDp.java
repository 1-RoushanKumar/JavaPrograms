package com.roushan._19_DynamicProgramming;

public class _12_Ques10UsingTabulationDp {
    public static void main(String[] args) {
        // Input strings
        String s1 = "SATURDAY";
        String s2 = "SUNDAY";

        // Lengths of the input strings
        int m = s1.length();
        int n = s2.length();

        // Initialize the DP table with dimensions (m+1)x(n+1)
        int[][] dp = new int[m + 1][n + 1];

        // Fill the first row (converting empty s1 to s2)
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        // Fill the first column (converting s1 to empty s2)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters are the same, no new operation is needed
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If characters are different, consider all three operations:
                    // 1. Insert (dp[i][j - 1])
                    // 2. Remove (dp[i - 1][j])
                    // 3. Replace (dp[i - 1][j - 1])
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }

        // Print the result from the bottom-right corner of the DP table
        System.out.println(dp[m][n]);
    }
}

// Time Complexity Explanation:
// The time complexity of this algorithm is O(m * n) where m and n are the lengths of the input strings s1 and s2.
// This is because the nested loops iterate through all cells of the dp table, and each cell computation takes constant time.

// Space Complexity Explanation:
// The space complexity of this algorithm is O(m * n) due to the dp table used to store the results of subproblems.
// The table has (m + 1) * (n + 1) entries, leading to the space complexity of O(m * n).
