package com.Concept;

public class _49_FibonacciNumber {
    public static void main(String[] args) {
        int n = 8;
        int ans = fibo(n);
        System.out.println("Fibo of " + n + " th place is " + ans);
    }

    static int fibo(int n) {
        if (n==1){
            return 0;
        }
        if (n==2){
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
}
