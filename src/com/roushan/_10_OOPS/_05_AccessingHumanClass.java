package com.roushan._10_OOPS;

public class _05_AccessingHumanClass {
    public static void main(String[] args) {
        //accessing human class from other java class but when we import it in different package Suppose i want to access
        //human class in Arrays package(file) then we to import it first to the array file using import keyword.
        _04_HumanClass roushan = new _04_HumanClass(22, "Roushan", 4534);
        _04_HumanClass raja = new _04_HumanClass(17, "Raja", 3434);
        _04_HumanClass rocky = new _04_HumanClass(29, "Rocky", 23423);

        System.out.println(roushan.age);
        System.out.println(raja.age);

//        System.out.println(roushan.populationn);
//        System.out.println(raja.populationn);
//        System.out.println(rocky.populationn);

        //when we used long keyword only then it all print population only one.
        //But we know population is common for all it must be same in all (ie total 3 references so there must be 3 population)
        //here we use static keyword so, such property which is not directly depend on the object but are common to all
        //object to the class is called static.

        System.out.println(roushan.population); //it will show 3
//        we can use name also but it's showing waring because for accessing static variable we need us class name.
        System.out.println(_04_HumanClass.population);
        // we can also access population without creating an object also because static does depend on object
        //if we comment above object instance it will still run.

        _04_HumanClass.message();
    }
}
