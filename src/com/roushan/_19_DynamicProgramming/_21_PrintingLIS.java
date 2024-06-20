package com.roushan._19_DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int[] arr) {
        // ArrayList to store the result of the longest increasing subsequence
        ArrayList<Integer> ans = new ArrayList<>();

        // Array to store the length of the LIS ending at each index
        int[] lis = new int[n];

        // Array to store the previous index in the LIS for each index
        int[] prevIndexes = new int[n];

        // Initialize the LIS and previous index arrays
        for (int i = 0; i < n; i++) {
            lis[i] = 1;          // Each element is an LIS of length 1 by itself
            prevIndexes[i] = i;  // Initialize previous index to itself
        }

        // Compute the length of the LIS ending at each index
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // If arr[i] can be appended to the LIS ending at arr[j]
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;   // Update the LIS length ending at i
                    prevIndexes[i] = j;    // Update the previous index for i
                }
            }
        }

        // Find the index of the maximum element in the LIS array
        int maxEleInd = 0;
        for (int i = 1; i < n; i++) {
            if (lis[i] > lis[maxEleInd]) {
                maxEleInd = i;  // Update the index of the longest LIS found so far
            }
        }

        // Reconstruct the longest increasing subsequence using prevIndexes array
        int index = maxEleInd;
        while (prevIndexes[index] != index) {
            ans.add(arr[index]);  // Add current element to the result list
            index = prevIndexes[index];  // Move to the previous index in the LIS
        }
        ans.add(arr[index]);  // Add the last element in the LIS

        // Since we added the elements in reverse order, reverse the result
        Collections.reverse(ans);

        return ans;  // Return the longest increasing subsequence
    }
}

public class _21_PrintingLIS {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Sample array
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int n = arr.length;  // Length of the array

        // Call the function to find the LIS and store the result
        ArrayList<Integer> result = solution.longestIncreasingSubsequence(n, arr);

        // Print the longest increasing subsequence
        System.out.println("Longest Increasing Subsequence: " + result);
    }
}

