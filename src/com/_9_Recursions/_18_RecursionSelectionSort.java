package com._9_Recursions;

import java.util.Arrays;

public class _18_RecursionSelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 1, 2};
        sort(arr, 0, 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int i, int j, int max) {
        if (i == arr.length) {
            return;
        }
        if (j >= arr.length - i) {
            swap(arr, max, arr.length - 1 - i);
            sort(arr, i + 1, 1, 0);
        } else {
            if (arr[j] > arr[max]) {
                sort(arr, i, j + 1, j);
            } else {
                sort(arr, i, j + 1, max);
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
