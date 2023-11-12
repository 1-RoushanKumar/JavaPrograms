//https://youtu.be/W9QJ8HaRvJQ?t=627
//Floor of the number means find the greatest element which is smaller
//than or equal to target element.
//Ex-[2,3,6,9,16,17,18] and target = 10 then floor of the target will be 9.

package com.questions;

import java.util.Scanner;

public class _56_ReturningTheFloorOfTarget {
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
        int ans = search(arr, target);
        if (ans == -1) {
            System.out.println("Not Possible!");
        } else {
            System.out.println("Ceiling of the target element is= " + ans);
        }
    }

    static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        if (arr[end] > arr[start]) {
            if (target < arr[start]) {
                return -1;
            }
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == target) {
                    return arr[mid];
                } else if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return arr[end];
        } else if (arr[end] < arr[start]) {
            if (target < arr[end]) {
                return -1;
            }
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == target) {
                    return arr[mid];
                } else if (arr[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return arr[start];
        }
        return -1;
    }
}
