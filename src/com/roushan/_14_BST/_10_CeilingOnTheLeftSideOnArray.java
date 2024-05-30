package com.roushan._14_BST;

import java.util.TreeSet;
//GFG Lec = 24.
public class _10_CeilingOnTheLeftSideOnArray {
    public static void main(String[] args) {
        int[] arr = {2, 8, 30, 15, 25, 12};
        printCeiling1(arr, arr.length);
        System.out.println();
        printCeiling(arr, arr.length);
    }

    //Naive Approach Time complexity = O(n2) and space complexity = O(1).
    public static void printCeiling1(int[] arr, int n) {
        System.out.print(-1 + " ");
        for (int i = 1; i < n; i++) {
            int diff = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[i]) {
                    diff = Math.min(diff, arr[j] - arr[i]);
                }
            }
            if (diff == Integer.MAX_VALUE) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(arr[i] + diff + " ");
            }
        }
    }

    //Efficient approach Time complexity = O(nlog(N)) and space complexity = O(n).
    public static void printCeiling(int[] arr, int n) {
        System.out.print("-1" + " ");
        TreeSet<Integer> s = new TreeSet<>();
        s.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (s.ceiling(arr[i]) != null)
                System.out.print(s.ceiling(arr[i]) + " ");
            else
                System.out.print("-1" + " ");
            s.add(arr[i]);
        }
    }
}
