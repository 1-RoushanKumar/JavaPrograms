package com.roushan._12_StacksAndQueues;

import java.util.Stack;

public class _12_ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        //remember it's not about reversing element and printing it. It's about reversing the order in which element are
        //stored in stack.
        //before reversing stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int n = stack.size();
        int[] arr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = stack.pop();
        }

        while (n - 1 >= 0) {
            stack.push(arr[n - 1]);
            n = n - 1;
        }
        System.out.println("After Reversing::");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }
}
