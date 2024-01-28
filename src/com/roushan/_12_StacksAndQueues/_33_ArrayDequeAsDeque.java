package com.roushan._12_StacksAndQueues;

import java.util.ArrayDeque;

public class _33_ArrayDequeAsDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(10);
        deque.offerLast(20);
        deque.offerLast(40);
        deque.offerFirst(30);
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.peekFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque.peekLast());
    }
}
