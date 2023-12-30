//Rotating array without taking extra array
//https://youtu.be/ODBaRTfZsDg?list=PLxgZQoSe9cg00xyG5gzb5BMkOClkch7Gr&t=3563
//url for detail video.
package com.roushan._3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _21_RotateArrayPart2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements:");
        int n = sc.nextInt();
        System.out.println("Enter the element of the array::");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.print("Enter Instances::");
        int k = sc.nextInt();
        reverse1(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    static void reverse1(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);
        reverse(arr, 0, n - 1);
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}

