package com._8_MathForDsa;

import java.util.Scanner;

public class _02_AlphabetCaseCheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter any character::");
        char ch = in.next().trim().charAt(0);
        //in.next() means string ,.trim() means ignore spaces
        //and charAt(0) means character at index 0 of string.
        if (ch >= 'a' && ch <= 'z') {
            System.out.println("LowerCase");
        } else if (ch >= 'A' && ch <= 'Z') {
            System.out.println("UpperCase");
        } else {
            System.out.println("Enter valid character");
        }
    }
}
