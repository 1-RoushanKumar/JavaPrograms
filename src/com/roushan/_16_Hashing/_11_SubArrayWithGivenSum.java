package com.roushan._16_Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class _11_SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {15, 2, 8, 10, -5, -8, 6};
        int sum = 3;
        boolean flag = check(arr, sum);
        System.out.println(flag);
        flag = check2(arr, sum);
        System.out.println(flag);
    }

    //Naive Solution which takes time = O(n2).
    public static boolean check(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
                if (sum == target) {
                    return true;
                }
            }
        }
        return false;
    }

    //optimal solution which takes time = O(n) and space O(n)
    public static boolean check2(int[] arr, int target) {
        int n = arr.length;
        HashSet<Integer> s = new HashSet<>();
        int pre_Sum = 0;
        for (int i = 0; i < n; i++) {
            pre_Sum += arr[i];
            if (pre_Sum == target) {
                return true;
            }
            if (s.contains(pre_Sum - target)) {
                return true;
            }
            s.add(pre_Sum);
        }
        return false;
    }
}
