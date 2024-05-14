package com.roushan._3_Arrays;

import java.util.*;

public class _52_SubArrays {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = findSubarrays(arr);
        for (List<Integer> subarray : findSubarrays(arr)) {
            System.out.println(subarray);
        }
    }

    //Time Complexity = O(n3).
    public static List<List<Integer>> findSubarrays(int[] arr) {
        List<List<Integer>> subarrays = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                List<Integer> subarray = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subarray.add(arr[k]);
                }
                subarrays.add(subarray);
            }
        }
        return subarrays;
    }
}
