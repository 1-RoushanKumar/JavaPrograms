//Given an array of integers of size n. Answer q queries where you need to print the sum
//of values in a given range of indices from l to r(both included).
//Note:The values of l and r in queries follow 1-based indexing.
//https://youtu.be/5_DFKL4zYLc?t=1395

package com.roushan._3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _30_OptimizedMethodForPrevQues {
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
        //trick is first find the prefix sum of the array.
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
        System.out.println("Prefix Sum of the arrays " + Arrays.toString(arr));
        System.out.print("Enter Numbers of query::");
        int query = sc.nextInt();
        while (query > 0) {
            System.out.print("Enter the value of l: ");
            int l = sc.nextInt();
            System.out.print("Enter the value of r: ");
            int r = sc.nextInt();
            int sum = 0;
            if (l == 0) {
                sum = arr[r];
            } else {
                sum = arr[r] - arr[l - 1];
            }
            System.out.println("Sum of the element between l and r is " + sum);
            query--;
        }
    }
}
