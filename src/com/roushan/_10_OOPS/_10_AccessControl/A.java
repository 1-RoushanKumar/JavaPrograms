package com.roushan._10_OOPS._10_AccessControl;

public class A {
    int num;
    private String name;
    //what is private.
    //private can only be accessible on the same class.
    //it can't be accessed from different class and packages.
    int[] arr;

    //but there is a way to access private variable outside the class.
    //the way is go create getter and setter.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public A(int num, String name) {
        this.num = num;
        this.name = name;
        this.arr = new int[num];
    }

    //here we can see, we can easily be accessing private variables in same class.
    public static void main(String[] args) {
        A obj = new A(4, "Raja");
        System.out.println(obj.name);
    }
}
