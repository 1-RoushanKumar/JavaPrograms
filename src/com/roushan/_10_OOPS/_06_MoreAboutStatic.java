package com.roushan._10_OOPS;

import com.sun.tools.javac.Main;

public class _06_MoreAboutStatic {
    public static void main(String[] args) {

//        greeting();
        //it will show error because only static data can be accessed in static method
        //here greeting is not static so it can not be accessed.
        //fun() is static so we don't need to create any object for it.
        fun();

        //creating object for fun2() ,for get access from static method.
        _06_MoreAboutStatic funn = new _06_MoreAboutStatic();
        funn.fun2();
    }

    void greeting() {
        System.out.println("Hello");
        //and this is depended on objects instances.
//        fun();
        //but you can call fun()  from greeting().
    }

    static void fun() {
//        greeting();  //here also we can not call greeting.
        //because this is dependent on objects instances.
        //but the function fun() is not depend on the instances.

        //but we can call greeting() by creating an object for greeting.
        _06_MoreAboutStatic obj = new _06_MoreAboutStatic();
        obj.greeting();
    }

    //in this case both fun2 and greeting are non static for accesing it from
    //static function then must have an object.And when we creating object for fun2
    //,we dont need to make object for greeting();
    void fun2() {
        greeting();
    }
}
//for more detail https://youtu.be/_Ya6CN13t8k?list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&t=2421
