//this method is improve version of previous question with better time complexity.
//https://youtu.be/ODBaRTfZsDg?list=PLxgZQoSe9cg00xyG5gzb5BMkOClkch7Gr&t=4465

package com.roushan._3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _23_BetterMethodForQ34 {
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
        int[] freq = frequency(arr);
        System.out.print("Enter no. of query::");
        int qu = sc.nextInt();
        while (qu > 0) {
            System.out.print("Enter query::");
            int query = sc.nextInt();
            if (freq[query] > 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            qu--;
        }
    }

    static int[] frequency(int[] arr) {
        int[] freq = new int[100005];
        for (int j : arr) {
            freq[j]++;
        }
        return freq;
    }
}
