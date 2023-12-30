package com.roushan._3_Arrays;

public class _17_uniqueValue {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 2, 1, 4};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    arr[i] = -1;
                    arr[j] = -1;
                }
            }
        }
        int ans = -1;
        for (int j : arr) {
            if (j != -1) {
                ans = j;
            }
        }
        System.out.println(ans);
    }
}
