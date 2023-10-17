package com.Concept;

import java.util.Scanner;

public class _11_FunctionExample {
    public static void main(String[] args) {
        System.out.println(greet());
    }
    static String greet(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter");
        return in.nextLine();
    }
}
