package com.roushan._18_GreedyAlgorithm;

import java.util.Arrays;

public class _01_MinimumNumberOfCoinsToGetSum {
    public static void main(String[] args) {
        int[] coins = {5, 10, 1, 2};
        int sum = 57;
        int ans = getMin(coins, sum);
        System.out.println(ans);
    }

    public static int getMin(int[] coins, int sum) {
        // Sort the array in ascending order
        Arrays.sort(coins);

        // Reverse the sorted array to make it descending
        int s = 0;
        int e = coins.length - 1;
        while (s < e) {
            int temp = coins[s];
            coins[s] = coins[e];
            coins[e] = temp;
            s++;
            e--;
        }

        int res = 0; // Variable to store the result (minimum number of coins)

        // Iterate over the sorted (descending) coins array
        for (int coin : coins) {
            if (sum >= coin) {
                // Calculate how many coins of the current denomination can be used
                int c = sum / coin;
                res = res + c; // Add the count to the result
                sum = sum - (c * coin); // Reduce the sum by the amount contributed by these coins
            }
            if (sum == 0) {
                break; // If the sum is zero, no more coins are needed
            }
        }

        return res; // Return the minimum number of coins needed
    }
}
