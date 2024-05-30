package com.roushan._15_Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class _14_MedianOfAStreamOptimalApproachUsingHeap {
    public static void main(String[] args) {
        int[] arr = {25, 7, 10, 15, 20};
        printMedian(arr);
    }

    //well explained in notebook.
    public static void printMedian(int[] arr) {
        PriorityQueue<Integer> G = new PriorityQueue<>();
        PriorityQueue<Integer> S = new PriorityQueue<>(Collections.reverseOrder());
        S.add(arr[0]);
        System.out.print(arr[0] + " ");
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            if (S.size() > G.size()) {
                if (S.peek() > x) {
                    G.add(S.poll());
                    S.add(x);
                } else {
                    G.add(x);
                }
                System.out.print((double) (S.peek() + G.peek()) / 2 + " ");
            } else {
                if (x <= S.peek()) {
                    S.add(x);
                } else {
                    G.add(x);
                    S.add(G.poll());
                }
                System.out.print(S.peek() + " ");
            }
        }
    }
}
