package com.roushan._9_Recursions;

public class _38_RecursionFindMinimumINArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, -5, -4, 8, 6};
        int n = arr.length;
        int ans = findMin(arr, n);
        System.out.println(ans);
    }

    public static int findMin(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return Math.min(arr[n - 1], findMin(arr, n - 1));
    }
}
