package com.roushan._3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _02_InputInArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the elements of the Array::");

        //Arrays of Primitive.
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("Array-->");
        //1st way.
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
        //2nd way.
        //enhanced for loop(for each loop)
//        for (int j : arr) {
//            System.out.print(j + " ");
//        }
        //3rd way.
        System.out.println(Arrays.toString(arr));

        //Arrays of Object.
        System.out.println("Enter the elements::");
        String[] str = new String[4];
        for (int i = 0; i < str.length; i++) {
            str[i] = in.next();
        }
        System.out.println(Arrays.toString(str));
        //modify
        str[2]="Roushan";
        //after modifying
        System.out.println(Arrays.toString(str));
    }
}
