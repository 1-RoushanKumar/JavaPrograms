package com.roushan._4_BinarySearch;

public class _12_IndexOfTheLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {5, 10, 10, 15, 20, 20, 20};
        int target = 20;
        //Using iterative method.
        int ans = search(arr, target);
        System.out.println(ans);
    }

    static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                if (mid < end && arr[mid] == arr[mid + 1]) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
