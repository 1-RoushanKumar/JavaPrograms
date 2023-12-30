package com.roushan._3_Arrays;

public class _19_FirstRepeatedElements {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 6, 3, 4};
        int val = check(arr);
        System.out.println(val);
    }

    static int check(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1 + i; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }
}
