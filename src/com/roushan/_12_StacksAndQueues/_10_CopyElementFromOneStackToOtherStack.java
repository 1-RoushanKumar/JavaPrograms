package com.roushan._12_StacksAndQueues;

import java.util.Stack;

//we need to copy an element of one stack to another stack without changing the order.
public class _10_CopyElementFromOneStackToOtherStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);

        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        Stack<Integer> newStack = new Stack<>();
        while (!tempStack.isEmpty()) {
            newStack.push(tempStack.pop());
        }
        System.out.println(newStack);
    }
}
