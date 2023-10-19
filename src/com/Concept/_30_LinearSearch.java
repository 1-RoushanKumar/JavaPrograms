package com.Concept;

import java.util.Arrays;
import java.util.Scanner;

public class _30_LinearSearch {
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
        int ans = search(arr, target);
        if (ans == -1) {
            System.out.println("Target Not Found!");
        } else {
            System.out.println("Index no.:: " + ans);
        }
    }

    static int search(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
