package com.roushan._12_StacksAndQueues;

import java.util.ArrayDeque;

public class _32_ArrayDequeAsQueue {
    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(10);
        queue.offer(20);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        queue.offer(40);
        System.out.println(queue.peek());

        //we can also use add(),remove() and element().This will throw exception also.(Recommended).
    }
}
