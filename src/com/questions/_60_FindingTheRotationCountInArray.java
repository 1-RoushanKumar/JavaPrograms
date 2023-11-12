//Find the Rotation Count in Rotated Sorted array
//https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
package com.questions;

public class _60_FindingTheRotationCountInArray {
    public static void main(String[] args) {
        int[] arr = {7,9,11,12,15};
        int ans = linear(arr);
        System.out.println("No.of Rotation is "+ans);     //by using linear search
        int Ans = binaryCheck(arr);
        System.out.println("No.of Rotation is "+(Ans+1)%arr.length);//by using binary search
    }

    //    1st Approach (linear Search)
//    If we take a closer look at examples, we can notice that the number of rotations is equal to the index of the
//    minimum element. A simple linear solution is to find the minimum element and returns its index.
    static int linear(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        return min;
    }

    //    2nd Approach(Binary Search)
//    Find pivot then return pivot+1 index.
    static int binaryCheck(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[start] > arr[mid]) {
                end = mid - 1;
            } else if (arr[start] < arr[mid]) {
                start = mid + 1;
            } else {
                return end;
            }
        }
        return -1;
    }
}
