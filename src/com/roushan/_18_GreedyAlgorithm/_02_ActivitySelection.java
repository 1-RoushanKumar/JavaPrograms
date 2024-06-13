package com.roushan._18_GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

class Activity {
    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class _02_ActivitySelection {
    public static void main(String[] args) {
        int[] start = {3, 2, 1, 10};
        int[] end = {8, 4, 3, 11};
        Activity[] pairArray = new Activity[start.length];
        for (int i = 0; i < start.length; i++) {
            pairArray[i] = new Activity(start[i], end[i]);
        }
        System.out.println(maxActivity(pairArray));
    }

    public static int maxActivity(Activity[] arr) {
        // Sort activities based on their end times
        Arrays.sort(arr, Comparator.comparingInt(a -> a.end));

        int res = 1; // Initialize result counter
        int prev = 0; // Index of the last selected activity

        // Iterate over sorted activities
        for (int i = 1; i < arr.length; i++) {
            // If current activity starts after or exactly when the previous one ends
            if (arr[i].start >= arr[prev].end) {
                res++; // Increment the count of activities
                prev = i; // Update the index of the last selected activity
            }
        }
        return res; // Return the maximum number of non-overlapping activities
    }
}
