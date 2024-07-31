package com.roushan._9_Recursions;

import java.util.Arrays;

//the problem say we have given ex = (n=5,a=2,b=5,c=1) we need to find which length rope should be cut which give maximum number of rope cuts.
//here if we cut n=5 in c=1(length), then we can get 5 pieces of rope cut which the maximum.
//GFG Recursion PlayList Lec 12.
public class _33_RecursionRopeCutting {
    public static void main(String[] args) {
        int n = 5, a = 2, b = 5, c = 1;
        int ans = cut(n, a, b, c);
        System.out.println(ans);

        System.out.println();
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(cut1(n, a, b, c, memo));
    }

    //time = O(3^n)
    public static int cut(int n, int a, int b, int c) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        int res = Math.max(cut(n - a, a, b, c), cut(n - b, a, b, c));
        res = Math.max(res, cut(n - c, a, b, c));
        //we need to find max of all three cases, but in math.max we can only store two at time
        //so, we again compare a result with a remaining case.
        if (res == -1) {
            return -1;
        }
        return res + 1;
    }

    //DP solution.
    public static int cut1(int n, int a, int b, int c, int[] memo) {
        // Base case: if n is 0, no more cuts are needed
        if (n == 0) {
            return 0;
        }

        // Base case: if n is negative, it's not possible to make a valid cut
        if (n < 0) {
            return -1;
        }

        // If the result for this value of n is already computed, return it
        if (memo[n] != -1) {
            return memo[n];
        }

        // Recursively calculate the maximum number of cuts possible by reducing the length by a, b, or c
        int res = Math.max(cut1(n - a, a, b, c, memo), cut1(n - b, a, b, c, memo));
        res = Math.max(res, cut1(n - c, a, b, c, memo));

        // If no valid cut could be made (res remains -1), return -1
        if (res == -1) {
            memo[n] = -1;  // Store the result in the memoization table
            return -1;
        }

        // Store the result in the memoization table and return the number of cuts plus one
        memo[n] = res + 1;
        return res + 1;
    }

    /*
     * Detailed comments and time/space complexity analysis:
     *
     * The function `cut1` determines the maximum number of pieces that can be obtained by
     * cutting a rod of length `n` using pieces of lengths `a`, `b`, and `c`. It uses memoization
     * to store already computed results for specific lengths to avoid redundant calculations.
     *
     * - Base Case 1: If `n == 0`, no more cuts are needed, so the function returns 0.
     * - Base Case 2: If `n < 0`, it's impossible to make a valid cut, so the function returns -1.
     * - Memoization Check: If the result for `n` is already computed and stored in `memo`, it returns that result.
     * - Recursive Calculation: The function recursively calculates the maximum number of cuts for the remaining lengths after cutting off pieces of length `a`, `b`, or `c`.
     * - Result Storage: The function stores the computed result in the memoization table `memo` to avoid redundant calculations.
     * - Final Result: If the maximum number of cuts is -1 (no valid cuts), it returns -1. Otherwise, it returns the maximum number of cuts plus one (for the current cut).
     *
     * Time Complexity:
     * - The time complexity of this solution is O(n) because each value of `n` from 0 to `n` is computed once and stored in the `memo` array.
     * - The recursive calls for each length reduction (`n - a`, `n - b`, `n - c`) are limited by the memoization check.
     *
     * Space Complexity:
     * - The space complexity is O(n) due to the memoization array `memo` that stores the results for each length from 0 to `n`.
     * - The space used by the recursive call stack is also O(n) in the worst case.
     */

}
