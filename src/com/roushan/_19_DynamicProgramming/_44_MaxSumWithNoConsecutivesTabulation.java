package com.roushan._19_DynamicProgramming;

public class _44_MaxSumWithNoConsecutivesTabulation {
    public static void main(String[] args) {
        int[] arr = {10, 5, 15, 20};
        int n = arr.length;
        int[] dp = new int[n + 1]; // Array to store maximum sum values

        // Base cases
        dp[1] = arr[0]; // Maximum sum for a subarray of size 1 is the first element
        dp[2] = Math.max(arr[0], arr[1]); // Maximum sum for a subarray of size 2 is the maximum of the first two elements

        // Fill dp array for all sizes from 3 to n
        for (int i = 3; i <= n; i++) {
            // Calculate maximum sum by choosing between:
            // 1. Not including the current element arr[i-1], taking maximum sum up to arr[i-1] (dp[i-1])
            // 2. Including the current element arr[i-1], adding it to maximum sum up to arr[i-2] (dp[i-2] + arr[i-1])
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i - 1]);
        }

        System.out.println(dp[n]); // Output the maximum sum of non-consecutive elements for the entire array
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
