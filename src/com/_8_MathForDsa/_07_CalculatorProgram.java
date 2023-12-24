package com._8_MathForDsa;

import java.util.Scanner;

public class _07_CalculatorProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ans;

        while (true) {
            System.out.println("Enter two number::");
            int num1 = input.nextInt();
            int num2 = input.nextInt();
            System.out.println("Enter Operator from (+,-,*,/,%,0):");  //for exiting the loop enter operator = 0;
            char oper = input.next().trim().charAt(0);

            if (oper == '+') {
                ans = num1 + num2;
                System.out.println("Addition::" + ans);
            }
            if (oper == '-') {
                ans = num1 - num2;
                System.out.println("Subtraction::" + ans);
            }
            if (oper == '*') {
                ans = num1 * num2;
                System.out.println("Multiplication::" + ans);
            }
            if (oper == '/') {
                if (num2 != 0) {
                    ans = num1 / num2;
                    System.out.println("Division::" + ans);
                }
            }
            if (oper == '%') {
                ans = num1 % num2;
                System.out.println("Remainder::" + ans);
            }
            if (oper == '0') {
                System.out.println("Exiting");
                break;
            }

        }
    }
}
