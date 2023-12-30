//rotating means if 1 2 3 4 5 is given after
//k=1 >> 5 1 2 3 4
//k=2 >> 4 5 1 2 3...


package com.roushan._3_Arrays;

import java.util.Arrays;

public class _20_RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 404;
//        rotate(arr, k);
        rotate2(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    //1st way by creating new array.
//    static void rotate(int[] arr, int k) {
//        int n = arr.length;
//        k = k % n;
//        int[] ans = new int[n];
//        int j = 0;
//        for (int i = n - k; i < n; i++) {
//            ans[j] = arr[i];
//            j++;
//        }
//        for (int i = 0; i < n - k; i++) {
//            ans[j] = arr[i];
//            j++;
//        }
//        System.out.println(Arrays.toString(ans));
//    }

    //2nd way without creating new array
    static void rotate2(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n - 1; j++) {
                int temp = arr[n - 1];
                arr[n - 1] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
