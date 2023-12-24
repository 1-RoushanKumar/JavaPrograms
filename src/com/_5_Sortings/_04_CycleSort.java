package com._5_Sortings;

import java.util.Arrays;

public class _04_CycleSort {
    public static void main(String[] args) {
        int[] arr = {500, 400, -50009, 10, 2, 0, -67};
        sort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Time complexity O(n^2) .
    //1st way.Simple find the value which is smaller than ith element count it then it will give the index
    //then swap it with that value.
    static void sort1(int[] arr) {
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[i]) {
                    count++;
                }
            }
            if (arr[i] == arr[count]) {
                i++;
            } else {
                swap(arr, i, count);
            }
        }
    }

    //Time complexity O(n^2) .
    //2nd way.Go to gfg cycle sort lecture.
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
