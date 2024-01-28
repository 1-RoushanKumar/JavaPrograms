package com.roushan._12_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class _24_InbuiltQueue {
    public static void main(String[] args) {
//      Queue<Integer> queue = new LinkedList<>();  //Inbuilt queue using linkedList interface.Time complexity O(1).
        Queue<Integer> queue = new ArrayDeque<>();    //Inbuilt queue using arrayDeque interface.Time complexity amortized O(1).
        //but in worst, case it may take more than O(1) time complexity.
        //prefer to use arrayDequeue because it is faster.
        queue.add(23);
        queue.add(45);
        queue.add(56);
        queue.offer(78); //it is the same as .add, but it does not throw exception when capacity is full.
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.poll()); //it is the same as .remove, but it also does not throw exception.
        System.out.println(queue.peek());
        System.out.println(queue);
    }
}
