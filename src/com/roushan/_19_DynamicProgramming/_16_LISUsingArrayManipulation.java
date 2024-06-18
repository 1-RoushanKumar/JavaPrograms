package com.roushan._19_DynamicProgramming;

public class _16_LISUsingArrayManipulation {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 8, 10}; // Array for which we want to find the longest increasing subsequence
        int n = arr.length; // Length of the array
        int ans = findLis(arr, n);
        System.out.println(ans); // Output the result
    }

    /**
     * Function to find the length of the longest increasing subsequence.
     *
     * @param arr The input array.
     * @param n   The length of the array.
     * @return The length of the longest increasing subsequence.
     */
    private static int findLis(int[] arr, int n) {
        if (n == 0) return 0;

        int[] lis = new int[n]; // Array to store the length of LIS ending at each index
        lis[0] = 1; // LIS ending at the first element is 1

        // Fill lis[] for each element
        for (int i = 1; i < n; i++) {
            lis[i] = 1; // Initialize LIS value for arr[i]
            for (int j = 0; j < i; j++) {
                // If arr[i] is greater than arr[j], and including arr[i] in the sequence ending at arr[j] makes a longer sequence
                if (arr[i] > arr[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Find the maximum value in lis[]
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, lis[i]);
        }
        return res;
    }
}

/*
 * Time Complexity:
 * The time complexity of this solution is O(n^2).
 * This is because there are two nested loops:
 * the outer loop runs for each element (n times), and the inner loop also runs for each element (in the worst case, up to n times).
 *
 * Space Complexity:
 * The space complexity is O(n) due to the array 'lis' used to store the length of the longest increasing subsequence ending at each index.
 */
