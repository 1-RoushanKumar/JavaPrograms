package com._6_String;

public class _03_OperatorInString {
    public static void main(String[] args) {
        System.out.println('a' + 'b');  //97+98=195
        System.out.println("a" + "b");  //it will concatenate because they are string.

        System.out.println('a' + 3);    //it will add 97 + 3 = 100;
        System.out.println((char)('a' + 3));  // at 100 which character d.
        System.out.println("a" + 3);   //it will concatenate again by converting integer to string by toString method.

        System.out.println("a" + 'a');  //it will print aa because char is promoted to string.

    }
}
