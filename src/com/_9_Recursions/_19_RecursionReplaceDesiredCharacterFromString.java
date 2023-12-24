package com._9_Recursions;

public class _19_RecursionReplaceDesiredCharacterFromString {
    public static void main(String[] args) {
        String str = "abbcda";
        char ch = 'a';

        //1st way.
//        StringBuilder builder = new StringBuilder(str);
//        remove(builder, 0, ch);
//        System.out.println(builder);

        //2nd way.
        System.out.println(remove(str, ch));

        //3rd way.
        skip(str, "", ch);
    }

    //1st way by using stringbuilder.

//    static StringBuilder remove(StringBuilder str, int i, char ch) {
//        if (i == str.length()) {
//            return str;
//        }
//        if (str.charAt(i) == ch) {
//            str.deleteCharAt(i);
//            return remove(str, i, ch);
//        } else {
//            return remove(str, i + 1, ch);
//        }
//    }

    //2nd way by returning string.
    static String remove(String str, char ch) {
        if (str.isEmpty()) {
            return "";
        }
        char val = str.charAt(0);

        if (val == ch) {
            return remove(str.substring(1), ch);
        } else {
            return val + remove(str.substring(1), ch);
        }
    }//It is forming string when stack is getting empty.

    //3rd way by passing two string in arguments.
    static void skip(String str, String store, char ch) {
        if (str.isEmpty()) {
            System.out.println(store);
            return;
        }
        char val = str.charAt(0);

        if (val == ch) {
            skip(str.substring(1), store, ch);
        } else {
            skip(str.substring(1), store + val, ch);
        }
    }
}
