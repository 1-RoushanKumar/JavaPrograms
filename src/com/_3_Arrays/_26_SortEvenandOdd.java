//Given an array of integers arr, move all the even integers at the beginning of the array followed by all the
//odd integers. The relative order of odd or even integers does not matter. Return any array that satisfies the condition.
//https://youtu.be/FmXF2df9OVo?list=PLxgZQoSe9cg00xyG5gzb5BMkOClkch7Gr&t=1968

package com._3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _26_SortEvenandOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements:");
        int n = sc.nextInt();
        System.out.println("Enter the element of the array::");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array before sorting " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Array After sorting " + Arrays.toString(arr));
    }

    // i used two pointer method to solve this question.
    static void sort(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] % 2 != 0 && arr[end] % 2 == 0) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            } else if (arr[start] % 2 == 0 && arr[end] % 2 == 0) {
                start++;
            } else if (arr[start] % 2 != 0 && arr[end] % 2 != 0) {
                end--;
            } else {
                start++;
                end--;
            }
        }
    }
}
