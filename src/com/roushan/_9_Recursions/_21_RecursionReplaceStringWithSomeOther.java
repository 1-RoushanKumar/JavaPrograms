package com.roushan._9_Recursions;

public class _21_RecursionReplaceStringWithSomeOther {
    public static void main(String[] args) {
        String str = "An apple is Red and apple is tasty.";
        String reStr1 = "apple";
        String reStr2 = "Red";
        String addStr = "orange";
        System.out.println(skip(str, reStr1, reStr2, addStr));
    }

    static String skip(String str, String reStr1, String reStr2, String addStr) {
        if (str.isEmpty()) {
            return "";
        }
        if (str.startsWith(reStr1)) {
            return skip(addStr + str.substring(reStr1.length()), reStr1, reStr2, addStr);
        }
        if (str.startsWith(reStr2)) {
            return skip(addStr + str.substring(reStr2.length()), reStr1, reStr2, addStr);

        } else {
            return str.charAt(0) + skip(str.substring(1), reStr1, reStr2, addStr);
        }

    }
}
