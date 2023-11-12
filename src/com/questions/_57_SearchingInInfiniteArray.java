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
        int ans = findRange(arr,target);
        System.out.println("Index no = "+ans);
    }

    static int findRange(int[] arr, int target) {
        //so first we need to find the range
        //first start with a box of size 2.
        int start = 0;
        int end = 1;
        int val = arr[0];
        while (target > val) {
            start = end;
            //double the box value
            //end = previous end + sizeOfBox*2.
            end = 2*end;
            val = arr[end];

        }
        return search(arr, target, start, end);

    }

    static int search(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
