package com.roushan._12_StacksAndQueues;
//https://www.geeksforgeeks.org/previous-greater-element/

import java.util.Stack;

public class _15_previousGreaterElement {
    public static void main(String[] args) {
        int[] arr = {15, 10, 18, 12, 4, 6, 2, 8};
        previousGreater1(arr);
        System.out.println();
        previousGreater2(arr);
        System.out.println();
        previousGreater3(arr);
    }

    //1st way which take O(n^2) time complexity.
    static void previousGreater1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    System.out.print(arr[j] + " ");
                    break;
                }
            }
            if (j == -1) {
                System.out.print(-1 + " ");
            }
        }
    }

    //2nd way: Efficient way:: this will take approx O(n) time complexity and O(2n)=O(n) space complexity.
    static void previousGreater2(int[] arr) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(arr[0]);
        System.out.print(-1 + " ");
        for (int i = 1; i < arr.length; i++) {
            while (!stack1.isEmpty()) {
                if (arr[i] < stack1.peek()) {
                    System.out.print(stack1.peek() + " ");
                    stack1.push(arr[i]);
                    break;
                } else {
                    stack2.push(stack1.pop());
                }
            }
            if (stack1.isEmpty()) {
                System.out.print(-1 + " ");
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
                stack1.push(arr[i]);
            }
        }
    }

    //3rd way it is a more efficient way than, 2nd way which take O(n) time and space complexity.
    static void previousGreater3(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        System.out.print(-1 + " ");
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            int prevGre = stack.isEmpty() ? -1 : stack.peek();
            System.out.print(prevGre + " ");
            stack.push(arr[i]);
        }
    }
}
