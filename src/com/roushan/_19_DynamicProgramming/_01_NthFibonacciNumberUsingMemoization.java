package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _01_NthFibonacciNumberUsingMemoization {
    public static void main(String[] args) {
        int n = 5;
        // Initialize memoization array with -1
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        // Print the nth Fibonacci number
        System.out.println(fibo(n, memo));
    }

    // Recursive function to calculate nth Fibonacci number using memoization
    public static int fibo(int n, int[] memo) {
        // Check if the value is already computed
        if (memo[n] == -1) {
            int res;
            // Base cases: fib(0) = 0, fib(1) = 1
            if (n == 0 || n == 1) {
                res = n;
            } else {
                // Recursive call to calculate fib(n-1) + fib(n-2)
                res = fibo(n - 1, memo) + fibo(n - 2, memo);
            }
            // Store the computed value in memo array
            memo[n] = res;
        }
        // Return the computed or memoized value
        return memo[n];
    }
}

/*
 * Time Complexity:
 * The time complexity of this algorithm is O(n). Each value from 0 to n is
 * computed once and stored in the memo array, making the function calls linear in terms of n.
 *
 * Space Complexity:
 * The space complexity of this algorithm is O(n) due to the memo array, which stores n+1 elements.
 * Additionally, the call stack will have a depth of at most n due to the recursive calls,
 * which also contributes to the O(n) space complexity.
 */
