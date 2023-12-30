package com.roushan._10_OOPS;

public class _04_HumanClass {
    int age;
    String name;
    float salary;
    //    long populationn;
    static long population;

    static void message() {
        System.out.println("Hello World");
    }

    public _04_HumanClass(int age, String name, float salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
//        this.populationn += 1;
        _04_HumanClass.population += 1; //to access static variable we use class name.
        _04_HumanClass.message();
    }
}
