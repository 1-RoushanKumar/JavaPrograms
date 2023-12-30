//https://youtu.be/5_DFKL4zYLc?list=PLxgZQoSe9cg00xyG5gzb5BMkOClkch7Gr&t=2159
//Check if we can partition the array into two sub arrays with equal sum .
//More formally, check that the prefix sum of a part of the array is equal
//to suffix sum of rest of the array.

package com.roushan._3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _31_CheckPrefixAndSuffix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements:");
        int n = sc.nextInt();
        System.out.println("Enter the element of the array::");
        //1st method.
        int[] arr = new int[n + 1];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            sum = sum + arr[i];
        }
        System.out.println("Array " + Arrays.toString(arr));
        boolean flag = check(arr, sum);
        System.out.println(flag);

        //2nd method.
//        int[] newArr = {2, 5, 7, 8, 5};
//        boolean newFlag = check2(newArr);
//        System.out.println(newFlag);
    }

    //1st way without creating new array optimized way.Its don't need any extra space.
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


    //2nd way creating two new array to store prefix and suffix sum.
//    static boolean check2(int[] arr) {
//        int[] arr1 = new int[arr.length];
//        int[] arr2 = new int[arr.length];
//        arr1[0] = arr[0];
//        arr2[arr.length - 1] = arr[arr.length - 1];
//        for (int i = 1; i < arr.length; i++) {
//            arr1[i] = arr[i] + arr1[i - 1];
//        }
//        for (int i = arr.length - 2; i >= 0; i--) {
//            arr2[i] = arr2[i + 1] + arr[i];
//        }
//        //Prefix sum array
//        System.out.println(Arrays.toString(arr1));
//        //Suffix sum array
//        System.out.println(Arrays.toString(arr2));
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr1[i] == arr2[i + 1]) {
//                return true;
//            }
//        }
//        return false;
//    }

}
