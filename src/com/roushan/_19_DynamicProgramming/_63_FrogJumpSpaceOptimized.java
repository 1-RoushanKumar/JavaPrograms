package com.roushan._19_DynamicProgramming;

public class _63_FrogJumpSpaceOptimized {
    public static void main(String[] args) {
        // Number of stones
        int n = 6;
        // Health cost at each stone
        int[] health = {30, 10, 60, 10, 60, 50};
        // Calculate and print the minimum energy required to reach the last stone
        System.out.println(minimumEnergy(health, n));
    }

    // Function to calculate the minimum energy required to reach the last stone
    public static int minimumEnergy(int[] arr, int N) {
        // Initialize variables to store the minimum energy required to reach the previous two stones
//        If we closely look at the values required at every iteration, dp[i], dp[i-1], and  dp[i-2]
//        we see that for any i, we do need only the last two values in the array. So is there a need to maintain a whole array for it?
//        The answer is ‘No.’ Let us call dp[i-1] as prev and dp[i-2] as prev2.
        int prev = 0;
        int prevPrev = 0;

        // Iterate over each stone starting from the second one
        for (int i = 1; i < N; i++) {
            // Calculate the energy required to jump from the previous stone
            int left = prev + Math.abs(arr[i] - arr[i - 1]);
            // Initialize right to a very large value
            int right = Integer.MAX_VALUE;
            // If there are at least two stones before the current one, calculate the energy for jumping over one stone
            if (i > 1) {
                right = prevPrev + Math.abs(arr[i] - arr[i - 2]);
            }
            // Store the minimum energy required to reach this stone
            int curr = Math.min(left, right);
            // Update prevPrev and prev for the next iteration
            prevPrev = prev;
            prev = curr;
        }
        // Return the minimum energy required to reach the last stone
        return prev;
    }
}
