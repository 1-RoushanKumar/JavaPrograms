package com.questions;

public class _90_RecursionPrintNNaturalNumber {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Natural Number::");
        printNum(n);
        System.out.println();
        System.out.println("Reverse Natural Number::");
        reverseNum(n);
    }

    static void printNum(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        } else {
            printNum(n - 1);
            System.out.print(n + " ");
        }
    }

    static void reverseNum(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        } else {
            System.out.print(n + " ");
            reverseNum(n - 1);
        }
    }
}
