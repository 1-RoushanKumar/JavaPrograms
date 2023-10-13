//https://youtu.be/FmXF2df9OVo?list=PLxgZQoSe9cg00xyG5gzb5BMkOClkch7Gr&t=843

package com.questions;

import java.util.Arrays;
import java.util.Scanner;

public class _37_SortPrevQuesUsingTwoPointer {
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
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            if (arr[start] > arr[end]) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            start++;
            end--;
        }
    }
}
