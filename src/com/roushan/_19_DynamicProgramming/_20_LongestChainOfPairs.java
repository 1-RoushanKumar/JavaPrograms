package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

// Class representing a pair of integers
class Pair1 implements Comparable<Pair1> {
    int first;
    int second;

    // Constructor to initialize the pair
    public Pair1(int first, int second) {
        this.first = first;
        this.second = second;
    }

    // Override the compareTo method to sort pairs based on the first value
    @Override
    public int compareTo(Pair1 other) {
        return Integer.compare(this.first, other.first);
    }

    // Override the toString method to print pairs in a readable format
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

public class _20_LongestChainOfPairs {
    public static void main(String[] args) {
        // Array of pairs representing the pairs
        Pair1[] arr = {
                new Pair1(5, 24),
                new Pair1(39, 60),
                new Pair1(15, 28),
                new Pair1(27, 40),
                new Pair1(50, 90)
        };

        // Sort the pairs based on the first value
        Arrays.sort(arr);

        // Print the sorted pairs
        for (Pair1 pair : arr) {
            System.out.println(pair);
        }

        // Step 1: Find the Longest Increasing Subsequence (LIS) based on the second values
        int[] lis = new int[arr.length];
        Arrays.fill(lis, 1); // Initialize the LIS array with 1

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                // Check if the current pair's first value is greater than the previous pair's second value
                if (arr[i].first > arr[j].second) {
                    lis[i] = Math.max(lis[i], lis[j] + 1); // Update the LIS value
                }
            }
        }

        // Step 2: Find the maximum value in the LIS array, which represents the length of the longest chain of pairs
        int res = lis[0];
        for (int i = 1; i < lis.length; i++) {
            res = Math.max(res, lis[i]);
        }

        // Print the result, which is the length of the longest chain of pairs
        System.out.println(res);
    }
}

/*
 * Detailed Explanation:
 *
 * 1. Pair1 Class:
 *    - Represents a pair of integers with `first` and `second` values.
 *    - Implements the Comparable interface to define the natural ordering of Pair1 objects based on the `first` value.
 *    - The compareTo method is overridden to sort by the `first` value.
 *
 * 2. _20_LongestChainOfPairs Class:
 *    - Contains the main method which demonstrates the process of sorting pairs and finding the Longest Chain of Pairs.
 *
 * 3. Sorting the Pairs:
 *    - The pairs are sorted using the Arrays.sort method, which uses the compareTo method of the Pair1 class to determine the order.
 *    - After sorting, the pairs are printed to show the sorted order.
 *
 * 4. Finding the Longest Chain of Pairs:
 *    - The Longest Chain of Pairs is calculated using dynamic programming to find the Longest Increasing Subsequence (LIS) based on the `second` values.
 *    - An array `lis` is used to store the length of the LIS ending at each index.
 *    - For each pair, the `first` value of the current pair is compared with the `second` values of the previous pairs, and the LIS value is updated accordingly.
 *
 * 5. Finding the Maximum LIS:
 *    - The maximum value in the `lis` array is found, which represents the length of the longest chain of pairs.
 *
 * Time Complexity:
 * The time complexity is O(n^2) due to the nested loops used to calculate the LIS.
 *
 * Space Complexity:
 * The space complexity is O(n) due to the additional array `lis` used to store the LIS values.
 */
