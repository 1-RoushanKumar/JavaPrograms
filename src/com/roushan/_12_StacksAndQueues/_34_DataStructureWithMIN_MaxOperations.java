package com.roushan._12_StacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;

public class _34_DataStructureWithMIN_MaxOperations {
    Deque<Integer> deque;

    public _34_DataStructureWithMIN_MaxOperations() {
        this.deque = new LinkedList<>();
    }

    void insertMin(int x) {
        deque.offerFirst(x);
    }

    void insertMax(int x) {
        deque.offerLast(x);
    }

    int getMin() {
        return deque.peekFirst();
    }

    int getMax() {
        return deque.peekLast();
    }

    int extractMin() {
        return deque.pollFirst();
    }

    int extrackMax() {
        return deque.pollLast();
    }

    public static void main(String[] args) {
        _34_DataStructureWithMIN_MaxOperations dq = new _34_DataStructureWithMIN_MaxOperations();
        dq.insertMin(10);
        dq.insertMax(15);
        dq.insertMin(5);
        System.out.println(dq.extractMin());
        System.out.println(dq.extrackMax());
        dq.insertMin(8);
        System.out.println(dq.getMin());
        System.out.println(dq.getMax());

    }
}
