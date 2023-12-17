//https://youtu.be/OEmIdnR-9zg?t=265

package com.questions;

import java.util.Arrays;
import java.util.Scanner;

public class _51_SumOfSelectedRectangle {
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
        System.out.println("Sum= " + sumMat(mat1));

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

    static int sumMat(int[][] mat1) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of l1 and r1::");
        //where l1 and r1 is the first coordinate point of the rectangle.
        int l1 = in.nextInt();
        int r1 = in.nextInt();
        System.out.println("Enter the value of l2 and r2::");
        //where l1 and r1 is the second coordinate point of the rectangle.
        int l2 = in.nextInt();
        int r2 = in.nextInt();
        int sum = 0;
        for (int i = l1; i <= l2; i++) {
            for (int j = r1; j <= r2; j++) {
                sum = sum + mat1[i][j];
            }
        }
        return sum;
    }
}
