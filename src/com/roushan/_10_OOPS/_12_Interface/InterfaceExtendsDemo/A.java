package com.roushan._10_OOPS._12_Interface.InterfaceExtendsDemo;

public interface A {
    void fun();

    //when we use default we can add body here and don't need to override it in extend interface.
    default void dance() {
        System.out.println("Dancing time!");
    }

    //similarly when we add static we need to add body also.
    static void partyOver() {
        System.out.println("Party Done!");
    }
}
