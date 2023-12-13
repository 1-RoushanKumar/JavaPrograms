package com.Concept;

public class _48_Recursion {
    public static void main(String[] args) {
        print(1);
    }

    static void print(int n) {
        if (n == 10) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        print(n + 1);
    }
}
