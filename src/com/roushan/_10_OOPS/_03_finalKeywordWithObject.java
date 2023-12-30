package com.roushan._10_OOPS;

public class _03_finalKeywordWithObject {
    public static void main(String[] args) {
        //but final keyword work differently for objects
        //in primitive datatype
        final int num = 80;
//        num = 34;  //we cannot re-initialize it.

        //but with object we can do like this
        final CAR name = new CAR();
        name.carName = "TATA Nano";
        System.out.println(name.carName);
        System.out.println(name.carNo);
        name.carName = "Maruti";
//        name.carNo = 45453;  // we cannot do this because in class we assign car number as final
        System.out.println(name.carName);

        //in final non-primitive we can change the values.
        //but we cannot reassign it.(in non-primitive is final)
        //Car newName = new CAR(); like this
    }
}
class CAR {
    final int carNo = 3453;
    String carName;
}
