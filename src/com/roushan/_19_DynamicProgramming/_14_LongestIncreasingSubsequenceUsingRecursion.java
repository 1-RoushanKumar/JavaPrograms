package com.roushan._19_DynamicProgramming;

public class _14_LongestIncreasingSubsequenceUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 8, 10}; // Array for which we want to find the longest increasing subsequence
        int n = arr.length; // Length of the array
        int ans = lis(arr, 0, -1, n); // Initial call to the recursive function
        System.out.println(ans); // Output the result
    }

    /*
     * Recursive function to find the length of the longest increasing subsequence.
     *
     * @param arr The input array.
     * @param i The current index in the array.
     * @param prev The index of the previous element in the subsequence.
     * @param n The length of the array.
     * @return The length of the longest increasing subsequence from index i to the end of the array.
     */
    private static int lis(int[] arr, int i, int prev, int n) {
        // Base case: If we've reached the end of the array
        if (i == n) {
            return 0;
        }

        // Case 1: Do not include the current element in the subsequence
        int NotTake = lis(arr, i + 1, prev, n);

        // Case 2: Include the current element in the subsequence if it forms an increasing sequence
        int take = 0;
        if (prev == -1 || arr[i] > arr[prev]) {
            take = 1 + lis(arr, i + 1, i, n);
        }

        // Return the maximum length of the subsequence by either taking or not taking the current element
        return Math.max(NotTake, take);
    }
}

/*
 * Time Complexity:
 * The time complexity of this recursive solution is O(2^n) in the worst case.
 * This is because at each step, the function makes two recursive calls:
 * one including the current element and one excluding it.
 * This results in an exponential number of function calls as the array size n increases.
 *
 * Space Complexity:
 * The space complexity is O(n) due to the recursion stack depth,
 * which can go up to n in the worst case.
 * Each function call adds a layer to the stack,
 * and the maximum depth of the stack will be equal to the number of elements in the array.
 */
