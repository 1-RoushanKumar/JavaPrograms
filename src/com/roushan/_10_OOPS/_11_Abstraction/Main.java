package com.roushan._10_OOPS._11_Abstraction;

public class Main {
    public static void main(String[] args) {
        Son son = new Son(25);
        son.career();
        son.partner();
        System.out.println(son.age);

//        Parent par = new Parent()
        //we also cannot create object of Parent class directly
        //we can only create it if you define the undefined abstract method.

        //but you can use as reference variable.
        Parent par = new Son(30);
        //because override is depend on Son class
        System.out.println(par.age);
    }
}
