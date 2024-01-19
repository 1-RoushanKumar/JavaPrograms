package com.roushan._12_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class _03_Deque {
    public static void main(String[] args) {

        //in deque we can insert and remove from both side(it is also called as doubly ended queue)
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(15);
        deque.add(20);
        deque.addFirst(10);
        deque.addLast(25);
        deque.add(45);
        //this will look like this
        //[10,15,20,25]

        System.out.println(deque.remove());
        System.out.println(deque.remove());
        System.out.println(deque.remove());
        System.out.println(deque.remove());
        System.out.println(deque.remove());
    }
}
