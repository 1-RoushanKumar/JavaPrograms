package com.roushan._10_OOPS._08_Inheritance;

class ChildChildBox extends ChildBox {
    //class that extends ChildBox class then it can also inheritance all the value that ChildBox have.
    double price;

    public ChildChildBox() {
        this.price = -1;
    }

    public ChildChildBox(double length, double breadth, double width, double weight, double price) {
        super(length, breadth, width, weight);//its calling constructor of ChildBox which contain
        //these four arguments.
        this.price = price;
    }

    public ChildChildBox(double side, double weight, double price) {
        super(side, weight);  //it is calling a constructor with two arguments in ChildBox.
        this.price = price;
    }
}
