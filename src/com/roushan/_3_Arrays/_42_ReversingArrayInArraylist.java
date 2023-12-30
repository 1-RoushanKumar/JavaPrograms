package com.roushan._3_Arrays;

import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
import java.util.Collections;
import java.util.Scanner;

public class _42_ReversingArrayInArraylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ls = new ArrayList<>();
        System.out.print("Enter the elements::");
        for (int i = 0; i < 10; i++) {
            ls.add(sc.nextInt());
        }
        System.out.println(ls);
//        Collections.reverse(ls);    //inbuilt reverse method in collection package.
        reverse(ls);
        System.out.println("In Reverse Order:: " + ls);
        Collections.sort(ls);
        System.out.println("Sorted In Ascending Order:: " + ls);
        Collections.sort(ls, Collections.reverseOrder());
        System.out.println("Sorted In Descending Order:: " + ls);
    }

    static void reverse(ArrayList<Integer> ls) {
        int i = 0, j = ls.size() - 1;
        while (i < j) {
            int temp = ls.get(i);
            ls.set(i, ls.get(j));
            ls.set(j, temp);
            i++;
            j--;
        }
    }
}
