package com.Concept;

public class _19_2dArrayColNotFix {
    public static void main(String[] args) {
        int[][] arr = {{45,89,25,56},{14,20},{85,2,6}};
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col]+" ");
            }
            System.out.println();
        }
    }
}
