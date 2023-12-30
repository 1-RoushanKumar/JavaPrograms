package com.roushan._4_BinarySearch;

public class _01_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};     //for binary search array must be sorted either in ascending or descending
        int target = 22;
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
//            int mid = (start+end)/2;    // it might possible that (start + end) exceed the range of the integer .
            int mid = start + (end - start) / 2;  //better way.
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
