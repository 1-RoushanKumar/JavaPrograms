package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _30_MinimumJumpsToReachEndUsingTabulation {
    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 3, 1, 3, 2, 1, 8};
        int ans = getMin(arr);
        System.out.println(ans); // Output the minimum number of jumps to reach the end
    }

    /**
     * Method to find the minimum number of jumps required to reach the end of the array using tabulation
     * @param arr The input array where each element represents the maximum jump length from that position
     * @return The minimum number of jumps required to reach the end, or -1 if not possible
     */
    public static int getMin(int[] arr) {
        int n = arr.length;
        // Create an array to store the minimum number of jumps to reach each position
        int[] jumps = new int[n];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0; // Base case: 0 jumps needed to reach the first element

        // Fill the jumps array using a bottom-up approach
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // If position j is reachable and from position j, position i is reachable
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                }
            }
        }

        // If the end is reachable, return the minimum number of jumps needed, otherwise return -1
        return jumps[n - 1] == Integer.MAX_VALUE ? -1 : jumps[n - 1];
    }
}

/*
Time Complexity:
The time complexity of this solution is O(n^2), where n is the length of the array.
This is because we have a nested loop, iterating over each pair of elements.

Space Complexity:
The space complexity is O(n) due to the jumps array used to store the minimum number of jumps needed to reach each position.
*/

