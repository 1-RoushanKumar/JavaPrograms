//https://youtu.be/ODBaRTfZsDg?list=PLxgZQoSe9cg00xyG5gzb5BMkOClkch7Gr&t=3766
//brute force algorithm to do this question.

package com._3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _22_SearchingQueriesInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements:");
        int n = sc.nextInt();
        System.out.println("Enter the element of the array::");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.print("Enter no. of query::");
        int qu = sc.nextInt();
        while (qu > 0) {
            System.out.print("Enter query::");
            int query = sc.nextInt();
            int i = 0;
            for (; i < arr.length; i++) {
                if (arr[i] == query) {
                    System.out.println("Yes");
                    break;
                }
            }
            if (i == arr.length) {
                System.out.println("No");
            }
            qu--;
        }
    }
}
