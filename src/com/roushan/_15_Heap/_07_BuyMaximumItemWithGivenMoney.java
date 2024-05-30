package com.roushan._15_Heap;

import java.util.PriorityQueue;

public class _07_BuyMaximumItemWithGivenMoney {
    public static void main(String[] args) {
        int[] item = {20, 10, 5, 30, 100};
        int money = 35;
        //1st approach is we can simply sort the array then traverse the array and find numbers of items which
        //is can be bought in given money. Time complexity for this is O(nlog(n)).


        //2nd approach is using minHeap we compare the top of the element with the money or sum if it is smaller than or equal
        //to sum then we decrease sum by sum - min and increment res.
        //Time complexity = O(res*log(n)) which is less than O(nlog(N)) in average case.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //creating min heap from all the element.
        for (int i : item) {
            pq.add(i);
        }
        int res = 0;
        //check the top element and then subtracting the sum and pop the top and again check for others.
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            if (temp <= money) {
                money = money - temp;
                res++;
            } else {
                break;
            }
        }
        System.out.println(res);
    }
}
