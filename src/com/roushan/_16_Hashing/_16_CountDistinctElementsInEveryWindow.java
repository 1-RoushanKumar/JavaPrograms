package com.roushan._16_Hashing;

import java.util.HashMap;

public class _16_CountDistinctElementsInEveryWindow {
    public static void main(String[] args) {
        int[] arr = {10, 10, 5, 3, 20, 5};
        int k = 4; //size of the window.
        printDistEleInWin(arr, k);
        System.out.println();
        printDistinct(arr, arr.length, k);
    }

    //Naive Approach : Time = O(n3)
    public static void printDistEleInWin(int[] arr, int k) {
        int n = arr.length;
        //first loop traverse to the array until it is in window(k) length
        for (int i = 0; i <= n - k; i++) {
            int count = 0;
            //the second loop will find distinct and count it.
            for (int j = 0; j < k; j++) {
                //but there is a possibility that each window contain duplicate
                //so for not counting the duplicate again, we have one more loop which will
                //check that element in the window repeated before or not.
                //if yes, then a flag = true, and it does not increment count else it will count get incremented.
                boolean flag = false;
                for (int l = 0; l < j; l++) {
                    if (arr[i + j] == arr[i + l]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    count++;
                }
            }
            System.out.print(count + " ");
        }
    }

    //Optimal Approach Time = O(N) and space = O(N).
    public static void printDistinct(int[] arr, int n, int k)
    {
        HashMap<Integer, Integer> m=new HashMap<>();

        for (int i = 0; i < k; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        System.out.print(m.size()+" ");

        for (int i = k; i < n; i++) {

            m.put(arr[i - k],  m.get(arr[i - k]) - 1);

            if (m.get(arr[i - k]) == 0) {
                m.remove(arr[i-k]);
            }
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);

            System.out.print(m.size()+" ");
        }
    }
}
