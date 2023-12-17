//https://youtu.be/LJeY_cL0oC8?list=PLxgZQoSe9cg00xyG5gzb5BMkOClkch7Gr
package com.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _49_PrintSpiralOfMatrix {
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
        spiral(mat1, n, m);
    }

    static void printMatrix(int[][] matrix, int x, int y) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter values::");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int n = matrix.length-1;
        int m = matrix[0].length-1;
        System.out.println(n);
        System.out.println(m);
    }

    static void spiral(int[][] matrix, int r, int c) {
        int topRow = 0, bottomRow = r - 1, leftCol = 0, rightCol = c - 1;
        int totalElements = 0;
        while (totalElements < r * c) {
            for (int i = leftCol; i <= rightCol && totalElements < r * c; i++) {
                System.out.print(matrix[topRow][i] + " ");
                totalElements++;
            }
            topRow++;
            for (int j = topRow; j <= bottomRow && totalElements < r * c; j++) {
                System.out.print(matrix[j][rightCol] + " ");
                totalElements++;
            }
            rightCol--;
            for (int i = rightCol; i >= leftCol && totalElements < r * c; i--) {
                System.out.print(matrix[bottomRow][i] + " ");
                totalElements++;
            }
            bottomRow--;
            for (int i = bottomRow; i >= topRow && totalElements < r * c; i--) {
                System.out.print(matrix[i][leftCol] + " ");
                totalElements++;
            }
            leftCol++;
        }
    }
}
