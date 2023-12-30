package com.roushan._3_Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class _07_MultiArraylist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> value = new ArrayList<>();

        System.out.println("Enter Values::");
        //initialisation mandatory .
        for (int i = 0; i < 3; i++) {
            value.add(new ArrayList<>());      //it creating individual list
        }
        //taking value
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                value.get(i).add(in.nextInt());
            }
        }
        //printing
        System.out.println(value);
    }
}
