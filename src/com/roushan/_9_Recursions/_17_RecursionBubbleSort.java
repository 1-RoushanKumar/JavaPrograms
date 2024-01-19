package com.roushan._9_Recursions;

import java.util.ArrayList;
import java.util.Arrays;

public class _17_RecursionBubbleSort {
    public static void main(String[] args) {
        int[] arr = {0, -1, 33, 5};
        sort(arr, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int i, int j) {
        if (i == arr.length) {
            return;
        }
        if (j >= arr.length - 1 - i) {
            sort(arr, i + 1, 0);
        } else {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
            }
            sort(arr, i, j + 1);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}