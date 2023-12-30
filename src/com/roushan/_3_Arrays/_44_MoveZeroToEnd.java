package com.roushan._3_Arrays;

import java.util.Arrays;

public class _44_MoveZeroToEnd {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] arr = {8, 0, 0, 0, 0, 20};
        moveZero(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Naive method with O(n^2) solution.
    static void moveZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] != 0) {
                        swap(arr, i, j);
                    }
                }
            }
        }
    }

    //optimized method with O(n) solution.
//    static void moveZero(int[] arr){
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i]!=0){
//                swap(arr,count,i);
//                count++;
//            }
//        }
//    }
    static void swap(int[] arr, int count, int i) {
        int temp = arr[count];
        arr[count] = arr[i];
        arr[i] = temp;
    }
}
