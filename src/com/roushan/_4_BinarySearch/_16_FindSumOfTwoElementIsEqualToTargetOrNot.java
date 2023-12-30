
//if sum of and two distinct element is equal to target then return true else false.

package com.roushan._4_BinarySearch;

public class _16_FindSumOfTwoElementIsEqualToTargetOrNot {
    public static void main(String[] args) {
        int[] arr = {5,25,75};
        int target = 100;

        //this is applicable for both sorted and unsorted array.
        boolean flag = search(arr, target);
        System.out.println(flag);

        //this is only applicable for sorted array.
        boolean check = searching(arr, target);
        System.out.println(check);
    }

    //Naive Method.For unsorted and sorted array.It will take O(n^2) complexity.
    static boolean search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum == target) {
                    return true;
                }
            }
        }
        return false;
    }

    //Two pointer method for sorted array.It will take O(n) complexity.
    //We can also first sort the array then we can apply two pointer method then time complexity will be (O(nlog(n))) for
    //sorting if used good algorithm for sorting and it take O(n) for two pointer . Total complexity will be
    //O(nlog(n)) + O(n) = O(nlog(n)).
    static boolean searching(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == target) {
                return true;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }
}
//One more better approach for this is hashing.That we learn later.
