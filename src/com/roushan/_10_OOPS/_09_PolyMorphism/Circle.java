package com.roushan._10_OOPS._09_PolyMorphism;

public class Circle extends Shapes {

    @Override
        //what is overriding
        //when a child class has method name same as the parent class,return type also same
        //just the body is different then this type of process is said to be overriding.
        //void area1() instead of area then it will show error because it's not overriding.
        //parent class must have area for overriding and overriding done at the runtime by the java.
    void area() {
        System.out.println("Area of the circle is pi*r*r");
    }

    //@Override
    // it will show error because static method can not be override.
    //because overriding depends on the object but static is not depend on the object
    //Hence, we cannot override static method.
    static void hello() {
        System.out.println("I am child class!");
    }

}
