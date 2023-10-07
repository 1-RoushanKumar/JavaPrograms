package com.Concept;

import java.util.Arrays;

public class _17_PassingArrayInFunc {
    public static void main(String[] args) {
        int[] num = {32, 52, 14, 85, 69};
        System.out.println(Arrays.toString(num));
        change(num);
        System.out.println("After calling function.");
        System.out.println(Arrays.toString(num));
    }

    static void change(int[] arr) {
        arr[3] = 99;
    }
}
