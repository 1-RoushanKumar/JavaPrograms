package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _26_MinimumCoinToMakeValueUsingMemoization {
    public static void main(String[] args) {
        int[] coins = {3,4,1};
        int val = 5;
        int[] memo = new int[val + 1];
        Arrays.fill(memo, -1);
        int ans = getMin(coins, coins.length, val, memo);
        System.out.println(Arrays.toString(memo));
        System.out.println(ans);
    }

    /**
     * This method calculates the minimum number of coins required to make the given value using memoization.
     *
     * @param coins array of different coin denominations
     * @param n the number of different coin denominations
     * @param val the total value to be made with the coins
     * @param memo array used for memoization to store results of subproblems
     * @return the minimum number of coins needed to make the given value
     */
    public static int getMin(int[] coins, int n, int val, int[] memo) {
        // Base case: if the value is 0, no coins are needed
        if (val == 0) {
            return 0;
        }

        // If the result is already computed, return it from the memo array
        if (memo[val] != -1) {
            return memo[val];
        }

        // Initialize the result to the maximum value
        int res = Integer.MAX_VALUE;

        // Try every coin that has a value smaller than or equal to the remaining value
        for (int i = 0; i < n; i++) {
            if (coins[i] <= val) {
                // Recursive call to get the minimum coins needed for the remaining value
                int subRes = getMin(coins, n, val - coins[i], memo);

                // Check if the subproblem result is not the maximum value (indicating a solution was found)
                if (subRes != Integer.MAX_VALUE) {
                    // Update the result to the minimum of the current result or the sub-problem result + 1
                    res = Math.min(res, subRes + 1);
                }
            }
        }

        // Store the result in the memo array and return it
        memo[val] = res;
        return res;
    }
}

/*
Time Complexity:
- The time complexity of the memoized solution is O(n * S), where n is the number of different coin denominations
  and S is the value to be made.
- This is because each problem is solved only once and stored in the memo array, resulting in a linear time complexity
  relative to the number of problems.

Space Complexity:
- The space complexity is O(S) due to the memo array used to store results of sub-problems.
- Additionally, the recursion stack depth is also O(S), so the overall space complexity remains O(S).
*/

