package com.roushan._9_Recursions;

import java.util.ArrayList;

public class _22_RecursionStringSubsequence {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println("SubSequence of " + str + " Are::");
        subSeq(str, "");

        System.out.println();
        System.out.println(subSeq2(str, ""));

        System.out.println();
        ArrayList<String> ans = new ArrayList<>();
        System.out.println(subSeq3(str, "", 0, str.length(), ans));

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

    //3rd way
    static ArrayList<String> subSeq3(String str, String store, int i, int n, ArrayList<String> ans) {
        if (i == n) {
            ans.add(store);  // Add the generated subsequence to the list
            return ans;
        }
        char ch = str.charAt(i);

        // Recursive call including the current character
        subSeq3(str, store + ch, i + 1, n, ans);

        // Recursive call excluding the current character
        subSeq3(str, store, i + 1, n, ans);

        return ans;  // Return the list of subsequences
    }
}
