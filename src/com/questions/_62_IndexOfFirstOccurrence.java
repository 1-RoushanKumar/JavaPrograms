//Ques if we hava given an non decreasing sorted array (ex-->[1,10,10,10,20,20,40])
//we need to find the first occurrence of the target element in the array (if target = 10 the answer index is 1)

package com.questions;

public class _62_IndexOfFirstOccurrence {
    public static void main(String[] args) {
        int[] arr = {5, 10, 10, 15, 20, 20, 20};
        int target = 10;
        //Using iterative method.
        int ans = search(arr, target);
        System.out.println(ans);
        //By Using Recursion call.
        int Ans = searchRecursion(arr, target, 0, arr.length - 1);
        System.out.println(Ans);
    }

    static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //all thing is same as binary search but extra case arises when we found the (arr[mid]=target) in this case
            //we must check array contain that target element before mid or not. We must also check mid>start from preventing
            //to enter in negative index(array out bound error).
            if (arr[mid] == target) {
                if (mid > start && arr[mid] == arr[mid - 1]) {
                    end = mid - 1;
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

    static int searchRecursion(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            if (mid > start && arr[mid] == arr[mid - 1]) {
                return searchRecursion(arr, target, start, mid - 1);
            } else {
                return mid;
            }
        } else if (arr[mid] > target) {
            return searchRecursion(arr, target, start, mid - 1);
        } else {
            return searchRecursion(arr, target, mid + 1, end);
        }
    }
}
