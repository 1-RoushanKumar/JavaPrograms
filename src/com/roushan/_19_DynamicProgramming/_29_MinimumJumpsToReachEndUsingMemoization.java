package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _29_MinimumJumpsToReachEndUsingMemoization {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        int n = arr.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1); // Initialize memo array with -1 indicating uncalculated states
        int ans = getMin(arr, 0, n, memo);
        System.out.println(Arrays.toString(memo));
        System.out.println(ans); // Output the minimum number of jumps to reach the end
    }

    /**
     * Method to find the minimum number of jumps required to reach the end of the array using memoization
     * @param arr The input array where each element represents the maximum jump length from that position
     * @param i The current position in the array
     * @param n The length of the array
     * @param memo The memoization array to store results of subproblems
     * @return The minimum number of jumps required to reach the end, or Integer.MAX_VALUE if not possible
     */
    public static int getMin(int[] arr, int i, int n, int[] memo) {
        // Base case: If the current position is at or beyond the last element, no more jumps are needed
        if (i >= n - 1) {
            return 0;
        }
        // If the current element is 0, it's not possible to move forward
        if (arr[i] == 0) {
            return Integer.MAX_VALUE;
        }
        // If the result for this position is already calculated, return it
        if (memo[i] != -1) {
            return memo[i];
        }

        int res = Integer.MAX_VALUE; // Initialize the result to the maximum value

        // Try all possible jumps from the current position
        for (int j = 1; j <= arr[i]; j++) {
            int subRes = getMin(arr, i + j, n, memo); // Recursive call for the next position
            // If the sub-result is valid, update the result
            if (subRes != Integer.MAX_VALUE) {
                res = Math.min(res, subRes + 1); // Add 1 to include the current jump
            }
        }

        memo[i] = res; // Store the result in the memoization array
        return memo[i];
    }
}

/*
Time Complexity:
The time complexity of this solution is O(n^2), where n is the length of the array.
This is because each position in the array is processed once, and for each position, we may explore all positions reachable by the maximum jump.

Space Complexity:
The space complexity is O(n) due to the memoization array and the recursion stack.
The memoization array of size n is used to store results of subproblems, and the maximum depth of the recursion tree is also n.
*/
