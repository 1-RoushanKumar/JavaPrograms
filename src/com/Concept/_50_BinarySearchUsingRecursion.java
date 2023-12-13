package com.Concept;

public class _50_BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {4, 5, 9, 11, 16};
        int target = 5;
        int start = 0;
        int end = arr.length - 1;
        int ans = search(arr, start, end, target);
        System.out.println(ans);
    }

    static int search(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (target == arr[mid]) {
            return mid;
        } else if (target > arr[mid]) {
            return search(arr, start + 1, end, target);
        } else {
            return search(arr, start, end - 1, target);
        }
    }
}
