package com.roushan._12_StacksAndQueues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

//https://www.geeksforgeeks.org/next-greater-element/
public class _16_NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {5, 15, 19, 8, 6, 12, 9, 18};
        nxtGre1(arr);
        System.out.println();
        nxtGre2(arr);
    }

    //1st way time complexity O(n^2).
    static void nxtGre1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    System.out.print(arr[j] + " ");
                    break;
                }
            }
            if (j == arr.length) {
                System.out.print(-1 + " ");
            }
        }
    }

    //2nd way with time complexity and space complexity with O(n)
    static void nxtGre2(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        //we need an array because this way is giving output in reverse so need array to store then reverse it.
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n - 1]);
        list.add(-1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            int nextGre = stack.isEmpty() ? -1 : stack.peek();
            list.add(nextGre);
            stack.push(arr[i]);
        }
        System.out.print(list.reversed());
    }
}
