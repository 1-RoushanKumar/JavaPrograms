package com.roushan._19_DynamicProgramming;

public class _62_FrogJumpTabulation {
    public static void main(String[] args) {
        int n = 6;
        int[] health = {30, 10, 60, 10, 60, 50};
        System.out.println(minimumEnergy(health, n));
    }

    public static int minimumEnergy(int[] arr, int N) {
        // Create a dp array to store the minimum energy required to reach each stone
        int[] dp = new int[N];
        // Initialize the energy to reach the first stone as 0
        dp[0] = 0;

        // Iterate over each stone starting from the second one
        for (int i = 1; i < N; i++) {
            // Calculate the energy required to jump from the previous stone
            int left = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            // Initialize right to a very large value
            int right = Integer.MAX_VALUE;
            // If there are at least two stones before the current one, calculate the energy for jumping over one stone
            if (i > 1) {
                right = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }
            // Store the minimum energy required to reach this stone
            dp[i] = Math.min(left, right);
        }

        // Return the minimum energy required to reach the last stone
        return dp[N - 1];
    }
}
