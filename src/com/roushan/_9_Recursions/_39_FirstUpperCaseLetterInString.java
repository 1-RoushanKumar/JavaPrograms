package com.roushan._9_Recursions;

public class _39_FirstUpperCaseLetterInString {
    public static void main(String[] args) {
        String s = "roushAnKumar";
        char ans = findUpper(s);
        System.out.println(ans);
    }

    public static char findUpper(String s) {
        if (s.isEmpty()) {
            return '*';
        }
        char ch = s.charAt(0);
        if (ch >= 'A' && ch <= 'Z') {
            return ch;
        } else {
            return findUpper(s.substring(1));
        }
    }
}
