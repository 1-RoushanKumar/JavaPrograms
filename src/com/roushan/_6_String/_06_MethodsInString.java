package com.roushan._6_String;

import java.util.Arrays;

public class _06_MethodsInString {
    public static void main(String[] args) {
        String name = " Rocky Bhai ";
        System.out.println(name.charAt(3));
        char ch = name.charAt(0);

        char[] charArray = name.toCharArray();     //a way to add string into array-first initialization.
        System.out.println(charArray[5]);
        System.out.println(Arrays.toString(charArray));
//        System.out.println(Arrays.toString(name.toCharArray()));  //direct way to printing string into array with initialization.
        System.out.println(name.substring(1, 5));
        
        String lo = new String(name.toLowerCase());
        System.out.println(lo);
//        System.out.println(name.toLowerCase());    //direct way.

        System.out.println(name.toUpperCase());

        int in = name.indexOf('c');
        System.out.println(name.indexOf('c'));
        System.out.println(name.trim());   //it will remove space from end and start of the string.
        System.out.println(name.substring(2));
        System.out.println(name.substring(3, 6));
        System.out.println(Arrays.toString(new char[]{name.charAt(3)}));

        String val = "Bhai";
        System.out.println(name.contains(val));
        //if we change it to bhai it will show false.
        //there are so many method.

        
        String s1 = "Rohit";
        String s2 = "Mohit";
        System.out.println(s1.contains("ohi"));
        int res = s1.compareTo(s2);
        if (res == 0) {
            System.out.println("Same");
        } else if (res > 0) {
            System.out.println("s1 is greater");
        } else {
            System.out.println("s1 is smaller");
        }
    }
}
