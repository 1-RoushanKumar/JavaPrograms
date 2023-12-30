package com.roushan._4_BinarySearch;

public class _02_BinarySearchInDescendingSortArray {
    public static void main(String[] args) {
        int[] arr = {98, 85, 20, 6, 3, 1, 0, -8, -20};     //for binary search array must be sorted either in ascending or descending
        int target = 85;
        int ans = search(arr, target);
        if (ans == -1) {
            System.out.println("Not Found");
        } else {
            System.out.println("Index no = " + ans);
        }
    }

    static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
