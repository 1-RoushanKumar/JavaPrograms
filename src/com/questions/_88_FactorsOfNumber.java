package com.questions;

import java.util.ArrayList;

public class _88_FactorsOfNumber {
    public static void main(String[] args) {
        int n = 20;
        factors(n);
    }

//    //O(n) complexity .
//    static void factors(int n) {
//        for (int i = 1; i <= n; i++) {
//            if (n % i == 0) {
//                System.out.print(i + " ");
//            }
//        }
//    }

    //O(sqrt(n)) complexity.But not in order.
//    static void factors(int n) {
//        for (int i = 1; i <= Math.sqrt(n); i++) {
//            if (n % i == 0) {
//                if (n / i == i) {
//                    System.out.print(i + " ");
//                } else {
//                    System.out.print(i + " " + n / i + " ");
//                }
//            }
//        }
//    }

    //O(sqrt(n)) complexity and O(sqrt(n)) space complexity for printing in order.
    static void factors(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " ");
                    list.add(n / i);
                }
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}
