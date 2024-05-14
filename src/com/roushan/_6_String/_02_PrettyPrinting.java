package com.roushan._6_String;

public class _02_PrettyPrinting {
    public static void main(String[] args) {
        float a = 453.12398f;
        System.out.printf("Formatted number is %.2f",a);
        //like C lang
        System.out.println();
        System.out.printf("Pi = %.3f",Math.PI);

        System.out.println();
        System.out.printf("My name is %s and I am %s.","Rocky","Cool");
        //there are so many format specifier.
    }
}
