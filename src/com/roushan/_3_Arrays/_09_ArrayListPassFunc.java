package com.roushan._3_Arrays;

import java.util.ArrayList;

public class _09_ArrayListPassFunc {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<String> str = new ArrayList<String>();
        arr.add(45);
        arr.add(25);
        arr.add(74);

        str.add("Hello");
        str.add("World");
        str.add("Roushan");

        pass(arr);
        System.out.println();
        passStr(str);
    }

    private static void passStr(ArrayList<String> str) {
        for (String val : str) {
            System.out.print(val + " ");
        }
    }

    private static void pass(ArrayList<Integer> arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}
