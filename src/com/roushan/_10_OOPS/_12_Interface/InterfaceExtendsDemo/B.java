package com.roushan._10_OOPS._12_Interface.InterfaceExtendsDemo;

//B extends A interface (ie B have both method greet() and fun()).
public interface B extends A{
    void greet();

    @Override
    default void dance() {
        A.super.dance();
    }
}
