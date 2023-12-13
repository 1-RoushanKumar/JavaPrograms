package com.Concept;

public class _42_String {
    public static void main(String[] args) {
        String name = "Roushan Kumar";   //in string
        System.out.println(name);

        String a = "Hello";
        String b = "Hello";
        //both a and b are pointing to the same object(only one Hello is created here) in String Pool.

        //but if we change a it does't effect the value of b.Because String is immutable in java.
        a = "Rocky";
        System.out.println(a);   //new object for a is created in job pool.
        System.out.println(b);   //we can see b will remain same.

        String p1 = "Kumar";
        String p2 = "Kumar";

        System.out.println(p1 == p2);    // it will print true because both are pointing to the same object in string pool.

        String p3 = "Bankai";
        String p4 = new String("Bankai"); // this will create Bankai in different object.From above.

        System.out.println(p3 == p4);   //we use == to checking the where the object is created.

        //when we need to check the value are equal or not then use equals() String inbuilt method.
        System.out.println(p3.equals(p4));  //it dont care object where is object created it only compare value.

        System.out.println(p3.charAt(3)); //k
    }
}
