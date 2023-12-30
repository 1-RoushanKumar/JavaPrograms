//https://youtu.be/_4QAUfXERsU?list=PLxgZQoSe9cg00xyG5gzb5BMkOClkch7Gr&t=2143
package com.roushan._3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _35_RotateSquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter only value of n (because it is square Matrix)::");
        int n = sc.nextInt();
        int[][] mat1 = new int[n][n];
        printMatrix(mat1, n, n);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(mat1[i]));
        }
        transposeInOneArray(mat1, n, n);
        reverseMatrix(mat1, n, n);
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
    }

    //first we transpose it
    static void transposeInOneArray(int[][] matrix, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = i; j < y; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    //then reverse the matrix per row
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
    //finally we get an 90 degree rotated array.
}
