package com.questions;

import java.util.Scanner;

public class _30_SecondMaxValINArray {
    public static void main(String[] args) {
        int[] arr = {-5, -6, -11, -1, -2, 0};
        int val = Max(arr);   //for finding max value in array.
        edit(arr, val);         //for finding second max we maked max value equal to minimum integer value.
        val = Max(arr);         //for finding max value(second max) after editing the array.
        System.out.println("Second Maximum value::" + val);
    }
    static int Max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    static void edit(int[] arr, int max) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                arr[i] = Integer.MIN_VALUE;
            }
        }
    }
}
