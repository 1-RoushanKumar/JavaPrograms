package com.roushan._10_OOPS;

public class _02_WrapperClassAndFinalKeyword {
    public static void main(String[] args) {
        int a = 10;
//        System.out.println(a);

        Integer num = 20;   //here Integer is a wrapper class
        // The Integer class wraps a value of the primitive type int in an object
        //wrapper class provide so many in built method.
//        System.out.println(num);

        int b = 4;
        int c = 2;
        swap(b, c);
//        System.out.println("Value before swapping " + a + " " + b);
//        System.out.println("Value After swapping " + a + " " + b);
        //it will remain same because we know pass by value don't change it.

        //but we know reference variable and object variable can get changed when it is passed to the function.
        //So Integer is a class which convert variable into object, lets try this

        Integer num1 = 45;
        Integer num2 = 90;
        swap2(num1, num2);
//        System.out.println("Value Before Swapping " + num1 + " " + num2);
//        System.out.println("Value After Swapping " + num1 + " " + num2);
        //it will also remain same,But it should have changed because this time we're passing the reference.
        //It remained same because Integer Class is Final.

        //what is final
        final int number = 45;   //we must initialize value while declaring in the final keyword
//        number = 67;  //here it is when we use final key it cannot be initialized again.final means final.

        //due to this reason value didn't get swapped because Integer wrapper class in final it can't be initialized again.
        //Hence, final keyword is immutable.
    }

    static void swap(int b, int c) {
        int temp = b;
        b = c;
        c = temp;
    }

    static void swap2(Integer num1, Integer num2) {
        Integer temp = num1;
        num1 = num2;
        num2 = temp;
    }
}
