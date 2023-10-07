package com.Concept;

import java.util.Arrays;
import java.util.Scanner;

public class _18_MultidimensionalArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arr = new int[3][3];     //declaration.

//        int[][] num = {{4,5,6},
//                        {8,61,23},
//                        {47,52,32}};
//        System.out.println(num[2][1]);
        System.out.println("Enter the elements::");
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = in.nextInt();
            }
        }
        //1st way.
//        for (int row = 0; row < arr.length ; row++) {
//            for (int col = 0; col < arr[row].length; col++) {
//                System.out.print(arr[row][col]+" ");
//            }
//            System.out.println();
//        }
        //2nd way.
//        for (int row = 0; row < arr.length; row++) {
//            System.out.println(Arrays.toString(arr[row]));
//        }
        //3rd way.
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
