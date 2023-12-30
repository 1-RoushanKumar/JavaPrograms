package com.roushan._3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _14_SearchInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of element::");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the element of the array::");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.print("Enter target element::");
        int target = sc.nextInt();
        System.out.println("Enter Range::");
        int start = sc.nextInt();
        int end = sc.nextInt();
        int ans = search(arr, target, start, end);
        if (ans == -1) {
            System.out.println("Target Not Found!");
        } else {
            System.out.println("Index no.:: " + ans);
        }
    }

    static int search(int[] arr, int target, int start, int end) {
        if (arr.length == 0) {
            return -1;
        }
        if (end < arr.length) {
            for (int i = start; i <= end; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
        }
        return -1;
    }
}
