package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _64_FrogJumpWithAtMostKStep {
    public static void main(String[] args) {
        int n = 6;
        int[] health = {30, 10, 60, 10, 60, 50};
        int k = 5;
        System.out.println(minimizeCost(health, n, k));
    }

    public static int minimizeCost(int[] arr, int N, int K) {
        // Initialize memo array with -1, indicating that the values have not been computed yet
        int[] memo = new int[N];
        Arrays.fill(memo, -1);
        // Call the recursive function starting from the last stone (N-1)
        return ans(N - 1, memo, arr, K);
    }

    public static int ans(int n, int[] memo, int[] arr, int K) {
        // Base case: if the frog is on the first stone, no energy is needed
        if (n == 0) {
            return 0;
        }
        // If the result for this stone is already computed, return it
        if (memo[n] != -1) {
            return memo[n];
        }
        int res = Integer.MAX_VALUE;
        // Iterate over all possible jumps from 1 to K
        for (int i = 1; i <= K; i++) {
            // Ensure we do not jump out of bounds
            if (n - i >= 0) {
                res = Math.min(res, ans(n - i, memo, arr, K) + Math.abs(arr[n] - arr[n - i]));
            }
        }
        // Memoize the result for the current stone
        memo[n] = res;
        return res;
    }
}


