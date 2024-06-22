package com.roushan._19_DynamicProgramming;

public class _32_0_1_KnapSackUsingRecursion {
    public static void main(String[] args) {
        int[] val = {10, 40, 30, 50}; // Values of the items
        int[] wt = {5, 4, 6, 3}; // Weights of the items
        int weight = 10; // Maximum weight capacity of the knapsack
        int n = val.length; // Number of items
        int ans = knapSack(wt, val, n, weight); // Call the knapSack function
        System.out.println(ans); // Output the maximum value that can be obtained
    }

    // Recursive function to solve the 0/1 Knapsack problem
    public static int knapSack(int[] wt, int[] val, int n, int w) {
        // Base case: if no items are left or knapsack capacity is 0
        if (w == 0 || n == 0) {
            return 0;
        }
        // If the weight of the nth item is more than the knapsack capacity w, it cannot be included
        if (wt[n - 1] > w) {
            return knapSack(wt, val, n - 1, w);
        } else {
            // Return the maximum of two cases:
            // 1. nth item included
            // 2. nth item not included
            return Math.max(knapSack(wt, val, n - 1, w), val[n - 1] + knapSack(wt, val, n - 1, w - wt[n - 1]));
        }
    }
}

/*
Time Complexity:
The time complexity of this recursive solution is O(2^n), where n is the number of items.
This is because for each item, we have two choices (include it or exclude it), leading to an exponential growth of possibilities.

Space Complexity:
The space complexity is O(n), due to the maximum depth of the recursion stack being equal to the number of items n.
*/
