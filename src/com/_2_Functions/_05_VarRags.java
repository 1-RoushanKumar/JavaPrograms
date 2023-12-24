package com._2_Functions;

import java.util.Arrays;

public class _05_VarRags {
    public static void main(String[] args) {
//        fun(12, 58, 456, 84, 25, 26, 78, 14);
        many(45, 56, "Java", "Dsa", "Super");
    }

    //(... any name) -->> is VarRags . it is used to take number of values.
    // instead of using (int a, int b,int c,int d,int e....) , we can use VarRags.
    //VarRags can be any datatype (String ,character,float...)

//    static void fun(int... name) {
//        System.out.println(Arrays.toString(name));
//    }

    //we can also pass different types of datatype also with VarRags.
    static void many(int a, int b, String... v) {      //it should be same order as passed variables.
        System.out.println(a);
        System.out.println(b);
        System.out.println(Arrays.toString(v));
    }
}
