package com.basic;

import java.util.Scanner;

public class _8_SwitchStatements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter fruit names.");
        String fruit_colour = in.next();

//        switch (fruit_colour) {
//            case "Mango":
//                System.out.println("Yellow colour");
//                break;
//            case "Apple":
//                System.out.println("Red colour");
//                break;
//            case "Grapes":
//                System.out.println("Green colour");
//                break;
//            case "Orange":
//                System.out.println("Orange colour");
//                break;
//            default:
//                System.out.println("please enter valid fruit");
//        }

//         enhance switch statement..
        switch (fruit_colour) {
            case "Mango" -> System.out.println("Yellow colour");
            case "Apple" -> System.out.println("Red colour");
            case "Grapes" -> System.out.println("Green colour");
            case "Orange" -> System.out.println("Orange colour");
            default -> System.out.println("please enter valid fruit");
        }
    }
}
