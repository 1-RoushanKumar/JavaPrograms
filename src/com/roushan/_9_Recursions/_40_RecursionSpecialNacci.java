package com.roushan._9_Recursions;
//https://www.geeksforgeeks.org/problems/geek-onacci-number/0
import java.util.Scanner;
public class _40_RecursionSpecialNacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T != 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int N = sc.nextInt();
            T--;
            int NthValue = find(A, B, C, N);
            System.out.println(NthValue);
        }
    }

    public static int find(int a, int b, int c, int n) {
        if (n == 3) {
            return c;
        }
        if (n == 2) {
            return b;
        }
        if (n == 1) {
            return a;
        }
        return find(a, b, c, n - 1) + find(a, b, c, n - 2) + find(a, b, c, n - 3);
    }
}
