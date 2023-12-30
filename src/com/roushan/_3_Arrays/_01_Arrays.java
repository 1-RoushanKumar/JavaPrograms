package com.roushan._3_Arrays;

public class _01_Arrays {
    public static void main(String[] args) {
        int[] arr = new int[5];//array declaration
        int[] arr1 = {5, 6, 8, 9, 0}; //if we don't add any value in array it will store 0 default.
        System.out.println(arr1[0]);
        System.out.println(arr1[4]);
//        System.out.println(arr1[5]);  //it will show array out of bound error because there are 5th index in array.

        String[] arr2 = new String[4];
        System.out.println(arr2[0]);   //it will show null because it is empty
        String[] arr3 = {"Rohan", "Roushan", "Raja"};
        System.out.println(arr3[2]);
    }
}
