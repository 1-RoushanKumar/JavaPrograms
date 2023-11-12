//https://leetcode.com/problems/find-in-mountain-array/
//https://youtu.be/W9QJ8HaRvJQ?t=8487

package com.questions;

import java.util.Scanner;

public class _58_FindingTargetInMountArr {
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
        int ans = mount(arr, target);
        System.out.println(ans);
    }

    static int mount(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = end - 1;
            } else {
                start = start + 1;
            }
        }
        int newStart = 0;
        int End = start;
        return search(arr, newStart, End, target);
    }

    static int search(int[] arr, int newStart, int End, int target) {
        int s = End + 1;
        while (newStart <= End) {
            int mid = newStart + (End - newStart) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                newStart = mid + 1;

            } else {
                End = mid - 1;
            }
        }
        int e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                s = mid + 1;

            } else {
                e = mid - 1;
            }
        }
        return -1;
    }
}
