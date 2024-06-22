package com.roushan._19_DynamicProgramming;

public class _34_0_1_KnapSackUsingTabulation {
    public static void main(String[] args) {
        int[] val = {10, 40, 30, 50}; // Values of the items
        int[] wt = {5, 4, 6, 3}; // Weights of the items
        int weight = 10; // Maximum weight capacity of the knapsack
        int n = val.length; // Number of items

        // Create a 2D array to store the maximum value that can be obtained for each weight and item combination
        int[][] dp = new int[n + 1][weight + 1];

        // Fill the dp array using a bottom-up approach
        for (int i = 1; i <= n; i++) { // Iterate over items
            for (int j = 1; j <= weight; j++) { // Iterate over all possible weights from 1 to weight
                if (wt[i - 1] > j) { // If the weight of the current item is more than the current weight capacity
                    dp[i][j] = dp[i - 1][j]; // Current item cannot be included
                } else {
                    // Current item can be included or excluded, take the maximum value of both cases
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
            }
        }

        // Output the maximum value that can be obtained with the given weight capacity
        System.out.println(dp[n][weight]);
    }
}

/*
Time Complexity:
The time complexity of this solution is O(n * w), where n is the number of items and w is the weight capacity of the knapsack.
This is because we are using a nested loop to fill the dp array.

Space Complexity:
The space complexity is O(n * w) due to the 2D dp array used to store the maximum values for each weight and item combination.
*/
