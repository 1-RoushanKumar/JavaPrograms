package com.roushan._9_Recursions;

public class _12_RecursionSearchElement {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 18, 9};
        int target = 18;
        int ans = search(arr, target, 0);
        System.out.println(ans);
    }

    static int search(int[] arr, int target, int i) {
        if (i >= arr.length) {
            return -1;
        }
        if (arr[i] == target) {
            return i;
        } else {
            return search(arr, target, i + 1);
        }
    }
}
