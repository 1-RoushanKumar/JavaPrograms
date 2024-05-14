package com.roushan._9_Recursions;

//GFG Lecture - 15 (Recursion)
public class _35_RecursionJosephusProblem {
    public static void main(String[] args) {
        int n = 7, k = 3;
        int ans = jos(n, k);
        System.out.println(ans);
    }

    private static int jos(int n, int k) {
        if (n == 1) {
            return 0;
        } else {
            return (jos(n - 1, k) + k) % n;
        }
    }
}
