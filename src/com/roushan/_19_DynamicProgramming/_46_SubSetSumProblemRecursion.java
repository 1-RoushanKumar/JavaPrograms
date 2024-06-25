package com.roushan._19_DynamicProgramming;

public class _46_SubSetSumProblemRecursion {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 3, 6}; // Example array
        int sum = 8; // Target sum
        int n = arr.length; // Length of the array
        int ans = count(arr, sum, n); // Call the recursive function
        System.out.println(ans); // Output the result
    }

    // Recursive function to count the number of subsets with a given sum
    public static int count(int[] arr, int sum, int n) {
        // Base case: If both sum and n are 0, there's exactly one subset (the empty subset)
        if (n == 0 && sum == 0) {
            return 1;
        }
        // Base case: If sum is 0, there's exactly one subset (the empty subset)
        if (sum == 0) {
            return 1;
        }
        // Base case: If n is 0 and sum is not 0, there's no subset that adds up to sum
        if (n == 0) {
            return 0;
        }

        // Recursive case:
        // If the last element is greater than sum, it cannot be included in the subset
        if (arr[n - 1] > sum) {
            return count(arr, sum, n - 1);
        } else {
            // Return the count of subsets including the last element and excluding the last element
            return count(arr, sum - arr[n - 1], n - 1) + count(arr, sum, n - 1);
        }
    }

    /*
     * Time Complexity: O(2^n)
     * The function explores all subsets, and there are 2^n subsets of a set with n elements.
     *
     * Space Complexity: O(n)
     * The space complexity is proportional to the maximum depth of the recursion tree, which is n.
     */
}
