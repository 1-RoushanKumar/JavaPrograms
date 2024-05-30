package com.roushan._15_Heap;

import java.util.PriorityQueue;

public class _05_PriorityQueue {
    public static void main(String[] args) {
        //Priority Queue internally follows min heap property.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(50);
        pq.add(4);
        pq.add(15);
        //All operations in priority queue are done from then top value (ie from min value)
        System.out.println(pq);
        System.out.println(pq.contains(4));
        System.out.println(pq.isEmpty());
        System.out.println(pq.poll());
        System.out.println(pq.peek());
    }
}
