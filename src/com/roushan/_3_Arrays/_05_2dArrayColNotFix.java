package com.roushan._3_Arrays;

public class _05_2dArrayColNotFix {
    public static void main(String[] args) {
        int[][] arr = {{45,89,25,56},{14,20},{85,2,6}};
        for (int[] ints : arr) {
            for (int col = 0; col < ints.length; col++) {
                System.out.print(ints[col] + " ");
            }
            System.out.println();
        }
    }
}
