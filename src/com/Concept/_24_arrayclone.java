package com.Concept;

import java.util.Arrays;

public class _24_arrayclone {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2};
        int[] arr3 = arr;     //copying one array to another
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
        for (int val : arr3) {
            System.out.print(val + " ");
        }

    }
}
