package com._3_Arrays;

public class _47_MaximumDifferenceBtwTwoElement {
    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 6, 4, 8, 2};
        int ans = MaxDiff(arr);
        System.out.println(ans);
    }

    //Naive Method With O(n^2) complexity.
//    static int MaxDiff(int[] arr) {
//        int diff = Integer.MIN_VALUE;
//        int n = arr.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (arr[j] - arr[i] > diff) {
//                    diff = arr[j] - arr[i];
//                }
//            }
//        }
//        return diff;
//    }

    //Optimized way with O(n).
    static int MaxDiff(int[] arr) {
        int n = arr.length;
        int res = arr[1] - arr[0], minVal = arr[0];

        for (int i = 1; i < n; i++) {

            res = Math.max(res, arr[i] - minVal);

            minVal = Math.min(minVal, arr[i]);
        }

        return res;
    }
}
