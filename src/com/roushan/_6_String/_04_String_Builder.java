package com.roushan._6_String;

import java.util.List;

public class _04_String_Builder {
    public static void main(String[] args) {
        String series = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            series = series + ch;
        }
        System.out.println(series);
        //this method keep creating new object
        // ex = "a" + "b" there are already two object it will create new one "ab"
        // again "ab" + "c" it will also create a new object "abc" ...so on.
        // this is not a better way of doing.

        // So we use String builder it will not create a new object just keep appending then.
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            builder.append(ch);
        }
        System.out.println(builder);

        System.out.println("Proof");
        //example.
        String name = "Rocky";
        System.out.println(name);   //print "Rocky"
        System.out.println(name.concat("Bhai"));   //print "RockyBhai"
        System.out.println(name);   //but it will "Rocky" even we concatenated it above
        //This is the proof that String make new objects for all changes previous (original) value is remained same.
        //Hence, String is immutable.

        //but in the case of StringBuilder.
        StringBuilder builder2 = new StringBuilder("Roushan");
        System.out.println(builder2);    //Roushan
        System.out.println(builder2.append("Kumar"));  //RoushanKumar
        System.out.println(builder2);    //it also RoushanKumar
        //Proved that StringBuilder don't create a new object is just appended the previous object.
        //Hence it is mutable.
       

    }
}

