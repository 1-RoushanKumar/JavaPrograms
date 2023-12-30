package com.roushan._10_OOPS._10_AccessControl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        A obj = new A(12, "Rocky");
        System.out.println(obj.num);
//        System.out.println(obj.name);
        //name will show an error because name variable is private.
        System.out.println(Arrays.toString(obj.arr));

        //now you can see we can also access private variable with the help of getter and setter constructor.
        //hence, private can not be accessed directly outside the class.
        System.out.println(obj.getName());
    }
}
//Public is accessible from anywhere.
//Protected can be accessible in same class,in same packages,and in subclass of same and different packages.
//When we don't write anything then it can be accessed in same class,and same subclass of the same packages(it cannot accessible in different packages.
