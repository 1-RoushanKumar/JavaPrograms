//https://youtu.be/m18Hntz4go8
package com.roushan._3_Arrays;

public class _49_TrappingWater {
    public static void main(String[] args) {

        int[] arr = {3, 2, 4, 0, 1, 2, 5};
        int ans = amount(arr);
        System.out.println(ans);
        ans = amount1(arr);
        System.out.println(ans);
        ans = amount2(arr);
        System.out.println(ans);
    }
    //Naive Solution Time = O(n2) and space = O(1).

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

    //Optimal Approach Time = O(n) and Space = O(n).
    static int amount1(int[] arr) {
        int n = arr.length;
        int res = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            left[i] = max;
        }
        max = arr[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            right[i] = max;
        }
        for (int i = 0; i < n; i++) {
            res = res + (Math.min(left[i], right[i]) - arr[i]);
        }
        return res;
    }

    //More Efficient Approach Time = O(n) ,Space = O(1).
    static int amount2(int[] arr){
        int n = arr.length;
        int left = 0, right = n - 1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= maxLeft) {
                    maxLeft = arr[left];
                } else {
                    res += maxLeft - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= maxRight) {
                    maxRight = arr[right];
                } else {
                    res += maxRight - arr[right];
                }
                right--;
            }
        }
        return res;
    }
}
