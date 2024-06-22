package com.roushan._19_DynamicProgramming;

public class _45_MaxSumWithNoConsecutivesSpaceOptimizedTabulation {
    public static void main(String[] args) {
        int[] arr = {10, 5, 15, 20};
        int n = arr.length;

        // Base cases
        int prev_prev = arr[0]; // Initialize for the first element
        int prev = Math.max(arr[0], arr[1]); // Initialize for the second element
        int res = prev; // Store the result

        // Iterate through the array from the third element to the end
        for (int i = 3; i <= n; i++) {
            // Calculate the current maximum sum by choosing between:
            // 1. Not including the current element arr[i-1], taking maximum sum up to arr[i-1] (prev)
            // 2. Including the current element arr[i-1], adding it to maximum sum up to arr[i-2] (prev_prev + arr[i-1])
            res = Math.max(prev, prev_prev + arr[i - 1]);

            // Update variables for the next iteration
            prev_prev = prev;
            prev = res;
        }

        // Output the maximum sum of non-consecutive elements for the entire array
        System.out.println(res);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
