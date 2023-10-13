//https://youtu.be/5_DFKL4zYLc?list=PLxgZQoSe9cg00xyG5gzb5BMkOClkch7Gr&t=2159
//Check if we can partition the array into two sub arrays with equal sum .
//More formally, check that the prefix sum of a part of the array is equal
//to suffix sum of rest of the array.

package com.questions;

import java.util.Arrays;
import java.util.Scanner;

public class _43_CheckPrefixAndSuffix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements:");
        int n = sc.nextInt();
        System.out.println("Enter the element of the array::");
        int[] arr = new int[n + 1];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            sum = sum + arr[i];
        }
        System.out.println("Array " + Arrays.toString(arr));
        boolean flag = check(arr, sum);
        System.out.println(flag);

    }

    static boolean check(int[] arr, int sum) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
            int suffix = sum - arr[i];
            if (suffix == arr[i]) {
                return true;
            }
        }
        return false;
    }
}
