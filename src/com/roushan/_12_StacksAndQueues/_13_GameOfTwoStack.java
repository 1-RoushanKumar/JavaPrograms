//https://www.hackerrank.com/challenges/game-of-two-stacks/problem

package com.roushan._12_StacksAndQueues;

import java.util.*;

public class _13_GameOfTwoStack {

//    https://youtu.be/WMmST9al0DE
    //1st way to solve this is a better way.

    static int twoStacks2(int maxSum, int[] a, int[] b) {
        int result = 0, stack1_count = 0, stack2_count = 0, total_sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (total_sum + a[i] > maxSum) {
                break;
            }
            total_sum += a[i];
            stack1_count++;
        }
        result = stack1_count;
        for (int i = 0; i < b.length; i++) {
            total_sum += b[i];
            stack2_count++;
            while (total_sum > maxSum && stack1_count > 0) {
                total_sum -= a[stack1_count - 1];
                stack1_count--;
            }
            result = (total_sum <= maxSum) ? Math.max(stack1_count + stack2_count, result) : result;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter no. of queries you want.");
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println("Enter the no of element you want in arr a::");
            int n = s.nextInt();
            System.out.println("Enter the no of element you want in arr a::");
            int m = s.nextInt();
            System.out.println("Enter max value::");
            int x = s.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            System.out.println("Enter the element of the first array::");
            for (int j = 0; j < n; j++) {
                a[j] = s.nextInt();
            }
            System.out.println("Enter the element of the second array::");
            for (int j = 0; j < m; j++) {
                b[j] = s.nextInt();
            }
            System.out.println("Ans is ::");
            System.out.println(twoStacks2(x, a, b));
        }
    }
}
