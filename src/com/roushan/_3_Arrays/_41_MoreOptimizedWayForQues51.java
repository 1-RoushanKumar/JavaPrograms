//https://youtu.be/OEmIdnR-9zg?list=PLxgZQoSe9cg00xyG5gzb5BMkOClkch7Gr&t=2071

package com.roushan._3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _41_MoreOptimizedWayForQues51 {

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
        System.out.println("Enter the value of l1 and r1::");
        int l1 = sc.nextInt();
        int r1 = sc.nextInt();
        System.out.println("Enter the value of l2 and r2::");
        int l2 = sc.nextInt();
        int r2 = sc.nextInt();
        int add = findSum3(mat1, l1, r1, l2, r2);
        System.out.println("Sum = " + add);
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

    static void findPrefixSumMatrix(int[][] matrix) {
        // calculate row wise and column wise sum

        int r = matrix.length;
        // if r > 0.
        int c = matrix[0].length;

        //traverse horizontally to calculate row wise prefix usm
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
            }
        }
        for (int i = 0; i < c; i++) {
            for (int j = 1; j < r; j++) {
                matrix[j][i] += matrix[j - 1][i];
            }
        }
    }

    static int findSum3(int[][] matrix, int l1, int r1, int l2, int r2) {

        int sum, up = 0, left = 0, leftUp = 0, ans;
        findPrefixSumMatrix(matrix);
        sum = matrix[l2][r2];
        if (r1 >= 1)
            left = matrix[l2][r1 - 1];
        if (l1 >= 1)
            up = matrix[l1 - 1][r2];
        if (l1 >= 1 && r1 >= 1)
            leftUp = matrix[l1 - 1][r1 - 1];
        ans = sum - up - left + leftUp;
        return ans;
    }
}
