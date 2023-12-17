//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
//https://youtu.be/W9QJ8HaRvJQ?t=5286
package com.questions;

import java.util.Scanner;

public class _57_SearchingInInfiniteArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n::");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the element in sorted order(either descending or ascending order):: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array::");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.print("\nEnter Target Element:: ");
        int target = sc.nextInt();
        int Ans = linear(arr, target);
        System.out.println("Index no = " + Ans);
    }

    //Naive Method..(for optimized way search in youtube).
    static int linear(int[] arr, int target) {
        int i = 0;
        while (true) {
            if (arr[i] == target) {
                return i;
            }
            if (arr[i] > target) {
                return -1;
            }
            i++;
        }
    }
}
