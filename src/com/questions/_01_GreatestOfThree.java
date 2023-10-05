package com.questions;

import java.util.Scanner;

public class _01_GreatestOfThree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of a,b and c::");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        if (a > b) {
            if (a > c) {
                System.out.println("a is greatest.");
            } else {
                System.out.println("c is greatest.");
            }
        } else if (b > a) {
            if (b > c) {
                System.out.println("b is greatest.");
            } else {
                System.out.println("c is greatest.");
            }
        }
    }
}
