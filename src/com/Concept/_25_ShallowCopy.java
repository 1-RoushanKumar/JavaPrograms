package com.Concept;

public class _25_ShallowCopy {
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 1, 2};
        int[] arr3 = arr;     //copying one array to another
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
        for (int val : arr3) {
            System.out.print(val + " ");
        }
        System.out.println();
        //updating the value of arr3 .
        arr3[3] = 99;
        arr3[4] = 999;

        for (int val : arr) {
            System.out.print(val + " ");
        }
        //but after changing the arr3 value arr value also get changed how.
        System.out.println();
        for (int val : arr3) {
            System.out.print(val + " ");
        }
    }
}
//this is because arr is pointing to some object of heap memory and when i maked arr3=arr at this time arr3 is also
//pointing the same heap memory (ie at same address both is pointing ) Due to this reason when I changed arr3 or arr
//the value of heap memory get altered for both.
