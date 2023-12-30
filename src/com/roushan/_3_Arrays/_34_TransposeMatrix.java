package com.roushan._3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _34_TransposeMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n and m::");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat1 = new int[n][m];
        printMatrix(mat1, n, m);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(mat1[i]));
        }
        transpose(mat1, n, m);
//        transposeInOneArray(mat1,n,m);
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(mat1[i]));
//        }
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

    static void transpose(int[][] matrix, int x, int y) {
        int[][] mat = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                mat[i][j] = matrix[j][i];
            }
        }
        System.out.println("Transpose of the matrix::");
        for (int i = 0; i < y; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    //This method is only good for square matrix.
//    static void transposeInOneArray(int[][] matrix,int x,int y){
//        for (int i = 0; i < x; i++) {
//            for (int j = i; j < y; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }
//    }
}
