package com.roushan._10_OOPS._08_Inheritance;

//if we make class as final then it can't be extends by child class.
//final class box{}
class Box {
    double length;
    double breadth;
    double width;
    //private double width;
    //when we use private it cannot be accessed by child class

    Box() {
        this.length = -1;
        this.breadth = -1;
        this.width = -1;
    }

    Box(double length, double breadth, double width) {
        this.length = length;
        this.breadth = breadth;
        this.width = width;
    }

    Box(double side) {
        this.length = side;
        this.breadth = side;
        this.width = side;
    }

    static void greeting() {
        System.out.println("Hey, I am Parent class.Hello!");
    }
}
