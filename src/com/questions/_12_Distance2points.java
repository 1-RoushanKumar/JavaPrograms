//Calculate Distance Between Two Points

package com.questions;

import java.util.Scanner;

public class _12_Distance2points {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of x1 and y1 of point A::");
        int x1 = input.nextInt();
        int y1 = input.nextInt();
        System.out.println("Enter the value of x1 and y1 of point B::");
        int x2 = input.nextInt();
        int y2 = input.nextInt();

        double distance = Math.sqrt(Math.pow((x1 - x2), 2) + (Math.pow((y1 - y2), 2)));
        System.out.println("Distance between point A and point B is " + distance);

    }
}
