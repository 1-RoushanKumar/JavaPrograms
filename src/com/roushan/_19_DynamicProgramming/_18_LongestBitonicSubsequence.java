package com.roushan._19_DynamicProgramming;

public class _18_LongestBitonicSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1}; // Input array
        int n = arr.length; // Length of the array

        // Step 1: Compute the LIS (Longest Increasing Subsequence) for each element
        int[] lis = new int[n];
        lis[0] = 1;
        for (int i = 1; i < n; i++) {
            lis[i] = 1; // Initialize LIS value for arr[i]
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Step 2: Compute the LDS (Longest Decreasing Subsequence) for each element
        int[] lds = new int[n];
        lds[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            lds[i] = 1; // Initialize LDS value for arr[i]
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // Step 3: Find the maximum value of lis[i] + lds[i] - 1 for all i
        int res = lis[0] + lds[0] - 1;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, lis[i] + lds[i] - 1);
        }

        // Output the result
        System.out.println(res); // The length of the longest bitonic subsequence
    }
}

/*
 * Detailed Explanation:
 *
 * 1. Longest Increasing Subsequence (LIS):
 *    - Compute the LIS ending at each index.
 *    - Initialize each position of the `lis` array to 1, as the smallest LIS ending at any index is the element itself.
 *    - Use nested loops to compare each element with previous elements and update the LIS value if a longer subsequence is found.
 *
 * 2. Longest Decreasing Subsequence (LDS):
 *    - Compute the LDS starting at each index.
 *    - Initialize each position of the `lds` array to 1, as the smallest LDS starting at any index is the element itself.
 *    - Use nested loops to compare each element with later elements and update the LDS value if a longer subsequence is found.
 *
 * 3. Combine LIS and LDS:
 *    - For each index `i`, the length of the bitonic subsequence ending at `i` is `lis[i] + lds[i] - 1`.
 *    - Subtract 1 to avoid double counting the peak element of the bitonic subsequence.
 *    - Find the maximum value of `lis[i] + lds[i] - 1` across all indices to get the length of the longest bitonic subsequence.
 *
 * Time Complexity:
 * The time complexity of this solution is O(n^2) due to the nested loops in the LIS and LDS calculations.
 *
 * Space Complexity:
 * The space complexity is O(n) due to the arrays `lis` and `lds` used to store the subsequence lengths.
 */
