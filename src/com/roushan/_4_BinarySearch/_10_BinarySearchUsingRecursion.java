package com.roushan._4_BinarySearch;

public class _10_BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        int target = 30;
        int ans = search(arr, target, 0, arr.length - 1);
        System.out.println(ans);
    }

    static int search(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }//base case to stop recursion call when target is not present.
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        }//base case to stop recursion if target is present.
        else if (arr[mid] > target) {
            return search(arr, target, start, mid - 1);
        } else {
            return search(arr, target, mid + 1, end);
        }
    }
}
//time complexity in both recursion and iterative is same (O(log(n)).
//but auxiliary space is high in recursion because it uses stack to store each function call.
