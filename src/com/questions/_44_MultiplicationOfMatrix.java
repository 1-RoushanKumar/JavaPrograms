//https://youtu.be/lhgH-Ehmlk4?list=PLxgZQoSe9cg00xyG5gzb5BMkOClkch7Gr&t=3272

package com.questions;

import java.util.Arrays;
import java.util.Scanner;

public class _44_MultiplicationOfMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n and m::");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat1 = new int[n][m];
        System.out.println("Enter the value of k and l::");
        int k = sc.nextInt();
        int l = sc.nextInt();
        int[][] mat2 = new int[k][l];
        printMatrix(mat1, n, m);
        printMatrix(mat2, k, l);
        multiply(n, m, mat1, k, l, mat2);
    }

    static void printMatrix(int[][] matrix, int x, int y) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter values::");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < x; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    static void multiply(int n, int m, int[][] mat1, int k, int l, int[][] mat2) {
        if (m != k) {
            System.out.println("Invalid");
            return;
        }
        int[][] mul = new int[n][l];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l; j++) {
                for (int z = 0; z < k; z++) {
                    mul[i][j] = mul[i][j] + (mat1[i][z] * mat2[z][j]);
                }
            }
        }
            System.out.println("Multiplication of Matrix::");
            for (int j = 0; j < n; j++) {
                System.out.println(Arrays.toString(mul[j]));
            }
        }
    }
