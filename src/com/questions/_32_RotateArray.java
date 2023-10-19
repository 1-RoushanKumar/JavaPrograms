//rotating means if 1 2 3 4 5 is given after
//k=1 >> 5 1 2 3 4
//k=2 >> 4 5 1 2 3...


package com.questions;

import java.util.Arrays;

public class _32_RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 401;
        rotate(arr, k);
    }
    static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int[] ans = new int[n];
        int j = 0;
        for (int i = n - k; i < n; i++) {
            ans[j] = arr[i];
            j++;
        }
        for (int i = 0; i < n - k; i++) {
            ans[j] = arr[i];
            j++;
        }
        System.out.println(Arrays.toString(ans));
    }
}
