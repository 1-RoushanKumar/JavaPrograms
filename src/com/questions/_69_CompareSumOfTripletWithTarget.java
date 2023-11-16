
package com.questions;

public class _69_CompareSumOfTripletWithTarget {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 8, 9, 20, 40};
        int target = 17;
        boolean flag = search(arr, target);
        System.out.println(flag);
    }

    static boolean search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = arr[start] + arr[end] + arr[mid];
            if (start < mid && end > mid) {
                if (sum == target) {
                    return true;
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
            else {
                return false;
            }
        }
        return false;
    }
}
