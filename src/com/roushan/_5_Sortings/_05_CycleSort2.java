package com.roushan._5_Sortings;

import java.util.Arrays;

public class _05_CycleSort2 {
    public static void main(String[] args) {
        int[] arr = {4,3,5,6,7,8,2,1};     //Elements should be distinct.
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //If given element is from 1 to n then we need only O(n) complexity.
    static void sort(int[] arr) {
        int n = arr.length;
        int i = 0;
        while (i < n - 1) {
            int correct = arr[i] - 1;
            if (i == correct) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }
        }
    }
}
