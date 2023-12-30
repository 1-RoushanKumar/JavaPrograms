package com.roushan._2_Functions;

import java.util.Arrays;

public class _07_SwappingUsingFunc {
    public static void main(String[] args) {
        int[] arr = {1, 96, 85, 36, 12};
        System.out.println(Arrays.toString(arr));
        swap(arr, 2, 4);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
