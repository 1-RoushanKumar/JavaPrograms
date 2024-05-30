package com.roushan._15_Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _06_SortKSortedArray {
    //time complexity = O(nlog(k)).
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }
        int index = 0;
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = pq.poll();
            pq.add(arr[i]);
        }
        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }
        System.out.println(Arrays.toString(arr));
    }
}
