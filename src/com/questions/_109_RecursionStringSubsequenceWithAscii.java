package com.questions;

import java.util.ArrayList;

public class _109_RecursionStringSubsequenceWithAscii {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println("SubSequence of " + str + " Are::");
        subSeq(str, "");

    }

    static void subSeq(String str, String store) {
        if (str.isEmpty()) {
            System.out.print(store + " ");
            return;
        }
        char ch = str.charAt(0);
        subSeq(str.substring(1), store + ch);
        subSeq(str.substring(1), store);
        subSeq(str.substring(1), store + (int) ch);
    }
}
