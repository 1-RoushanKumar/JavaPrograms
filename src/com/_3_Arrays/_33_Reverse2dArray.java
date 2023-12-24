package com._3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _33_Reverse2dArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n and m::");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat1 = new int[n][m];
        printMatrix(mat1, n, m);
        System.out.println("After Reversing::");
        reverseMatrix(mat1, n, m);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(mat1[i]));
        }
    }
    static void printMatrix(int[][] matrix, int x, int y) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter values::");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Matrix::");
        for (int i = 0; i < x; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    static void reverseMatrix(int[][] matrix, int x, int y) {
        for (int i = 0; i < x; i++) {
            int start = 0, end = y - 1;
            while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }
}
