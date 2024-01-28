package com.roushan._12_StacksAndQueues;

import java.util.Stack;

//gfg stack lecture 19.
//this approach is a more optimized way, but it only works for positive values.
public class _20_GetMinPart_2 {
    Stack<Integer> stack;
    int min;

    public _20_GetMinPart_2() {
        this.stack = new Stack<>();
    }

    void push(int x) {
        if (stack.isEmpty()) {
            min = x;
            stack.push(x);
        } else if (x <= min) {
            stack.push(x - min);
            min = x;
        } else {
            stack.push(x);
        }
    }

    int pop() {
        int temp = stack.pop();
        if (temp <= 0) {
            int res = min;
            min = min - temp;
            return res;
        } else {
            return temp;
        }
    }

    int peek() {
        int temp = stack.peek();
        return (temp <= 0) ? min : temp;
    }

    int getMin() {
        return min;
    }

    public static void main(String[] args) {
        _20_GetMinPart_2 obj = new _20_GetMinPart_2();
        obj.push(5);
        obj.push(10);
        obj.push(20);
        obj.push(2);
        System.out.println(obj.getMin());
        obj.push(6);
        obj.push(4);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        obj.push(2);
        obj.pop();
        obj.push(1);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.getMin());
    }
}
