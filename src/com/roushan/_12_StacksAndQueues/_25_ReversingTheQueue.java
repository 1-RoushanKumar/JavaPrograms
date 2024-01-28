package com.roushan._12_StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _25_ReversingTheQueue {
    static Queue<Integer> reverse(Queue<Integer> queue) {
        //concept is we push all elements from the queue to stack
        //and when we pop element from stack it will start popping
        //from the peek and keep adding to the queue.
        //This will reverse the queue.
        //It will take O(n) complexity and O(n) space complexity.
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(5);
        queue.offer(15);
        queue.offer(20);
        System.out.println(queue);
        System.out.println(reverse(queue));
    }
}
