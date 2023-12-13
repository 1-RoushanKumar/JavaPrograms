package com.Concept;

import java.util.Arrays;

public class _40_CycleSort {
    public static void main(String[] args) {
        int[] arr = {50, 400, -50, 100, 200};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Time complexity O(n^2) .
    static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int pos = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    pos++;
                }
            }
            swap(arr, i, pos);
            while (pos != i) {
                pos = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[i]) {
                        pos++;
                    }
                }
                swap(arr, i, pos);
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
