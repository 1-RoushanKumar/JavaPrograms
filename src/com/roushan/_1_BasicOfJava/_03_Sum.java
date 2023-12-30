package com.roushan._1_BasicOfJava;
import java.util.Scanner;
public class _03_Sum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Values");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int sum = num1 + num2;

        System.out.println("Sum = " + sum);
    }
}
