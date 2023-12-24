//Q22 Array Playlist GFG.
package com._3_Arrays;

public class _51_MaximumSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-3, 8, -2, 4, -5, 6};
        int ans = find(arr);
        System.out.println(ans);
    }

    //Naive method with O(n^2).
//    static int find(int[] arr){
//        int n = arr.length;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = i; j < n; j++) {
//                sum = sum + arr[j];
//                max = Math.max(sum,max);
//            }
//        }
//        return max;
//    }

    //Optimal way with O(n).
    static int find(int[] arr) {
        int res = arr[0];
        int maxEnding = arr[0];
        for (int i = 0; i < arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(res, maxEnding);
        }
        return res;
    }
}
