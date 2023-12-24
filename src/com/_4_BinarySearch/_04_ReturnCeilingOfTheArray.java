//https://youtu.be/W9QJ8HaRvJQ?t=627
//find ceiling of the target element means find the smallest number which
//is greater than or equal to target element
//Ex:[2,3,6,14,16,18] and target = 15 then ceiling is 16.

package com._4_BinarySearch;

import java.util.Scanner;

public class _04_ReturnCeilingOfTheArray {
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

    //1st way.
    static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        if (arr[end] > arr[start]) {
            if (target > arr[end]) {
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
            return arr[start];
        } else if (arr[end] < arr[start]) {
            if (target > arr[start]) {
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
            return arr[end];
        }
        return -1;
    }

//    //2nd way easy to understand Similarly we can make it for decreasing sorted array.
//    static int search(int[] arr, int target) {
//        int start = 0;
//        int end = arr.length - 1;
//        //when target is greater than end value then there is no possible way to return number which just greater than it.
//        if (arr[end] < target) {
//            return -1;
//        }
//        //when target is smaller than start that means just greater number of target element is start element.
//        else if (arr[start] > target) {
//            return arr[start];
//        } else {
//            while (start <= end) {
//                int mid = start + (end - start) / 2;
//                if (arr[mid] == target) {
//                    return arr[mid];
//                } else if (arr[mid] > target) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//            }
//        }
//        return arr[start];
//    }
}
