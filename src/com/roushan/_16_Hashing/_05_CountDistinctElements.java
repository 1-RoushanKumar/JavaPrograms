package com.roushan._16_Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class _05_CountDistinctElements {
    public static void main(String[] args) {
        int[] arr = {15, 12, 13, 12, 13, 13, 18};
        int ans = countDis(arr);
        System.out.println("Number of distinct elements are::" + ans);
        ans = countDis2(arr);
        System.out.println("Number of distinct elements are::" + ans);
    }

    //1st approach (sorting) that takes time complexity = O(nLogn) and space complexity = O(1).
    public static int countDis(int[] arr) {
        //approach is if n = 0 return 0.
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        //Sort the array first and skip the value which is counted already and count the distinct.
        Arrays.sort(arr);
        int k = arr[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] != k) {
                count++;
                k = arr[i];
            }
        }
        return count;
    }

    //2nd approach using hashset time complexity = O(n) and space complexity = O(n).
    public static int countDis2(int[] arr) {
        //hashset already store only unique key , Hence add the element and return it size.
        HashSet<Integer> h = new HashSet<>();
        for (int j : arr) {
            h.add(j);
        }
        return h.size();
    }
}
