package com.roushan._10_OOPS._12_Interface.InterfaceExtendsDemo;

//Party class implements B then it can access both method.
public class Party implements B {

    @Override
    public void fun() {
        System.out.println("Funtime");
    }

    @Override
    public void greet() {
        System.out.println("Greeting Time");
    }

    @Override
    public void dance() {
        B.super.dance();
    }
}
