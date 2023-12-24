package com._1_BasicOfJava;
public class _05_TypePromotion {
    public static void main(String[] args) {

        byte b = 56;
        char c = 'd';
        short s = 1013;
        int i = 50000;
        float f = 56.67f;
        double d = 1.634634;
//        double result = (f * b) + (i / c) - (d * s);
        System.out.println((f * b) + " " + (i / c) + " " + (d * s));
        //smaller datatype getting converted into bigger datatype.
        //(f*b)-->f(float) is bigger datatype so result of (f*b) = float
        //similarly (i/c) = int , (d*s) = double
        //and finally (float + int + double) = double.
        System.out.println((f * b) + (i / c) - (d * s));
    }
}
