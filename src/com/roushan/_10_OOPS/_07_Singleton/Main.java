package com.roushan._10_OOPS._07_Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();

        Singleton obj2 = Singleton.getInstance();

        Singleton obj3 = Singleton.getInstance();
        //all 3 references variable are pointing to just one object
        //due to all giving same output.
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);
    }
}
