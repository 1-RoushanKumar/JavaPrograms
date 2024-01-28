package com.roushan._12_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class _03_Deque {
    public static void main(String[] args) {

        //in deque we can insert and remove from both sides (it is also called as doubly ended queue)
//        Deque<Integer> deque = new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        //this will show exception for when deque is full or empty.
        deque.add(15);
        deque.add(20);
        deque.addFirst(10);
        deque.addLast(25);
        deque.add(45);
//        System.out.println(deque.remove());
//        System.out.println(deque.remove());
//        System.out.println(deque.remove());
//        System.out.println(deque.remove());
//        System.out.println(deque.remove());
//        System.out.println(deque.remove()); //this will throw exception.

        System.out.println();
        //but this will not show exception simply it adds null.
        deque.offer(56);
        deque.offerFirst(1);
        deque.offerLast(34);
//        System.out.println(deque.peek());
//        System.out.println(deque.peekFirst());
//        System.out.println(deque.peekLast());
//        System.out.println(deque.pollFirst());
//        System.out.println(deque.pollLast());
//        System.out.println(deque.poll());
//        System.out.println(deque.poll());   //this will show null

        //deque iteration printing all value.
        //make sure to check what is Iterator in Google.
        Iterator<Integer> it = deque.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        //it also prints but in reverse manner.
        Iterator<Integer> itd = deque.descendingIterator();
        while (itd.hasNext()) {
            System.out.print(itd.next() + " ");
        }
    }
}
