package com.roushan._15_Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class _09_KClosestElement {
    public static void main(String[] args) {
        //the question is to find the closet element of x
        //here closet elements to 35 is 20,38 and 40.
        int[] arr = {10, 30, 5, 40, 38, 80, 70};
        int x = 35;
        int k = 3;

        printK(arr, arr.length, k, x);
        System.out.println();
        printKClosestElements(arr, arr.length, k, x);
    }

    //Naive Approach which take time = O(N*K) and space = O(N).
    public static void printK(int[] arr, int n, int k, int x) {
        //the idea is to traverse the whole array k times to find the k elements which is closet to x.
        //boolean visited is used to mark the element which is found to be shortest.
        boolean[] visited = new boolean[n];
        //loop run k times for find k closet element.
        for (int i = 0; i < k; i++) {
            //to track min_diff number that helps to find the number closet to x.
            int min_diff = Integer.MAX_VALUE;
            //this min_diff_index used to mark in boolean and printing the element.
            int min_diff_index = 0;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && Math.abs(arr[j] - x) <= min_diff) {
                    min_diff = Math.abs(arr[j] - x);
                    min_diff_index = j;
                }
            }
            System.out.print(arr[min_diff_index] + " ");
            visited[min_diff_index] = true;
        }
    }

    //Optimal Solution
    static class Pair implements Comparable<Pair> {
        int diff;  // The absolute difference from x
        int index; // The index of the element in the array

        Pair(int diff, int index) {
            this.diff = diff;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.diff, other.diff);
        }
    }

    public static void printKClosestElements(int[] arr, int n, int k, int x) {
        // Max-heap to store pairs of (difference from x, index)
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Add the first k elements to the max-heap
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(Math.abs(arr[i] - x), i));
        }

        // Process the remaining elements
        for (int i = k; i < n; i++) {
            int diff = Math.abs(arr[i] - x);
            // If the current element's difference is smaller than the largest difference in the heap
            if (pq.peek() != null && pq.peek().diff > diff) {
                pq.poll(); // Remove the element with the largest difference
                pq.add(new Pair(diff, i)); // Add the current element
            }
        }

        // Extract the k closest elements from the max-heap and print them
        for (int i = 0; i < k; i++) {
            assert pq.peek() != null;
            System.out.print(arr[pq.poll().index] + " ");
        }
        System.out.println(); // Add a newline for better output readability
    }
}
