package com._5_Sortings;

import java.util.Arrays;

public class _02_SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 0, -22, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 1; j < n - i; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            int last = n - i - 1;
            int temp = arr[max];
            arr[max] = arr[last];
            arr[last] = temp;
        }
    }
}
