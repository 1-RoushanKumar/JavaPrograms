//Given an integer array arr, return the prefix sum/running sum in the
//same array without creating a new array.
//Ex: arr={2,1,3,4,5} then result arr = {2,3,6,10,15}.
//https://youtu.be/5_DFKL4zYLc?t=749

package com.roushan._3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _28_PrefixOrRunningSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements:");
        int n = sc.nextInt();
        System.out.println("Enter the element of the array::");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array before " + Arrays.toString(arr));

        //by using extra array.
//        int[] ans = new int[n];
//        ans[0] = arr[0];
//        for (int i = 1; i < n; i++) {
//            ans[i] = arr[i] + ans[i - 1];
//        }
//        System.out.println(Arrays.toString(ans));

        //without using extra array or space.
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
        System.out.println("Array Now " + Arrays.toString(arr));

    }
}
