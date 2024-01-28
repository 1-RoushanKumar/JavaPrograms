package com.roushan._12_StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class _26_ReverseTheQueueRecursively {

    static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        int x = queue.peek();
        queue.poll();
        reverse(queue);
        queue.offer(x);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(5);
        queue.offer(15);
        queue.offer(20);
        System.out.println(queue);
        reverse(queue);
        System.out.println(queue);
    }
}
