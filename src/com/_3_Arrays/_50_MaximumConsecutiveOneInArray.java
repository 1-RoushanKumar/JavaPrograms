package com._3_Arrays;

public class _50_MaximumConsecutiveOneInArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1};
        int ans = find(arr);
        System.out.println(ans);
    }

    static int find(int[] arr) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }
            if (count > max) {
                max = count;
            } else if (arr[i] != 1) {
                count = 0;
            }
        }
        return max;
    }
}
