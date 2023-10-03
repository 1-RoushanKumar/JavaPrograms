package com.questions;

import java.util.Scanner;

public class _17_HcfOftwoNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two number::");
        int num1 = in.nextInt();
        int num2 = in.nextInt();

        int min = Math.min(num1, num2);
        for (int i = min; i >= 1; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                System.out.println("Hcf of num1 and num2 is " + i);
                break;
            }
        }
    }
}
