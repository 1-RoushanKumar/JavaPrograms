package com.roushan._19_DynamicProgramming;

public class _25_MinimumCoinsToMakeValueUsingRecursion {
    public static void main(String[] args) {
        int[] coins = {25, 10, 5};
        int val = 30;
        int ans = getMin(coins, coins.length, val);
        System.out.println(ans);
    }

    /**
     * This method calculates the minimum number of coins required to make the given value.
     *
     * @param coins array of different coin denominations
     * @param n the number of different coin denominations
     * @param val the total value to be made with the coins
     * @return the minimum number of coins needed to make the given value
     */
    public static int getMin(int[] coins, int n, int val) {
        // Base case: if the value is 0, no coins are needed
        if (val == 0) {
            return 0;
        }

        // Initialize the result to the maximum value
        int res = Integer.MAX_VALUE;

        // Try every coin that has a value smaller than or equal to the remaining value
        for (int i = 0; i < n; i++) {
            if (coins[i] <= val) {
                // Recursive call to get the minimum coins needed for the remaining value
                int subRes = getMin(coins, n, val - coins[i]);

                // Check if the subproblem result is not the maximum value (indicating a solution was found)
                if (subRes != Integer.MAX_VALUE) {
                    // Update the result to the minimum of the current result or the subproblem result + 1
                    res = Math.min(res, subRes + 1);
                }
            }
        }

        // Return the result
        return res;
    }
}

/*
Time Complexity:
- The time complexity of this recursive solution is exponential, specifically O(S^n),
  where S is the value to be made and n is the number of different coin denominations.
- This is because, in the worst case, the function explores all combinations of coins
  for each value from 1 to S, leading to a large number of recursive calls.

Space Complexity:
- The space complexity is O(S) due to the maximum depth of the recursion stack,
  which occurs when making the largest possible value using the smallest denomination coin.
- Each recursive call adds a new frame to the stack, and the maximum number of frames is equal to the value S.
*/
