package com.roushan._5_Sortings;

import java.util.Arrays;

public class _08_QuickSort {
    public static void main(String[] args) {
        int[] arr = {85, 269, 226, 952, 656, 556};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];

        while (start < end) {
            if (nums[start] < pivot && nums[end] > pivot) {
                start++;
                end--;
            } else if (nums[start] < pivot) {
                start++;
            } else if (nums[end] > pivot) {
                end--;
            } else {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }

        }

        sort(nums, low, end - 1);

        sort(nums, start + 1, high);
    }
}
