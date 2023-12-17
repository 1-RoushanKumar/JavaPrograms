//finding pivot in sorted rotated array (where array is in increasing order.).
//what is pivot..
//suppose we have an array [3,4,5,6,7,0,1,2] , here pivot is 7. because 7 is the element from where the array is changing.
// some test cases {[15,18,2,3,6,12] or [3,4,5,6,7,8] or [13,4,5,6,7,8] } these are some test cases we can test.
//https://youtu.be/W9QJ8HaRvJQ?t=9374
package com.questions;

import java.util.Scanner;

public class _59_FindingPivotUsingBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n::");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the element in sorted order(either descending or ascending order):: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array::");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        //Searching pivot for increasing array.
        int ans = pivotInIncArr(arr);
        System.out.println();
        if (ans == -1) {
            System.out.println("Array is not rotated, So index of pivot is " + (n - 1));
        } else {
            System.out.println("Pivot index is :: " + ans);
        }


//        //Searching pivot for decreasing array.
//        System.out.println();
//        int Ans = pivotINDecArr(arr);
//        if (Ans == -1) {
//            System.out.println("Array is not rotated, So index of pivot is 0.");
//        } else {
//            System.out.println("Pivot index is :: " + Ans);
//        }
    }

    //so below we have function for finding the pivot.
    static int pivotInIncArr(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //suppose we hava an array [4,5,6,7,0,1,2].So start = 0 and end = 6 ,hence mid = 3 ie (arr[mid] = 7)
            //first we make sure mid is smaller than end so that mid+1 don't show array out of bound error.
            //then we check arr[3]>arr[4] or not if it is then return mid index.
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            //similarly use same concept as above.
            else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            //case 3 and 4 Suppose we hava an array [3,4,5,6,7,0,1,2] here arr[mid] = 6.We check arr[0] is greater than arr[mid]
            //Or arr[0] is smaller than arr[mid] or not .If arr[0] < arr[mid] that means pivot will lies from index (mid+1) to end
            //so start = mid+1; .But when arr[start]>arr[mid] that means pivot will lies from index (mid-1) to start .So end = mid-1.
            else if (arr[start] < arr[mid]) {
                start = mid + 1;
            } else if (arr[start] > arr[mid]) {
                end = mid - 1;
            } else {
                return -1;
            }
        }
        return -1;
    }

    static int pivotINDecArr(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] < arr[mid + 1]) {
                return mid + 1;
            } else if (mid > start && arr[mid] > arr[mid - 1]) {
                return mid;
            } else if (arr[end] > arr[mid]) {
                start = mid + 1;
            } else if (arr[end] < arr[mid]) {
                end = mid - 1;
            }
        }
        return -1;
    }
}
