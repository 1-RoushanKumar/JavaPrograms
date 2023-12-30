package com.roushan._6_String;

public class _05_MethodsInStringbuilder {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("Roushan");
        System.out.println(builder);
        System.out.println(builder.length());   //7
        String str = builder.toString();
        System.out.println(str);
//        System.out.println(builder.toString()); //Roushan
        System.out.println(builder.append("Kumar")); //RoushanKumar
        System.out.println(builder);    //RoushanKumar
        System.out.println(builder.length());   //12
        System.out.println(builder.delete(7,12));  //Roushan after deleting value of the given range.
        System.out.println(builder.indexOf("a"));  //index of a is 5
        System.out.println(builder.reverse());
        System.out.println(builder.reverse());
        char ch = builder.charAt(0);
        ch = 'r';
        System.out.println(builder);
        //there are so many more.
//        System.out.println(str);
        builder.deleteCharAt(6);
        System.out.println(builder);
        toLowerCase(builder);
        System.out.println(builder);

    }

    private static void toLowerCase(StringBuilder builder) {
        for (int i = 0; i < builder.length(); i++) {
            if (Character.isUpperCase(builder.charAt(i))){
                builder.setCharAt(i,Character.toLowerCase(builder.charAt(i)));
            }
        }
    }
}
