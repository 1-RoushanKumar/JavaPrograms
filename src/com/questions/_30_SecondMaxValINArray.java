package com.questions;

public class _30_SecondMaxValINArray {
    public static void main(String[] args) {
        int[] arr = {-5, 8, 0, 2, 12};
        edit(arr); //for finding first maximum value then making its minimum
        int val = Max(arr);  //for finding new maximum value
        System.out.println("Second Maximum value::" + val);
    }

    static void edit(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        arr[max] = Integer.MIN_VALUE;
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

}
