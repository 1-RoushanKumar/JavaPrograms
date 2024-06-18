package com.roushan._19_DynamicProgramming;

public class _02_NthFibonacciNumberUsingTabularForm {
    public static void main(String[] args) {
        int n = 5;
        // Print the nth Fibonacci number
        System.out.println(fibo(n));
    }

    // Function to calculate nth Fibonacci number using tabular (bottom-up) approach
    public static int fibo(int n) {
        // Create a dp array to store Fibonacci numbers
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 0;
        dp[1] = 1;

        // Fill the dp array iteratively
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return the nth Fibonacci number
        return dp[n];
    }
}

/*
 * Time Complexity:
 * The time complexity of this algorithm is O(n). We iterate from 2 to n, and each iteration takes constant time.
 *
 * Space Complexity:
 * The space complexity of this algorithm is O(n) due to the dp array, which stores the Fibonacci numbers up to n.
 */
