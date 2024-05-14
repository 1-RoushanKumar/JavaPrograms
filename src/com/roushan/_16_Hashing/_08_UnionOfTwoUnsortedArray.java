package com.roushan._16_Hashing;

import java.util.HashSet;

public class _08_UnionOfTwoUnsortedArray {
    public static void main(String[] args) {
        int[] arr1 = {15, 20, 5, 15};
        int[] arr2 = {15, 15, 15, 20, 10};
        int count = union1(arr1, arr2);
        System.out.println("Union of two array have::" + count + " element.");
    }

    private static int union1(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            s.add(arr1[i]);
        }
        for (int i = 0; i < m; i++) {
            s.add(arr2[i]);
        }
        return s.size();
    }
}
