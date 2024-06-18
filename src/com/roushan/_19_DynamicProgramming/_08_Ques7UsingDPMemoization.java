package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _08_Ques7UsingDPMemoization {
    public static void main(String[] args) {
        int[] coins = {1, 2};
        int sum = 4;
        int ans = countMemo(coins, coins.length, sum);
        System.out.println(ans);
    }

    public static int countMemo(int[] coins, int n, int sum) {
        // Memoization array, initialized with -1
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = countMemoHelper(coins, n, sum, dp);
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return res;
    }

    private static int countMemoHelper(int[] coins, int n, int sum, int[][] dp) {
        // Base cases
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        // Check if the value is already computed
        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }

        // Compute the result recursively
        int res = countMemoHelper(coins, n - 1, sum, dp);
        if (coins[n - 1] <= sum) {
            res += countMemoHelper(coins, n, sum - coins[n - 1], dp);
        }

        // Store the computed result in memoization table
        dp[n][sum] = res;

        return res;
    }

}
