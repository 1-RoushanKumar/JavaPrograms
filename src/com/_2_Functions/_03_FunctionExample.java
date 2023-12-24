package com._2_Functions;

import java.util.Scanner;

public class _03_FunctionExample {
    public static void main(String[] args) {
        System.out.println(greet());
    }
    static String greet(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter");
        return in.nextLine();
    }
}
