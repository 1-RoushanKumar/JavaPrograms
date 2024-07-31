package com.roushan._19_DynamicProgramming;

public class _60_FrogJumpRecursion {
    public static void main(String[] args) {
        int n = 6;
        int[] health = {30, 10, 60, 10, 60, 50};
        System.out.println(find(n - 1, health));
    }

    public static int find(int i, int[] health) {
        if (i == 0) {
            return 0;
        }
        int twoStep = Integer.MAX_VALUE;

        int oneStep = find(i - 1, health) + Math.abs(health[i] - health[i - 1]);
        if (i > 1) {
            twoStep = find(i - 2, health) + Math.abs(health[i] - health[i - 2]);
        }
        return Math.min(oneStep, twoStep);
    }
}
