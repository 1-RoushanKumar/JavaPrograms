package com.roushan._9_Recursions;

public class _20_RecursionRemoveDesiredWordFromString {
    public static void main(String[] args) {
        String str = "An apple is Red and apple is tasty.";
        String reStr = "apple";
        System.out.println(skip(str, reStr));
        skip1(str, reStr, "");
    }

    static String skip(String str, String reStr) {
        if (str.isEmpty()) {
            return "";
        }
        if (str.startsWith(reStr)) {
            return skip(str.substring(reStr.length() + 1), reStr);
        } else {
            return str.charAt(0) + skip(str.substring(1), reStr);
        }
    }

    public static void skip1(String str, String reStr, String store) {
        if (str.isEmpty()) {
            System.out.println(store);
            return; // Ensure we terminate the method after printing
        }

        int index = str.indexOf(' ');
        if (index == -1) {
            index = str.length(); // If no space is found, take the remaining string
        }
        String startingString = str.substring(0, index);

        if (startingString.equals(reStr)) {
            if (index == str.length()) {
                skip1("", reStr, store); // Skip the word and handle end of string
            } else {
                skip1(str.substring(index + 1), reStr, store); // Skip the word
            }
        } else {
            if (index == str.length()) {
                skip1("", reStr, store + startingString); // Include the word and handle end of string
            } else {
                skip1(str.substring(index + 1), reStr, store + startingString + " "); // Include the word
            }
        }
    }

}
