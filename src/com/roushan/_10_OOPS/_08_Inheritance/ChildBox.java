package com.roushan._10_OOPS._08_Inheritance;

public class ChildBox extends Box {
    //this is a child class which inherit all the elements of the parent class Box
    //this process is know as inheritance.
    double weight;

    ChildBox() {
        this.weight = -1;
    }

    //constructor with arguments.
    ChildBox(double length, double breadth, double width, double weight) {
        //super must be initialized before child class values.
        super(length, breadth, width);  //what is this.
        //it's basically calling parent class constructor that are with parameter.
        this.weight = weight; //it must include weight because it is from child class.

//        super(length,breadth,width) //we cannot do this
        //we cannot initialize after weight.
    }

    //constructor with two arguments.
    ChildBox(double side, double weight) {
        super(side);   //this will call constructor with one argument only
        this.weight = weight;
    }
}

