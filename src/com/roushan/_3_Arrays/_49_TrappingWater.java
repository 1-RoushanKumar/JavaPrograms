//Question Number 20 of Array Playlist of GFG.
package com.roushan._3_Arrays;

public class _49_TrappingWater {
    public static void main(String[] args) {

        int[] arr = {3,2,4,0,1,2,5};
        int ans = amount(arr);
        System.out.println(ans);
    }

    static int amount(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int leftMax = arr[i];
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(arr[j], leftMax);
            }
            int rightMax = arr[i];
            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(arr[j], rightMax);
            }
            res = res + (Math.min(leftMax, rightMax) - arr[i]);
        }
        return res;
    }
}
