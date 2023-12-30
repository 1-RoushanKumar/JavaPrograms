package com.roushan._10_OOPS;

public class _01_ClassesAndObjects {
    public static void main(String[] args) {
        //here first declaring the object and then creating it.
//        Student rocky;
//        rocky = new Student();

        Student rocky = new Student();   //creating and declaring at same time.This Student is actually a constructor function.

        //we use dot operator to access the object instances.
        //when we try to access these value it will first check that the requirement value is available in object or not
        //if it is not available then it go to search in class where we make that property, if value is also not present
        //there then it will print default values.

//        System.out.println(rocky.rollno); //so it is primitive then it default store 0.
//        System.out.println(rocky.name);   //so we know String is itself a class its default value is null.

//        //here it will create instance in the object .
//        rocky.rollno = 69;
//        rocky.name = "Roushan Kumar";
//        rocky.marks = 80.5f;

        System.out.println(rocky);   //it will print some hex value
        System.out.println(rocky.rollno);
        System.out.println(rocky.name);
        System.out.println(rocky.marks);

        rocky.greeting();    //rocky is calling function greeting.

        //assigning new value to the rocky object.
        rocky = new Student(69, "Roushan Kumar", 79.1f);
        System.out.println(rocky.rollno);
        System.out.println(rocky.name);
        System.out.println(rocky.marks);
        Student roushan = new Student();
        System.out.println(roushan.name);
    }
}

//class are the property or template for an object and object is an instances of the class.
class Student {
    int rollno;
    String name;
    float marks;

    // Constructor is a special function that runs when you create an object, and it allocates some variable.
    Student() {    //this constructor is without arguments
//        rocky.rollno = 16;  //we can't do this
        //we need a way to add the values of the above properties object by object.
        //when we require to print for rocky or rohan or any references then it should automatically put that object
        // references below, for accessing variable in this manner we need (this) keyword.

        this.rollno = 16;
        this.name = "Rahul";
        this.marks = 45.8f;

        //internally this keyword get replaced by rocky.
        //assume we create a new object Student hello = new Student() now when again constructor is called
        //then that (this) will get replaced by hello
    }

    void greeting() {
        //rocky is calling this function this.name will get removed by rocky.name
        System.out.println("hello my name is " + this.name);
    }

    //passing constructor with arguments and, we can also see we are creating new constructor with other arguments
    //like we previously did in the function which was said to be function overloading.
    //here it is constructor overloading.
    Student(int Roll, String naam, float result) {
        this.rollno = Roll;
        this.name = naam;
        this.marks = result;
    }
}