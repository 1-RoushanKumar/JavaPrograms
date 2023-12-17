//https://youtu.be/FmXF2df9OVo?list=PLxgZQoSe9cg00xyG5gzb5BMkOClkch7Gr&t=528

package com.questions;

import java.util.Arrays;
import java.util.Scanner;

public class _36_SortZeroesAndOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements:");
        int n = sc.nextInt();
        System.out.println("Enter the element(0,1) of the array::");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array before sorting " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Array After sorting " + Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int j : arr) {
            if (j == 0) {
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i < count) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
    }
}
