package com.roushan._19_DynamicProgramming;

public class _09_Ques7UsingDPTabulation {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 4;
        int ans = countTabulation(coins, coins.length, sum);
        System.out.println(ans);
    }

    public static int countTabulation(int[] coins, int n, int sum) {
        // Create a DP table
        int[][] dp = new int[n + 1][sum + 1];

        // Base case initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // There is exactly one way to make sum 0, by choosing no coins
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j]; // Exclude the coin
                if (coins[i - 1] <= j) {
                    dp[i][j] += dp[i][j - coins[i - 1]]; // Include the coin
                }
            }
        }

        return dp[n][sum];
    }

}
