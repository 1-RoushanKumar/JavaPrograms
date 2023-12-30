package com.roushan._9_Recursions;

public class _16_RecursionPattern2 {
    public static void main(String[] args) {
        int n = 5;
        int row = 1;
        int col = 0;
        pattern(n, row, col);
    }

    static void pattern(int n, int row, int col) {
        if (row > n) {
            return;
        }
        if (col < row) {
            System.out.print("*");
            pattern(n, row, col + 1);
        } else {
            System.out.println();
            pattern(n, row + 1, 0);
        }
    }
}
