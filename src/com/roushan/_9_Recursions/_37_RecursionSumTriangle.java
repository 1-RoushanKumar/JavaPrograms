package com.roushan._9_Recursions;

import java.util.Arrays;

public class _37_RecursionSumTriangle {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        printSumTriangle(arr);
    }

    public static void printSumTriangle(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int[] temp = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            int x = arr[i] + arr[i + 1];
            temp[i] = x;
        }
        printSumTriangle(temp);
        System.out.println(Arrays.toString(arr));
    }
}
