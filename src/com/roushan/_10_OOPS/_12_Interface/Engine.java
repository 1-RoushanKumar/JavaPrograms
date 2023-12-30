//why interface.Remember in inheritance one subclass cannot have more than one parent class
//because if two parent class two same variable(n=10 in parent class and n=15) then subclass
//are not able to know which valur to access.(ie Multiple inheritance is not possible(not available in java))
//So we use interface.Interface is like class but not completely . it is like an abstract class.
//by default function are public and abstract in interface.And variable are final and static by default.

package com.roushan._10_OOPS._12_Interface;

//interface cannot be private.
public interface Engine {
    void start();//methods are default abstract and public and it cannot be private.

    void stop();

    void accelerate();
}
