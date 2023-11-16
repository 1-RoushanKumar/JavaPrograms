package com.Concept;

import java.util.Arrays;

public class _37_BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 58, -9, -2, 0, 258, 655};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        boolean swappedFlag = false;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n - i - 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swappedFlag = true;
                }
            }
            if (!swappedFlag) {     //same as swappedFlag==false.
                break;
            }
        }
    }
}
//I use swappedFlag because when array is sorted we not need to run i loop again.
