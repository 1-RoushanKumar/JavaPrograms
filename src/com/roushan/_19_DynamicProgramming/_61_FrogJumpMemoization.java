package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _61_FrogJumpMemoization {
    public static void main(String[] args) {
        int n = 6;
        int[] health = {30, 10, 60, 10, 60, 50};
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(find(n - 1, health, memo));
    }

    public static int find(int i, int[] health, int[] memo) {
        if (i == 0) {
            return 0;
        }
        int twoStep = Integer.MAX_VALUE;
        if (memo[i] != -1) {
            return memo[i];
        }
        int oneStep = find(i - 1, health, memo) + Math.abs(health[i] - health[i - 1]);
        if (i > 1) {
            twoStep = find(i - 2, health, memo) + Math.abs(health[i] - health[i - 2]);
        }
        memo[i] = Math.min(oneStep, twoStep);
        return Math.min(oneStep, twoStep);
    }
}
