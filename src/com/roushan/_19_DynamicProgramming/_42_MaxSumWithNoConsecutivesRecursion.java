package com.roushan._19_DynamicProgramming;

public class _42_MaxSumWithNoConsecutivesRecursion {
    public static void main(String[] args) {
        int[] arr = {10, 5, 15, 20};
        int n = arr.length;
        int ans = maxSum(arr, n);
        System.out.println(ans); // Output the maximum sum of non-consecutive elements
    }

    /**
     * Function to calculate the maximum sum of elements in an array such that no two elements are adjacent.
     *
     * @param arr The input array of integers.
     * @param n   The number of elements in the current subarray being considered.
     * @return The maximum sum possible with non-consecutive elements up to index 'n' in the array 'arr'
     * Time Complexity: O(2^n)
     * - Each recursive call branch into two further calls, leading to an exponential number of calls.
     * - However, due to overlapping subproblems, the effective time complexity is reduced in practice.
     * Space Complexity: O(n)
     * - The space complexity is O(n) due to the recursive stack space used by the function calls.
     */
    public static int maxSum(int[] arr, int n) {
        // Base cases
        if (n == 1) {
            return arr[0]; // If there is only one element, return that element as the maximum sum.
        } else if (n == 2) {
            return Math.max(arr[0], arr[1]); // If there are two elements, return the maximum of the two.
        } else {
            // Recursive cases
            // Calculate the maximum sum:
            // 1. Excluding the current element arr[n-1] and taking the maximum sum up to arr[n-1] (n-1 elements)
            // 2. Including the current element arr[n-1] and adding it to the maximum sum up to arr[n-2] (n-2 elements)
            return Math.max(maxSum(arr, n - 1), maxSum(arr, n - 2) + arr[n - 1]);
        }
    }
}
