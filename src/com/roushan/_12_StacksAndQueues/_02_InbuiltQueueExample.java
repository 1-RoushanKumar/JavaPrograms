package com.roushan._12_StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class _02_InbuiltQueueExample {
    public static void main(String[] args) {
        //queue internally work like linkedList.
        //it is simple queue where we can only add to the back and remove from front.
        Queue<Integer> que = new LinkedList<>();
        que.add(3);
        que.add(5);
        que.add(7);
        que.add(9);
        que.add(11);

        //queue follow fifo(first in first out) and lilo(last in last out) principal;
        System.out.println(que.remove());
        System.out.println(que.remove());
        System.out.println(que.remove());
        System.out.println(que.remove());
        System.out.println(que.remove());
//        System.out.println(que.remove());   //it will show exception
    }
}
