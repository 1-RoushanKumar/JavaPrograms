package com.roushan._19_DynamicProgramming;

import java.util.ArrayList;

public class _17_LISMostEfficientSolution {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 8, 10}; // Array for which we want to find the longest increasing subsequence
        int n = arr.length; // Length of the array

        // ArrayList to store the current longest increasing subsequence
        ArrayList<Integer> tail = new ArrayList<>();
        tail.add(arr[0]);

        for (int i = 1; i < n; i++) {
            // If arr[i] is greater than the last element in the tail, append it to the tail
            if (arr[i] > tail.getLast()) {
                tail.add(arr[i]);
            } else {
                // Find the position of the smallest element in the tail which is greater than or equal to arr[i]
                int c = ceil(tail, 0, tail.size() - 1, arr[i]);
                // Replace the element at position c with arr[i]
                tail.set(c, arr[i]);
            }
        }

        // The size of the tail is the length of the longest increasing subsequence
        System.out.println(tail.size());
    }

    /**
     * Function to find the index of the smallest element in the tail which is greater than or equal to ele
     *
     * @param tail The list storing the current longest increasing subsequence
     * @param s    The starting index for the binary search
     * @param e    The ending index for the binary search
     * @param ele  The element to find the ceil for
     * @return The index of the ceil element
     */
    public static int ceil(ArrayList<Integer> tail, int s, int e, int ele) {
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (tail.get(mid) >= ele) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return e;
    }
}

/*
 * Time Complexity:
 * The time complexity of this solution is O(n log n).
 * The outer loop runs in times, and for each iteration, we perform a binary search
 * which takes O(log n) time. Hence, the overall time complexity is O(n log n).
 *
 * Space Complexity:
 * The space complexity is O(n) due to the array list 'tail' used to store the
 * elements of the longest increasing subsequence.
 */
