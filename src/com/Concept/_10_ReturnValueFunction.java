package com.Concept;

import java.util.Scanner;

public class _10_ReturnValueFunction {
    public static void main(String[] args) {
        int result = sum();
        System.out.println("Sum is " + result);
    }

    static int sum() {              //here return type int.
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Two number");
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        return num1 + num2;   //after return value function return to the main function and don't execute again.
    }
}
