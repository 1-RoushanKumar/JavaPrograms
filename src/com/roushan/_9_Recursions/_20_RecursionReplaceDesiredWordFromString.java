package com.roushan._9_Recursions;

public class _20_RecursionReplaceDesiredWordFromString {
    public static void main(String[] args) {
        String str = "An apple is Red and apple is tasty.";
        String reStr = "apple";
        System.out.println(skip(str, reStr));
    }

    static String skip(String str, String reStr) {
        if (str.isEmpty()) {
            return "";
        }

        if (str.startsWith(reStr)) {
            return skip(str.substring(reStr.length()), reStr);
        } else {
            return str.charAt(0) + skip(str.substring(1), reStr);
        }

    }
}
