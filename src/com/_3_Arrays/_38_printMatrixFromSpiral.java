//https://www.youtube.com/watch?v=LJeY_cL0oC8&list=PLxgZQoSe9cg00xyG5gzb5BMkOClkch7Gr&index=26&pp=iAQB/

package com._3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _38_printMatrixFromSpiral {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n::");
        int n = sc.nextInt();
        int[][] matrix = spiral(n);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    static int[][] spiral(int n) {
        int[][] matrix = new int[n][n];
        int topRow = 0, bottomRow = n - 1, leftCol = 0, rightCol = n - 1;
        int current = 1;
        while (current <= n * n) {
            for (int i = leftCol; i <= rightCol && current <= n * n; i++) {
                matrix[topRow][i] = current;
                current++;
            }
            topRow++;
            for (int j = topRow; j <= bottomRow && current <= n * n; j++) {
                matrix[j][rightCol] = current;
                current++;
            }
            rightCol--;
            for (int i = rightCol; i >= leftCol && current <= n * n; i--) {
                matrix[bottomRow][i] = current;
                current++;
            }
            bottomRow--;
            for (int i = bottomRow; i >= topRow && current <= n * n; i--) {
                matrix[i][leftCol] = current;
                current++;
            }
            leftCol++;
        }
        return matrix;

    }
}
