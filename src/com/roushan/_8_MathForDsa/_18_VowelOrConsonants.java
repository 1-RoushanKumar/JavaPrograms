package com.roushan._8_MathForDsa;

import java.util.Scanner;

public class _18_VowelOrConsonants {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter any character");
        char y = in.next().trim().charAt(0);
        if (y == 'a' || y == 'e' || y == 'i' || y == 'o'
                || y == 'u' || y == 'A' || y == 'E' || y == 'I'
                || y == 'O' || y == 'U')
            System.out.println("It is a Vowel.");
        else
            System.out.println("It is a Consonant.");

    }
}
