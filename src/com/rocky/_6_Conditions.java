package com.rocky;

import java.util.Scanner;

public class _6_Conditions {
    public static void main(String[] args) {
        int a, b;
        System.out.println("Enter the value of a and b ::");
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        b = input.nextInt();
        //if else checking conditions if (a>b) then condition will be true and if statement get executed
        if (a > b) {
            System.out.println("a is greater than b.");
        } else {
            System.out.println("b is greater than a.");
        }
    }
}
