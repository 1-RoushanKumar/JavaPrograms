package com.roushan._10_OOPS._11_Abstraction;

public abstract class Parent {    //we cannot use final keyword with abstract because it needs to be overriding


    //normally when we create method then it require body also
//    void game();

    //but using abstract we don't need to create body it can be created in subclass.
    abstract void career();   //for using abstract we must need to declare class also as abstract.

    abstract void partner();

//    abstract int num;   //we cannot create abstract variables and objects.

    int num = 56;  //but we can create variable normally.
    int age;

    //can we create an constructor.Yes we can, but we cannot create abstract constructor
    public Parent(int age) {
        this.age = age;
    }

    //we also don't can create abstract static because static method cannot be overriding.

    //but we create it without abstract
    static void hello() {
        System.out.println("Hello");
    }

    //we can create method

}
