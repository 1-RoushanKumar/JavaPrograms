package com.roushan._9_Recursions;

public class _01_Recursion {
    public static void main(String[] args) {
        print(1);
        call(5);
    }

    static void print(int n) {
        if (n == 5) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        print(n + 1);
    }
    static void call(int n){
        if (n == 0){
            return;
        }
        call(n-1);
        System.out.println(n);
    }
}
