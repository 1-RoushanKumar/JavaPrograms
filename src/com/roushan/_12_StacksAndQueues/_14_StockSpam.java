package com.roushan._12_StacksAndQueues;

import java.util.Stack;

//https://www.geeksforgeeks.org/the-stock-span-problem/
public class _14_StockSpam {
    public static void main(String[] args) {
        int[] arr = {18, 12, 13, 14, 11, 16};
        printSpan(arr);
        System.out.println();
        printSpan2(arr);
        System.out.println();
        printSpan3(arr);
    }

    //Naive approach which O(n^2) time complexity. This approach will show tle.
    static void printSpan(int[] arr) {
        System.out.print(1 + " ");
        for (int i = 1; i < arr.length; i++) {
            int span = 1;
            for (int j = i - 1; j >= 0 && arr[j] <= arr[i]; j--) {
                span++;
            }
            System.out.print(span + " ");
        }
    }

    //Efficient approach which take O(n) time complexity and space complexity.
    //12th lecture of stack gfg.
    static void printSpan2(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        System.out.print(1 + " ");

        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            int span = stack.isEmpty() ? i + 1 : i - stack.peek();
            System.out.print(span + " ");
            stack.push(i);
        }
    }

    //One more approach by taking two stacks.
    static void printSpan3(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> spam = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                count += spam.pop();
                stack.pop();
            }
            stack.push(arr[i]);
            spam.push(count);
            System.out.print(count + " ");
        }
    }
}
