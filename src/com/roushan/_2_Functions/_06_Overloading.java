package com.roushan._2_Functions;

public class _06_Overloading {
    public static void main(String[] args) {
        sum(2, 4);
        sum(5, 3, 1);
    }

    //when we make two or more function with the same name but with different
    //number arguments or types .this type of function is called overloading
    static void sum(int a, int b) {
        System.out.println("Sum1=" + (a + b));
    }

    static void sum(int a, int b, int c) {
        System.out.println("Sum2=" + (a + b + c));
    }
}
