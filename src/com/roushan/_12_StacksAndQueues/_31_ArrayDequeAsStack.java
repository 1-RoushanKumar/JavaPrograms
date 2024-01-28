package com.roushan._12_StacksAndQueues;

import java.util.ArrayDeque;

//ArrayDeque is one of the collection.Which inherits queue and deque collection.
//ArrayDeque is faster than linkedList because arrayDeque is an array implementation.
//ArrayDeque can be used as queue, stack, and deque.
//But in arrayDeque we cannot excess any index element like linkedList.
public class _31_ArrayDequeAsStack {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(40);
        System.out.println(stack.peek());
    }
}
