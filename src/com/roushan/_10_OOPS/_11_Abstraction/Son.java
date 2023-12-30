package com.roushan._10_OOPS._11_Abstraction;

public class Son extends Parent {

    // for extends parent information to son we must Override all the method and value that parent class.
    //hence, every child class have to override parent class because parent call have no body.
    @Override
    void career() {
        System.out.println("I want to become a software engineer.");
    }

    @Override
    void partner() {
        System.out.println("I partner are my friends.");
    }

    public Son(int age) {
        super(age);
    }
}

