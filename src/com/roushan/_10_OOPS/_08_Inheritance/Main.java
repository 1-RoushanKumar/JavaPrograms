package com.roushan._10_OOPS._08_Inheritance;

public class Main {
    public static void main(String[] args) {
        //parent class box
        //box1 is calling tho box() constructor which store default value.
        Box box1 = new Box();
        System.out.println(box1.length + " " + box1.breadth + " " + box1.width); //it will present default value
        Box.greeting();  //to access static method use class name form where it belongs

        //box2 is calling the box() constructor with arguments
        Box box2 = new Box(4, 2, 9);
        System.out.println(box2.length + " " + box2.breadth + " " + box2.width);

        //here it's calling child constructor
        ChildBox box3 = new ChildBox();
        System.out.println(box3.length + " " + box3.weight);
        //you can see we are getting the value parent class also from parent class

        //here it's calling child constructor with arguments.
        ChildBox box4 = new ChildBox(12, 3, 4, 6);
        System.out.println(box4.length + " " + box4.width + " " + box4.breadth + " " + box4.weight);
//        System.out.println("Area of cube is"+box4.area);

        //what happens when we write like this
        Box box5 = new ChildBox(5, 3, 2, 1);
//        System.out.println(box5.weight);
        //we can't access weight because the type of the reference variable(here Box)
        //that actually determine what member to access.It's not determined by the object(ChildBox)
        //due to this reason we are not able to access weight value.


        //Similarly we cannot do this also.
//        ChildBox box6 = new Box(5,6,3,2); //we cannot do this.
        //because reference variable childBox and object is Box.

        //here we're calling constructor with only two arguments.
        ChildBox box7 = new ChildBox(45, 35);
        System.out.println(box7.length + " " + box7.breadth + " " + box7.width + " " + box7.weight);

        ChildChildBox box8 = new ChildChildBox();
        System.out.println(box8.length + " " + box8.breadth + " " + box8.weight + " " + box8.price);

        ChildChildBox box9 = new ChildChildBox(53, 34, 34, 24, 6643);
        System.out.println(box9.length + " " + box9.breadth + " " + box9.weight + " " + box9.price);

        ChildChildBox box10 = new ChildChildBox(4534, 345, 435342);
        System.out.println(box10.length + " " + box10.breadth + " " + box10.weight + " " + box10.price);

    }
}
