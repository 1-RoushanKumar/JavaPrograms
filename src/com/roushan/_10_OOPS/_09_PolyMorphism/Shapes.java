package com.roushan._10_OOPS._09_PolyMorphism;

public class Shapes {
    void area() {
        System.out.println("Area of shape.");
    }

    //but we can prevent overriding by using final keyword.Just make above method as final.
//    final void area(){
//        System.out.println("Area of shape.");
//    }

    static void hello() {
        System.out.println("I am from parent class.");
    }
}
