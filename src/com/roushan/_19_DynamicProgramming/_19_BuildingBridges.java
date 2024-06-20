package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

class Pair implements Comparable<Pair> {
    int first;
    int second;

    // Constructor to initialize the pair
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    // Override the compareTo method to sort pairs based on the first value,
    // and if they are the same, then by the second value
    @Override
    public int compareTo(Pair other) {
        if (this.first != other.first) {
            return Integer.compare(this.first, other.first);
        } else {
            return Integer.compare(this.second, other.second);
        }
    }

    // Override the toString method to print pairs in a readable format
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

public class _19_BuildingBridges {
    public static void main(String[] args) {
        // Array of pairs representing bridges
        Pair[] bridge = {new Pair(6, 2), new Pair(4, 3), new Pair(2, 6), new Pair(1, 5), new Pair(1, 3)};

        // Sort the pairs based on the first value, and if equal, then by the second value
        Arrays.sort(bridge);

        // Print the sorted pairs
        for (Pair pair : bridge) {
            System.out.println(pair);
        }

        // Step 1: Find the Longest Increasing Subsequence (LIS) based on the second values
        int[] lis = new int[bridge.length];
        lis[0] = 1; // The LIS for the first element is always 1

        for (int i = 1; i < bridge.length; i++) {
            lis[i] = 1; // Initialize LIS value for the current element
            for (int j = 0; j < i; j++) {
                // Check if the current pair's second value is greater than the previous pair's second value
                if (bridge[i].second > bridge[j].second) {
                    lis[i] = Math.max(lis[i], lis[j] + 1); // Update the LIS value
                }
            }
        }

        // Step 2: Find the maximum value in the LIS array, which represents the length of the longest increasing subsequence
        int res = lis[0];
        for (int i = 1; i < lis.length; i++) {
            res = Math.max(lis[i], res);
        }

        // Print the result, which is the length of the longest increasing subsequence
        System.out.println(res);
    }
}

/*
 * Detailed Explanation:
 *
 * 1. Pair Class:
 *    - Represents a pair of integers with `first` and `second` values.
 *    - Implements the Comparable interface to define the natural ordering of Pair objects.
 *    - The compareTo method is overridden to sort by the `first` value primarily and by the `second` value secondarily.
 *
 * 2. _19_BuildingBridges Class:
 *    - Contains the main method which demonstrates the process of sorting pairs and finding the Longest Increasing Subsequence (LIS).
 *
 * 3. Sorting the Pairs:
 *    - The pairs are sorted using the Arrays.sort method, which uses the compareTo method of the Pair class to determine the order.
 *    - After sorting, the pairs are printed to show the sorted order.
 *
 * 4. Finding the LIS:
 *    - The LIS is calculated based on the `second` values of the sorted pairs.
 *    - An array `lis` is used to store the length of the LIS ending at each index.
 *    - For each pair, the `second` values of the previous pairs are compared, and the LIS value is updated accordingly.
 *
 * 5. Finding the Maximum LIS:
 *    - The maximum value in the `lis` array is found, which represents the length of the longest increasing subsequence.
 *
 * Time Complexity:
 * The time complexity is O(n^2) due to the nested loops used to calculate the LIS.
 *
 * Space Complexity:
 * The space complexity is O(n) due to the additional array `lis` used to store the LIS values.
 */
