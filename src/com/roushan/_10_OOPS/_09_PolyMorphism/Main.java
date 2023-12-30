package com.roushan._10_OOPS._09_PolyMorphism;

public class Main {
    public static void main(String[] args) {

//        Shapes shape = new Shapes();
//        shape.area();
//        Circle cir = new Circle();
//        cir.area();
//        Square sqr = new Square();
//        sqr.area();

        //In inheritance, we learn that call is depend on the reference
        //But in polymorphism, call is depend on the object because of overriding
        //Due to this reason shapes.area() is calling Circle(Sub class) method.
        Shapes shapes = new Circle();
        shapes.area();
        Shapes shapes1 = new Square();
        shapes1.area();

//        Circle cirri = new Shapes();
        //but we can't do this.We can't call parent class from child reference.


        Circle.hello(); //we can inherit static but we cannot override it .
        Shapes.hello();
    }
}
