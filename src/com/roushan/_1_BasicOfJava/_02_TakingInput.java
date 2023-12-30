package com.roushan._1_BasicOfJava;
import java.util.Scanner;
public class _02_TakingInput {
    public static void main(String[] args) {
        System.out.print("Enter your name::");
        Scanner input = new Scanner(System.in);
//      System.out.println(input.next()); //it will print only one word.
        //for to print full line use input.nextLine().
        System.out.println(input.nextLine());
        System.out.print("Enter Your Rollno.:");
        System.out.println("Your rollno.is "+input.nextInt());

        System.out.print("Enter Your marks::");
        float marks = input.nextFloat();
        System.out.println("Marks = "+marks);
    }
}
