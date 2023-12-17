package com.questions;

public class _101_RecursionPattern1 {
    public static void main(String[] args) {
        int n = 10;
        pattern(n, 0);
    }

    static void pattern(int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            System.out.print("*");
            pattern(row, col + 1);
        } else {
            System.out.println();
            pattern(row - 1, 0);
        }
    }
}
