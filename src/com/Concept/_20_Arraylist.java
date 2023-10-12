package com.Concept;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class _20_Arraylist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>(4);

//        list.add(45);
//        list.add(2);
//        list.add(89);
//        list.add(98);
//        list.add(123);
//        list.add(45);
//        System.out.println(list);    //printing.
//
//        list.set(3, 90);
//        list.set(1, 0);
//        System.out.println(list);    //modifying then printing.
//
//        list.remove(2);
//        list.remove(3);
////        list.remove(4);        //it will show error because after removing two element above array size
//        //got decreased by 2 so now array size is 4 (ie upto index 3).
//        System.out.println(list);
//
//        //there so many function in arraylist you can check it.

        //how take input in array.
        System.out.println("Enter the value:");
        for (int i = 0; i < 5; i++) {
            list.add(in.nextInt());
        }
        //for printing
//       System.out.println(list);   //1st way
        //2nd way
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        System.out.println(list.get(3));

        Collections.sort(list);  //sort the array
        for(int value: list){
            System.out.print(value+" ");
        }
    }
}
