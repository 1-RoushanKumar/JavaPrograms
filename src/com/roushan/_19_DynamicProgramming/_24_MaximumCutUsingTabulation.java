package com.roushan._19_DynamicProgramming;

public class _24_MaximumCutUsingTabulation {
    public static void main(String[] args) {
        int n = 5; // Total length of the rope
        int a = 1, b = 2, c = 3; // Lengths of the cuts we can make
        // Create a dp array to store results for different lengths
        int[] dp = new int[n + 1];

        // Initialize the dp array
        dp[0] = 0; // Base case: No cuts needed for length 0
        for (int i = 1; i <= n; i++) {
            dp[i] = -1; // Initialize dp[i] with -1 indicating no solution
            if (i - a >= 0 && dp[i - a] != -1) {
                dp[i] = Math.max(dp[i], dp[i - a] + 1);
            }
            if (i - b >= 0 && dp[i - b] != -1) {
                dp[i] = Math.max(dp[i], dp[i - b] + 1);
            }
            if (i - c >= 0 && dp[i - c] != -1) {
                dp[i] = Math.max(dp[i], dp[i - c] + 1);
            }
        }

        // The answer is the maximum number of cuts for length n
        System.out.println(dp[n]);
    }
}

/*
 * Time Complexity Analysis:
 * The time complexity of this solution is O(n) because we have a single loop running from 1 to n,
 * and within the loop, we perform a constant amount of work (checking up to three previous states).
 *
 * Space Complexity Analysis:
 * The space complexity is O(n) due to the dp array used to store the maximum number of cuts for each length from 0 to n.
 */
