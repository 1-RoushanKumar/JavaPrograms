package com.roushan._10_OOPS._07_Singleton;

//when only one instances of object allowed then we can say that it is singleton class.
public class Singleton {
    private Singleton() {

    }

    private static Singleton instance;

    //when we want user can only create one instance then we don't let them call constructor.
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
//https://youtu.be/_Ya6CN13t8k?t=4244
