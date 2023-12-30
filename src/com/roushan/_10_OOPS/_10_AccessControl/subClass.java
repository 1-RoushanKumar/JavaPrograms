package com.roushan._10_OOPS._10_AccessControl;

public class subClass extends A {
    public subClass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {
        //we know for accessing non-static in static we need to create an object.
        subClass value = new subClass(35, "Sohan");
//        System.out.println(value.name); //we cannot able to access directly because it is private.
        System.out.println(value.getName()); //now we can.
    }
}
