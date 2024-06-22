package com.roushan._19_DynamicProgramming;

public class _28_MinimumJumpsToReachEnd {
    public static void main(String[] args) {
        int[] arr = {4,1,5,3,1,3,2,1,8};
        int n = arr.length;
        int ans = getMin(arr, 0, n);
        System.out.println(ans); // Output the minimum number of jumps to reach the end
    }

    /**
     * Method to find the minimum number of jumps required to reach the end of the array
     * @param arr The input array where each element represents the maximum jump length from that position
     * @param i The current position in the array
     * @param n The length of the array
     * @return The minimum number of jumps required to reach the end, or Integer.MAX_VALUE if not possible
     */
    public static int getMin(int[] arr, int i, int n) {
        // Base case: If the current position is at or beyond the last element, no more jumps are needed
        if (i >= n - 1) {
            return 0;
        }
        // If the current element is 0, it's not possible to move forward
        if (arr[i] == 0) {
            return Integer.MAX_VALUE;
        }

        int res = Integer.MAX_VALUE; // Initialize the result to the maximum value

        // Try all possible jumps from the current position
        for (int j = 1; j <= arr[i]; j++) {
            int subRes = getMin(arr, i + j, n); // Recursive call for the next position
            // If the sub-result is valid, update the result
            if (subRes != Integer.MAX_VALUE) {
                res = Math.min(res, subRes + 1); // Add 1 to include the current jump
            }
        }

        return res; // Return the minimum number of jumps needed
    }
}

/*
Time Complexity:
The time complexity of this solution is exponential, O(2^n), where n is the length of the array.
This is because, in the worst case, each position leads to multiple recursive calls, exploring all possible jumps from that position.

Space Complexity:
The space complexity is O(n) due to the recursion stack, where n is the length of the array.
The maximum depth of the recursion tree is the length of the array in the worst case.
*/
