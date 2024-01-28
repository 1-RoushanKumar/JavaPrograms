package com.roushan._12_StacksAndQueues;

import java.util.Stack;

public class _19_GetMin {
    //1st approach this will take O(1) time complexity but O(n) space complexity.
    Stack<Integer> stack;
    Stack<Integer> findMinStack;

    public _19_GetMin() {
        stack = new Stack<>();
        findMinStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (findMinStack.isEmpty() || val <= findMinStack.peek()) {
            findMinStack.push(val);
        }
    }

    public void pop() {
        if (!findMinStack.isEmpty()) {
            if (stack.peek().equals(findMinStack.peek())) {
                findMinStack.pop();
            }
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return findMinStack.peek();
    }

    public static void main(String[] args) {
        _19_GetMin obj = new _19_GetMin();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}
