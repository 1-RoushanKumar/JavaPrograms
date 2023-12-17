//https://youtu.be/3gJxLkPPW6M
package com.Concept;

import java.util.*;

public class _57_BitOperEveryNumRepeatThriceExceptOneFindIt {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter No. of elements::");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of the array::");
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr) + " is the unique one.");
    }

    public static int solution(int[] arr) {
        int ones = 0, twos = 0, threes = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int mask1 = (ones & arr[i]);
            int mask2 = (twos & arr[i]);
            int mask3 = (threes & arr[i]);

            int nones = (ones & (~mask1));
            nones |= mask3;

            int ntwos = (twos & (~mask2));
            ntwos |= mask1;

            int nthrees = (threes & (~mask3));
            nthrees |= mask2;

            ones = nones;
            twos = ntwos;
            threes = nthrees;
        }
        return ones;
    }

}