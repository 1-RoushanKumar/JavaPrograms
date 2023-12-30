package com.roushan._3_Arrays;

import java.util.ArrayList;

public class _08_ForEachLoop {
    public static void main(String[] args) {
        //Printing Arraylist element using foreach loop.
        ArrayList<Integer> arrr = new ArrayList<Integer>();
        arrr.add(45);
        arrr.add(90);
        arrr.add(23);
        arrr.add(67);
        for (int val : arrr) {
            System.out.print(val + " ");
        }


        //Printing Array element using foreach loop.
//       int[] arr = {67, 23, 12, 90, 12, 56};
//        for (int value : arr) {
//            System.out.print(value + " ");
//        }
    }
}
