package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _27_MinimumCoinsToMakeValueUsingTabulation {
    public static void main(String[] args) {
        int[] coins = {3, 4, 1};
        int val = 5;
        int ans = getMin(coins, coins.length, val);
        System.out.println(ans);
    }

    /**
     * This method calculates the minimum number of coins required to make the given value using tabulation.
     *
     * @param coins array of different coin denominations
     * @param n the number of different coin denominations
     * @param val the total value to be made with the coins
     * @return the minimum number of coins needed to make the given value
     */
    private static int getMin(int[] coins, int n, int val) {
        // Create an array to store the minimum number of coins needed for each value from 0 to val
        int[] dp = new int[val + 1];

        // Initialize the dp array with a large value (indicating initially impossible to make that value)
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case: 0 coins are needed to make value 0
        dp[0] = 0;

        // Compute minimum coins required for each value from 1 to val
        for (int i = 1; i <= val; i++) {
            // Iterate through each coin denomination
            for (int j = 0; j < n; j++) {
                // Check if the current coin can be used to make the current value i
                if (coins[j] <= i) {
                    // Calculate the result if we were to use one more coin of denomination coins[j]
                    int subRes = dp[i - coins[j]];

                    // Check if the subproblem result is valid (i.e., not Integer.MAX_VALUE)
                    if (subRes != Integer.MAX_VALUE) {
                        // Update dp[i] to the minimum of its current value or subRes + 1 (use one more coin)
                        dp[i] = Math.min(dp[i], subRes + 1);
                    }
                }
            }
        }

        // If dp[val] is still Integer.MAX_VALUE, it means val cannot be formed with the given coins
        // Return -1 in such cases, otherwise return dp[val] which contains the minimum coins required
        return dp[val] == Integer.MAX_VALUE ? -1 : dp[val];
    }
}

/*
Time Complexity:
- The outer loop runs from 1 to val, so it iterates val times.
- The inner loop runs n times for each value of i, where n is the number of coin denominations.
- Therefore, the total number of operations is O(n * val).

Space Complexity:
- The space complexity is O(val) due to the dp array, which stores results for each value from 0 to val.
- Additional space complexity is O(1) for other variables (constants and loop indices), which is negligible compared to the dp array.
*/
