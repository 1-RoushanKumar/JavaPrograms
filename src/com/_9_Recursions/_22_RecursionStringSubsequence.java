package com._9_Recursions;

import java.util.ArrayList;

public class _22_RecursionStringSubsequence {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println("SubSequence of " + str + " Are::");
        subSeq(str, "");

        System.out.println();
        System.out.println(subSeq2(str, ""));

    }

    //1st way.
    static void subSeq(String str, String store) {
        if (str.isEmpty()) {
            System.out.print(store + " ");
            return;
        }
        char ch = str.charAt(0);
        subSeq(str.substring(1), store + ch);
        subSeq(str.substring(1), store);
    }

    //2nd way.
    static ArrayList<String> subSeq2(String str, String store) {
        if (str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(store);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> left = subSeq2(str.substring(1), store + ch);
        ArrayList<String> right = subSeq2(str.substring(1), store);

        left.addAll(right);
        return left;
    }
}
