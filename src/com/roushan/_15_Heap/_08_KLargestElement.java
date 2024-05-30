package com.roushan._15_Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _08_KLargestElement {
    public static void main(String[] args) {
        //we need to find k number of the largest element from the array.
        //order of the largest element does not matter
        int[] arr = {5, 15, 10, 20, 8};
        int k = 2;
        //Naive
        //1st approach Sort the array Then print the element from the last.
        //time complexity = O(nlog(n))
        Arrays.sort(arr);
        int j = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (j <= k) {
                System.out.print(arr[i] + " ");
                j++;
            } else {
                break;
            }
        }

        System.out.println();

        //Better
        // 2nd approach is create a max heap of the element the extract max or top element.
        //up to k times.Time complexity will be O(n) for building heap and O(k*log(K)) for extracting and then building
        //the max heap.Overall time complexity = O(n+k(log(n)).
        //How implement max heap using priority queue because internally priority queue uses min heap.
        //for this, we use comparator.reverseOrder.

        //this will implement the max heap.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int value : arr) {
            pq.add(value);
        }
        for (int i = 0; i < k; i++) {
            System.out.print(pq.poll() + " ");
        }


        System.out.println();
        //Best
        //3rd approach. Using min heap, in this case first we make min heap of a first k element of the array.
        //now We traverse from the (k+1)th element::
        //a. compare a current element with the top of the heap.If smaller than top, ignore it.
        //b. else remove the top element and insert the current element in the min heap.
        //At the end, all array traverses completed than we have a min heap that contains all k elements that are largest.
        //At the end, Simply Print all min heap elements.time complexity = O(k+(n-k)*log(k)).

        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            p.add(arr[i]);
        }
        for (int i = k + 1; i < arr.length; i++) {
            if (!p.isEmpty() && p.peek() < arr[i]) {
                p.poll();
                p.add(arr[i]);
            }
        }
        while (!p.isEmpty()) {
            System.out.print(p.poll() + " ");
        }
    }
}
